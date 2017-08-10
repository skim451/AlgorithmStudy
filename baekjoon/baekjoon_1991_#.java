import java.util.Scanner; 

public class Main {
	private class Node {
		public char val; 
		public Node left, right; 
		public Node (char val) {
			this.val = val; 
			this.left = null; 
			this.right = null; 
		}

		public void insert(char val) {
			if (val < this.val) {
				if (this.left == null) 
					this.left = new Node(val); 
				else 
					this.left.insert(val); 
			}
			else {
				if (this.right == null) 
					this.right = new Node(val); 
				else 
					this.right.insert(val); 
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in); 
	private Node root; 
	private int numNode; 

	public Main() { 
		numNode = scanner.nextInt(); 
		Char curr; 
		for(int i = 0; i < numNode; i++) {
			curr = scanner.nextChar(); 
			insert(curr); 
			scanner.nextChar(); 
			scanner.nextChar(); 
		}
	}

	public void insert(Char val){ 
		if(this.root == null){
			this.root = new Node(val);
		}
		
		this.root.insert(val);
	}

	public static void main(String[] args) {

	}
}