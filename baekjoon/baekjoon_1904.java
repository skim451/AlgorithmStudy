import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in); 
	private int size, memo[];

	public Main() {
		this.size = scanner.nextInt(); 
		this.memo = new int[size + 1]; 

		memo[0] = 1; 
		memo[1] = 1;
	}

	private int fib(int n) {
		if(memo[n] == 0) {
			memo[n] = (fib(n - 1) + fib(n - 2)) % 15746;  
		}

		return memo[n]; 
	}

	public void solve() {
		if(size > 0)
			System.out.println(fib(this.size)); 
		else
			System.out.println(0); 
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.solve();
	}
}