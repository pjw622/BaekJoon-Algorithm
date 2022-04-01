import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Stack;

public class Problem_10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i<inputCnt; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				stack.pop();
			}
			else {
				stack.push(input);
			}
		}
		
		while(!stack.isEmpty()) {
			result+=stack.pop();
		}
		bw.write(String.valueOf(result));
		bw.flush();
		

	}

}
