import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_15650 {
	static int arr[];
	static int n;
	static int m;
//	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		backTracking(0, "");
		
		bw.flush();
		
	}
	
	static void backTracking(int index, String str) throws IOException {
		if(str.length() == m) {
			bw.write(addBlank(str)+"\n");
			return;
		}
		if(index == n) {
			return;
		}
		
		backTracking(index+1, str+(arr[index]));
//		str = str.substring(0,str.length()-1);
		backTracking(index+1, str);
	}
	
	static String addBlank(String str) {
		String rtn = "";
		
		for(int i=0; i<str.length(); i++) {
			rtn+=Character.toString(str.charAt(i))+" ";
		}
		return rtn;
	}

}
