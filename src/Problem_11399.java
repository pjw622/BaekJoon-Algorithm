import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int numbers[] = new int[n];
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		int wait = 0;
		
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		for(int item : numbers) {
			ans += wait+item;
			wait+=item;
		}
		
		bw.write(Integer.toString(ans));
		bw.flush();
	}

}
