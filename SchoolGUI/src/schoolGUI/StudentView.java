package schoolGUI;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentView extends JFrame{
	Font font;
	
	JLabel mainLabel,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8;

	JButton nameBtn1,phoneBtn2,addressBtn3,emailBtn4;
	
	JPanel mainPanel,panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8;
	
	
	public StudentView() {
		super("학생 정보");
		
		mainPanel = new JPanel();
		
		mainPanel.setLayout(new GridLayout(8, 1));
		panel1 = new JPanel();
		
		font = new Font("돋움", Font.BOLD, 20);
		
		mainLabel = new JLabel("프로필");
		mainLabel.setFont(font);
		panel1.add(mainLabel);
	
//		mainPanel.add(mainLabel,"North");
		
		add(panel1,"North");
		add(mainPanel);
		setBounds(600, 200, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentView lg = new StudentView();
	}

}
