import java.util.Scanner;
import java.util.Stack;

public class Problem2504 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		Stack<String> stack = new Stack<>();
		String inputArr[] = new String[input.length()];
		
		//String input을 배열로 변경
		for(int i=0; i<input.length(); i++) {
			inputArr[i] = Character.toString(input.charAt(i));
		}
		
		for(int i=0; i<inputArr.length; i++) {
			System.out.println(inputArr[i]);
			if(inputArr[i].equals("(")||inputArr[i].equals("[")) {
				stack.push(inputArr[i]);
			}
			else if(inputArr[i].equals(")")||inputArr[i].equals("]")) {
				int pushVal = 1;
				boolean isNumeric = false;
				while(true) {
					String peek = stack.pop();
					System.out.println("peek : "+peek);
					if(!peek.equals("(")||peek.equals("[")) {
						if(peek.equals("(")) {
							pushVal*=2;
						}
						else if(peek.equals("[")) {
							pushVal*=3;
						}
					}
					else {
						if(isNumeric = false) {
							if(peek.equals("(")) {
								pushVal*=2;
							}
							else if(peek.equals("[")) {
								pushVal*=3;
							}
							isNumeric = true;
						}
						else {
						}
						
						System.out.println("pushVal : "+pushVal);
						stack.push(Integer.toString(pushVal));
						break;
					}
				}
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		

	}

}
