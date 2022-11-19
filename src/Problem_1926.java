import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem_1926 {
	static int n;
	static int m;
	static int mr[] = {0, 1, 0, -1};
	static int mc[] = {-1, 0, 1, 0};
	static int size = 0;;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int graph[][] = new int[n][m];
		boolean visited[][] = new boolean[n][m];
		ArrayList<Integer> pictures = new ArrayList<>();
		//그래프 마킹
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && graph[i][j] == 1 ) {
					size = 0;
					dfs(i,j,graph,visited);
					pictures.add(size);
				}
			}
		}
		Collections.sort(pictures, Collections.reverseOrder());
		if(pictures.size()>0) {
			bw.write(Integer.toString(pictures.size())+"\n");
			bw.write(Integer.toString(pictures.get(0)));
		}
		else {
			bw.write("0\n");
			bw.write("0");
		}
		
		bw.flush();
		
	}
	
	public static void dfs(int row, int col, int graph[][], boolean visited[][]) {
		visited[row][col] = true;
		if(graph[row][col] != 1) {
			return;
		}
		size++;
		for(int i=0; i<4; i++) {
			int nextRow = row+mr[i];
			int nextCol = col+mc[i];
			if(isValidFiled(nextRow, nextCol)&&!visited[nextRow][nextCol]) {
				dfs(nextRow, nextCol, graph, visited);
			}
		}
	}
	
	public static boolean isValidFiled(int row, int col) {
		if(row>=0 && col >=0 && row<n && col<m) {
			return true;
		}
		return false;
	}
}
