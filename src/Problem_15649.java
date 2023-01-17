import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_15649 {
	static int arr[];
	static boolean visited[];
	static int n;
	static int targetDepth;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		targetDepth = Integer.parseInt(st.nextToken());
		
		arr = new int[targetDepth];
		visited = new boolean[n];
		
		backTracking(0);
		bw.flush();

	}
	
	private static void backTracking(int depth) throws IOException {
		if(depth==targetDepth) {
			for(int num : arr) {
				bw.write(Integer.toString(num)+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				backTracking(depth+1);
				visited[i] = false;
			}
		}
		
	}

}
