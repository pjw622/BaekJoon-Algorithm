import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_2644 {
	static int ans = -1;
	static boolean visited[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<Integer>[] graph;
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		
		int human1 = Integer.parseInt(st.nextToken());
		int human2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		dfs(human1, human2, graph, 0);
		
		bw.write(Integer.toString(ans));
		bw.flush();
	}
	public static void dfs(int curVertex, int human2, ArrayList<Integer>[] graph, int dist) {
		visited[curVertex] = true;
		if(curVertex == human2) {
			ans = dist;
		}
		for(int item : graph[curVertex]) {
			if(!visited[item]) {
				dist++;
				dfs(item, human2, graph, dist);
				dist--;
			}
		}
		
		
	}

}
