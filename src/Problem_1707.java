import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_1707 {
//	static boolean visited[];
	static int visited[];
	static ArrayList<ArrayList<Integer>> graph;
//	static ArrayList<Integer> groupList[] = new ArrayList[2];
	static boolean isBipartiteGraph = true;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<ArrayList<Integer>>();
//			groupList[0] = new ArrayList<Integer>();
//			groupList[1] = new ArrayList<Integer>();
			visited = new int[v+1];
			isBipartiteGraph = true;
			
			//정점 생성
			for(int i=0; i<=v; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			//간선 연결
			for(int i=1; i<=e; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				graph.get(v1).add(v2);
				graph.get(v2).add(v1);
			}
			
			for(int i=1; i<=v; i++) {
				if(isBipartiteGraph == false) {
					break;
				}
				if(graph.get(i).size() == 0) {
					continue;
				}
				if(visited[i] == 0) {
					dfs(i,1);
				}
			}
			
			if(isBipartiteGraph == false) {
				bw.write("NO"+"\n");
			}
			else {
				bw.write("YES"+"\n");
			}
			
		}
		
		bw.flush();
		
	}
	
	public static void dfs(int vertex, int group) {  
		if(visited[vertex] !=0) {
			return;
		}
		visited[vertex] = group;
		
//		for(int adjacentVertex : graph.get(vertex)) {
//			if(groupList[group].contains(adjacentVertex)) {
//				isBipartiteGraph = false;
//				return;
//			}
//		}
//		groupList[group].add(vertex);
//		group = (group == 0) ? 1: 0;
		for(int adjacentVertex : graph.get(vertex)) {
			if(visited[adjacentVertex] !=0) {
				if(visited[adjacentVertex]+visited[vertex] !=0) {
					isBipartiteGraph = false;
					return;
				}
			}
			
			dfs(adjacentVertex, group*-1);
		}
	}

}
