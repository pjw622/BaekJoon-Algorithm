import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_4796 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int tc=1;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()); //몇일동안 사용 가능한지
			int p = Integer.parseInt(st.nextToken()); // 연속 몇일동안
			int v = Integer.parseInt(st.nextToken()); //휴가 일수
			int ans;
			
			if(l == 0 && p == 0 && v == 0) {
				bw.flush();
				break;
			}
			
			ans = (v/p)*l+Math.min((v%p), l);
			
			
			
			bw.write("Case "+tc+":"+" "+ans+"\n");
			tc++;
		}

	}

}
