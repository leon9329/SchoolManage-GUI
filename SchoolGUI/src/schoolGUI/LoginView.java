package schoolGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame{
	
	JPanel pn1;
	JPanel pn2;
	JPanel pn3;
	JPanel pn4;
	JPanel pn5;
	
	
	JLabel mainLabel;
	JLabel idLaBel;
	JLabel pwLabel;
	
	JTextField idField;
	JTextField pwfield;
	
	JButton studentBtn;
	JButton professorBtn;
	
	
	LoginView(){
		super("LoginView");
		
		mainLabel = new JLabel("학사 관리 시스템",JLabel.CENTER);
		idLaBel = new JLabel("ID",JLabel.CENTER);
		pwLabel = new JLabel("PW",JLabel.CENTER);
		
		idField = new JTextField(10);
		pwfield = new JPasswordField();
		
		studentBtn = new JButton("학생");
		professorBtn = new JButton("교수");
		
		pn1 = new JPanel(new GridLayout(2, 1));
		pn2 = new JPanel(new GridLayout(2, 1));
		pn3 = new JPanel();
		pn4 = new JPanel();
		pn5 = new JPanel(new BorderLayout());

		
		pn1.add(idLaBel);
		pn1.add(pwLabel);
		
		pn2.add(idField);
		pn2.add(pwfield);
		
		pn3.add(pn1);
		pn3.add(pn2);
		
		pn4.add(studentBtn);
		pn4.add(professorBtn);
		
		pn5.add(pn3);
		pn5.add(pn4,"South");
		
		add(mainLabel);
		add(pn5,"South");
		
		setBounds(300, 300, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginView lg = new LoginView();
	}

}
