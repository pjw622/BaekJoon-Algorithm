import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.x>o.x) {
			return 1;
		}
		else if (this.x == o.x) {
			if(this.y>o.y) {
				return 1;
			}
		}
		return -1;
	}
}

public class Problem_11650 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<>();
		
		for(int i=0; i<testCase; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			bw.write(list.get(i).x+ " "+list.get(i).y+"\n");
		}
		bw.flush();
	}

}
