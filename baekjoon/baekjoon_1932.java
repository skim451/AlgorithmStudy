import java.util.Scanner; 

public class Main {
	private static final Scanner scanner = new Scanner(System.in); 
	private int size, nums[][], memo[][]; 

	public Main() { 
		size = scanner.nextInt(); 
		nums = new int[size][size]; 
		memo = new int[size][size]; 

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i + 1; j++) {
				nums[i][j] = scanner.nextInt(); 
				memo[i][j] = 0;
			}
		}
	}

	private int max(int x, int y) {
		return x > y ? x : y; 
	}

	private int getMaxPathSum(int x, int y) {
		if (x >= size || y >= size) 
			return 0; 

		if (x == size - 1) {
			memo[x][y] = nums[x][y]; 
		}

		if(memo[x][y] == 0) {
			memo[x][y] = nums[x][y] + max(getMaxPathSum(x + 1, y), getMaxPathSum(x + 1, y + 1)); 
		}

		return memo[x][y]; 
	}

	public void solve() {
		System.out.println(getMaxPathSum(0, 0));
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.solve(); 
	}
}