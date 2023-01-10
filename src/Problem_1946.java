import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Applicant{
	int paperScore;
	int interviewScore;
}

class PaperScoreComparator implements Comparator<Applicant>{

	@Override
	public int compare(Applicant o1, Applicant o2) {
		return o1.paperScore-o2.paperScore;
	}
	
}

class interviewScoreComparator implements Comparator<Applicant>{

	@Override
	public int compare(Applicant o1, Applicant o2) {
		return o1.interviewScore-o2.interviewScore;
	}
}

public class Problem_1946 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc<testCase; tc++) {
			int n = Integer.parseInt(br.readLine());
			Applicant paperAsc[] = new Applicant[n];
			Applicant interviewAsc[] = new Applicant[n];
			
			int ans = 0;
			int paperMin = Integer.MAX_VALUE;
			int interviewMin = Integer.MAX_VALUE;
			boolean passYn[] = new boolean[n];
			boolean paperEnd = false;
			boolean interviewEnd = false;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				paperAsc[i] = new Applicant();
				paperAsc[i].paperScore = paper;
				paperAsc[i].interviewScore = interview;
				interviewAsc[i] = new Applicant();
				interviewAsc[i].paperScore = paper;
				interviewAsc[i].interviewScore = interview;
			}
			
			
			PaperScoreComparator paperScoreComparator = new PaperScoreComparator();
			interviewScoreComparator interviewScoreComparator = new interviewScoreComparator();
			
			Arrays.sort(paperAsc, paperScoreComparator);
			Arrays.sort(interviewAsc, interviewScoreComparator);
			
			
//			for(int i=0; i<paperAsc.length; i++) {
//				System.out.println(paperAsc[i].paperScore+" "+paperAsc[i].interviewScore);
//			}
//			
//			for(int i=0; i<interviewAsc.length; i++) {
//				System.out.println(interviewAsc[i].paperScore+" "+interviewAsc[i].interviewScore);
//			}
			
			
			for(int i=0; i<n; i++) {
				if(i>=paperMin-1 && i>=interviewMin-1) {
					break;
				}
				if((passYn[paperAsc[i].paperScore-1]==false) && (paperAsc[i].interviewScore < interviewMin)) {
					passYn[paperAsc[i].paperScore-1] = true;
					interviewMin = paperAsc[i].interviewScore;
					ans++;
				}
				if((passYn[interviewAsc[i].paperScore-1]==false) && (interviewAsc[i].paperScore < paperMin)) {
					passYn[interviewAsc[i].paperScore-1] = true;
					paperMin = interviewAsc[i].paperScore;
					ans++;
				}
			}
			
			bw.write(Integer.toString(ans)+"\n");
			bw.flush();
		}
		
	}

}
