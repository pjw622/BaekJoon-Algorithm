import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2468 {
	static int area[][];
	static int afterRainArea[][];
	static boolean visited[][];
	static int maxHeight = Integer.MIN_VALUE;
	static int mr[] = {0, -1 ,0, 1};
	static int mc[] = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int maxSafeArea = 0;
		area = new int[n][n];
		
		
		//지역 생성
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int curHeight = Integer.parseInt(st.nextToken()); 
				area[i][j] = curHeight;
				maxHeight = Math.max(maxHeight, curHeight);
			}
		}
		
		//최대 안전 영역 구하기
		// 0~maxHeight+1까지 물에 잠기게 하기
		for(int rain = 0; rain<maxHeight+1; rain++) {
			afterRainArea = new int[n][n];
			visited = new boolean[n][n];
			int safeAreaCount = 0;
			
			//물에 잠김
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(area[i][j]<rain) {
						// 1 = 잠김, 0 = 안잠김
						afterRainArea[i][j] = 1;
					}
				}
			}
			
			//잠긴 
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]&&afterRainArea[i][j]==0) {
						dfs(i, j);
						safeAreaCount++;
					}
				}
			}
			
			maxSafeArea = Math.max(maxSafeArea, safeAreaCount);
		}
		
		bw.write(Integer.toString(maxSafeArea));
		bw.flush();
	}
	
	static void dfs(int curRow, int curCol) {
		visited[curRow][curCol] = true;
		for(int i=0; i<mr.length; i++) {
			int nRow = curRow+mr[i];
			int nCol = curCol+mc[i];
			if(rangeCheck(nRow,nCol) && afterRainArea[nRow][nCol]==0&&!visited[nRow][nCol]) {
				dfs(nRow, nCol);
			}
		}
	}
	
	static boolean rangeCheck(int row, int col) {
		if(row>=0 && col>=0 && row<area[0].length && col<area[0].length) {
			return true;
		}
		return false;
	}

}
