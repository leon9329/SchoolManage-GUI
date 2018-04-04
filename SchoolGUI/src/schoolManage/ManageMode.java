package schoolManage;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManageMode extends JFrame implements ActionListener {
	private SchoolManage f;

	JTextField id = new JTextField(8);
	JTextField password = new JTextField(8);
	Container managerCP = getContentPane();
	JLabel idLabel = new JLabel("        id");
	JLabel passwordLabel = new JLabel("password");
	JPanel jp = new JPanel(new GridLayout(2, 1));
	JPanel jp1 = new JPanel(new GridLayout(2, 1));
	JButton loginBtn = new JButton("로그인");

	public ManageMode(SchoolManage f) {
		// TODO Auto-generated constructor stub
		super("관리자 모드");
		this.f = f;

		jp.add(id);
		jp.add(password);

		jp1.add(idLabel);
		jp1.add(passwordLabel);

		managerCP.add(jp, "Center");
		managerCP.add(jp1, "West");
		managerCP.add(loginBtn, "East");

		setLocation(700, 400);
		setSize(300, 150);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		loginBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(id.getText().equals(SchoolMain.HOST_ID) 
				&& password.getText().equals(SchoolMain.HOST_PASSWROD)) {
			
			JOptionPane.showMessageDialog(this, "로그인 성공");
			ManagerView mv = new ManagerView();
			setVisible(false);
		}else {
			JOptionPane.showMessageDialog(this, "로그인 실패");
			id.setText("");
			password.setText("");
		}
		

	}
}
