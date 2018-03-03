package MVC_1;

import java.util.ArrayList;

/**
 * @author 祝添添 E-mail:loveforyou@live.cn
 * @version 创建时间：Dec 27, 2016 2:02:44 PM 类说明
 */
public class around_win {
	ArrayList<BlockWhite> one1 = new ArrayList<BlockWhite>();
	ArrayList<BlockBlack> one2 = new ArrayList<BlockBlack>();
	int[][] map = new int[12][12];
	int c = 0;
	int d = 0;

	int[][] add(int x, int y, int b) {
		bianli(x, y, b);
		return TakePiece();
	}

	void bianli(int x, int y, int b) {
		map[x][y] = b;
		if (b == 1 && one1.size() == 0 && c == 0) {
			String a = x + "-" + y;
			one1.add(0, new BlockWhite(a));
			System.out.println("1");
			c = 1;

		}

		if (b == 1 && one1.size() != 0 && c == 2) {

			for (int i = 0; i < one1.size(); i++) {

				String[] regret = one1.get(i).BlockWhite.split("\\+");

				System.out.println(one1.size());

				for (int i1 = 0; i1 < regret.length; i1++) {
					String[] regret_1 = regret[i1].split("-");
					int x1 = Integer.parseInt(regret_1[0]);
					int y1 = Integer.parseInt(regret_1[1]);
					if (x1 + 1 == x && y == y1) {

						String a = one1.get(i).BlockWhite + "+" + x + "-" + y;
						one1.add(i, new BlockWhite(a));
						continue;
					}
					if (x1 - 1 == x && y == y1) {
						String a = one1.get(i).BlockWhite + "+" + x + "-" + y;
						one1.add(i, new BlockWhite(a));
						continue;
					}
					if (x1 == x && y == y1 + 1) {
						String a = one1.get(i).BlockWhite + "+" + x + "-" + y;
						one1.add(i, new BlockWhite(a));
						continue;
					}

					if (x1 == x && y == y1 - 1) {
						String a = one1.get(i).BlockWhite + "+" + x + "-" + y;
						one1.add(i, new BlockWhite(a));
						continue;
					}
					String a = x + "-" + y;
					one1.add(i++, new BlockWhite(a));
					System.out.println("2");
				}

			}

		}
		c = 2;

		if (b == 2 && one1.size() == 0 && c == 0) {
			String a = x + "-" + y;
			one2.add(0, new BlockBlack(a));
			System.out.println("3");
			c = 1;
		}
		if (b == 2 && one2.size() != 0 && c == 2) {
			for (int i = 0; i < one2.size(); i++) {
				String[] regret = one2.get(i).BlockBlack.split("\\+");
				System.out.println("4...");
				for (int i1 = 0; i1 < regret.length; i1++) {
					String[] regret_1 = regret[i1].split("-");
					int x1 = Integer.parseInt(regret_1[0]);
					int y1 = Integer.parseInt(regret_1[1]);
					if (x1 + 1 == x && y == y1) {

						String a = one2.get(i).BlockBlack + "+" + x + "-" + y;
						one2.add(i, new BlockBlack(a));
						continue;
					}
					if (x1 - 1 == x && y == y1) {
						String a = one2.get(i).BlockBlack + "+" + x + "-" + y;
						one2.add(i, new BlockBlack(a));
						continue;
					}
					if (x1 == x && y == y1 + 1) {
						String a = one2.get(i).BlockBlack + "+" + x + "-" + y;
						one2.add(i, new BlockBlack(a));
						continue;
					}

					if (x1 == x && y == y1 - 1) {
						String a = one2.get(i).BlockBlack + "+" + x + "-" + y;
						one2.add(i, new BlockBlack(a));
						continue;
					}
					String a = x + "-" + y;
					one2.add(i++, new BlockBlack(a));
					System.out.println("4");
				}

			}
		}
		c = 2;

	}

	int[][] TakePiece() {
		int a = 0;
		for (int i = 0; i < one1.size(); i++) {
			String[] regret = one1.get(i).BlockWhite.split("\\+");
			for (int i1 = 0; i1 < regret.length; i1++) {
				String[] regret_1 = regret[i1].split("-");
				int x = Integer.parseInt(regret_1[0]);
				int y = Integer.parseInt(regret_1[1]);
				if (map[x + 1][y] == 0 || map[x - 1][y] == 0
						|| map[x][y - 1] == 0 || map[x][y + 1] == 0) {
					break;
				}
				a++;
				System.out.println("5");
			}

			if (a == regret.length) {
				for (int i1 = 0; i1 < regret.length; i1++) {
					String[] regret_1 = regret[i].split("-");
					int x = Integer.parseInt(regret_1[0]);
					int y = Integer.parseInt(regret_1[1]);
					map[x][y] = 0;
				}
				one1.remove(i);
				a = 0;
			}

		}

		for (int i = 0; i < one2.size(); i++) {
			String[] regret = one2.get(i).BlockBlack.split("\\+");
			for (int i1 = 0; i1 < regret.length; i1++) {
				String[] regret_1 = regret[i1].split("-");
				int x = Integer.parseInt(regret_1[0]);
				int y = Integer.parseInt(regret_1[1]);
				if (map[x + 1][y] == 0 || map[x - 1][y] == 0
						|| map[x][y - 1] == 0 || map[x][y + 1] == 0) {
					break;
				}
				a++;
				System.out.println("6");
			}
			if (a == regret.length) {
				for (int i1 = 0; i1 < regret.length; i1++) {
					String[] regret_1 = regret[i].split("-");
					int x = Integer.parseInt(regret_1[0]);
					int y = Integer.parseInt(regret_1[1]);
					map[x][y] = 0;
				}
				one2.remove(i);
				a = 0;
			}

		}

		return map;
	}

}

class BlockWhite {
	String BlockWhite = "";

	BlockWhite(String a) {
		this.BlockWhite = this.BlockWhite + a;
	}
}

class BlockBlack {
	String BlockBlack = "";

	BlockBlack(String a) {
		this.BlockBlack = this.BlockBlack + a;
	}
}
