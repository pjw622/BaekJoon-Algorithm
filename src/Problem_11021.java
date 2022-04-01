import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_11021 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int i=0; i<tc; i++) {
			st = new StringTokenizer(br.readLine());
			int inputA = Integer.parseInt(st.nextToken());
			int inputB = Integer.parseInt(st.nextToken());
			bw.write("Case #"+(i+1)+":"+" "+inputA+" + "+inputB+" = "+(inputA+inputB)+"\n");
		}
		bw.flush();
	}

}
