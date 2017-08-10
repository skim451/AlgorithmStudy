import java.util.Scanner; 

public class Main {
	private static final Scanner scanner = new Scanner(System.in); 
	private int size, nums[], memo[]; 

	public Main() { 
		size = scanner.nextInt(); 
		nums = new int[size]; 
		memo = new int[size];

		for (int i = 0; i < size; i++) { 
			nums[i] = scanner.nextInt(); 
			memo[i] = 0; 
		}
	}

	private int getMaxAscSum(int index) {
		if (index >= size) 
			return 0; 

		if (index == size - 1) 
			memo[index] = nums[index]; 

		if (memo[index] == 0) {
			int max = 0; 
			for (int i = index + 1; i < size; i++) {
				if (nums[i] > nums[index]) {
					if (getMaxAscSum(i) > max) 
						max = getMaxAscSum(i); 
				}
			}
			memo[index] = nums[index] + max; 
		}
		
		return memo[index]; 
	}

	public void solve() {
		int max = 0; 
		for (int i = 0; i < size; i++) {
			if (memo[i] == 0) {
				int result = getMaxAscSum(i); 
				max = max > result ? max : result;
			}
		}
		System.out.println(max); 
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.solve(); 
	}
}