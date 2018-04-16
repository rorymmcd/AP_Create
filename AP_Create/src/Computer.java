import java.util.ArrayList;
import java.util.Random;

public class Computer {
	public Board board;
	ArrayList<int[]> hits;// hits[q] == {x,y}

	public Computer(Board b) {
		board = b;
		hits = new ArrayList<int[]>();
	}

	public void placeShips() {
		Random rand = new Random();
		for (int i = 0; i < 3;) {
			if (board.setShip(rand.nextInt(10), rand.nextInt(10), rand.nextInt(2)))
				i++;
		}
	}

	public void takeShot(Board bp) {
		Random rand = new Random();
		ArrayList<int[]> targetList = new ArrayList<int[]>();
		if (hits.size() > 0)
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
		int[] target = targetList.get(rand.nextInt(targetList.size()));
		int isHit = bp.shoot(target[0], target[1]);
		if (isHit == 1)
			hits.add(target);
	}
}
