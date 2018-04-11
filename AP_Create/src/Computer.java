import java.util.ArrayList;
import java.util.Random;

public class Computer {
	public Board board;
	ArrayList<int[]> hits;//hits[q] == {x,y}
	
	public Computer(Board b){
		board = b;
	}
	
	public void placeShips(){
		Random rand = new Random();
		for(int i = 0;i<3;){
			if(board.setShip(rand.nextInt(10),rand.nextInt(10),rand.nextInt(2)))i++;
		}
	}
	
	public void takeShot(Board bp){
		ArrayList<int[]> targetList;
		
	}
}
