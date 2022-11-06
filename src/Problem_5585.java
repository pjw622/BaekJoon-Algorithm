import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem_5585 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		int receiveCoin = 1000-input;
		int coin[] = {500, 100, 50, 10, 5, 1};
		int ans = 0;
		
		while(receiveCoin !=0) {
			for(int i=0; i<coin.length; i++) {
				if(receiveCoin >= coin[i]) {
					ans += receiveCoin/coin[i];
					receiveCoin = receiveCoin%coin[i];
				}
			}
		}
		
		bw.write(Integer.toString(ans));
		bw.flush();
	}

}
