package schoolGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentView extends JFrame{
	Font font;
	
	JLabel mainLabel,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8;
	

	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	
	JButton updateBtn,completeBtn;
	
	JPanel mainPanel,panel0,panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,updatePN;
	
	
	public StudentView() {
		super("학생 정보");
		
		font = new Font("돋움", Font.BOLD, 20);

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(4, 2));

		panel0 = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		updatePN = new JPanel();
		
		
		mainLabel = new JLabel("프로필");
		mainLabel.setFont(font);
		
		lb1 = new JLabel("id");
		lb2 = new JLabel("학번");
		lb3 = new JLabel("이름");
		lb4 = new JLabel("전화번호");
		lb8 = new JLabel("주소");
		lb5 = new JLabel("Email");
		lb6 = new JLabel("전공");
		lb7 = new JLabel("비밀번호");
		
		tf1 = new JTextField(10);
		tf1.setEditable(false);
		
		tf2 = new JTextField(10);
		tf2.setEditable(false);
		
		tf3 = new JTextField(10);
		tf3.setEditable(false);
		
		tf4 = new JTextField(10);
		tf4.setEditable(false);
		
		tf5 = new JTextField(10);
		tf5.setEditable(false);
		
		tf6 = new JTextField(10);
		tf6.setEditable(false);
		
		tf7 = new JTextField(10);
		tf7.setEditable(false);
		
		tf8 = new JTextField(10);
		tf8.setEditable(false);
		
		updateBtn = new JButton("수정");
		completeBtn = new JButton("완료");
		
		updatePN.add(updateBtn);
		updatePN.add(completeBtn);
		
		
		panel0.add(mainLabel);
		
		panel1.add(lb1);//id label
		panel1.add(tf1);//textField
		
		panel2.add(lb2);//학번
		panel2.add(tf2);
		
		panel3.add(lb3);//이름
		panel3.add(tf3);
		
		panel4.add(lb4);//전화번호
		panel4.add(tf4);
		
		panel5.add(lb5);//주소
		panel5.add(tf5);
		
		panel6.add(lb6);//이메일
		panel6.add(tf6);
		
		panel7.add(lb7);//전공
		panel7.add(tf7);
		
		panel8.add(lb8);//비밀번호
		panel8.add(tf8);
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		mainPanel.add(panel8);
		
		add(panel0,"North");
		add(mainPanel);
		add(updatePN,"South");
		setBounds(600, 200, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentView lg = new StudentView();
	}

}
