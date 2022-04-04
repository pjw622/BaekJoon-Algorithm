import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2875 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int girls = Integer.parseInt(st.nextToken());
		int boys = Integer.parseInt(st.nextToken());
		int internship = Integer.parseInt(st.nextToken());
		
		while(internship != 0) {
			if(girls == 0 || boys == 0) {
				break;
			}
			if(girls/2 >= boys) {
				girls-=1;
				internship-=1;
			}
			else {
				boys-=1;
				internship-=1;
			}
		}
		
//		if(girls == 0 || boys == 0) {
//			bw.write("0");
//			bw.flush();
//		}
//		else {
//			bw.write(Integer.toString(Math.min(girls/2, boys)));
//			bw.flush();
//		}
		bw.write(Integer.toString(Math.min(girls/2, boys)));
		bw.flush();
		

	}

}
