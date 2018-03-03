package 图书管理系统;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Library_data_operation {
	Library_data data;

	Library_data_operation() throws IOException {
		data = new Library_data();
	}

	void off() throws IOException {
		FileOutputStream empty = new FileOutputStream("Student.txt");
		empty.write(new String("").getBytes());
		empty.close();// 请空原数据

		File file = new File("Student.txt");
		FileWriter fw = null;
		BufferedWriter writer = null;
		fw = new FileWriter(file);
		writer = new BufferedWriter(fw);
		for (int i = 0; i < data.StudentArrayList.size(); i++) {
			String a = data.StudentArrayList.get(i).ID + "-"
					+ data.StudentArrayList.get(i).name + "-"
					+ data.StudentArrayList.get(i).password + "-"
					+ data.StudentArrayList.get(i).age + "-"
					+ data.StudentArrayList.get(i).grade;
			writer.write(a);
			writer.newLine();
		}
		writer.flush();
		writer.close();
		fw.close();
		// 用户名称

		FileOutputStream sayempty = new FileOutputStream("message.txt");
		sayempty.write(new String("").getBytes());
		sayempty.close();// 请空原数据

		File sayfile = new File("message.txt");
		FileWriter sayfw = null;
		BufferedWriter saywriter = null;
		sayfw = new FileWriter(sayfile);
		saywriter = new BufferedWriter(sayfw);
		for (int i = 0; i < data.LeavingmessageArrayList.size(); i++) {
			String a = data.LeavingmessageArrayList.get(i).Leavinger + "-"
					+ data.LeavingmessageArrayList.get(i).lookmessage + "-"
					+ data.LeavingmessageArrayList.get(i).message;
			saywriter.write(a);
			saywriter.newLine();
		}
		saywriter.flush();
		saywriter.close();
		sayfw.close();
		// ///留言系统
		FileOutputStream bookempty = new FileOutputStream("bookdata.txt");
		bookempty.write(new String("").getBytes());
		bookempty.close();// 请空原数据

		File bookfile = new File("bookdata.txt");
		FileWriter bookfw = null;
		BufferedWriter bookwriter = null;
		bookfw = new FileWriter(bookfile);
		bookwriter = new BufferedWriter(bookfw);
		for (int i = 0; i < data.bookArrayList.size(); i++) {
			
			String a1[]=data.bookArrayList.get(i).booker;
			String a2="";
			for(int i1=0;i1<a1.length;i1++){
				if(a1.length==0||a1[0].equals("")){
					System.out.println(a1[0]);
					break;
				}
				if(i1==0){
					a2=a1[i1];
					continue;
				}
				a2=a2+"-"+a1[i1];
			}
			String a = data.bookArrayList.get(i).name + "-"
					+ data.bookArrayList.get(i).booknameer + "-"
					+ data.bookArrayList.get(i).id+"-"+data.bookArrayList.get(i).much+"-"+a2;
			bookwriter.write(a);
			bookwriter.newLine();
		}
		bookwriter.flush();
		bookwriter.close();
		bookfw.close();
		//书库
		FileOutputStream newbookempty = new FileOutputStream("newbook.txt");
		newbookempty.write(new String("").getBytes());
		newbookempty.close();// 请空原数据

		File newbookfile = new File("newbook.txt");
		FileWriter newbookfw = null;
		BufferedWriter newbookwriter = null;
		newbookfw = new FileWriter(newbookfile);
		newbookwriter = new BufferedWriter(newbookfw);
		for (int i = 0; i < data.newbookArrayList.size(); i++) {
			
			String a1=data.newbookArrayList.get(i).bookname;
			String a2=data.newbookArrayList.get(i).booker;
			
			String a = a1+"-"+a2;
			newbookwriter.write(a);
			newbookwriter.newLine();
		}
		newbookwriter.flush();
		newbookwriter.close();
		newbookfw.close();
		//
		FileOutputStream Reserve = new FileOutputStream("bookReserve.txt");
		Reserve.write(new String("").getBytes());
		Reserve.close();// 请空原数据

		File Reservefile = new File("bookReserve.txt");
		FileWriter Reservefw = null;
		BufferedWriter Reservewriter = null;
		Reservefw = new FileWriter(Reservefile);
		Reservewriter = new BufferedWriter(Reservefw);
		for (int i = 0; i < data.newbookArrayList.size(); i++) {
			if(data.bookReserveList.size()==0){
				break;
			}
			String a1=data.bookReserveList.get(i).book;
			String a2=data.bookReserveList.get(i).er;
			
			String a = a1+"-"+a2;
			Reservewriter.write(a);
			Reservewriter.newLine();
		}
		Reservewriter.flush();
		Reservewriter.close();
		Reservefw.close();
	}

	int returnbook(String name, int c) {// 还书
		for (int i = 0; i < data.bookArrayList.size(); i++) {
			if (data.bookArrayList.get(i).name.equals(name)
					|| data.bookArrayList.get(i).id.equals(name)) {
				int x = data.bookArrayList.get(i).booker.length;
				String[] x1 = data.bookArrayList.get(i).booker;
				String returnname = data.StudentArrayList.get(c).ID;
				for (int y = 0; y < x; y++) {
					System.out.println(x);
					if (x1[y].equals(returnname)) {
						x1[y] = x1[x - 1];
						x1[x - 1] = "";
						int much = Integer
								.parseInt(data.bookArrayList.get(i).much) + 1;
						data.bookArrayList.add(new book(data.bookArrayList
								.get(i).name,
								data.bookArrayList.get(i).booknameer,
								data.bookArrayList.get(i).id, String
										.valueOf(much), x1));
						data.bookArrayList.remove(i);
						return 1;// 还书成功！
					}
				}
				return 2;// 无此用户
			}
		}
		return 3;
	}

	int Reservebook(String name, int c) {// 借书书
		for (int i = 0; i < data.bookArrayList.size(); i++) {
			if (data.bookArrayList.get(i).name.equals(name)
					|| data.bookArrayList.get(i).id.equals(name)) {
				int x = data.bookArrayList.get(i).booker.length;
				String[] x1 = data.bookArrayList.get(i).booker;
				String Reservename = data.StudentArrayList.get(c).ID;
				if (x == 0) {
					return 5;// 书借完了
				}
				String[]x2=new String[x+1];
				for(int i1=0;i1<x2.length-1;i1++){
					System.out.println(x1[i1]);
					if(x1[i1].equals(Reservename)){
						return 2;//你接过了
					}
					x2[i1]=x1[i1];
				}
				x2[x]=Reservename;
				int much = Integer.parseInt(data.bookArrayList.get(i).much) - 1;
				
				data.bookArrayList
						.add(new book(data.bookArrayList.get(i).name,
								data.bookArrayList.get(i).booknameer,
								data.bookArrayList.get(i).id, String
										.valueOf(much), x2));
				data.bookArrayList.remove(i);
				return 1;// 成功

			}
		}
		return 0;
	}

	
	
	String[] Studentbook(String id){
		String [] name;
		String []return1 = new String [40] ;
		
		int x=0;
		for(int i=0;i<data.bookArrayList.size();i++){
			name=data.bookArrayList.get(i).booker;
			for(int c=0;c<name.length;c++){
				if(name[c].equals(id)){
					return1[x]=
							data.bookArrayList.get(i).name;
					
					x++;
					return1[x]=data.bookArrayList.get(i).booknameer;
				
					x++;
					return1[x]=data.bookArrayList.get(i).id;
					
					x++;
					return1[x]="1";
					
					x++;
					}
				}
			}
		
		
		
		return return1;
	}
	
	
	String[] message(int looker) {// 留言系统
		String[] a = { "ta", "" };

		for (int i = 0; i < data.LeavingmessageArrayList.size(); i++) {
			if (data.StudentArrayList.get(looker).name
					.equals(data.LeavingmessageArrayList.get(i).lookmessage)) {
				a[0] = data.LeavingmessageArrayList.get(i).Leavinger;
				for (int c = 0; c < data.StudentArrayList.size(); c++) {
					if (data.StudentArrayList.get(c).name.equals(a[0])) {
						a[0] = data.StudentArrayList.get(c).name;

					}
				}
				a[1] = data.LeavingmessageArrayList.get(i).message;

				return a;
			}
		}

		return a;

	}

	String[] queryStudent(String id) {
		for (int i = 0; i < data.StudentArrayList.size(); i++) {
			if (data.StudentArrayList.get(i).ID.equals(id)
					|| data.StudentArrayList.get(i).name.equals(id)) {
				String[] a = { data.StudentArrayList.get(i).ID,
						data.StudentArrayList.get(i).name,
						data.StudentArrayList.get(i).age,
						data.StudentArrayList.get(i).grade };
				return a;
			}
		}

		return null;

	}

	String[] newbook() {
		int s = data.newbookArrayList.size();
		String[] a = { data.newbookArrayList.get(s-1).bookname,
				data.newbookArrayList.get(s - 1).booker,
				data.newbookArrayList.get(s - 2).bookname,
				data.newbookArrayList.get(s - 2).booker,
				data.newbookArrayList.get(s - 3).bookname,
				data.newbookArrayList.get(s - 3).booker,
				data.newbookArrayList.get(s - 4).bookname,
				data.newbookArrayList.get(s - 4).booker,
				data.newbookArrayList.get(s - 5).bookname,
				data.newbookArrayList.get(s - 5).booker};
		return a;
	}

	int Sendmessage(int c, String er, String say) {// 发送留言
		for (int i = 0; i < data.StudentArrayList.size(); i++) {
			if (data.StudentArrayList.get(i).name.equals(er)) {
				data.LeavingmessageArrayList.add(new Leavingmessage(
						data.StudentArrayList.get(c).name,
						data.StudentArrayList.get(i).name, say));
				return 1;
			}
		}
		return 0;

	}

	int Land(String id, String password) {
		for (int i = 0; i < data.StudentArrayList.size(); i++) {
			if (id.equals(data.StudentArrayList.get(i).ID)) {
				if (password.equals(data.StudentArrayList.get(i).password)) {
					System.out.println("进入系统！");
					return i;
				} else if (!password
						.equals(data.StudentArrayList.get(i).password)) {
					System.out.println("密码错误！");
					return -1;
				}
			}

		}
		return -2;

	}

	int register(String ID, String name, String password, String age,
			String grade) {
		for (int i = 0; i < data.StudentArrayList.size(); i++) {
			if (ID.equals(data.StudentArrayList.get(i).ID)) {
				return 1;// 以有此登录名！
			}
		}
		data.StudentArrayList.add(new Student(ID, name, password, age, grade));
		return 0;// 注册成功！
	}
	ArrayList<Student>getStudent(){
		return data.StudentArrayList;
	}
	ArrayList<book>getbook(){
		return data.bookArrayList;
	}
	
	int moveStudent(String name){
		for(int i =0;i<data.StudentArrayList.size();i++){
			if(data.StudentArrayList.get(i).name.equals(name)||data.StudentArrayList.get(i).ID.equals(name)){
				data.StudentArrayList.remove(i);
				//书！
				for(int c=0;c<data.bookArrayList.size();c++){
				returnbook(data.bookArrayList.get(c).name, i);
				}
				return 1;
			}
		}
		return 0;
	}
	
	int Borrowbook(String name,int c){
		for (int i = 0; i < data.bookArrayList.size(); i++) {
			if (data.bookArrayList.get(i).name.equals(name)
					|| data.bookArrayList.get(i).id.equals(name)) {
				int x = data.bookArrayList.get(i).booker.length;
				String[] x1 = data.bookArrayList.get(i).booker;
				String Reservename = data.StudentArrayList.get(c).ID;
				
				
				String[]x2=new String[x+1];
				for(int i1=0;i1<x2.length-1;i1++){
					System.out.println(x1[i1]);
					if(x1[i1].equals(Reservename)){
						return 2;//你借过过了
					}
					x2[i1]=x1[i1];
				}
				for(int j=0;j<data.bookReserveList.size();j++){
					if(data.bookReserveList.get(j).er.equals(Reservename)){
						return 3;//预定过
					}
				}
				
				if (x == 0) {
					data.bookReserveList.add(new bookReserve(name,Reservename) );
					return 5;// 成功
					
				}
				if(x>0){
					return 1;
				}
				

			}
			
		}
		return 0;//无此书
		
		
		
		
		
		
	}
	
	int addbook(String name,String er,String id,String much ){
		for(int i=0;i<data.bookArrayList.size();i++){
			if(data.bookArrayList.get(i).id.equals(id)){
				return 0;
			}
		}
		String []a={""};
		data.bookArrayList.add(new book(name,er,id,much,a));
		data.newbookArrayList.add(new newbook("《"+name+"》", er));
		return 1;
		
	}
	
	int movebook(String name){
		for(int i=0;i<data.bookArrayList.size();i++){
			if(data.bookArrayList.get(i).id.equals(name)||data.bookArrayList.get(i).name.equals(name)){
				data.bookArrayList.remove(i);
				return 1;
			}
		}
		return 0;
	}
	
	String[] getbook(String book) {
		for (int i = 0; i < data.bookArrayList.size(); i++) {
			if (data.bookArrayList.get(i).name.equals(book)
					|| data.bookArrayList.get(i).id.equals(book)) {
				String a[] = { data.bookArrayList.get(i).name,
						data.bookArrayList.get(i).booknameer,
						data.bookArrayList.get(i).id,
						data.bookArrayList.get(i).much };
				return a;
			}
		}
		return null;

	}

	int Retrieve(String ID, String name, String grade, String password) {
		for (int i = 0; i < data.StudentArrayList.size(); i++) {
			if (ID.equals(data.StudentArrayList.get(i).ID)) {
				if (name.equals(data.StudentArrayList.get(i).name)) {
					if (grade.equals(data.StudentArrayList.get(i).grade)) {

						data.StudentArrayList.add(new Student(ID, name,
								password, data.StudentArrayList.get(i).age,
								grade));

						data.StudentArrayList.remove(i);
						return 4;
					}
					return 3;
				}
				return 2;
			}
		}
		return 1;
	}
	
	
	int modifyStudent(String  id,String age, String grd){
				for(int i=0;i<data.StudentArrayList.size();i++){
					if(data.StudentArrayList.get(i).ID.equals(id)){
					
				data.StudentArrayList.add(new Student(data.StudentArrayList.get(i).ID, data.StudentArrayList.get(i).name, data.StudentArrayList.get(i).password, age, grd));
				data.StudentArrayList.remove(i);
				return 1;
					}
				}
				return 2;
		
	}
	
	

	int Retrieve(String password, String newpassword, int i) {
		if (password.equals(data.StudentArrayList.get(i).password)) {
			data.StudentArrayList.add(i,
					new Student(data.StudentArrayList.get(i).ID,
							data.StudentArrayList.get(i).name, newpassword,
							data.StudentArrayList.get(i).age,
							data.StudentArrayList.get(i).grade));
			return 1;
		}
		return 0;
	}
}

	
