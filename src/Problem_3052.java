import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int modulo[] = new int[42];
		int res = 0;
		
		for(int i=0; i<10; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input==0) {
				modulo[0]++;
				continue;
			}
			int mod = input%42;
			modulo[mod] +=1;
		}
		
		for(int i=0; i<modulo.length; i++) {
			if(modulo[i]>0) {
				res++;
			}
		}
		
		bw.write(Integer.toString(res));
		bw.flush();
	}
}