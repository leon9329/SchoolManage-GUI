package schoolManage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SchoolManage {
	JFrame j = new JFrame("�ʱ� ȭ��");
	JButton btn1 = new JButton("������ ���");
	JButton btn2 = new JButton("�л� ���");
	JButton btn3 = new JButton("���� ���");
	JButton btn4 = new JButton("����");
	
	SchoolManage(){
		
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		j.setLayout(new GridLayout(4,1));
		
		j.add(btn1);
		j.add(btn2);
		j.add(btn3);
		j.add(btn4);
		
		j.setLocation(800,400);
		j.setSize(200,200);
		j.setVisible(true);
		j.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SchoolManage jf = new SchoolManage();
	}

}
