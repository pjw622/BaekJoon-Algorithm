import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_1715 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Long> pQueue = new PriorityQueue<>();
		long ans = 0;

		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			pQueue.add(Long.parseLong(br.readLine()));
		}
		
		if(n==1) {
			ans = 0;
		}
		
		while(pQueue.size()>1) {
			Long temp1 = pQueue.poll();
			Long temp2 = pQueue.poll();
			ans += temp1+temp2;
			pQueue.add(temp1+temp2);
		}

		bw.write(Long.toString(ans));
		bw.flush();
	}

}
