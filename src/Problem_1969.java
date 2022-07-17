import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_1969 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int a[] = new int[m];
		int c[] = new int[m];
		int g[] = new int[m];
		int t[] = new int[m];
		String dnaArr[] = new String[n];
		StringBuilder sb = new StringBuilder();
		int hammingDistance = 0;
		
		for(int i=0; i<n; i++) {
			String dna = br.readLine();
			dnaArr[i] = dna;
			for(int j=0; j<m; j++) {
				if(dna.charAt(j) == 'A') {
					a[j]++;
				}
				else if(dna.charAt(j) == 'C') {
					c[j]++;
				}
				else if(dna.charAt(j) == 'G') {
					g[j]++;
				}
				else if(dna.charAt(j) == 'T') {
					t[j]++;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			String addDna = "A";
			int maxDna = a[i];
			if(a[i]<c[i]) {
				addDna = "C";
				maxDna = c[i];
			}
			
			if(maxDna<g[i]) {
				addDna = "G";
				maxDna = g[i];
			}
			
			if(maxDna<t[i]) {
				addDna = "T";
				maxDna = t[i];
			}
			sb.append(addDna);
			hammingDistance+=n-maxDna;
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				if(dnaArr[i].charAt(j) != sb.toString().charAt(j)) {
//					hammingDistance++;
//				}
//			}
//		}
		
		bw.write(sb.toString()+"\n");
		bw.write(Integer.toString(hammingDistance));
		bw.flush();

	}

}
