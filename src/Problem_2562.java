import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_2562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int arr[] = new int[9];
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		
		bw.write(max+"\n");
		bw.write(""+(maxIndex+1));
		bw.flush();
	}

}
