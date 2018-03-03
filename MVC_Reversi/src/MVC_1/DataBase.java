package MVC_1;
/**
 * @author 祝添添 E-mail:loveforyou@live.cn
 * @version 创建时间：Dec 19, 2016 3:03:53 PM
 * 类说明
 */
public class DataBase {
	int Piece[][]=new int[12][12];
	
	
	
	
	void getPiece(int[][]s){
		Piece=s;
	}
	
	int[][] setPiece(){ //给棋盘界面写入的数据
		 return Piece; 
	 } 
	
	
	boolean getPiece_one(int x,int y,int i){//获取用户下棋位置
		if(Piece[x][y]==0){
			Piece[x][y]=i;
			
			
		}else if(Piece[x][y]==1||Piece[x][y]==2){
			return false;
		}
		return true;
	}
	 
}



