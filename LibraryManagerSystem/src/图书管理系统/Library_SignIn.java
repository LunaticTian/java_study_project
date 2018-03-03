package ͼ�����ϵͳ;

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
	JButton Land = new JButton("��¼");
	JButton register = new JButton("ע��");
	JButton Retrieve = new JButton("�һ�����");
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

		Student = new JRadioButton("ѧ��", true);
		admin = new JRadioButton("����Ա");
		group = new ButtonGroup();// JRadioButton��ѡ
		group.add(Student);
		group.add(admin);
		Student.addActionListener(this);
		admin.addActionListener(this);

		JLabel ID = new JLabel("�˺�:");
		ID1 = new JTextField(15);
		JLabel PassWord = new JLabel("����:");
		PassWord1 = new JPasswordField(15);
		PassWord1.setEchoChar('*');
		// ����
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
		if (e.getSource() == Land) {// ��¼

			String id = ID1.getText();
			char[] PassWord = PassWord1.getPassword();
			String password = new String(PassWord);

			int c = run.Land(id, password);
			if (a.equals("ѧ��")) {
				if (c != -1 && c != -2) {
					JOptionPane.showMessageDialog(null, "     ����ϵͳ��", "�ɹ���",
							JOptionPane.WARNING_MESSAGE);
					try {
						run.off();
					} catch (IOException e1) {
					}
					this.dispose();
					try {
						new StudentInterface("ѧ������", c);
					} catch (IOException e1) {
					}
				} else if (c == -1) {
					JOptionPane.showMessageDialog(null, "     �������", "����",
							JOptionPane.WARNING_MESSAGE);
				} else if (c == -2) {
					JOptionPane.showMessageDialog(null, "     �޴��˺ţ�", "����",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			if (a.equals("����Ա")) {
				String id1 = ID1.getText();
				char[] PassWord2 = PassWord1.getPassword();
				String password3 = new String(PassWord2);
				if (id1.equals("admin") && password3.equals("admin")) {
					try {
						this.dispose();
						new adminInterface("����Ա");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (!id1.equals("admin") || !password3.equals("admin")) {
					JOptionPane.showMessageDialog(null, "     �˺Ż��������", "����",
							JOptionPane.WARNING_MESSAGE);
				}

			}

		}
		if (e.getSource() == register) {// ע��

			class register extends JFrame implements ActionListener {
				JTextField registerID1;
				JTextField registername11;
				JTextField registerage1;
				JTextField registergrade1;
				JPasswordField registerPassWord1;
				JButton registerJButton;

				register(String name) {
					super(name);
					registerJButton = new JButton("ע��");
					registerJButton.addActionListener(this);
					setLayout(new FlowLayout(1, 20, 30));
					JLabel registerID = new JLabel("�˺�:");
					JLabel registerage = new JLabel("����:");
					registerage1 = new JTextField(15);
					registerID1 = new JTextField(15);
					JLabel registername1 = new JLabel("�ǳ�:");
					registername11 = new JTextField(15);
					JLabel registerPassWord = new JLabel("����:");
					registerPassWord1 = new JPasswordField(15);
					registerPassWord1.setEchoChar('*');
					JLabel registergrade = new JLabel("�༶:");
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
							JOptionPane.showMessageDialog(null, "     �˺��ظ���",
									"ע��ʧ�ܣ�", JOptionPane.WARNING_MESSAGE);
						}
						if (a == 0) {
							JOptionPane.showMessageDialog(null, "     ע��ɹ���",
									"ע��ɹ���",

									JOptionPane.WARNING_MESSAGE);
							this.dispose();
						}

					}

				}
			}
			new register("ע��");
		}
		if (e.getSource() == Retrieve) {// �һ�����
			class Retrieve extends JFrame implements ActionListener {
				JTextField RetrieveID1;
				JTextField Retrievename11;
				JTextField Retrievegrade1;
				JPasswordField RetrievePassWord1;
				JButton RetrieveJButton;

				Retrieve(String name) {
					super(name);
					RetrieveJButton = new JButton("�޸�����");
					RetrieveJButton.addActionListener(this);
					setLayout(new FlowLayout(1, 20, 30));
					JLabel RetrieveID = new JLabel("�˺�:");
					RetrieveID1 = new JTextField(15);
					JLabel Retrievename1 = new JLabel("�ǳ�:");
					Retrievename11 = new JTextField(15);
					JLabel RetrievePassWord = new JLabel("����:");
					RetrievePassWord1 = new JPasswordField(15);
					RetrievePassWord1.setEchoChar('*');
					JLabel Retrievegrade = new JLabel("�༶:");
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
							JOptionPane.showMessageDialog(null, "     �޴��˺ţ�",
									"�޸�ʧ�ܣ�", JOptionPane.WARNING_MESSAGE);

						}
						if (a == 2) {
							JOptionPane.showMessageDialog(null, "     �ǳƴ���",
									"�޸�ʧ�ܣ�", JOptionPane.WARNING_MESSAGE);
						}
						if (a == 3) {
							JOptionPane.showMessageDialog(null, "     �༶����",
									"�޸�ʧ�ܣ�", JOptionPane.WARNING_MESSAGE);
						}
						if (a == 4) {
							JOptionPane.showMessageDialog(null, "     �ɹ��޸ģ�",
									"�޸ĳɹ���", JOptionPane.WARNING_MESSAGE);
							this.dispose();
						}
					}

				}
			}
			new Retrieve("�һ�����");
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
		JLabel StudentName = new JLabel("�ǳ�:"
				+ run.data.StudentArrayList.get(i).name);
		StudentName.setFont(new Font("����", Font.BOLD, 13));
		JLabel StudentID = new JLabel("�û���:"
				+ run.data.StudentArrayList.get(i).ID);
		StudentID.setFont(new Font("����", Font.BOLD, 13));
		JLabel Studentage = new JLabel("����:"
				+ run.data.StudentArrayList.get(i).age);
		Studentage.setFont(new Font("����", Font.BOLD, 13));
		JLabel Studentgrade = new JLabel("�༶:"
				+ run.data.StudentArrayList.get(i).grade);
		Studentgrade.setFont(new Font("����", Font.BOLD, 13));
		JLabel Modify_password = new JLabel("�����޸�");
		Modify_password.setFont(new Font("����", Font.BOLD, 13));

		Modify_password.addMouseListener(this);
		String[] departmentNames = { "�˺�ѡ��", "�޸�����", "ע���û�" };
		department = new JComboBox(departmentNames);
		department.setEditable(false);
		department.addActionListener(this);
		Query = new JLabel("    ��ѯ�û�");
		Query.setFont(new Font("����", Font.BOLD, 15));
		Query.setForeground(Color.blue);
		Query.addMouseListener(this);

		message = new JLabel("��ta����");
		message.setFont(new Font("����", Font.BOLD, 15));
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
		// �Ϸ�______________________________________________________

		JPanel Riter = new JPanel();
		// Riter.setLayout(new GridLayout(4,1,10,10));
		JPanel RiterSon = new JPanel();// Riter�������

		BookName = new JTextField("����\\ID", 13);
		BookName.addMouseListener(this);
		bookquery = new JButton("��ѯ");
		bookquery.addActionListener(this);
		RiterSon.add(BookName);
		RiterSon.add(bookquery);

		Riter.add(RiterSon);
		// --------------------------------------
		JPanel NewBook = new JPanel(new GridLayout(6, 1, 20, 25));// �����ϼ�
		NewBook.setBorder(new EmptyBorder(30, 0, 0, 0)); // ���ñ߿����

		// ��ѯ����
		JLabel newbookJLabel = new JLabel("�����ϼ� ");
		newbookJLabel.setFont(new Font("����", Font.BOLD, 15));
		newbookJLabel.setForeground(Color.orange);
		NewBook.add(newbookJLabel);

		String[] newbook = run.newbook();
		for (int x = 0; x < 10; x++) {
			JLabel ax = new JLabel(newbook[x] + "       " + newbook[x + 1]);
			NewBook.add(ax);
			x++;

		}
		// _________________________�����ϼ�

		JPanel Leavingmessage = new JPanel(new GridLayout(2, 1, 0, 0));

		Leavingmessage.setBorder(new EmptyBorder(2, 0, 0, 0)); // ���ñ߿����

		JLabel Leavingmessage1 = new JLabel(run.message(i)[0] + "�������ԣ�       ");
		Leavingmessage1.setFont(new Font("����", Font.BOLD, 15));
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
		Riter.setPreferredSize(new Dimension(260, 0));// ����BorderLayout�����ҿ��
		add(Riter, BorderLayout.EAST);

		// ----------------------------------------

		

		JPanel Borrowbooks = new JPanel();
		Borrowbooks.setBorder(new EmptyBorder(40, 20, 80, 80));

		vDate = new Vector();
		vName = new Vector();
		vName.add("���");
		vName.add("����");
		vName.add("����");
		vName.add("���");
		vName.add("���ı���");
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

		// _____________________________________������

		JPanel cent = new JPanel(new GridLayout(3, 1, 30, 100));
		cent.setBorder(new EmptyBorder(40, 10, 40, 30));
		returnbook = new JButton("�黹ͼ��");
		Borrowbook = new JButton("Ԥ��ͼ��");
		Reservebook = new JButton("����ͼ��");
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
					JLabel RetrievePassWord = new JLabel("ͼ����/id:");
					name1 = new JTextField(10);
					newRetrieveJButton = new JButton("�黹ͼ��");
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
							JOptionPane.showMessageDialog(null, "     ����ɹ���",
									"�ɹ���", JOptionPane.WARNING_MESSAGE);
							addDate();
							this.dispose();
						}
						if (a == 2) {
							JOptionPane.showMessageDialog(null,
									"     ��û���Ȿ���أ�", "ʧ�ܣ�",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 3) {
							JOptionPane.showMessageDialog(null,
									"     �ҹܻ�û�����أ�", "ʧ�ܣ�",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 0) {
							JOptionPane.showMessageDialog(null,
									"     ��Ҳ��֪����ʲô����", "ʧ�ܣ�",
									JOptionPane.WARNING_MESSAGE);

						}
					}

				}
			}
			new returnbook("����", i);
			
		}
		if (arg2.getSource() == Borrowbook) {
			class Borrowbook extends JFrame implements ActionListener {

				JTextField name1;
				JButton newRetrieveJButton;

				Borrowbook(String name, int i) {

					super(name);
					setLayout(new FlowLayout(3, 15, 30));
					JLabel RetrievePassWord = new JLabel("ͼ����/id:");
					name1 = new JTextField(10);
					newRetrieveJButton = new JButton("��ҪԤ���Ȿ��");
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
							JOptionPane.showMessageDialog(null, "     �Ȿ�黹���������أ�",
									"ʧ�ܣ�", JOptionPane.WARNING_MESSAGE);
							
							
						}
						if (a == 0) {
							JOptionPane.showMessageDialog(null,
									"     û�Ȿ���أ���ôԤ����", "ʧ�ܣ�",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 1) {
							JOptionPane.showMessageDialog(null,
									"     �Ȿ�黹���أ�����ҪԤ����", "ʧ�ܣ�",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 5) {
							JOptionPane.showMessageDialog(null,
									"     Ԥ���ɹ�����", "�ɹ���",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 3) {
							JOptionPane.showMessageDialog(null,
									"     ���Ѿ�Ԥ�����Ȿ���ˣ�", "ʧ�ܣ�",
									JOptionPane.WARNING_MESSAGE);

						}

					}
					
					
						
					
					

				}
			}
			new Borrowbook("Ԥ��", i);
		}
		if (arg2.getSource() == Reservebook) {
			class Reservebook extends JFrame implements ActionListener {

				JTextField name1;
				JButton newRetrieveJButton;

				Reservebook(String name, int i) {

					super(name);
					setLayout(new FlowLayout(3, 15, 30));
					JLabel RetrievePassWord = new JLabel("ͼ����/id:");
					name1 = new JTextField(10);
					newRetrieveJButton = new JButton("��Ҫ���Ȿ��");
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
							JOptionPane.showMessageDialog(null, "     ����ɹ���",
									"�ɹ���", JOptionPane.WARNING_MESSAGE);
							this.dispose();
							addDate();
						}
						if (a == 0) {
							JOptionPane.showMessageDialog(null,
									"     û�Ȿ���أ���ô�裡", "ʧ�ܣ�",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 5) {
							JOptionPane.showMessageDialog(null,
									"     �Բ����Ȿ���Ѿ�û���ˣ�", "ʧ�ܣ�",
									JOptionPane.WARNING_MESSAGE);

						}
						if (a == 2) {
							JOptionPane.showMessageDialog(null,
									"     ���Ѿ�����Ȿ���ˣ�", "ʧ�ܣ�",
									JOptionPane.WARNING_MESSAGE);

						}

					}
					
					
						
					
					

				}
			}
			new Reservebook("����", i);
			
		}

		if (arg2.getSource() == bookquery) {

			final String[] a = run.getbook(BookName.getText());
			if (a == null) {
				JOptionPane.showMessageDialog(null, "     �޴�ͼ�飡", "��������",
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
					JLabel ID = new JLabel("����:   ");
					ID1 = new JTextField(10);
					ID1.setText(a[0]);
					JLabel name2 = new JLabel("����:   ");
					name3 = new JTextField(10);
					name3.setText(a[1]);
					JLabel age = new JLabel("����:   ");
					age1 = new JTextField(10);
					age1.setText(a[2]);
					JLabel ged = new JLabel("�ڹܱ���:");
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
				new query("ͼ���ѯ");
			}

		}
		if (arg2.getSource() == department) {
			if (department.getSelectedItem().toString().equals("�޸�����")) {
				class Retrieve extends JFrame implements ActionListener {

					JPasswordField newRetrievePassWord1;
					JButton newRetrieveJButton;
					JPasswordField RetrievePassWord1;
					JButton RetrieveJButton;

					Retrieve(String name) {
						super(name);
						newRetrieveJButton = new JButton("�޸�����");
						newRetrieveJButton.addActionListener(this);
						setLayout(new FlowLayout(1, 30, 26));
						JLabel RetrievePassWord = new JLabel("ԭ����:");
						RetrievePassWord1 = new JPasswordField(15);
						RetrievePassWord1.setEchoChar('*');
						JLabel newRetrievePassWord = new JLabel("������:");
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
										"     �ɹ��޸ģ�", "�޸ĳɹ���",
										JOptionPane.WARNING_MESSAGE);
								this.dispose();
							}
							if (a == 0) {
								JOptionPane.showMessageDialog(null,
										"     ԭ�������", "�޸�ʧ�ܣ�",
										JOptionPane.WARNING_MESSAGE);

							}
						}

					}
				}
				new Retrieve("�����޸�");
			}
			if (department.getSelectedItem().toString().equals("ע���û�")) {
				try {
					run.off();
					this.dispose();
					new Library_SignIn("��¼");
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
					JLabel name1 = new JLabel("�Է��ǳ�\\�û���:");
					JLabel ID = new JLabel("                            ID:");
					ID1 = new JTextField(10);

					JLabel name2 = new JLabel("                       �ǳ�:");
					name3 = new JTextField(10);

					JLabel age = new JLabel("                       ����:");
					age1 = new JTextField(10);

					JLabel ged = new JLabel("                       �༶:");
					ged1 = new JTextField(10);

					messageName = new JTextField(10);

					say = new JButton(" ��ѯ");
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
							JOptionPane.showMessageDialog(null, "     �޴��û���",
									"����", JOptionPane.WARNING_MESSAGE);

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
			new query("�û���ѯ");
		}

		if (e.getSource() == message) {
			class message extends JFrame implements ActionListener {

				JTextField messageName;
				JTextArea messagesay;
				JButton say;

				message(String name) {
					super(name);

					setLayout(new FlowLayout(1, 40, 20));
					JLabel messagename = new JLabel("�Է��ǳ�:");
					JLabel messagenameSAY = new JLabel("����:");
					messageName = new JTextField(10);
					messagesay = new JTextArea(3, 15);
					messagesay.setLineWrap(true);
					say = new JButton(" ����");
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
									"     �ɹ����͵��Է�����", "�ɹ���",
									JOptionPane.WARNING_MESSAGE);
							this.dispose();
						}
						if (a == 0) {
							JOptionPane.showMessageDialog(null, "     �޴��û���",
									"����", JOptionPane.WARNING_MESSAGE);

						}
					}

				}

			}
			new message("����");
		}
		if (e.getSource() == BookName) {
			if (BookName.getText().equals("����\\ID")) {
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
		Studentsearch = new JLabel("��ѯ�û�");
		Studentsearch.setFont(new Font("����", Font.BOLD, 13));
		Studentsearch.setForeground(Color.orange);
		Studentsearch.addMouseListener(this);

		Studentlist = new JLabel("�û��б�");
		Studentlist.setFont(new Font("����", Font.BOLD, 13));
		Studentlist.setForeground(Color.blue);
		Studentlist.addMouseListener(this);

		booksearch = new JLabel("��ѯͼ��");
		booksearch.setFont(new Font("����", Font.BOLD, 13));
		booksearch.setForeground(Color.magenta);
		booksearch.addMouseListener(this);

		booklist = new JLabel("ͼ���б�");
		booklist.setFont(new Font("����", Font.BOLD, 13));
		booklist.setForeground(Color.yellow);
		booklist.addMouseListener(this);

		JLabel admin = new JLabel("����Ա:" + " admin");
		admin.setFont(new Font("����", Font.BOLD, 13));
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

		JMenuBar bar = new JMenuBar(); // ��ӿյĲ˵���
		this.setJMenuBar(bar);
		JMenu menu = new JMenu("����Ա����");// �˵�����

		addStudent = new JMenuItem("����û�");
		moveStudent = new JMenuItem("ɾ���û�");
		addbook = new JMenuItem("���ͼ��");
		movebook = new JMenuItem("ɾ��ͼ��");
		off = new JMenuItem("ע��");
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
						registerJButton = new JButton("����û�");
						registerJButton.addActionListener(this);
						setLayout(new FlowLayout(1, 20, 30));
						JLabel registerID = new JLabel("�˺�:");
						JLabel registerage = new JLabel("����:");
						registerage1 = new JTextField(15);
						registerID1 = new JTextField(15);
						JLabel registername1 = new JLabel("�ǳ�:");
						registername11 = new JTextField(15);
						JLabel registerPassWord = new JLabel("����:");
						registerPassWord1 = new JPasswordField(15);
						registerPassWord1.setEchoChar('*');
						JLabel registergrade = new JLabel("�༶:");
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
										"     �˺��ظ���", "���ʧ�ܣ�",
										JOptionPane.WARNING_MESSAGE);
							}
							if (a == 0) {
								JOptionPane.showMessageDialog(null,
										"     ��ӳɹ���", "��ӳɹ���",

										JOptionPane.WARNING_MESSAGE);
								this.dispose();
							}

						}

					}
				}
				new register("����û�");
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
						registerJButton = new JButton("ɾ����");
						registerJButton.addActionListener(this);
						registername11 = new JTextField(10);
						setLayout(new FlowLayout(1, 10, 10));
						JLabel registerID = new JLabel("�˺�:");

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
										"     �޴��˺ţ�", "ɾ��ʧ�ܣ�",
										JOptionPane.WARNING_MESSAGE);
							}
							if (a == 1) {
								JOptionPane.showMessageDialog(null,
										"     ɾ���ɹ���", "ɾ����",

										JOptionPane.WARNING_MESSAGE);

							}

						}

					}
				}
				new register("ɾ���û�");

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

						JLabel ID = new JLabel("                       ����:");
						ID1 = new JTextField(13);

						JLabel name2 = new JLabel("                       ���:");
						name3 = new JTextField(13);

						JLabel age = new JLabel("                       ����:");
						age1 = new JTextField(13);

						JLabel ged = new JLabel("                       �汾:");
						ged1 = new JTextField(13);

						messageName = new JTextField(13);

						say = new JButton(" ���");
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
										"     ��ӳɹ���", "�ɹ���",
										JOptionPane.WARNING_MESSAGE);
							}
							if (a == 0) {
								JOptionPane.showMessageDialog(null,
										"     ����ظ���", "���ʧ�ܣ�",
										JOptionPane.WARNING_MESSAGE);
							}
						}

					}

				}
				new booksearch("ͼ���ѯ");

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
						registerJButton = new JButton("ɾ����");
						registerJButton.addActionListener(this);
						registername11 = new JTextField(10);
						setLayout(new FlowLayout(1, 10, 10));
						JLabel registerID = new JLabel("ͼ��/�����:");

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
										"     �޴��飡", "ɾ��ʧ�ܣ�",
										JOptionPane.WARNING_MESSAGE);
							}
							if (a == 1) {
								JOptionPane.showMessageDialog(null,
										"     ɾ���ɹ���", "ɾ����",

										JOptionPane.WARNING_MESSAGE);

							}

						}

					}
				}
				new register("ɾ��ͼ��");
			}

		});
		off.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				off();
				try {
					run.off();
					new Library_SignIn("��¼");
					
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
					JLabel name1 = new JLabel("�û��ǳ�\\�û���:");
					JLabel ID = new JLabel("                            ID:");
					ID1 = new JTextField(10);
					ID1.setEditable(false);
					JLabel name2 = new JLabel("                       �ǳ�:");
					name3 = new JTextField(10);
					name3.setEditable(false);
					JLabel age = new JLabel("                       ����:");
					age1 = new JTextField(10);
					
					JLabel ged = new JLabel("                       �༶:");
					ged1 = new JTextField(10);

					messageName = new JTextField(10);

					say = new JButton(" ��ѯ");
					say.addActionListener(this);
					
					modify = new JButton(" �޸�");
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
							JOptionPane.showMessageDialog(null, "     �޴��û���",
									"����", JOptionPane.WARNING_MESSAGE);

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
							JOptionPane.showMessageDialog(null, "     �޸��û���",
									"�ɹ���", JOptionPane.WARNING_MESSAGE);

						}
						if(b==2){
							JOptionPane.showMessageDialog(null, "     ����Ϊ�ǲ����ܳ��ֵĴ���",
									"�ɹ���", JOptionPane.WARNING_MESSAGE);
						}
						
					}

				}

			}
			new Studentsearch("�û���ѯ/�޸�");
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
					JLabel name1 = new JLabel("����\\���:");
					JLabel ID = new JLabel("                       ����:");
					ID1 = new JTextField(13);

					JLabel name2 = new JLabel("                       ���:");
					name3 = new JTextField(13);

					JLabel age = new JLabel("                       ����:");
					age1 = new JTextField(13);

					JLabel ged = new JLabel("                       �汾:");
					ged1 = new JTextField(13);

					messageName = new JTextField(13);

					say = new JButton(" ��ѯ");
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
							JOptionPane.showMessageDialog(null, "     �޴�ͼ�飡",
									"����", JOptionPane.WARNING_MESSAGE);

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
			new booksearch("ͼ���ѯ");
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
					vName.add("���");
					vName.add("ID");
					vName.add("�ǳ�");
					vName.add("����");
					vName.add("�༶");

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
			new Studentlist("�û��б�");
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
					vName.add("���");
					vName.add("����");
					vName.add("����");
					vName.add("���");
					vName.add("�汾");

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
			new booklist("ͼ���б�");
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

