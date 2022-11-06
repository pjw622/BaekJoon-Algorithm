import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_1439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char firstNum;
		char preNum;
		int equalToFirstCnt = 1;
		int diffToFirstCnt = 0;
		
		String input = br.readLine();
		preNum = input.charAt(0);
		firstNum = input.charAt(0);
		
		for(int i=1; i<input.length(); i++) {
			char curNum = input.charAt(i);
			if(preNum != curNum) {
				preNum = curNum;
				if(curNum == firstNum) {
					equalToFirstCnt++;
				}
				else {
					diffToFirstCnt++;
				}
			}
		}
		
		bw.write(Integer.toString(Math.min(equalToFirstCnt, diffToFirstCnt)));
		bw.flush();
	}

}
