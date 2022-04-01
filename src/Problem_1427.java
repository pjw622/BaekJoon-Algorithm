import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem_1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		Integer arr[] = new Integer[input.length()];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Character.getNumericValue(input.charAt(i));
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int item : arr) {
			sb.append(item);
		}
		
		bw.write(sb.toString());
		bw.flush();
	}

}
