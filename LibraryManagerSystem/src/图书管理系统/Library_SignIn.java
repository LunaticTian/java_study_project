package 图书管理系统;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.crypto.Data;

public class Library_SignIn extends JFrame implements ActionListener {

	Library_data data;
	Library_data_operation run = new Library_data_operation();
	JButton Land = new JButton("登录");
	JButton register = new JButton("注册");
	JButton Retrieve = new JButton("找回密码");
	JTextField ID1;
	JPasswordField PassWord1;
	JRadioButton Student;
	JRadioButton admin;
	ButtonGroup group;

	Library_SignIn(String name) throws IOException {
		super(name);
		data = new Library_data();
		JPanel di = new JPanel();
		JPanel di1 = new JPanel();

		Student = new JRadioButton("学生", true);
		admin = new JRadioButton("管理员");
		group = new ButtonGroup();// JRadioButton单选
		group.add(Student);
		group.add(admin);
		Student.addActionListener(this);
		admin.addActionListener(this);

		JLabel ID = new JLabel("账号:");
		ID1 = new JTextField(15);
		JLabel PassWord = new JLabel("密码:");
		PassWord1 = new JPasswordField(15);
		PassWord1.setEchoChar('*');
		// 监听
		Land.addActionListener(this);
		register.addActionListener(this);
		Retrieve.addActionListener(this);

		ImageIcon background = new ImageIcon("1123.png");
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());

		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		Container cp = getContentPane();
		setLayout(new BorderLayout());
		((JPanel) cp).setOpaque(false);

		di.add(ID);
		di.add(ID1);
		di.add(PassWord);
		di.add(PassWord1);
		di.add(Land);
		di.add(Student);
		di.add(admin);
		di1.setLayout(new FlowLayout(FlowLayout.LEFT, 150, 0));
		di1.add(Retrieve);
		di1.add(register);
		add(di1, BorderLayout.SOUTH);
		add(di, BorderLayout.NORTH);

