
public class AP_Create {

	public static Board ba;
	public Board bb;
	
	public static void main(String[] args) {
		ba = new Board();
		ba.setShip(0, 0, 0);
		ba.setShip(2, 0, 1);
		ba.setShip(5, 5, 1);
		char[][] m = ba.getShipMap();
		for(char[] r : m){
			for(char c : r)System.out.print(c);
			System.out.println();
		}
	}

}
