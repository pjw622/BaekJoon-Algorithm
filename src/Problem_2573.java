import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2573 {
	static boolean visited[][];
	static int graph[][];
	static int n;
	static int m;
	static int mr[] = {0, -1, 0, 1};
	static int mc[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			visited = new boolean[n][m];
			
			boolean visitedTest[][] = visited;
			int graphTest[][] = graph;
			
			if(isAllMelt(graph)) {
				ans=0;
				break;
			}
			int land = 0;
			
			for(int i=1; i<n-1; i++) {
				for(int j=1; j<m-1; j++) {
					if(visited[i][j] == false&&graph[i][j]!=0) {
						dfs(i,j);
						land++;
					}
				}
			}
			if(land>1) {
				break;
			}
			melting();
			ans++;
		}
		
		bw.write(Integer.toString(ans));
		bw.flush();
	}
	
	static void dfs(int row, int col) {
		if(visited[row][col]) {
			return;
		}
		visited[row][col] = true;
		for(int i=0; i<4; i++) {
			int nRow = row+mr[i];
			int nCol = col+mc[i];
			if(validRange(nRow, nCol)&&graph[nRow][nCol]!=0) {
				dfs(nRow, nCol);
			}
		}
	}
	
	static boolean validRange(int row, int col) {
		if(row>=1 && row<n-1 && col>=1 && col<m-1) {
			return true;
		}
		return false;
	}
	
	static boolean isAllMelt(int graph[][]) {
		for(int i=1; i<n-1; i++) {
			for(int j=1; j<m-1; j++) {
				if(graph[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void melting() {
		int meltingDegree[][] = new int[n][m];
		for(int i=1; i<n-1; i++) {
			for(int j=1; j<m-1; j++) {
				for(int k=0; k<4; k++) {
					if(graph[i+mr[k]][j+mc[k]] == 0) {
						meltingDegree[i][j] -=1;
					}
				}
			}
		}
		for(int i=1; i<n-1; i++) {
			for(int j=1; j<m-1; j++) {
				graph[i][j] += meltingDegree[i][j];
				if(graph[i][j]<0) graph[i][j]=0;
			}
		}
	}

}
