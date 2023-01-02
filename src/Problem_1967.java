import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
	int num;
	int dist;
	
	public Node(int num, int value) {
		this.num = num;
		this.dist = value;
	}
}

public class Problem_1967 {
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static boolean visited[];
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		visited = new boolean[n+1];
		
		// 인접 List 초기화
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		// graph 생성
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			graph.get(node1).add(new Node(node2, dist));
			graph.get(node2).add(new Node(node1, dist));
		}
		
		for(int i=1; i<n+1; i++) {
			visited[i] = true;
			dfs(graph.get(i), 0);
			visited[i] = false;
		}
		
		bw.write(Integer.toString(ans));
		bw.flush();
		
	}
	
	public static void dfs(ArrayList<Node> node, int totalDist) {
		for(Node nNode : node) {
			if(visited[nNode.num]) {
				continue;
			}
			visited[nNode.num] = true;
			totalDist+=nNode.dist;
			dfs(graph.get(nNode.num), totalDist);
			visited[nNode.num] = false;
			totalDist-=nNode.dist;
		}
		ans = Math.max(ans, totalDist);
	}

}
