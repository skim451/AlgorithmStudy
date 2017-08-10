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

		public void insert(char val, char left, char right) {
			if (this.val == val) {
				if (left != '.')
					this.left = new Node(left);
				if (right != '.')
					this.right = new Node(right);
			} else {
				if (this.left != null) 
					this.left.insert(val, left, right); 
				if (this.right != null) 
					this.right.insert(val, left, right); 
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in); 
	private Node root; 
	private int numNode; 

	public Main() { 
		numNode = scanner.nextInt(); 
		char curr, left, right; 
		for(int i = 0; i < numNode; i++) {
			curr = scanner.next().charAt(0);  
			left = scanner.next().charAt(0); 
			right = scanner.next().charAt(0); 
			insert(curr, left, right);
		}
	}

	public void insert(char val, char left, char right){ 
		if(this.root == null){
			this.root = new Node(val);
			if (left != '.') 
				this.root.left = new Node(left); 
			if (right != '.')
				this.root.right = new Node(right); 
		}
		
		this.root.insert(val, left, right);
	}

	public void preorder(Node node) {
		if (node == null) 
			return; 

		System.out.print(node.val); 
		preorder(node.left); 
		preorder(node.right); 
	}

	public void inorder(Node node) {
		if (node == null) 
			return; 

		inorder(node.left); 
		System.out.print(node.val); 
		inorder(node.right); 		
	}

	public void postorder(Node node) {
		if (node == null) 
			return; 

		postorder(node.left);  
		postorder(node.right); 
		System.out.print(node.val);
	}

	public void solve() { 
		preorder(root); 
		System.out.println(); 
		inorder(root); 
		System.out.println(); 
		postorder(root); 
		System.out.println(); 
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.solve(); 
	}
}