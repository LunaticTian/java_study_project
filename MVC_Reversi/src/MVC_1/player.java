package MVC_1;
/**
 * @author 祝添添 E-mail:loveforyou@live.cn
 * @version 创建时间：Dec 20, 2016 2:45:12 PM
 * 类说明
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
