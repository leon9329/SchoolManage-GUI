package schoolGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LoginView extends JFrame implements ActionListener {
	String id;
	String pw;
	String sql;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	Connection con = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;

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

	ButtonGroup bg;
	JRadioButton studentCheck;
	JRadioButton professorCheck;
	JRadioButton managerCheck;

	JButton loginBtn;

	Font font;

	LoginView() {

		super("LoginView");

		font = new Font("����", Font.BOLD, 20);

		mainLabel = new JLabel("�л� ���� �ý���", JLabel.CENTER);
		mainLabel.setFont(font);
		pwLabel = new JLabel("PW", JLabel.CENTER);

		idField = new JTextField(10);
		pwfield = new JPasswordField();
		idLaBel = new JLabel("ID", JLabel.CENTER);

		bg = new ButtonGroup();
		studentCheck = new JRadioButton("�л�", true);
		professorCheck = new JRadioButton("����");
		managerCheck = new JRadioButton("������");

		bg.add(studentCheck);
		bg.add(professorCheck);
		bg.add(managerCheck);

		loginBtn = new JButton("�α���");

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
		pn3.add(loginBtn);

		pn4.add(studentCheck);
		pn4.add(professorCheck);
		pn4.add(managerCheck);

		pn5.add(pn3);
		pn5.add(pn4, "South");

		add(mainLabel);
		add(pn5, "South");

		setBounds(700, 400, 400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == loginBtn) {

			if (idField.getText().equals("") || pwfield.equals("")) {
				JOptionPane.showMessageDialog(this, "Input ID/PW");
			} else if (studentCheck.isSelected()) {
				id = idField.getText();
				pw = pwfield.getText();
				connectDB();
				if (passwordCompare(0)) {
					JOptionPane.showMessageDialog(this, "�л� �α��� ����");
				} else {
					JOptionPane.showMessageDialog(this, "�α��� ����");
				}
				;
				// JOptionPane.showMessageDialog(this, "�л� �α���");

			} else if (professorCheck.isSelected()) {
				id = idField.getText();
				pw = pwfield.getText();
				connectDB();
				if (passwordCompare(1)) {
					JOptionPane.showMessageDialog(this, "���� �α��� ����");
				} else {
					JOptionPane.showMessageDialog(this, "�α��� ����");
				}
				;

			} else if (managerCheck.isSelected()) {
				id = idField.getText();
				pw = pwfield.getText();
				connectDB();
				if (passwordCompare(2)) {
					JOptionPane.showMessageDialog(this, "������ �α��� ����");
				} else {
					JOptionPane.showMessageDialog(this, "�α��� ����");
				}
				;

			}
		}

	}

	void connectDB() {
		try {
			Class.forName(driver);
			// System.out.println("����̹� �ε� ����");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("����̹� �ε� ����");
		}

		try {
			con = DriverManager.getConnection(url, "scott", "tiger");
			// System.out.println("Ŀ�ؼ� ���� ����");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ŀ�ؼ� ���� ����");
		}

	}

	public boolean passwordCompare(int a) {
		boolean test = false;
		switch (a) {
		case 0:
			sql = "select password from student where id = ?";
			break;
		case 1:
			sql = "select password from professor where id = ?";
			break;
		case 2:
			sql = "select password from manager where id = ?";
			break;
		default:
			break;
		}

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("password").equals(pw))
					test = true;
				else
					test = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return test;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginView lg = new LoginView();
	}

}
