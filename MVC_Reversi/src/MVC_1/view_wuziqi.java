package MVC_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 祝添添 E-mail:loveforyou@live.cn
 * @version 创建时间：Dec 19, 2016 2:46:00 PM
 * 类说明
 */

			
public class view_wuziqi extends JFrame implements MouseListener, ActionListener {
	DataBase base =new DataBase();
	player name1=new player("小明");
	player name2=new player("小黑");
	around_win win=new around_win();
	
	boolean a=true;
	
		JPanel anniu = new JPanel();
	JPanel say=new JPanel();
	JButton kaishi = new JButton("开始");
	JButton huiqi = new JButton("悔棋");
	JButton renshu = new JButton("认输");
	JButton chongxinkaishi = new JButton("重新开始");
	
	
	view_wuziqi(String name){
		super(name);
		anniu.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 0));
		anniu.add(kaishi);
		anniu.add(huiqi);
		anniu.add(renshu);
		anniu.add(chongxinkaishi);
		
		
		add(say, BorderLayout.CENTER   );
		add(anniu, BorderLayout.NORTH);
		addMouseListener(this);
		chongxinkaishi.addActionListener(this);
		kaishi.addActionListener(this);
		huiqi.addActionListener(this);
		renshu.addActionListener(this);
		
		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setResizable(false);
		setVisible(true);
	}
	public void paint(Graphics g) {
		super.paint(g);// 调用父类
		g.drawRect(100, 100, 550, 550);// 正方形
		for (int i = 100; i <= 650; i = i + 50) {
			g.drawLine(100, i, 650, i);
			g.drawLine(i, 100, i, 650);
		}

		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				if (base.setPiece()[i][j] == 1) {// 1代表白棋
					int x = (i * 50) + 100 - 20;
					int y = (j * 50) + 100 - 20;
					g.setColor(Color.black);
					g.drawOval(x, y, 40, 40);
					g.setColor(Color.white);
					g.fillOval(x, y, 40, 40);
				}
				if (base.setPiece()[i][j] == 2) {// 2代表黑棋
					int x = (i * 50) + 100 - 20;
					int y = (j * 50) + 100 - 20;
					g.setColor(Color.black);
					g.fillOval(x, y, 40, 40);
				}
			}
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
				
				public int LocationX(int x) {// 调整X的坐标
					return x = ((x + 25) - 100) / 50;
				}

				public int LocationY(int y) {// 调整Y的坐标
					return y = ((y + 25) - 100) / 50;
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					if(a){
						int x = e.getX();
						int y = e.getY();
						x=LocationX(x);
						y=LocationX(y);
						if ((e.getX() <= 650 && e.getX() >= 100) && (e.getY() <= 650 && e.getY() >= 100)) {// 鼠标单击要在方框内
							if (base.setPiece()[x][y] == 0) {
								
									base.getPiece_one(x, y, 1);
									name1.SetRecord(x, y);		
									base.getPiece(win.add(base.setPiece()));
									System.out.println(name1.record);
									a=!a;
									this.repaint();
								}
							}
					}
					if(!a){
						int x = e.getX();
						int y = e.getY();
						x=LocationX(x);
						y=LocationX(y);
						if ((e.getX() <= 650 && e.getX() >= 100) && (e.getY() <= 650 && e.getY() >= 100)) {// 鼠标单击要在方框内
							if (base.setPiece()[x][y] == 0) {
								
									base.getPiece_one(x, y, 2);
									name2.SetRecord(x, y);
									base.getPiece(win.add(base.setPiece()));
									System.out.println(name2.record);
									a=!a;
									this.repaint();
								}
							}
					}
					
				}
					
					
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
}
