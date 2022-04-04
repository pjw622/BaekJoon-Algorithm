import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
//import java.util.StringTokenizer;

public class Problem_1026 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;
		
		int arrSize = Integer.parseInt(br.readLine());
		int arrA[] = new int[arrSize];
		int arrB[] = new int[arrSize];
//		Integer arrB[] = new Integer[arrSize];
		int ans = 0;
		String splits[];
		
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<arrSize; i++) {
//			arrA[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<arrSize; i++) {
//			arrB[i] = Integer.parseInt(st.nextToken());
//		}
		
		splits = br.readLine().split(" ");
		for(int i=0; i<arrSize; i++) {
			arrA[i] = Integer.parseInt(splits[i]);
		}
		
		splits = br.readLine().split(" ");
		for(int i=0; i<arrSize; i++) {
			arrB[i] = Integer.parseInt(splits[i]);
		}
		
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
//		Arrays.sort(arrB, Collections.reverseOrder());
		
		for(int i=0; i<arrSize; i++) {
			ans+=arrA[i]*arrB[arrSize-i-1];
		}
		bw.write(Integer.toString(ans));
		bw.flush();
	}

}
