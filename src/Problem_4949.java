import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Stack;

public class Problem_4949 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<String> stack = new Stack<>();
		
		while(true) {
			String input = br.readLine();
			boolean emptyAccess = false;	
			if(input.equals(".")) {
				break;
			}
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == '['||input.charAt(i) == '(') {
					stack.push(Character.toString(input.charAt(i)));
				}
				else if(input.charAt(i) == ']') {
					if(stack.isEmpty()) {
//						bw.write("no"+"\n");
						emptyAccess = true;
						break;
					}
					String popVal = stack.peek();
					if(!popVal.equals("[")) {
//						bw.write("no"+"\n");
						break;
					}else {
						stack.pop();
					}
				}
				else if(input.charAt(i) == ')') {
					if(stack.isEmpty()) {
//						bw.write("no"+"\n");
						emptyAccess = true;
						break;
					}
					String popVal = stack.peek();
//					System.out.println(popVal);
					if(!popVal.equals("(")) {
//						bw.write("no"+"\n");
						break;
					}else {
						stack.pop();
					}
				}
				
//				if(i==input.length()-1) {
//					bw.write("yes"+"\n");
//				}
			}
			
			if(stack.isEmpty()&&emptyAccess==false) {
				bw.write("yes"+"\n");
			}
			else {
				bw.write("no"+"\n");
			}
			
			stack.clear();
		}
		
		bw.flush();

	}

}
