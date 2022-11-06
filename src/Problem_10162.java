import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_10162 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		int timer[] = {300, 60, 10};
//		int timerCnt[] = new int[3];
		
		if(input%10 == 0) {
			while(input !=0) {
				for(int i=0; i<timer.length; i++) {
//						timerCnt[i] += input/timer[i];
					bw.write(Integer.toString(input/timer[i])+" ");
					input = input%timer[i];
				}
			}
		}
		else {
			bw.write(Integer.toString(-1));
		}
		
		
		bw.flush();
	}

}
