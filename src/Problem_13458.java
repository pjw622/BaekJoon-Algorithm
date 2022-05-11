import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int tester[] = new int[n]; 
		
		// ������ �� �Է�
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			tester[i] = Integer.parseInt(st.nextToken());
		}
		
		// ������ �ɷ�ġ �Է�
		st = new StringTokenizer(br.readLine());
		int mainViewer = Integer.parseInt(st.nextToken());
		int subViewer = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		
		for(int i=0; i<n; i++) {
			if(tester[i]<=mainViewer) {
				ans++;
				continue;
			}
			else {
				int subTester = tester[i]-mainViewer;
				ans++; // ���� ������ 1�� �߰�
				if(subTester%subViewer==0) {
					ans+=subTester/subViewer;
				}
				else {
					ans=ans+(subTester/subViewer)+1;
				}
			}
		}
		
		bw.write(Long.toString(ans));
		bw.flush();


	}

}
