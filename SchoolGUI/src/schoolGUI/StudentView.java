package schoolGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentView extends JFrame implements ActionListener{
	Font font;
	
	JLabel mainLabel,lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8;
	

	
	
	JButton updateBtn,completeBtn;
	
	JPanel mainPanel,panel0,panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,updatePN;
	
	JTextField tf1 = new JTextField(10);
	
	JTextField tf2 = new JTextField(10);
	
	JTextField tf3 = new JTextField(10);
	
	JTextField tf4 = new JTextField(10);
	
	JTextField tf5 = new JTextField(10);
	
	JTextField tf6 = new JTextField(10);
	
	JTextField tf7 = new JTextField(10);
	
	JTextField tf8 = new JTextField(10);
	
	
	
	
	public StudentView() {
		super("�л� ����");
		
		font = new Font("����", Font.BOLD, 20);

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
		
		
		mainLabel = new JLabel("������");
		mainLabel.setFont(font);
		
		lb1 = new JLabel("id");
		lb2 = new JLabel("�й�");
		lb3 = new JLabel("�̸�");
		lb4 = new JLabel("��ȭ��ȣ");
		lb5 = new JLabel("�ּ�");
		lb6 = new JLabel("Email");
		lb7 = new JLabel("����");
		lb8 = new JLabel("��й�ȣ");
		
		
		updateBtn = new JButton("����");
		completeBtn = new JButton("�Ϸ�");
		
		updatePN.add(updateBtn);
		updatePN.add(completeBtn);
		
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
		tf5.setEditable(false);
		tf6.setEditable(false);
		tf7.setEditable(false);
		tf8.setEditable(false);

		
		
		panel0.add(mainLabel);
		
		panel1.add(lb1);//id label
		panel1.add(tf1);//textField
		
		panel2.add(lb2);//�й�
		panel2.add(tf2);
		
		panel3.add(lb3);//�̸�
		panel3.add(tf3);
		
		panel4.add(lb4);//��ȭ��ȣ
		panel4.add(tf4);
		
		panel5.add(lb5);//�ּ�
		panel5.add(tf5);
		
		panel6.add(lb6);//�̸���
		panel6.add(tf6);
		
		panel7.add(lb7);//����
		panel7.add(tf7);
		
		panel8.add(lb8);//��й�ȣ
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
		
		updateBtn.addActionListener(this);
		completeBtn.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(updateBtn)) {
			tf3.setEditable(true);
			tf4.setEditable(true);
			tf5.setEditable(true);
			tf6.setEditable(true);
			
		}else if(e.getSource().equals(completeBtn)) {
			
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentView lg = new StudentView();
	}

}
