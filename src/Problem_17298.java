import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_17298 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int seq[] = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(0);
		
		for(int i=1; i<n; i++) {
			if(seq[i] <= seq[stack.peek()]) {
				stack.push(i);
			}
			else if(seq[i]>seq[stack.peek()]) {
				int stackSize = stack.size();
//				for(int j=0; j<stackSize; j++) {
//					if(seq[stack.peek()]<seq[i]) {
//						seq[stack.pop()] = seq[i];
//					}
//				}
				while(!stack.empty() && seq[stack.peek()] < seq[i]) {
					seq[stack.pop()] = seq[i];
				}
				stack.push(i);
			}
		}
		
		int stackSize = stack.size();
		for(int i=0; i<stackSize; i++) {
			seq[stack.pop()] = -1;
		}
		
		for(int i=0; i<n; i++) {
			bw.write(Integer.toString(seq[i])+" ");
		}
		bw.flush();
	}

}
