package MVC_1;
/**
 * @author ף���� E-mail:loveforyou@live.cn
 * @version ����ʱ�䣺Dec 19, 2016 3:03:53 PM
 * ��˵��
 */
public class DataBase {
	int Piece[][]=new int[12][12];
	
	
	
	
	void getPiece(int[][]s){
		Piece=s;
	}
	
	int[][] setPiece(){ //�����̽���д�������
		 return Piece; 
	 } 
	
	
	boolean getPiece_one(int x,int y,int i){//��ȡ�û�����λ��
		if(Piece[x][y]==0){
			Piece[x][y]=i;
			
			
		}else if(Piece[x][y]==1||Piece[x][y]==2){
			return false;
		}
		return true;
	}
	 
}



