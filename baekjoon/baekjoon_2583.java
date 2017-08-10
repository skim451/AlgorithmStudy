import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private int width, height, numRectangle, area, numArea; 
	private boolean isRectangle[][], isVisited[][];
	private ArrayList<Integer> areaList; 

	public Main() {
		height = scanner.nextInt(); 
		width = scanner.nextInt(); 
		numRectangle = scanner.nextInt(); 

		isRectangle = new boolean[height][width]; 
		isVisited = new boolean[height][width]; 

		areaList = new ArrayList<Integer>(); 

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				isRectangle[i][j] = false; 
				isVisited[i][j] = false; 
			}
		}

		int loX, loY, hiX, hiY; 
		for (int i = 0; i < numRectangle; i++) {
			loY = scanner.nextInt(); 
			loX = scanner.nextInt(); 
			hiY = scanner.nextInt(); 
			hiX = scanner.nextInt(); 

			for (int j = loX; j < hiX; j++) {
				for (int k = loY; k < hiY; k++) {
					isRectangle[j][k] = true;
				}
			}
		}
	}

	public void dfsTouch(int x, int y) {
		if(x < 0 || y < 0 || x >= height || y >= width) 
			return ;
		if(isRectangle[x][y] || isVisited[x][y])
			return ;

		isVisited[x][y] = true; 
		area++; 

		dfsTouch(x - 1, y); 
		dfsTouch(x + 1, y);
		dfsTouch(x, y - 1);
		dfsTouch(x, y + 1);   
	}

	private void printSolutions() {
		System.out.println(numArea); 
		for (Integer area : areaList) {
			System.out.print(area + " "); 
		}
	}

	public void solve() {
		numArea = 0; 
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!isRectangle[i][j] && !isVisited[i][j]) {
					area = 0; 
					dfsTouch(i, j); 
					areaList.add(area); 
					numArea++; 
				}
			}
		}
		Collections.sort( areaList, new Comparator<Integer>() {
			@Override 
			public int compare(Integer num1, Integer num2) {
				return num1.compareTo(num2); 
			}
		});
		printSolutions();
	}	

	public static void main(String[] args) {
		Main main = new Main(); 
		main.solve(); 
	}
}