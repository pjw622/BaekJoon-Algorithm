import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class InterViewer{
	int paperScore;
	int interviewScore;
}

class PaperAsc implements Comparator<InterViewer>{

	@Override
	public int compare(InterViewer o1, InterViewer o2) {
		return o1.paperScore-o2.paperScore;
	}
	
}


public class Problem_1947_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<testCase; tc++) {
			int n = Integer.parseInt(br.readLine());
			InterViewer interViewerArr[] = new InterViewer[n];
			
			int ans = 0;
			int paperMin = Integer.MAX_VALUE;
			int interviewMin = Integer.MAX_VALUE;
			boolean passYn[] = new boolean[n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				interViewerArr[i] = new InterViewer();
				interViewerArr[i].paperScore = paper;
				interViewerArr[i].interviewScore = interview;
			}
			
			Arrays.sort(interViewerArr, new PaperAsc());
			
			for(int i=0; i<n; i++) {
				if(interViewerArr[i].interviewScore<interviewMin) {
					ans++;
					interviewMin = interViewerArr[i].interviewScore;
				}
			}
			
			bw.write(Integer.toString(ans)+"\n");
			bw.flush();
		}
		
	}

}
