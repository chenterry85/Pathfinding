import java.util.ArrayList;

public class Node implements Comparable<Node> {

	boolean visited, isStart, isEnd, isObstacle, inPath, openList;
	double g = 10e5, h = 10e5, t = g + h;
	int r, c;

	Node parent;
	ArrayList<Node> edges = new ArrayList<Node>();

	public Node(int r1, int c1) {
		r = r1;
		c = c1;
	}

	public double getDistance(Node node) {
		return Math.sqrt((node.r - this.r)*(node.r - this.r) + (node.c - this.c)*(node.c - this.c));
	}

	public boolean isDiagonal(Node node) {
		if(node.r == this.r - 1 && node.c == this.c -1)
			return true;
		if(node.r == this.r - 1 && node.c == this.c +1)
			return true;
		if(node.r == this.r + 1 && node.c == this.c -1)
			return true;
		if(node.r == this.r + 1 && node.c == this.c +1)
			return true;
		return false;
	}

	public void getEdges(Node[][] nodes) {
		if(r - 1 >= 0 && c - 1 >= 0)
			edges.add(nodes[r-1][c-1]);
		if(r - 1 >= 0)
			edges.add(nodes[r-1][c]);
		if(r - 1 >= 0 && c + 1 < nodes[0].length)
			edges.add(nodes[r-1][c+1]);
		if(c - 1 >= 0)
			edges.add(nodes[r][c-1]);
		if(c + 1 < nodes[0].length)
			edges.add(nodes[r][c+1]);
		if(r + 1 < nodes.length && c - 1 >= 0)
			edges.add(nodes[r+1][c-1]);
		if(r + 1 < nodes.length)
			edges.add(nodes[r+1][c]);
		if(r + 1 < nodes.length && c + 1 < nodes[0].length)
			edges.add(nodes[r+1][c+1]);
	}

	public boolean isNextTo(Node node){
		if(r == node.r-1 && c == node.c-1 ||
		   r == node.r-1 && c == node.c   ||
			 r == node.r-1 && c == node.c+1 ||
			 r == node.r   && c == node.c-1 ||
       r == node.r   && c == node.c+1 ||
       r == node.r+1 && c == node.c-1 ||
			 r == node.r+1 && c == node.c   ||
			 r == node.r+1 && c == node.c+1)
			 return true;
		return false;
	}

	@Override
	public int compareTo(Node node) {
		if (node.t > this.t)
			return -1;
		if (node.t < this.t)
			return 1;
		return 0;
	}

}
