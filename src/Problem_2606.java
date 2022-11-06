import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class Graph{
	Node[] nodes;
	int clusteredNodeCnt;
	
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		Node(int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<>();
		}
	}
	
	Graph(int size){
		nodes = new Node[size];
		clusteredNodeCnt = 0;
		for(int i=0; i<size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n1)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	int dfs(int startNode) {
		Stack<Node> stack = new Stack<>();
		Node root = nodes[startNode];
		stack.push(root);
		root.marked = true;
		while(!stack.isEmpty()) {
			Node r = stack.pop();
			for(Node n : r.adjacent) {
				if(n.marked==false) {
					n.marked = true;
					clusteredNodeCnt++;
					stack.push(n);
				}
			}
		}
		return clusteredNodeCnt;
	}
	
	int dfsR(int startNode) {
		dfsR(nodes[startNode]);
		return clusteredNodeCnt;
	}
	
	void dfsR(Node r) {
		if(r == null) return;
		r.marked = true;
		for(Node n : r.adjacent) {
			if(n.marked ==false) {
				clusteredNodeCnt++;
				dfsR(n);
			}
			
		}
	}
	
}

public class Problem_2606 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int totalNode = Integer.parseInt(br.readLine());
		int totalAdjacent = Integer.parseInt(br.readLine());
		Graph graph = new Graph(totalNode+1);
		
		for(int i=0; i<totalAdjacent; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			graph.addEdge(node1, node2);
		}
		
		bw.write(Integer.toString(graph.dfsR(1)));
		bw.flush();
	}

}
