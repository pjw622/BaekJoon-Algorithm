import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_2753 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		
		if(input%4==0) {
			if(input%400 ==0 || input%100 !=0) {
				bw.write("1");
			}
			else {
				bw.write("0");
			}
			
		}
		else {
			bw.write("0");
		}
		bw.flush();
	}

}
