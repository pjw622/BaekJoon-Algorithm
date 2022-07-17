import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Problem_1541 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		int accumulateNum = 0;
		sb.append(br.readLine());
		
//		System.out.println(sb.length());
//		System.out.println(sb.indexOf("+"));
//		System.out.println(sb.indexOf("-"));
//		System.out.println(sb.substring(0, Math.min(sb.indexOf("+"), sb.indexOf("-"))));
//		System.out.println(sb.delete(0, 2));
//		System.out.println(sb.toString());
		
		while(true) {
			int cutIndex = 0;
			int plusIndex = sb.indexOf("+",1);
			int minusIndex = sb.indexOf("-",1);
			if(plusIndex==-1 && minusIndex==-1) {
				stack.push(Integer.parseInt(sb.substring(0,sb.length())));
				break;
			}
			else if(plusIndex == -1 || minusIndex == -1 ){
				cutIndex = Math.max(plusIndex, minusIndex);
			}
			else {
				cutIndex = Math.min(plusIndex, minusIndex);
			}
			
			stack.push(Integer.parseInt(sb.substring(0, cutIndex)));
			
			sb.delete(0, cutIndex);
		}
		
		while(stack.size()>0) {
			int popNum = stack.pop();
			if(popNum<0) {
				if(accumulateNum==0) {
					ans+=popNum;
				}
				else {
					ans-=accumulateNum+Math.abs(popNum);
					accumulateNum=0;
				}
			}
			else {
				accumulateNum+=popNum;
			}
		}
		ans+=accumulateNum;
		bw.write(Integer.toString(ans));
		bw.flush();
		
	}

}
