import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Problem_10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		Integer nums[] = new Integer[input.length()];
		int sum = 0;
		String ans="";
		
		if(!input.contains("0")) {
			bw.write("-1");
			bw.flush();
		}
		else {
			for(int i=0; i<nums.length; i++) {
				nums[i] = Character.getNumericValue(input.charAt(i)); 
			}
			
			for(int num : nums) {
				sum+=num;
			}
			
			if(sum%3==0){
				Arrays.sort(nums, Collections.reverseOrder());
//				for(int num : nums) {
//					ans+=Integer.toString(num);
//				}
				
				StringBuilder sb = new StringBuilder();
				for(int num : nums) {
					sb.append(Integer.toString(num));
				}
				
				bw.write(sb.toString());
				bw.flush();
			}
			else {
				bw.write("-1");
				bw.flush();
			}
		}
	}

}
