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
	boolean passYn;
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
			Applicant applicant1[] = new Applicant[n];
			Applicant applicant2[] = new Applicant[n];
			
			int ans = 0;
			int paperMax = Integer.MAX_VALUE;
			int interviewMax = Integer.MAX_VALUE;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				applicant1[i] = new Applicant();
				applicant1[i].paperScore = paper;
				applicant1[i].interviewScore = interview;
				applicant2[i] = new Applicant();
				applicant2[i].paperScore = paper;
				applicant2[i].interviewScore = interview;
			}
			
			
			PaperScoreComparator paperScoreComparator = new PaperScoreComparator();
			interviewScoreComparator interviewScoreComparator = new interviewScoreComparator();
			
			Arrays.sort(applicant1, paperScoreComparator);
			Arrays.sort(applicant2, interviewScoreComparator);
			
//			applicant1[0].passYn = true;
			
			for(int i=0; i<applicant1.length; i++) {
				System.out.println(applicant1[i].paperScore+" "+applicant1[i].interviewScore);
			}
			
			for(int i=0; i<applicant2.length; i++) {
				System.out.println(applicant2[i].paperScore+" "+applicant2[i].interviewScore);
			}
			if(n==1) {
				ans=1;
			}
			else {
				for(int i=0; i<n; i++) {
					if(applicant1[i].paperScore<paperMax && applicant1[i].interviewScore<interviewMax && !applicant1[i].passYn) {
						paperMax = Math.min(applicant1[i].paperScore, paperMax);
						interviewMax = Math.min(applicant1[i].interviewScore, interviewMax);
						applicant1[i].passYn = true;
						ans++;
					}
					if(applicant2[i].interviewScore<interviewMax && applicant2[i].interviewScore<interviewMax && !applicant2[i].passYn) {
						paperMax = Math.min(applicant2[i].paperScore, paperMax);
						interviewMax = Math.min(applicant2[i].interviewScore, interviewMax);
						applicant2[i].passYn = true;
						ans++;
					}
				}
			}
			
			bw.write("tc# "+tc+" "+Integer.toString(ans));
			bw.flush();
		}
		
	}

}
