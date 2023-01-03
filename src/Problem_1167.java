import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node1{
	int vertex;
	int dist;
	
	public Node1(int edge, int dist) {
		this.vertex = edge;
		this.dist = dist;
	}
}

public class Problem_1167{
	static ArrayList<ArrayList<Node1>> graph = new ArrayList<ArrayList<Node1>>();
	static boolean visited[];
	static long maxDist = Long.MIN_VALUE;
	static long ans = Long.MIN_VALUE;
	static int endVertex;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		
		// list √ ±‚»≠
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Node1>());
		}
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			String inputValue[] = input.split(" ");
			int startVertex = Integer.parseInt(inputValue[0]);
			
			for(int j=1; j<inputValue.length-1; j=j+2) {
				int endVertex = Integer.parseInt(inputValue[j]);
				int dist = Integer.parseInt(inputValue[j+1]);
				graph.get(startVertex).add(new Node1(endVertex, dist));
			}
		}
		
		visited[1] = true;
		dfsForSearchEndVertex(graph.get(1), 0);
		visited[1] = false;
		visited[endVertex] = true;
		bw.write(Long.toString(dfs(graph.get(endVertex), 0)));
		bw.flush();
	}
	
	public static void dfsForSearchEndVertex(ArrayList<Node1> nodeList, long totalDist) {
		for(Node1 nNode : nodeList) {
			if(visited[nNode.vertex]) {
				continue;
			}
			visited[nNode.vertex] = true;
			totalDist+=nNode.dist;
			dfsForSearchEndVertex(graph.get(nNode.vertex), totalDist);
			if(totalDist>maxDist) {
				maxDist = totalDist;
				endVertex = nNode.vertex;
			}
			visited[nNode.vertex] = false;
			totalDist-=nNode.dist;
		}
	}
	
	public static long dfs(ArrayList<Node1> nodeList, long totalDist) {
		for(Node1 nNode : nodeList) {
			if(visited[nNode.vertex]) {
				continue;
			}
			visited[nNode.vertex] = true;
			totalDist += nNode.dist;
			dfs(graph.get(nNode.vertex), totalDist);
			ans = Math.max(ans, totalDist);
			totalDist -= nNode.dist;
			visited[nNode.vertex] = false;
		}
		return ans;
	}

}
