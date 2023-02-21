import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem_2210 {
	static int mr[] = {0, -1, 0, 1};
	static int mc[] = {1, 0, -1, 0};
	static int board[][] = new int[5][5];
//	static ArrayList<String> nums = new ArrayList<>();
	static HashSet<String> hashSet = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
//				dfs(i, j, 0, "");
				dfs(i, j, 0);
			}
		}
		
		bw.write(Integer.toString(hashSet.size()));
		bw.flush();
	}
	
	public static void dfs(int row, int col, int length) {
		length+=1;
//		num+=num+board[row][col];
		sb.append(board[row][col]);
		
		if(length==6) {
			hashSet.add(sb.toString());
			sb.deleteCharAt(sb.length()-1);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nRow = row+mr[i];
			int nCol = col+mc[i];
			if(isValidArea(nRow, nCol)) {
				dfs(nRow, nCol, length);
			}
		}
		sb.deleteCharAt(sb.length()-1);
	}
	
	public static boolean isValidArea(int i, int j) {
		if(i>=0 && i<5 && j>=0 && j<5) {
			return true;
		}
		return false;
	}

}
