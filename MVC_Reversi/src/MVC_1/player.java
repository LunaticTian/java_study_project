package MVC_1;
/**
 * @author ף���� E-mail:loveforyou@live.cn
 * @version ����ʱ�䣺Dec 20, 2016 2:45:12 PM
 * ��˵��
 */
public class player {
	player(String name){
		this.name=name;
	}
	String name;
	String record="";
	void SetRecord(int x,int y){
		record=record+Integer.toString(x)+"-"+Integer.toString(y)+"+";	
	}
}
