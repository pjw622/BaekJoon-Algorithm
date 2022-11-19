import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_4963 {
	static int area[][];
	static boolean visited[][];
	static int moveX[] = {-1 ,0, 1, -1, 1, -1, 0, 1};
	static int moveY[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int w;
	static int h;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				break;
			}
			
			area = new int[h][w];
			visited = new boolean[h][w];
			int isLand = 0;
			
			for(int i=0; i<h; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					int landCheck = Integer.parseInt(st.nextToken());
					area[i][j] = landCheck;
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(visited[i][j] || area[i][j] != 1) {
						continue;
					}
					else {
						isLand++;
						dfs(i,j);
					}
				}
			}
			
			bw.write(Integer.toString(isLand)+"\n");
		}
		bw.flush();
	}
	
	public static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for(int n=0; n<moveX.length; n++) {
			if(rangeCheck(i+moveX[n], j+moveY[n]) && !visited[i+moveX[n]][j+moveY[n]]&&area[i+moveX[n]][j+moveY[n]] == 1) {
				dfs(i+moveX[n], j+moveY[n]);
			}
			
		}
	}

	private static boolean rangeCheck(int x, int y) {
		if(x>=0&&y>=0&&x<h&&y<w) {
			return true;
		}
		return false;
	}

}
