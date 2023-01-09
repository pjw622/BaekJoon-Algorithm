import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Problem_11724 {
	
	static boolean visited[]  = new boolean[1001];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int point1 = Integer.parseInt(st.nextToken());
			int point2 = Integer.parseInt(st.nextToken());
			graph.get(point1).add(point2);
			graph.get(point2).add(point1);
		}
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		bw.write(Integer.toString(ans));
		bw.flush();
	}
	
	public static void dfs(int start) {
		if(visited[start]) {
			return;
		}
		
		visited[start] = true;
		
		for(int i=0; i<graph.get(start).size(); i++) {
			dfs(graph.get(start).get(i));
		}
	}

}
