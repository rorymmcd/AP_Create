import java.util.ArrayList;
import java.util.Random;

public class Computer {
	public Board board;
	ArrayList<int[]> hits;// hits[q] == {x,y}

	public Computer(Board b) {
		board = b;
	}

	public void placeShips() {
		Random rand = new Random();
		for (int i = 0; i < 3;) {
			if (board.setShip(rand.nextInt(10), rand.nextInt(10), rand.nextInt(2)))
				i++;
		}
	}

	public void takeShot(Board bp) {
		ArrayList<int[]> targetList = null;
		for (int[] q : hits) {
			targetList.add(new int[] { q[0], q[1] + 1 });
			targetList.add(new int[] { q[0], q[1] - 1 });
			targetList.add(new int[] { q[0] + 1, q[1] });
			targetList.add(new int[] { q[0] - 1, q[1] });
		}
		for (int i = 0; i < targetList.size();) {
			int[] q = targetList.get(i);
			if (bp.isTargetValid(q[0], q[1]))
				i++;
			else
				targetList.remove(i);
		}
		if (targetList.size() == 0) {
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					targetList.add(new int[] { i, j });
			for (int i = 0; i < targetList.size();) {
				int[] q = targetList.get(i);
				if (bp.isTargetValid(q[0], q[1]))
					i++;
				else
					targetList.remove(i);
			}
		}
		
	}
}
