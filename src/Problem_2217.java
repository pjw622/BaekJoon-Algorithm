import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem_2217 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Integer rope[] = new Integer[n];
		int maxHeight = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rope, Collections.reverseOrder());
		maxHeight = rope[0];
		
		if(n!=1) {
			for(int i=1; i<n; i++) {
				maxHeight = Math.max(maxHeight, rope[i]*(i+1));
			}
		}
		
		bw.write(Integer.toString(maxHeight));
		bw.flush();
		
	}

}
