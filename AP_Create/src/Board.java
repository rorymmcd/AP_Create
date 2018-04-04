
public class Board {
	private Square[][] squares;
	
	public Board(){
		squares = new Square[10][10];
	}
	
	public boolean setShip(int x,int y,int o){
		// o  is orientation, 0 is horizontal, 1 is vertical 
		if(x>9||y>9)return false;
		if(!(o==0||o==1))return false;
		if(o==0&&x>6)return false;
		if(o==1&&y>6)return false;
		if(o==0&&((squares[x][y].shipID!=-1)||
				(squares[x+1][y].shipID!=-1)||
				(squares[x+2][y].shipID!=-1)||
				(squares[x+3][y].shipID!=-1)))return false;
		if(o==1&&((squares[x][y].shipID!=-1)||
				(squares[x][y+1].shipID!=-1)||
				(squares[x][y+2].shipID!=-1)||
				(squares[x][y+3].shipID!=-1)))return false;
	}
	
	public char[][] getShipMap(){
		char[][] map = new char[10][10];
		for(int x = 0; x <10; x++)
			for(int y = 0; y < 10; y++){
				
			}
		return map;
	}
}
