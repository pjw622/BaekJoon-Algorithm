import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		int ans = 0;
		int coin[] = new int[10];
		int index = 9;
		
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		
		while(total!=0) {
			if(coin[index]>0 && coin[index]<=total) {
				ans += total/coin[index];
				total = total%coin[index];
			}
			index--;
		}
		
		bw.write(Integer.toString(ans));
		bw.flush();
	}

}
