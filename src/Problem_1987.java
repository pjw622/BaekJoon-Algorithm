import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1987 {
	static boolean alphabet[] = new boolean[26];
	static boolean visited[][];
	static char board[][];
	static int mr[] = {0, 1, 0, -1};
	static int mc[] = {1, 0, -1, 0};
	static int n;
	static int m;
	static int maxDistance = Integer.MIN_VALUE; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		char test = 'A'; //65
		board = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j] = input.charAt(j);
			}
		}
		
		dfs(0, 0, 0);
		bw.write(Integer.toString(maxDistance));
		bw.flush();
	}
	
	static void dfs(int row, int col, int dist) {
		dist++;
		visited[row][col] = true; // 방문 했음 체크
		alphabet[board[row][col]-65] = true; //밟은 알파벳 체크
		for(int i=0; i<4; i++) {
			int nrow = row+mr[i];
			int ncol = col+mc[i];
			if(isValidArea(nrow, ncol) && !visited[nrow][ncol] && !alphabet[board[nrow][ncol]-65]) {
				dfs(nrow, ncol, dist);
			}
		}
		visited[row][col] = false;
		alphabet[board[row][col]-65] = false;
		maxDistance = Math.max(maxDistance, dist);
	}
	
	static boolean isValidArea(int row, int col) {
		if(row>=0 && row<n && col>=0 && col<m) {
			return true;
		}
		return false;
	}

}
