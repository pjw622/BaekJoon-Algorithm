import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem_1068_4 {
	static final int MX = 50;
	static int n, root, removed_node, ans;
	static int parentNodes[] = new int[MX]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			parentNodes[i] = parent;
			if(parent == -1) root = i;
		}
		
		removed_node = Integer.parseInt(br.readLine());
		if(removed_node == root) {
			bw.write(Integer.toString(0));
		}
		else {
			dfs(root);
			bw.write(Integer.toString(ans));
		}
		
		bw.flush();
		
	}
	
	static public void dfs(int node) {
		boolean isLeaf = true;
		for(int i=0; i<n; i++) {
			if(i == removed_node) {
				continue;
			}
			if(parentNodes[i] == node) {
				isLeaf = false;
				dfs(i);
			}
		}
		if(isLeaf) {
			ans++;
		}
	}
}
