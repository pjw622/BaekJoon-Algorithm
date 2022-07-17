import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1969_a {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int input[][] = new int[m][4];
		int charArr[] = {'A', 'C', 'G', 'T'};
		
		String dnaArr[] = new String[n];
		StringBuilder sb = new StringBuilder();
		int hammingDistance = 0;
		
		for(int i=0; i<n; i++) {
			String dna = br.readLine();
			dnaArr[i] = dna;
			for(int j=0; j<m; j++) {
				if(dna.charAt(j) == 'A') {
					input[j][0]++;
				}
				else if(dna.charAt(j) == 'C') {
					input[j][1]++;
				}
				else if(dna.charAt(j) == 'G') {
					input[j][2]++;
				}
				else if(dna.charAt(j) == 'T') {
					input[j][3]++;
				}
			}
		}
		
		
		
	}

}
