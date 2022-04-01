import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem_10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int inputCnt = Integer.parseInt(br.readLine());
		for(int i=0; i<inputCnt; i++) {
			String input = br.readLine();
			if(input.contains("push")) {
				String pushArr[] = new String[2];
				pushArr = input.split(" ");
				stack.push(Integer.parseInt(pushArr[1]));
			}
			else if(input.equals("pop")) {
				if(!stack.isEmpty()) {
					bw.write(String.valueOf(stack.pop())+"\n");
				}
				else {
					bw.write(String.valueOf(-1)+"\n");
				}
			}
			else if(input.equals("size")) {
				bw.write(String.valueOf(stack.size())+"\n");
			}
			else if(input.equals("empty")) {
				if(stack.isEmpty()) {
					bw.write(String.valueOf(1)+"\n");
				}
				else {
					bw.write(String.valueOf(0)+"\n");
				}
			}
			else if (input.equals("top")) {
				if(!stack.isEmpty()) {
					bw.write(String.valueOf(stack.peek())+"\n");
				}
				else {
					bw.write(String.valueOf(-1)+"\n");
				}
			}
		}
		bw.flush();
	}

}
