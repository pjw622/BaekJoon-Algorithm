import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem_13305 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int cityCnt = Integer.parseInt(br.readLine());
		int oilPrice[] = new int[cityCnt];
		int distance[] = new int[cityCnt-1];
		long accumulateOil = 0;
		long minPrice;
		long totalPrice=0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<distance.length; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<oilPrice.length; i++) {
			oilPrice[i] = Integer.parseInt(st.nextToken());
		}
		
		minPrice = oilPrice[0];
		
		for(int i=0; i<oilPrice.length; i++) {
			int curPrice = oilPrice[i];
			if(curPrice<minPrice) {
				totalPrice+=accumulateOil*minPrice;
				minPrice = curPrice;
				accumulateOil = 0;
			}
			if(i == oilPrice.length-1) {
				totalPrice+=accumulateOil*minPrice;
			}
			else {
				accumulateOil+=distance[i];
			}
		}
		
		bw.write(Long.toString(totalPrice));
		bw.flush();
	}

}
