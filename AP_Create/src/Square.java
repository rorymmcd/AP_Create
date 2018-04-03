
public class Square {
	public int shipID, shipPart;
	public boolean beenHit;
	public Square(){
		shipID = -1;
		shipPart = -1;
	}
	
	public void Set(int a, int b){
		shipID = a;
		shipPart = b;
		beenHit = false;
	}
}
