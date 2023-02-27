import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem_1068 {
	static Map<Integer, ArrayList<Integer>> tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int ans = 0;
		
		int n = Integer.parseInt(br.readLine());
		tree = new HashMap<Integer, ArrayList<Integer>>();
		
		
		for(int i=0; i<n; i++) {
			tree.put(i, new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			int parentNode = Integer.parseInt(st.nextToken());
			if(parentNode != -1) {
				tree.get(parentNode).add(i);
			}
		}
		int deletedNode = Integer.parseInt(br.readLine());
		
		//test
		Map<Integer, ArrayList<Integer>> temp = tree;
//		System.out.println(temp);
		
		dfs(deletedNode);
		tree.remove(deletedNode);
		
		for(Integer key : tree.keySet()) {
			if(tree.get(key).size() == 0) {
				ans++;
				continue;
			}
			for(int node : tree.get(key)) {
				if(tree.get(node) == null) {
					ans++;
				}
			}
		}
		
		bw.write(Integer.toString(ans));
		bw.flush();
		
	}
	
	static public void dfs(int deletedNode) {
		for(int node : tree.get(deletedNode)) {
			dfs(node);
			tree.remove(node);
		}
	}

}
