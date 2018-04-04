package schoolManage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SchoolManage extends JFrame implements ActionListener {

	JButton btn1 = new JButton("관리자 모드");
	JButton btn2 = new JButton("학생 모드");
	JButton btn3 = new JButton("교수 모드");
	JButton btn4 = new JButton("종료");
	Container contentPane = getContentPane();
	JPanel jp = new JPanel();

	SchoolManage() {

		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		// this.setLayout(new GridLayout(4, 1));
		contentPane.setLayout(new GridLayout(4, 1));
		contentPane.add(btn1);
		contentPane.add(btn2);
		contentPane.add(btn3);
		contentPane.add(btn4);
		// contentPane.add(jp,BorderLayout.SOUTH);

		setLocation(700, 300);
		setSize(300, 300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn1) {

			ManageMode manageMode = new ManageMode(this);
			setVisible(false);

		} else if (e.getSource() == btn2) {

		} else if (e.getSource() == btn3) {

		} else {

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SchoolManage sm = new SchoolManage();
	}

}
