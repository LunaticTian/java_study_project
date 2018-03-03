package MVC_1;
/**
 * @author 祝添添 E-mail:loveforyou@live.cn
 * @version 创建时间：Dec 20, 2016 2:43:16 PM
 * 类说明
 */
public class five_win {//五子棋输赢算法

	
	 void paly(int x,int y,int [][]Piece){
		 int win_lose;
		 for (int i = 0; i < 1; i++) {
				win_lose = five_transverse(x,
						y, Piece);
				if (win_lose == 2) {
					continue;
				}
				win_lose = five_portrait(x,
						y, Piece);
				if (win_lose == 2) {
					continue;
				}
				win_lose = Right_oblique(x,
						y, Piece);
				if (win_lose == 2) {
					continue;
				}
				win_lose = Left_oblique(x,
						y, Piece);
				if (win_lose == 2) {
					continue;
				}
			}
	 }
	
	public int five_transverse(int x, int y, int[][] Piece) {
			// 横向判断
			int ia = 0;
			for (int i = 1; x >= i; i++) {
				if (Piece[x - i][y] == Piece[x][y]) {
					ia++;
				} else if (Piece[x - i][y] != Piece[x][y]) {
					break;
				}
			}
			for (int i = 0; x - i <= 11; i--) {
				if (Piece[x - i][y] == Piece[x][y]) {
					ia++;
				} else if (Piece[x - i][y] != Piece[x][y]) {
					break;
				}
				if (x < 0) {
					break;
				}
			}
			if (ia == 5) {
				if (Piece[x][y] == 2) {
					return 2;

				}
				if (Piece[x][y] == 1) {
					return 1;

				}
				return 0;
			}
			return 0;
		}

		public int five_portrait(int x, int y, int[][] Piece) {
			// 纵向判断
			int ia = 0;
			for (int i = 1; y >= i; i++) {
				if (Piece[x][y - i] == Piece[x][y]) {
					ia++;
				} else if (Piece[x][y - i] != Piece[x][y]) {
					break;
				}
			}
			for (int i = 0; y - i < 12; i--) {
				if (Piece[x][y - i] == Piece[x][y]) {
					ia++;
				} else if (Piece[x][y - i] != Piece[x][y]) {
					break;
				}
				if (y < 0) {
					break;
				}
			}
			if (ia == 5) {
				if (Piece[x][y] == 2) {
					System.out.println("黑棋赢了");
					return 2;
				}
				if (Piece[x][y] == 1) {
					System.out.println("白棋赢了");
					return 1;
				}
			}
			return 0;
		}

		// 右斜向 Right oblique
		public int Right_oblique(int x, int y, int[][] Piece) {
			int ia = 0;
			for (int i = 1; y >= i && x >= i; i++) {
				if (Piece[x - i][y - i] == Piece[x][y]) {
					ia++;
				} else if (Piece[x - i][y - i] != Piece[x][y]) {
					break;
				}
			}
			for (int i = 0; y - i <= 11 && x - i <= 11; i--) {
				if (Piece[x - i][y - i] == Piece[x][y]) {
					ia++;
				} else if (Piece[x - i][y - i] != Piece[x][y]) {
					break;
				}
			}
			if (ia == 5) {
				if (Piece[x][y] == 2) {
					return 2;
				}
				if (Piece[x][y] == 1) {
					return 1;

				}
			}
			return 0;
		}

		// 左斜向
		public int Left_oblique(int x, int y, int[][] Piece) {
			int ia = 0;
			for (int i = 1; x >= i && y + i <= 11; i++) {
				if (Piece[x - i][y + i] == Piece[x][y]) {
					ia++;
				} else if (Piece[x - i][y + i] != Piece[x][y]) {
					break;
				}
			}
			for (int i = 0; x - i <= 11 && y + i >= 0; i--) {
				if (Piece[x - i][y + i] == Piece[x][y]) {
					ia++;
				} else if (Piece[x - i][y + i] != Piece[x][y]) {
					break;
				}
			}
			if (ia == 5) {
				if (Piece[x][y] == 2) {
					System.out.println("黑棋赢了");
					return 2;
				}
				if (Piece[x][y] == 1) {
					System.out.println("白棋赢了");
					return 1;
				}
			}
			return 0;
		
	}
}