		setSize(700, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String a = "";
		if (Student.isSelected()) {
			a = Student.getText();
		}
		if (admin.isSelected()) {
			a = admin.getText();
		}
		if (e.getSource() == Land) {// 登录

			String id = ID1.getText();
			char[] PassWord = PassWord1.getPassword();
			String password = new String(PassWord);

			int c = run.Land(id, password);
			if (a.equals("学生")) {
				if (c != -1 && c != -2) {
					JOptionPane.showMessageDialog(null, "     进入系统！", "成功！",
							JOptionPane.WARNING_MESSAGE);
					try {
						run.off();
					} catch (IOException e1) {
					}
					this.dispose();
					try {
						new StudentInterface("学生管理", c);
					} catch (IOException e1) {
					}
				} else if (c == -1) {
					JOptionPane.showMessageDialog(null, "     密码错误！", "错误！",
							JOptionPane.WARNING_MESSAGE);
				} else if (c == -2) {
					JOptionPane.showMessageDialog(null, "     无此账号！", "错误！",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			if (a.equals("管理员")) {
				String id1 = ID1.getText();
				char[] PassWord2 = PassWord1.getPassword();
				String password3 = new String(PassWord2);
				if (id1.equals("admin") && password3.equals("admin")) {
					try {
						this.dispose();
						new adminInterface("管理员");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (!id1.equals("admin") || !password3.equals("admin")) {
					JOptionPane.showMessageDialog(null, "     账号或密码错误！", "错误！",
							JOptionPane.WARNING_MESSAGE);
				}

			}

		}
		if (e.getSource() == register) {// 注册

			class register extends JFrame implements ActionListener {
				JTextField registerID1;
				JTextField registername11;
				JTextField registerage1;
				JTextField registergrade1;
				JPasswordField registerPassWord1;
				JButton registerJButton;

				register(String name) {
					super(name);
					registerJButton = new JButton("注册");
					registerJButton.addActionListener(this);
					setLayout(new FlowLayout(1, 20, 30));
					JLabel registerID = new JLabel("账号:");
					JLabel registerage = new JLabel("年龄:");
					registerage1 = new JTextField(15);
					registerID1 = new JTextField(15);
					JLabel registername1 = new JLabel("昵称:");
					registername11 = new JTextField(15);
					JLabel registerPassWord = new JLabel("密码:");
					registerPassWord1 = new JPasswordField(15);
					registerPassWord1.setEchoChar('*');
					JLabel registergrade = new JLabel("班级:");
					registergrade1 = new JTextField(15);

					add(registerID);
					add(registerID1);
					add(registername1);
					add(registername11);
					add(registerPassWord);
					add(registerPassWord1);
					add(registerage);
					add(registerage1);
					add(registergrade);
					add(registergrade1);
					add(registerJButton);

					setSize(300, 400);
					setLocationRelativeTo(null);
					setVisible(true);
				}

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (arg0.getSource() == registerJButton) {
						String registerpassword = new String(
								registerPassWord1.getPassword());
						int a = run.register(registerID1.getText(),
								registername11.getText(), registerpassword,
								registerage1.getText(),
								registergrade1.getText());

						if (a == 1) {
							JOptionPane.showMessageDialog(null, "     账号重复！",
									"注册失败！", JOptionPane.WARNING_MESSAGE);
						}
						if (a == 0) {
							JOptionPane.showMessageDialog(null, "     注册成功！",
									"注册成功！",

									JOptionPane.WARNING_MESSAGE);
							this.dispose();
						}

					}

				}
			}
			new register("注册");
		}
		if (e.getSource() == Retrieve) {// 找回密码
			class Retrieve extends JFrame implements ActionListener {
				JTextField RetrieveID1;
				JTextField Retrievename11;
				JTextField Retrievegrade1;
				JPasswordField RetrievePassWord1;
				JButton RetrieveJButton;

				Retrieve(String name) {
					super(name);
					RetrieveJButton = new JButton("修改密码");
					RetrieveJButton.addActionListener(this);
					setLayout(new FlowLayout(1, 20, 30));
					JLabel RetrieveID = new JLabel("账号:");
					RetrieveID1 = new JTextField(15);
					JLabel Retrievename1 = new JLabel("昵称:");
					Retrievename11 = new JTextField(15);
					JLabel RetrievePassWord = new JLabel("密码:");
					RetrievePassWord1 = new JPasswordField(15);
					RetrievePassWord1.setEchoChar('*');
					JLabel Retrievegrade = new JLabel("班级:");
					Retrievegrade1 = new JTextField(15);

					add(RetrieveID);
					add(RetrieveID1);
					add(Retrievename1);
					add(Retrievename11);

					add(Retrievegrade);
					add(Retrievegrade1);
					add(RetrievePassWord);
					add(RetrievePassWord1);
					add(RetrieveJButton);

					setSize(300, 400);
					setLocationRelativeTo(null);
					setVisible(true);
				}

				@Override
				public void actionPerformed(ActionEvent arg1) {
					if (arg1.getSource() == RetrieveJButton) {
						String Retrievepassword = new String(
								RetrievePassWord1.getPassword());
						int a = run.Retrieve(RetrieveID1.getText(),
								Retrievename11.getText(),
								Retrievegrade1.getText(), Retrievepassword);

						if (a == 1) {
							JOptionPane.showMessageDialog(null, "     无此账号！",
									"修改失败！", JOptionPane.WARNING_MESSAGE);

						}
						if (a == 2) {
							JOptionPane.showMessageDialog(null, "     昵称错误！",
									"修改失败！", JOptionPane.WARNING_MESSAGE);
						}
						if (a == 3) {
							JOptionPane.showMessageDialog(null, "     班级错误！",
									"修改失败！", JOptionPane.WARNING_MESSAGE);
						}
						if (a == 4) {
							JOptionPane.showMessageDialog(null, "     成功修改！",
									"修改成功！", JOptionPane.WARNING_MESSAGE);
							this.dispose();
						}
					}

				}
			}
			new Retrieve("找回密码");
		}

	}

}

class StudentInterface extends JFrame implements ActionListener, MouseListener {
	private static final Object[] String = null;
	Library_data_operation run = new Library_data_operation();
	int i;
	JComboBox department;
	JLabel Query;
	JLabel message;
	JTextField BookName;
	JButton bookquery;
	JButton returnbook;
	JButton Borrowbook;
	JButton Reservebook;

	JTable table;
	JScrollPane sPane;
	DefaultTableModel atm;
	Vector vDate;
	Vector vName;

	StudentInterface(String name, int i) throws IOException {
		super(name);
		this.i = i;

		JPanel information = new JPanel();
		information.setLayout(new FlowLayout(3, 60, 10));
		JLabel StudentName = new JLabel("昵称:"
				+ run.data.StudentArrayList.get(i).name);
		StudentName.setFont(new Font("宋体", Font.BOLD, 13));
		JLabel StudentID = new JLabel("用户名:"
				+ run.data.StudentArrayList.get(i).ID);
		StudentID.setFont(new Font("宋体", Font.BOLD, 13));
		JLabel Studentage = new JLabel("年龄:"
				+ run.data.StudentArrayList.get(i).age);
		Studentage.setFont(new Font("宋体", Font.BOLD, 13));
		JLabel Studentgrade = new JLabel("班级:"
				+ run.data.StudentArrayList.get(i).grade);
		Studentgrade.setFont(new Font("宋体", Font.BOLD, 13));
		JLabel Modify_password = new JLabel("密码修改");
		Modify_password.setFont(new Font("宋体", Font.BOLD, 13));

		Modify_password.addMouseListener(this);
		String[] departmentNames = { "账号选项", "修改密码", "注销用户" };
		department = new JComboBox(departmentNames);
		department.setEditable(false);
		department.addActionListener(this);
		Query = new JLabel("    查询用户");
		Query.setFont(new Font("宋体", Font.BOLD, 15));
		Query.setForeground(Color.blue);
		Query.addMouseListener(this);

		message = new JLabel("给ta留言");
		message.setFont(new Font("宋体", Font.BOLD, 15));
		message.setForeground(Color.red);
		message.addMouseListener(this);

		information.add(StudentName);
		information.add(StudentID);
		information.add(Studentage);
		information.add(Studentgrade);
		information.add(department);
		information.add(Query);
		information.add(message);
		add(information, BorderLayout.NORTH);
		// 上方______________________________________________________

		JPanel Riter = new JPanel();
		// Riter.setLayout(new GridLayout(4,1,10,10));
		JPanel RiterSon = new JPanel();// Riter的子面板

		BookName = new JTextField("书名\\ID", 13);
		BookName.addMouseListener(this);
		bookquery = new JButton("查询");
		bookquery.addActionListener(this);
		RiterSon.add(BookName);
		RiterSon.add(bookquery);

		Riter.add(RiterSon);
		// --------------------------------------
		JPanel NewBook = new JPanel(new GridLayout(6, 1, 20, 25));// 新书上架
		NewBook.setBorder(new EmptyBorder(30, 0, 0, 0)); // 设置边框距离

		// 查询搜索
		JLabel newbookJLabel = new JLabel("新书上架 ");
		newbookJLabel.setFont(new Font("宋体", Font.BOLD, 15));
		newbookJLabel.setForeground(Color.orange);
		NewBook.add(newbookJLabel);

		String[] newbook = run.newbook();
		for (int x = 0; x < 10; x++) {
			JLabel ax = new JLabel(newbook[x] + "       " + newbook[x + 1]);
			NewBook.add(ax);
			x++;

		}
		// _________________________新书上架

		JPanel Leavingmessage = new JPanel(new GridLayout(2, 1, 0, 0));

		Leavingmessage.setBorder(new EmptyBorder(2, 0, 0, 0)); // 设置边框距离

		JLabel Leavingmessage1 = new JLabel(run.message(i)[0] + "对你留言：       ");
		Leavingmessage1.setFont(new Font("宋体", Font.BOLD, 15));
		Leavingmessage1.setForeground(Color.green);
		Leavingmessage.add(Leavingmessage1);

		JTextArea newbookJLabel2 = new JTextArea(5, 8);
		newbookJLabel2.setLineWrap(true);
		newbookJLabel2.setText("      ");
		newbookJLabel2.append(run.message(i)[1]);
		newbookJLabel2.setEditable(false);
		JScrollPane scroll = new JScrollPane(newbookJLabel2);
		Leavingmessage.add(scroll);

		// Leavingmessage.setPreferredSize(new Dimension(200, 0));

		Riter.add(NewBook);
		Riter.add(Leavingmessage);
		Riter.setPreferredSize(new Dimension(260, 0));// 设置BorderLayout的左右宽度
		add(Riter, BorderLayout.EAST);

		// ----------------------------------------

		

		JPanel Borrowbooks = new JPanel();
		Borrowbooks.setBorder(new EmptyBorder(40, 20, 80, 80));

		vDate = new Vector();
		vName = new Vector();
		vName.add("序号");
		vName.add("书名");
		vName.add("作者");
		vName.add("编号");
		vName.add("借阅本数");
		atm = new DefaultTableModel(vDate, vName);

		table = new JTable(atm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sPane = new JScrollPane(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(240);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		sPane.setBounds(0, 0, 529, 234);
		table.updateUI();
		Borrowbooks.add(sPane);
		addDate();
		add(Borrowbooks, BorderLayout.WEST);

		// _____________________________________借书表格

		JPanel cent = new JPanel(new GridLayout(3, 1, 30, 100));
		cent.setBorder(new EmptyBorder(40, 10, 40, 30));
		returnbook = new JButton("归还图书");
		Borrowbook = new JButton("预定图书");
		Reservebook = new JButton("借阅图书");
		returnbook.addActionListener(this);
		Borrowbook.addActionListener(this);
		Reservebook.addActionListener(this);
		cent.add(returnbook);
		cent.add(Borrowbook);
		cent.add(Reservebook);
		add(cent, BorderLayout.CENTER);

		// ____________________________

		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	void addDate() {
		
		Vector vTmp;
		String[] Studentbook = run
				.Studentbook(run.data.StudentArrayList.get(i).ID);
		
		for(int c=0;c<100;c++){
			int i = table.getRowCount()-1;
			System.out.println(i);
			if(i<0){
				break;
			}
			vDate.remove(i);
			i--;
			table.updateUI();
			
			}
		
			int x=0;
			for (int i = 0; i < Studentbook.length; i=i+4) {
				System.out.println("add");
					vTmp = new Vector();
					if(Studentbook[x]==null){
						break;
					}
					
					vTmp.add(new Integer(vDate.size()+1));
					vTmp.add(Studentbook[x]);
					x++;
					
					vTmp.add(Studentbook[x]);
					x++;
					
					vTmp.add(Studentbook[x]);
					x++;
					
					vTmp.add(Studentbook[x]);
					x++;
					vDate.add(vTmp);
					table.updateUI();
				}
			
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(730, 40, 730, 570);
		g.drawLine(30, 77, 970, 77);
	}

	@Override
	public void actionPerformed(ActionEvent arg2) {
		// returnbook.addActionListener(this);
		// Borrowbook.addActionListener(this);
		// Reservebook.addActionListener(this);
		if (arg2.getSource() == returnbook) {
			
			class returnbook extends JFrame implements ActionListener {

				JTextField name1;
				JButton newRetrieveJButton;

				returnbook(String name, int i) {

					super(name);
					setLayout(new FlowLayout(3, 15, 30));
					JLabel RetrievePassWord = new JLabel("图书名/id:");
					name1 = new JTextField(10);
					newRetrieveJButton = new JButton("归还图书");
					newRetrieveJButton.addActionListener(this);

					add(RetrievePassWord);
					add(name1);
					add(newRetrieveJButton);

					setResizable(false);
					setSize(350, 120);
					setLocationRelativeTo(null);
					setVisible(true);
				}

				@Override
				public void actionPerformed(ActionEvent arg1) {
					if (arg1.getSource() == newRetrieveJButton) {
						String name = name1.getText();
						int a = run.returnbook(name, i);
						if (a == 1) {
							JOptionPane.showMessageDialog(null, "     还书成功！",
									"成功！", JOptionPane.WARNING_MESSAGE);
							addDate();
							this.dispose();
						}
						if (a == 2) {
							JOptionPane.showMessageDialog(null,
									"     你没借这本书呢！", "失败！",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 3) {
							JOptionPane.showMessageDialog(null,
									"     我管还没本书呢！", "失败！",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 0) {
							JOptionPane.showMessageDialog(null,
									"     我也不知道是什么错误！", "失败！",
									JOptionPane.WARNING_MESSAGE);

						}
					}

				}
			}
			new returnbook("还书", i);
			
		}
		if (arg2.getSource() == Borrowbook) {
			class Borrowbook extends JFrame implements ActionListener {

				JTextField name1;
				JButton newRetrieveJButton;

				Borrowbook(String name, int i) {

					super(name);
					setLayout(new FlowLayout(3, 15, 30));
					JLabel RetrievePassWord = new JLabel("图书名/id:");
					name1 = new JTextField(10);
					newRetrieveJButton = new JButton("我要预定这本书");
					newRetrieveJButton.addActionListener(this);

					add(RetrievePassWord);
					add(name1);
					add(newRetrieveJButton);

					setResizable(false);
					setSize(350, 120);
					setLocationRelativeTo(null);
					setVisible(true);
				}

				@Override
				public void actionPerformed(ActionEvent arg1) {
					if (arg1.getSource() == newRetrieveJButton) {
						String name = name1.getText();
						int a = run.Borrowbook(name, i);
						if (a == 2) {
							JOptionPane.showMessageDialog(null, "     这本书还在你手上呢！",
									"失败！", JOptionPane.WARNING_MESSAGE);
							
							
						}
						if (a == 0) {
							JOptionPane.showMessageDialog(null,
									"     没这本书呢，怎么预定！", "失败！",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 1) {
							JOptionPane.showMessageDialog(null,
									"     这本书还有呢，不需要预定！", "失败！",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 5) {
							JOptionPane.showMessageDialog(null,
									"     预定成功啦！", "成功！",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 3) {
							JOptionPane.showMessageDialog(null,
									"     你已经预定过这本书了！", "失败！",
									JOptionPane.WARNING_MESSAGE);

						}

					}
					
					
						
					
					

				}
			}
			new Borrowbook("预定", i);
		}
		if (arg2.getSource() == Reservebook) {
			class Reservebook extends JFrame implements ActionListener {

				JTextField name1;
				JButton newRetrieveJButton;

				Reservebook(String name, int i) {

					super(name);
					setLayout(new FlowLayout(3, 15, 30));
					JLabel RetrievePassWord = new JLabel("图书名/id:");
					name1 = new JTextField(10);
					newRetrieveJButton = new JButton("我要借这本书");
					newRetrieveJButton.addActionListener(this);

					add(RetrievePassWord);
					add(name1);
					add(newRetrieveJButton);

					setResizable(false);
					setSize(350, 120);
					setLocationRelativeTo(null);
					setVisible(true);
				}

				@Override
				public void actionPerformed(ActionEvent arg1) {
					if (arg1.getSource() == newRetrieveJButton) {
						String name = name1.getText();
						int a = run.Reservebook(name, i);
						if (a == 1) {
							JOptionPane.showMessageDialog(null, "     借书成功！",
									"成功！", JOptionPane.WARNING_MESSAGE);
							this.dispose();
							addDate();
						}
						if (a == 0) {
							JOptionPane.showMessageDialog(null,
									"     没这本书呢，怎么借！", "失败！",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 5) {
							JOptionPane.showMessageDialog(null,
									"     对不起这本书已经没有了！", "失败！",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 2) {
							JOptionPane.showMessageDialog(null,
									"     你已经借过这本书了！", "失败！",
									JOptionPane.WARNING_MESSAGE);

						}

					}
					
					
						
					
					

				}
			}
			new Reservebook("借书", i);
			
		}

		if (arg2.getSource() == bookquery) {

			final String[] a = run.getbook(BookName.getText());
			if (a == null) {
				JOptionPane.showMessageDialog(null, "     无此图书！", "搜索错误！",
						JOptionPane.WARNING_MESSAGE);
			}

			class query extends JFrame {

				JTextField messageName;
				JTextArea messagesay;
				JTextField ID1;

				JTextField name3;
				JTextField age1;
				JTextField ged1;

				query(String name) {
					super(name);

					setLayout(new FlowLayout(3, 75, 30));
					JLabel ID = new JLabel("书名:   ");
					ID1 = new JTextField(10);
					ID1.setText(a[0]);
					JLabel name2 = new JLabel("作者:   ");
					name3 = new JTextField(10);
					name3.setText(a[1]);
					JLabel age = new JLabel("书编号:   ");
					age1 = new JTextField(10);
					age1.setText(a[2]);
					JLabel ged = new JLabel("在管本数:");
					ged1 = new JTextField(10);
					ged1.setText(a[3]);

					add(ID);
					add(ID1);
					add(name2);
					add(name3);
					add(age);
					add(age1);
					add(ged);
					add(ged1);

					setResizable(false);
					setSize(400, 300);
					setLocationRelativeTo(null);
					setVisible(true);
				}

			}
			if (a != null) {
				new query("图书查询");
			}

		}
		if (arg2.getSource() == department) {
			if (department.getSelectedItem().toString().equals("修改密码")) {
				class Retrieve extends JFrame implements ActionListener {

					JPasswordField newRetrievePassWord1;
					JButton newRetrieveJButton;
					JPasswordField RetrievePassWord1;
					JButton RetrieveJButton;

					Retrieve(String name) {
						super(name);
						newRetrieveJButton = new JButton("修改密码");
						newRetrieveJButton.addActionListener(this);
						setLayout(new FlowLayout(1, 30, 26));
						JLabel RetrievePassWord = new JLabel("原密码:");
						RetrievePassWord1 = new JPasswordField(15);
						RetrievePassWord1.setEchoChar('*');
						JLabel newRetrievePassWord = new JLabel("新密码:");
						newRetrievePassWord1 = new JPasswordField(15);
						newRetrievePassWord1.setEchoChar('*');

						add(RetrievePassWord);
						add(RetrievePassWord1);
						add(newRetrievePassWord);
						add(newRetrievePassWord1);
						add(newRetrieveJButton);

						setResizable(false);
						setSize(300, 200);
						setLocationRelativeTo(null);
						setVisible(true);
					}

					@Override
					public void actionPerformed(ActionEvent arg1) {
						if (arg1.getSource() == newRetrieveJButton) {
							String newRetrievepassword = new String(
									newRetrievePassWord1.getPassword());
							String Retrievepassword = new String(
									RetrievePassWord1.getPassword());
							int a = run.Retrieve(Retrievepassword,
									newRetrievepassword, i);

							if (a == 1) {
								JOptionPane.showMessageDialog(null,
										"     成功修改！", "修改成功！",
										JOptionPane.WARNING_MESSAGE);
								this.dispose();
							}
							if (a == 0) {
								JOptionPane.showMessageDialog(null,
										"     原密码错误！", "修改失败！",
										JOptionPane.WARNING_MESSAGE);

							}
						}

					}
				}
				new Retrieve("密码修改");
			}
			if (department.getSelectedItem().toString().equals("注销用户")) {
				try {
					run.off();
					this.dispose();
					new Library_SignIn("登录");
				} catch (IOException e) {
				}

			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == Query) {
			class query extends JFrame implements ActionListener {

				JTextField messageName;
				JTextArea messagesay;
				JTextField ID1;
				JButton say;
				JTextField name3;
				JTextField age1;
				JTextField ged1;

				query(String name) {
					super(name);

					setLayout(new FlowLayout(3, 40, 20));
					JLabel name1 = new JLabel("对方昵称\\用户名:");
					JLabel ID = new JLabel("                            ID:");
					ID1 = new JTextField(10);

					JLabel name2 = new JLabel("                       昵称:");
					name3 = new JTextField(10);

					JLabel age = new JLabel("                       年龄:");
					age1 = new JTextField(10);

					JLabel ged = new JLabel("                       班级:");
					ged1 = new JTextField(10);

					messageName = new JTextField(10);

					say = new JButton(" 查询");
					say.addActionListener(this);
					add(name1);
					add(messageName);
					add(say);
					add(ID);
					add(ID1);
					add(name2);
					add(name3);
					add(age);
					add(age1);
					add(ged);
					add(ged1);

					setResizable(false);
					setSize(400, 300);
					setLocationRelativeTo(null);
					setVisible(true);
				}

				@Override
				public void actionPerformed(ActionEvent arg1) {
					if (arg1.getSource() == say) {

						String[] a = run.queryStudent(messageName.getText());

						if (a == null) {
							JOptionPane.showMessageDialog(null, "     无此用户！",
									"错误！", JOptionPane.WARNING_MESSAGE);

						}
						if (a != null) {
							ID1.setText(a[0]);
							name3.setText(a[1]);
							age1.setText(a[2]);
							ged1.setText(a[3]);
						}
					}

				}

			}
			new query("用户查询");
		}

		if (e.getSource() == message) {
			class message extends JFrame implements ActionListener {

				JTextField messageName;
				JTextArea messagesay;
				JButton say;

				message(String name) {
					super(name);

					setLayout(new FlowLayout(1, 40, 20));
					JLabel messagename = new JLabel("对方昵称:");
					JLabel messagenameSAY = new JLabel("留言:");
					messageName = new JTextField(10);
					messagesay = new JTextArea(3, 15);
					messagesay.setLineWrap(true);
					say = new JButton(" 发送");
					say.addActionListener(this);
					JScrollPane scroll = new JScrollPane(messagesay);
					add(messagename);
					add(messageName);
					add(messagenameSAY);
					add(scroll);
					add(say);

					setResizable(false);
					setSize(300, 200);
					setLocationRelativeTo(null);
					setVisible(true);
				}

				@Override
				public void actionPerformed(ActionEvent arg1) {
					if (arg1.getSource() == say) {
						String er = messageName.getText();
						String Say = messagesay.getText();

						int a = run.Sendmessage(i, er, Say);

						if (a == 1) {
							JOptionPane.showMessageDialog(null,
									"     成功发送到对方！！", "成功！",
									JOptionPane.WARNING_MESSAGE);
							this.dispose();
						}
						if (a == 0) {
							JOptionPane.showMessageDialog(null, "     无此用户！",
									"错误！", JOptionPane.WARNING_MESSAGE);

						}
					}

				}

			}
			new message("留言");
		}
		if (e.getSource() == BookName) {
			if (BookName.getText().equals("书名\\ID")) {
				BookName.setText("");
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

// guanliyuan
class adminInterface extends JFrame implements ActionListener, MouseListener {
	void off() {
		this.dispose();
	}

	JLabel Studentsearch;
	JLabel Studentlist;
	JLabel booksearch;
	JLabel booklist;
	Library_data_operation run;

	JMenuItem addStudent;
	JMenuItem moveStudent;
	JMenuItem addbook;
	JMenuItem movebook;
	JMenuItem off;

	adminInterface(String name) throws IOException {
		super(name);
		run = new Library_data_operation();

		JPanel information = new JPanel();
		information.setLayout(new FlowLayout(3, 30, 10));
		Studentsearch = new JLabel("查询用户");
		Studentsearch.setFont(new Font("宋体", Font.BOLD, 13));
		Studentsearch.setForeground(Color.orange);
		Studentsearch.addMouseListener(this);

		Studentlist = new JLabel("用户列表");
		Studentlist.setFont(new Font("宋体", Font.BOLD, 13));
		Studentlist.setForeground(Color.blue);
		Studentlist.addMouseListener(this);

		booksearch = new JLabel("查询图书");
		booksearch.setFont(new Font("宋体", Font.BOLD, 13));
		booksearch.setForeground(Color.magenta);
		booksearch.addMouseListener(this);

		booklist = new JLabel("图书列表");
		booklist.setFont(new Font("宋体", Font.BOLD, 13));
		booklist.setForeground(Color.yellow);
		booklist.addMouseListener(this);

		JLabel admin = new JLabel("管理员:" + " admin");
		admin.setFont(new Font("宋体", Font.BOLD, 13));
		admin.setForeground(Color.black);

		ImageIcon background = new ImageIcon("123.png");
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());

		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		Container cp = getContentPane();
		setLayout(new BorderLayout());
		((JPanel) cp).setOpaque(false);

		add(Studentsearch);
		add(Studentlist);
		add(booksearch);
		add(booklist);
		add(admin);
		setLayout(new FlowLayout(3, 45, 10));

		JMenuBar bar = new JMenuBar(); // 添加空的菜单栏
		this.setJMenuBar(bar);
		JMenu menu = new JMenu("管理员操作");// 菜单对象

		addStudent = new JMenuItem("添加用户");
		moveStudent = new JMenuItem("删除用户");
		addbook = new JMenuItem("添加图书");
		movebook = new JMenuItem("删除图书");
		off = new JMenuItem("注销");
		addStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				class register extends JFrame implements ActionListener {
					JTextField registerID1;
					JTextField registername11;
					JTextField registerage1;
					JTextField registergrade1;
					JPasswordField registerPassWord1;
					JButton registerJButton;

					register(String name) {
						super(name);
						registerJButton = new JButton("添加用户");
						registerJButton.addActionListener(this);
						setLayout(new FlowLayout(1, 20, 30));
						JLabel registerID = new JLabel("账号:");
						JLabel registerage = new JLabel("年龄:");
						registerage1 = new JTextField(15);
						registerID1 = new JTextField(15);
						JLabel registername1 = new JLabel("昵称:");
						registername11 = new JTextField(15);
						JLabel registerPassWord = new JLabel("密码:");
						registerPassWord1 = new JPasswordField(15);
						registerPassWord1.setEchoChar('*');
						JLabel registergrade = new JLabel("班级:");
						registergrade1 = new JTextField(15);

						add(registerID);
						add(registerID1);
						add(registername1);
						add(registername11);
						add(registerPassWord);
						add(registerPassWord1);
						add(registerage);
						add(registerage1);
						add(registergrade);
						add(registergrade1);
						add(registerJButton);

						setSize(300, 400);
						setLocationRelativeTo(null);
						setVisible(true);
					}

					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (arg0.getSource() == registerJButton) {
							String registerpassword = new String(
									registerPassWord1.getPassword());
							int a = run.register(registerID1.getText(),
									registername11.getText(), registerpassword,
									registerage1.getText(),
									registergrade1.getText());

							if (a == 1) {
								JOptionPane.showMessageDialog(null,
										"     账号重复！", "添加失败！",
										JOptionPane.WARNING_MESSAGE);
							}
							if (a == 0) {
								JOptionPane.showMessageDialog(null,
										"     添加成功！", "添加成功！",

										JOptionPane.WARNING_MESSAGE);
								this.dispose();
							}

						}

					}
				}
				new register("添加用户");
			}
		});
		moveStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				class register extends JFrame implements ActionListener {

					JTextField registername11;
					JButton registerJButton;

					register(String name) {
						super(name);
						registerJButton = new JButton("删除！");
						registerJButton.addActionListener(this);
						registername11 = new JTextField(10);
						setLayout(new FlowLayout(1, 10, 10));
						JLabel registerID = new JLabel("账号:");

						add(registerID);
						add(registername11);

						add(registerJButton);

						setSize(400, 100);
						setLocationRelativeTo(null);
						setVisible(true);
					}

					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (arg0.getSource() == registerJButton) {
							int a = run.moveStudent(registername11.getText());

							if (a == 0) {
								JOptionPane.showMessageDialog(null,
										"     无此账号！", "删除失败！",
										JOptionPane.WARNING_MESSAGE);
							}
							if (a == 1) {
								JOptionPane.showMessageDialog(null,
										"     删除成功！", "删除！",

										JOptionPane.WARNING_MESSAGE);

							}

						}

					}
				}
				new register("删除用户");

			}

		});

		addbook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				class booksearch extends JFrame implements ActionListener {

					JTextField messageName;
					JTextArea messagesay;
					JTextField ID1;
					JButton say;
					JTextField name3;
					JTextField age1;
					JTextField ged1;

					booksearch(String name) {
						super(name);

						setLayout(new FlowLayout(1, 40, 20));

						JLabel ID = new JLabel("                       书名:");
						ID1 = new JTextField(13);

						JLabel name2 = new JLabel("                       编号:");
						name3 = new JTextField(13);

						JLabel age = new JLabel("                       作者:");
						age1 = new JTextField(13);

						JLabel ged = new JLabel("                       存本:");
						ged1 = new JTextField(13);

						messageName = new JTextField(13);

						say = new JButton(" 添加");
						say.addActionListener(this);

						add(ID);
						add(ID1);
						add(name2);
						add(name3);
						add(age);
						add(age1);
						add(ged);
						add(ged1);
						add(say);
						setResizable(false);
						setSize(350, 250);
						setLocationRelativeTo(null);
						setVisible(true);
					}

					@Override
					public void actionPerformed(ActionEvent arg1) {
						if (arg1.getSource() == say) {

							int a = run.addbook(ID1.getText(), age1.getText(),
									name3.getText(), ged1.getText());
							if (a == 1) {
								JOptionPane.showMessageDialog(null,
										"     添加成功！", "成功！",
										JOptionPane.WARNING_MESSAGE);
							}
							if (a == 0) {
								JOptionPane.showMessageDialog(null,
										"     编号重复！", "天加失败！",
										JOptionPane.WARNING_MESSAGE);
							}
						}

					}

				}
				new booksearch("图书查询");

			}

		});
		movebook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				class register extends JFrame implements ActionListener {

					JTextField registername11;
					JButton registerJButton;

					register(String name) {
						super(name);
						registerJButton = new JButton("删除！");
						registerJButton.addActionListener(this);
						registername11 = new JTextField(10);
						setLayout(new FlowLayout(1, 10, 10));
						JLabel registerID = new JLabel("图书/编号牌:");

						add(registerID);
						add(registername11);

						add(registerJButton);

						setSize(400, 100);
						setLocationRelativeTo(null);
						setVisible(true);
					}

					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (arg0.getSource() == registerJButton) {
							int a = run.movebook(registername11.getText());

							if (a == 0) {
								JOptionPane.showMessageDialog(null,
										"     无此书！", "删除失败！",
										JOptionPane.WARNING_MESSAGE);
							}
							if (a == 1) {
								JOptionPane.showMessageDialog(null,
										"     删除成功！", "删除！",

										JOptionPane.WARNING_MESSAGE);

							}

						}

					}
				}
				new register("删除图书");
			}

		});
		off.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				off();
				try {
					run.off();
					new Library_SignIn("登录");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		menu.add(addStudent);
		menu.add(moveStudent);
		menu.add(addbook);
		menu.add(movebook);
		menu.add(off);
		menu.addSeparator();
		bar.add(menu);

		information.setBorder(new EmptyBorder(15, 0, 0, 0));

		setSize(600, 350);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == Studentsearch) {
			class Studentsearch extends JFrame implements ActionListener {

				JTextField messageName;
				JTextArea messagesay;
				JTextField ID1;
				JButton say;
				JButton modify;
				JTextField name3;
				JTextField age1;
				JTextField ged1;

				Studentsearch(String name) {
					super(name);

					setLayout(new FlowLayout(1, 40, 20));
					JLabel name1 = new JLabel("用户昵称\\用户名:");
					JLabel ID = new JLabel("                            ID:");
					ID1 = new JTextField(10);
					ID1.setEditable(false);
					JLabel name2 = new JLabel("                       昵称:");
					name3 = new JTextField(10);
					name3.setEditable(false);
					JLabel age = new JLabel("                       年龄:");
					age1 = new JTextField(10);
					
					JLabel ged = new JLabel("                       班级:");
					ged1 = new JTextField(10);

					messageName = new JTextField(10);

					say = new JButton(" 查询");
					say.addActionListener(this);
					
					modify = new JButton(" 修改");
					modify.addActionListener(this);
					
					add(name1);
					add(messageName);
					add(say);
					add(ID);
					add(ID1);
					add(name2);
					add(name3);
					add(age);
					add(age1);
					add(ged);
					add(ged1);
					add(modify);

					setResizable(false);
					setSize(400, 300);
					setLocationRelativeTo(null);
					setVisible(true);
				}

				@Override
				public void actionPerformed(ActionEvent arg1) {

					if (arg1.getSource() == say) {

						String[] a = run.queryStudent(messageName.getText());

						if (a == null) {
							JOptionPane.showMessageDialog(null, "     无此用户！",
									"错误！", JOptionPane.WARNING_MESSAGE);

						}
						if (a != null) {
							ID1.setText(a[0]);
							name3.setText(a[1]);
							age1.setText(a[2]);
							ged1.setText(a[3]);
						}
					}
					
					
					if (arg1.getSource() == modify) {
						
						String c=ID1.getText();
						String a = age1.getText();
						String g=ged1.getText();
						int b=run.modifyStudent(c, a, g);
						if (b == 1) {
							JOptionPane.showMessageDialog(null, "     修改用户！",
									"成功！", JOptionPane.WARNING_MESSAGE);

						}
						if(b==2){
							JOptionPane.showMessageDialog(null, "     我认为是不可能出现的错误！",
									"成功！", JOptionPane.WARNING_MESSAGE);
						}
						
					}

				}

			}
			new Studentsearch("用户查询/修改");
		}
		if (e.getSource() == booksearch) {
			class booksearch extends JFrame implements ActionListener {

				JTextField messageName;
				JTextArea messagesay;
				JTextField ID1;
				JButton say;
				JTextField name3;
				JTextField age1;
				JTextField ged1;

				booksearch(String name) {
					super(name);

					setLayout(new FlowLayout(3, 40, 20));
					JLabel name1 = new JLabel("书名\\编号:");
					JLabel ID = new JLabel("                       书名:");
					ID1 = new JTextField(13);

					JLabel name2 = new JLabel("                       编号:");
					name3 = new JTextField(13);

					JLabel age = new JLabel("                       作者:");
					age1 = new JTextField(13);

					JLabel ged = new JLabel("                       存本:");
					ged1 = new JTextField(13);

					messageName = new JTextField(13);

					say = new JButton(" 查询");
					say.addActionListener(this);
					add(name1);
					add(messageName);
					add(say);
					add(ID);
					add(ID1);
					add(name2);
					add(name3);
					add(age);
					add(age1);
					add(ged);
					add(ged1);

					setResizable(false);
					setSize(400, 300);
					setLocationRelativeTo(null);
					setVisible(true);
				}

				@Override
				public void actionPerformed(ActionEvent arg1) {
					if (arg1.getSource() == say) {

						final String[] a = run.getbook(messageName.getText());

						if (a == null) {
							JOptionPane.showMessageDialog(null, "     无此图书！",
									"错误！", JOptionPane.WARNING_MESSAGE);

						}
						if (a != null) {
							ID1.setText(a[0]);
							name3.setText(a[2]);
							age1.setText(a[1]);
							ged1.setText(a[3]);
						}
					}

				}

			}
			new booksearch("图书查询");
		}

		if (e.getSource() == Studentlist) {

			class Studentlist extends JFrame {

				JTable table = null;
				JScrollPane sPane = null;
				DefaultTableModel atm = null;
				Vector vDate = new Vector();
				Vector vName = new Vector();

				ArrayList<Student> StudentArrayList;

				public Studentlist(String name) {
					super(name);
					vName.add("序号");
					vName.add("ID");
					vName.add("昵称");
					vName.add("年龄");
					vName.add("班级");

					getContentPane().setLayout(null);
					setBounds(100, 100, 500, 300);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setLayout(null);
					setSize(530, 300);
					setResizable(false);

					atm = new DefaultTableModel(vDate, vName);

					table = new JTable(atm);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					sPane = new JScrollPane(table);

					sPane.setBounds(0, 0, 529, 234);
					this.getContentPane().add(sPane);

					table.updateUI();

					final JButton button = new JButton();

					addDate();

					setLocationRelativeTo(null);
					setVisible(true);
				}

				public void addDate() {
					StudentArrayList = run.getStudent();

					for (int i = 0; i < StudentArrayList.size(); i++) {
						Vector vTmp = new Vector();
						vTmp.add(new Integer(vDate.size()));
						vTmp.add(StudentArrayList.get(i).ID);
						vTmp.add(StudentArrayList.get(i).name);
						vTmp.add(StudentArrayList.get(i).age);
						vTmp.add(StudentArrayList.get(i).grade);
						vDate.add(vTmp);
						table.updateUI();
					}

				}

			}
			new Studentlist("用户列表");
		}
		if (e.getSource() == booklist) {
			class booklist extends JFrame {

				JTable table = null;
				JScrollPane sPane = null;
				DefaultTableModel atm = null;
				Vector vDate = new Vector();
				Vector vName = new Vector();

				ArrayList<book> bookArrayList;

				public booklist(String name) {
					super(name);
					vName.add("序号");
					vName.add("书名");
					vName.add("作者");
					vName.add("编号");
					vName.add("存本");

					getContentPane().setLayout(null);
					// setBounds(100, 100, 500, 300);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setLayout(null);
					setSize(530, 300);
					setResizable(false);

					atm = new DefaultTableModel(vDate, vName);

					table = new JTable(atm);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					sPane = new JScrollPane(table);

					sPane.setBounds(0, 0, 529, 234);
					this.getContentPane().add(sPane);

					table.updateUI();

					final JButton button = new JButton();

					addDate();

					setLocationRelativeTo(null);
					setVisible(true);
				}

				public void addDate() {
					bookArrayList = run.getbook();

					for (int i = 0; i < bookArrayList.size(); i++) {
						Vector vTmp = new Vector();
						vTmp.add(new Integer(vDate.size()));
						vTmp.add(bookArrayList.get(i).name);
						vTmp.add(bookArrayList.get(i).booknameer);
						vTmp.add(bookArrayList.get(i).id);
						vTmp.add(bookArrayList.get(i).much);
						vDate.add(vTmp);
						table.updateUI();
					}

				}

			}
			new booklist("图书列表");
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}

