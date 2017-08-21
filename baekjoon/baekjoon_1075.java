import java.util.Scanner; 

public class Main {
	private static final Scanner scanner = new Scanner(System.in); 
	private int num, divisor; 

	public Main() {
		num = scanner.nextInt(); 
		divisor = scanner.nextInt(); 
	}

	public void solve() {
		int lastTwo = num % 100;
		int remainder = num % divisor; 

		lastTwo += divisor - remainder; 

		while(lastTwo >= divisor) {
			lastTwo -= divisor; 
		}

		System.out.print(lastTwo / 10); 
		System.out.print(lastTwo % 10); 
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.solve(); 
	}
}