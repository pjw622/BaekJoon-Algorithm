import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_1789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long input = Long.parseLong(br.readLine());
		long accumulateNum =0;
		long num = 1;
		while(accumulateNum!=input) {
			if(input>=accumulateNum+(num+num+1)) {
				accumulateNum+=num;
				num++;
			}
			else {
				accumulateNum+=input-accumulateNum;
			}
		}
		
		bw.write(Long.toString(num));
		bw.flush();

	}

}
