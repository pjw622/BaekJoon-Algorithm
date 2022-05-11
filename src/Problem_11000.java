import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lesson implements Comparable<Lesson>{
	int start;
	int end;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public int compareTo(Lesson o) {
		// TODO Auto-generated method stub
		return this.start-o.start;
	}
}

public class Problem_11000 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Lesson[] lessons = new Lesson[n];
		int ans = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(0);
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			lessons[i] = new Lesson();
			lessons[i].setStart(Integer.parseInt(st.nextToken()));
			lessons[i].setEnd(Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(lessons);
		
		for(int i=0; i<n; i++) {
			if(lessons[i].start>=pq.peek()) {
				pq.poll();
			}
			else {
				ans++;
			}
			pq.add(lessons[i].getEnd());
		}
		
//		for(int i=0; i<n; i++) {
//			System.out.print(lessons[i].getStart()+" ");
//			System.out.println(lessons[i].getEnd());
//		}
		
		bw.write(Integer.toString(ans));
		bw.flush();
		
	}

}
