import java.util.Scanner;

public class AP_Create {

	public static Board bp;
	public static Board bc;
	public static Computer comp;
	public static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		bp = new Board();
		bc = new Board();
		comp = new Computer(bc);
		comp.placeShips();
		printMap(bc.getShipMap());
		for (int i = 0; i < 3;) {
			System.out.print("Enter X position:");
			int x = scan.nextInt();
			System.out.print("Enter Y position:");
			int y = scan.nextInt();
			System.out.print("Enter orientation(0 horizontal, 1 vertical:");
			int o = scan.nextInt();
			if (bp.setShip(x, y, o))
				i++;
			else
				System.out.println("Invalid position");
		}
		printMap(bp.getShipMap());
		int winner = 0;
		while (bp.numHit < 12 && bc.numHit < 12) {
			int shotSuccess;
			do {
				System.out.print("X-Coordinate of Target");
				int x = scan.nextInt();
				System.out.print("Y-Coordinate of Target");
				int y = scan.nextInt();
				shotSuccess = bc.shoot(x, y);
			} while (shotSuccess != 0);
			if(shotSuccess==1)System.out.println("HIT!");
			else System.out.println("MISS");
			printMap(bc.getShotsMap());
			if(bc.numHit==12){
				System.out.println("YOU WIN!!");
				break;
			}
			
		}
	}

	public static void printMap(char[][] m) {
		for (char[] q : m) {
			for (char c : q)
				System.out.print(c);
			System.out.println();
		}
	}
}
