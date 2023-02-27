import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem_1068_2 {
	static Map<Integer, ArrayList<Integer>> tree;
	static int deletedNode;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int rootNode = -1;
		
		int n = Integer.parseInt(br.readLine());
		tree = new HashMap<Integer, ArrayList<Integer>>();
		
		
		for(int i=0; i<n; i++) {
			tree.put(i, new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			int parentNode = Integer.parseInt(st.nextToken());
			if(parentNode == -1) {
				rootNode = i;
				continue;
			}
			tree.get(parentNode).add(i);
		}
		deletedNode = Integer.parseInt(br.readLine());
		
		//test
//		Map<Integer, ArrayList<Integer>> temp = tree;
//		System.out.println(temp);
		
		if(deletedNode == rootNode) {
			bw.write(Integer.toString(0));
		}
		else {
			dfs(rootNode);
			bw.write(Integer.toString(ans));
		}
		bw.flush();
		
	}
	
	static public void dfs(int node) {
		if(tree.get(node).size() == 0) {
			ans++;
			return;
		}
		
		for(int nNode : tree.get(node)) {
			if(nNode == deletedNode) {
				if(tree.get(node).size()==1) {
					ans++;
					continue;
				}
				else {
					continue;
				}
			}
			dfs(nNode);
		}
	}
}
