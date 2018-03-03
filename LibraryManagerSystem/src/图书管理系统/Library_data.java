package 图书管理系统;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Library_data {
	ArrayList<Student> StudentArrayList = new ArrayList<Student>();
	ArrayList<admin> adminArrayList = new ArrayList<admin>();
	ArrayList<Leavingmessage> LeavingmessageArrayList = new ArrayList<Leavingmessage>();
	ArrayList<newbook> newbookArrayList = new ArrayList<newbook>();
	ArrayList<book> bookArrayList = new ArrayList<book>();
	ArrayList<bookReserve> bookReserveList = new ArrayList<bookReserve>();
	

	Library_data() throws IOException {
		// 用户数据库
		FileInputStream Studentfout = null;
		InputStreamReader isr = null;
		BufferedReader br = null;// 包装
		try {
			Studentfout = new FileInputStream("Student.txt");
			isr = new InputStreamReader(Studentfout);
			br = new BufferedReader(isr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String res = "";
		while ((res = br.readLine()) != null) {
			String[] a = res.split("-");
			StudentArrayList.add(new Student(a[0], a[1], a[2], a[3], a[4]));
		}

		br.close();
		isr.close();
		Studentfout.close();
		System.out.println("用户加载完成！");

		// 留言数据库
		FileInputStream message = null;
		InputStreamReader messageisr = null;
		BufferedReader messagebr = null;// 包装
		try {
			message = new FileInputStream("message.txt");
			messageisr = new InputStreamReader(message);
			messagebr = new BufferedReader(messageisr);
		} catch (FileNotFoundException e) {
		}

		String messageres = "";
		while ((messageres = messagebr.readLine()) != null) {
			String[] a = messageres.split("-");
			LeavingmessageArrayList.add(new Leavingmessage(a[0], a[1], a[2]));
		}

		messagebr.close();
		messageisr.close();
		message.close();
		System.out.println("留言加载完成！");

		// 新书数据库

		FileInputStream newbook = null;
		InputStreamReader newbookisr = null;
		BufferedReader newbookebr = null;// 包装
		try {
			newbook = new FileInputStream("newbook.txt");
			newbookisr = new InputStreamReader(newbook);
			newbookebr = new BufferedReader(newbookisr);
		} catch (FileNotFoundException e) {
		}

		String newbookeer = "";
		while ((newbookeer = newbookebr.readLine()) != null) {
			String[] a = newbookeer.split("-");
			System.out.println("11111111111111111111");
			newbookArrayList.add(new newbook(a[0],
					a[1]));
		}

		newbookebr.close();
		newbookisr.close();
		newbook.close();
		System.out.println("新书加载完成！");
		
		//图书
		FileInputStream book = null;
		InputStreamReader bookisr = null;
		BufferedReader bookebr = null;// 包装
		try {
			book = new FileInputStream("bookdata.txt");
			bookisr = new InputStreamReader(book);
			bookebr = new BufferedReader(bookisr);
		} catch (FileNotFoundException e) {
		}

		String bookeer = "";
		while ((bookeer = bookebr.readLine()) != null) {
			String[] a = bookeer.split("-");
			String[] b={""};
			int b1=4;
			for(int i=0;i<5;i++,b1++){
				if(a.length>4&&a.length>b1){
				if(a[b1]!=""||a[b1]!=null){
					b[0]=a[b1];
				}
				}
			}
			bookArrayList.add(new book(a[0], a[1],a[2],a[3],b));
		}

		bookebr.close();
		bookisr.close();
		book.close();
		System.out.println("图书加载完成！");
		//
		FileInputStream Reserve = null;
		InputStreamReader Reserveisr = null;
		BufferedReader Reservebr = null;// 包装
		try {
			Reserve = new FileInputStream("bookReserve.txt");
			Reserveisr = new InputStreamReader(Reserve);
			Reservebr = new BufferedReader(Reserveisr);
		} catch (FileNotFoundException e) {
		}

		String Reservebr1 = "";
		while ((Reservebr1 = Reservebr.readLine()) != null) {
			String[] a = Reservebr1.split("-");
			bookReserveList.add(new bookReserve(a[0],a[1]));
		}

		Reservebr.close();
		Reserveisr.close();
		Reserve.close();
		System.out.println("预定加载完成！");
	}

}

class Student {
	Student(String ID, String name, String password, String age, String grade) {
		this.ID = ID;
		this.name = name;
		this.password = password;
		this.age = age;
		this.grade = grade;
	}

	String ID;
	String name;
	String password;
	String age;
	String grade;// 年级

}

class Leavingmessage {
	Leavingmessage(String Leavinger, String lookmessage, String message) {
		this.Leavinger = Leavinger;
		this.lookmessage = lookmessage;
		this.message = message;
	}

	String Leavinger;
	String lookmessage;
	String message;
}

class admin {
	String ID;
	String password;
}

class newbook {
	newbook(String bookname, String booker) {
		this.bookname = bookname;
		this.booker = booker;
	}

	String bookname;
	String booker;
}

class book {
	book(String name,String booknameer, String id, String much, String[] booker) {
		this.name = name;
		this.booknameer=booknameer;
		this.id = id;
		this.much = much;
		this.booker = booker;
	}

	String name;
	String booknameer;
	String id;
	String much;
	String[] booker;
}

class bookReserve{
	bookReserve(String book,String er){
		this.book=book;
		this.er=er;
	}
	String book;
	String er;
}
