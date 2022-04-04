import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int input = Integer.parseInt(br.readLine());
		int bag3 = 1;
		int bag5 = 0;
		
		if(input%5==0) {
			bw.write(Integer.toString(input/5));
		}
		else {
			while(true) {
				input-=3;
				if(input%5==0) {
					bag5 = input/5;
					bw.write(Integer.toString(bag3+bag5));
					break;
				}
				
				if(input==0) {
					bw.write(Integer.toString(bag3));
					break;
				}
				else if(input<3) {
					bw.write("-1");
					break;
				}
				bag3++;
			}
		}
		
		bw.flush();
		
	}

}
