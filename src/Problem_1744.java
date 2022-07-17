import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Problem_1744 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> minusList = new ArrayList<Integer>();
		ArrayList<Integer> plusList = new ArrayList<Integer>();
		
		int ans=0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine()); 
			if(num<=0) {
				minusList.add(num);
			}
			else {
				plusList.add(num);
			}
		}
		
		Collections.sort(minusList);
		Collections.sort(plusList, Collections.reverseOrder());
		
		int index=0;
		if(minusList.size()>1) {
			while(index<minusList.size()) {
				if(index+1>=minusList.size()) {
					ans+=minusList.get(index);
					break;
				}
				//안곱한게 더 크면 더하기
				if(minusList.get(index)+minusList.get(index+1)>=minusList.get(index)*minusList.get(index+1)) {
					ans+=minusList.get(index);
					index+=1;
				}
				//곱한게 더 크면 곱하기
				else if(minusList.get(index)+minusList.get(index+1)<minusList.get(index)*minusList.get(index+1)) {
					ans+=minusList.get(index)*minusList.get(index+1);
					index+=2;
				}
			}
		}
		else if(minusList.size()==1){
			ans+=minusList.get(0);
		}
		
		
		index=0;
		if(plusList.size()>1) {
			while(index<plusList.size()) {
				if(index+1>=plusList.size()) {
					ans+=plusList.get(index);
					break;
				}
				//안곱한게 더 크면 더하기
				if(plusList.get(index)+plusList.get(index+1)>=plusList.get(index)*plusList.get(index+1)) {
					ans+=plusList.get(index);
					index+=1;
				}
				//곱한게 더 크면 곱하기
				else if(plusList.get(index)+plusList.get(index+1)<plusList.get(index)*plusList.get(index+1)) {
					ans+=plusList.get(index)*plusList.get(index+1);
					index+=2;
				}
			}
		}
		else if(plusList.size()==1){
			ans+=plusList.get(0);
		}
		
		
		bw.write(Integer.toString(ans));
		bw.flush();
	}

}
