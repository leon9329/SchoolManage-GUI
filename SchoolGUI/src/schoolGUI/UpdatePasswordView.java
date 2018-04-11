package schoolGUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UpdatePasswordView extends JFrame{
	JLabel lb1,lb2,lb3;
	JPasswordField tf1,tf2,tf3;
	JPanel mainPanel,pn1,pn2,pn3,pn4;
	JButton btn;
	
	public UpdatePasswordView() {
		// TODO Auto-generated constructor stub
		super("비밀번호 변경");
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(4, 1));
		
		lb1 = new JLabel("origin PW");
		lb2 = new JLabel("new PW");
		lb3 = new JLabel("new PW(confirm) ");
		

		tf1 = new JPasswordField(10);
		tf2 = new JPasswordField(10);
		tf3 = new JPasswordField(10);

		
		pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		pn4 = new JPanel();
		
		btn = new JButton("확인");
	
		pn1.add(lb1);
		pn1.add(tf1);
		
		pn2.add(lb2);
		pn2.add(tf2);
		
		pn3.add(lb3);
		pn3.add(tf3);
		
		pn4.add(btn);
		
		mainPanel.add(pn1);
		mainPanel.add(pn2);
		mainPanel.add(pn3);
		mainPanel.add(pn4);
		
		add(mainPanel);
		setBounds(700,300,300,200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdatePasswordView pw = new UpdatePasswordView();
	}

}
