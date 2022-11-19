import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_11725 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<ArrayList<Integer>> graph =  new ArrayList<ArrayList<Integer>>();
		int n = Integer.parseInt(br.readLine());
		int parentArr[] = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		
		dfs(graph, parentArr, 1, 0);
		
		for(int i=2; i<n+1; i++) {
			bw.write(Integer.toString(parentArr[i])+"\n");
		}
		bw.flush();
		
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> graph, int parentArr[], int start, int parent) {
		parentArr[start] = parent;
		for(int item : graph.get(start)) {
			if(item != parent) {
				dfs(graph, parentArr, item, start);
			}
		}
	}

}
