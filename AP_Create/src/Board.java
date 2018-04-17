
public class Board {
	private Square[][] squares;
	public int numHit;

	public Board() {
		squares = new Square[10][10];
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				squares[i][j] = new Square();
	}

	public boolean setShip(int x, int y, int o) {
		// o is orientation, 0 is horizontal, 1 is vertical
		if (x > 9 || y > 9)
			return false;
		if (!(o == 0 || o == 1))
			return false;
		if (o == 0 && x > 6)
			return false;
		if (o == 1 && y > 6)
			return false;
		if (o == 0 && ((squares[y][x].shipID != -1) || (squares[y][x + 1].shipID != -1)
				|| (squares[y][x + 2].shipID != -1) || (squares[y][x + 3].shipID != -1)))
			return false;
		if (o == 1 && ((squares[y][x].shipID != -1) || (squares[y + 1][x].shipID != -1)
				|| (squares[y + 2][x].shipID != -1) || (squares[y + 3][x].shipID != -1)))
			return false;
		if (o == 0) {
			squares[y][x].Set(0, 0);
			squares[y][x + 1].Set(0, 1);
			squares[y][x + 2].Set(0, 1);
			squares[y][x + 3].Set(0, 2);
			return true;
		}
		if (o == 1) {
			squares[y][x].Set(0, 3);
			squares[y + 1][x].Set(0, 4);
			squares[y + 2][x].Set(0, 4);
			squares[y + 3][x].Set(0, 5);
			return true;
		}
		return false;
	}

	public int shoot(int x, int y) {
		// return conditions: 0 already shot, 1 hit 2 miss
		if (squares[y][x].beenHit)
			return 0;
		squares[y][x].beenHit = true;
		if (squares[y][x].shipID == -1)
			return 2;
		numHit++;
		return 1;

	}

	public char[][] getShipMap() {
		char[][] map = new char[10][10];
		for (int y = 0; y < 10; y++)
			for (int x = 0; x < 10; x++) {
				int part = squares[y][x].shipPart;
				if (part == -1)
					map[y][x] = '#';
				if (part == 0)
					map[y][x] = '<';
				if (part == 1)
					map[y][x] = '=';
				if (part == 2)
					map[y][x] = '>';
				if (part == 3)
					map[y][x] = '^';
				if (part == 4)
					map[y][x] = 'H';
				if (part == 5)
					map[y][x] = 'V';
			}
		return map;
	}

	public char[][] getShotsMap() {
		char[][] map = new char[10][10];
		for (int y = 0; y < 10; y++)
			for (int x = 0; x < 10; x++) {
				if (squares[y][x].beenHit) {
					if (squares[y][x].shipID == -1)
						map[y][x] = 'O';
					else
						map[y][x] = 'X';
				} else
					map[y][x] = '?';
			}
		return map;
	}

	public char[][] getAllMap() {
		char[][] map = new char[10][10];
		for (int y = 0; y < 10; y++)
			for (int x = 0; x < 10; x++) {
				if (squares[y][x].beenHit) {
					if (squares[y][x].shipID == -1)
						map[y][x] = 'O';
					else
						map[y][x] = 'X';
				} else {
					int part = squares[y][x].shipPart;
					if (part == -1)
						map[y][x] = '#';
					if (part == 0)
						map[y][x] = '<';
					if (part == 1)
						map[y][x] = '=';
					if (part == 2)
						map[y][x] = '>';
					if (part == 3)
						map[y][x] = '^';
					if (part == 4)
						map[y][x] = 'H';
					if (part == 5)
						map[y][x] = 'V';
				}
			}
		return map;
	}

	public boolean isTargetValid(int x, int y) {
		if (x < 0 || y < 0 || x > 9 || y > 9)
			return false;
		return !squares[y][x].beenHit;
	}
}
