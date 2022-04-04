import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//class Conference{
//	protected int start;
//	protected int end;
//	
//	public int getStart() {
//		return start;
//	}
//	public void setStart(int start) {
//		this.start = start;
//	}
//	public int getEnd() {
//		return end;
//	}
//	public void setEnd(int end) {
//		this.end = end;
//	}
//}

public class Problem_1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int lastEnd = 0;
		int ans = 0;

		//		Conference conferences[] = new Conference[n];

		//		ArrayList에 length = 2인 배열로도 해보기
		//		ArrayList<int[]> conferences = new ArrayList<int[]>();

		//		for(int i=0; i<n; i++) {
		//			conferences[i] = new Conference();
		//			st = new StringTokenizer(br.readLine());
		//			
		//			conferences[i].setStart(Integer.parseInt(st.nextToken()));
		//			conferences[i].setEnd(Integer.parseInt(st.nextToken()));
		//		}
		//		
		//		Arrays.sort(conferences, comp);
		//		
		//		for(int i=0; i<n; i++) {
		//			if(lastEnd<=conferences[i].getStart()) {
		//				lastEnd = conferences[i].getEnd();
		//				ans++;
		//			}
		//		}

		//		배열로 해보기
		int conferences[][] = new int [n][2]; 

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			conferences[i][0] = Integer.parseInt(st.nextToken());
			conferences[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(conferences, comp2);

		for(int i=0; i<n; i++) {
			if(lastEnd<=conferences[i][0]) {
				lastEnd = conferences[i][1];
				ans++;
			}
		}

		bw.write(Integer.toString(ans));
		bw.flush();
	}

	//	public static Comparator<Conference> comp = new Comparator<Conference>() {
	//		
	//		@Override
	//		public int compare(Conference arg0, Conference arg1) {
	//			// TODO Auto-generated method stub
	//			if(arg0.getEnd()==arg1.getEnd()) {
	//				return arg0.getStart()-arg1.getStart();
	//			}
	//			return arg0.getEnd()-arg1.getEnd();
	//		}
	//	};

	public static Comparator<int[]> comp2 = new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[1] == o2[1]) {
				return o1[0]-o2[0];
			}
			return o1[1]-o2[1];
		}
	};

}
