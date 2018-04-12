package schoolGUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfessorView extends JFrame implements ActionListener {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	String sql;
	ResultSet rs;
	Connection con;
	PreparedStatement pstmt;
	
	String position = "professor";
	
	String id;

	Font font;

	JLabel mainLabel, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8;

	JButton updateBtn, completeBtn, pwdUpdateBtn;

	JPanel mainPanel, panel0, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, updatePN;

	JTextField tf1 = new JTextField(10);

	JTextField tf2 = new JTextField(10);

	JTextField tf3 = new JTextField(10);

	JTextField tf4 = new JTextField(10);

	JTextField tf5 = new JTextField(10);

	JTextField tf6 = new JTextField(10);

	JTextField tf7 = new JTextField(10);

	JTextField tf8 = new JTextField(10);

	ProfessorView(String id) {
		super("���� ����");
		
		JOptionPane.showMessageDialog(this, "���� �α��� ����");

		
		this.id = id;
		
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

		mainLabel = new JLabel("������", JLabel.CENTER);
		mainLabel.setFont(font);

		lb1 = new JLabel("id", JLabel.CENTER);
		lb2 = new JLabel("�̸�", JLabel.CENTER);
		lb3 = new JLabel("email", JLabel.CENTER);
		lb4 = new JLabel("����", JLabel.CENTER);
		lb5 = new JLabel("�ּ�", JLabel.CENTER);
		lb6 = new JLabel("��ȭ", JLabel.CENTER);
		lb7 = new JLabel("�޿�", JLabel.CENTER);
		lb8 = new JLabel("��й�ȣ", JLabel.CENTER);

		updateBtn = new JButton("����");
		completeBtn = new JButton("�Ϸ�");
		pwdUpdateBtn = new JButton("����");

		updatePN.add(updateBtn);
		updatePN.add(completeBtn);

		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
		tf5.setEditable(false);
		tf6.setEditable(false);
		tf7.setEditable(false);
		// tf8.setEditable(false);

		panel0.add(mainLabel);

		panel1.add(lb1);// id label
		panel1.add(tf1);// textField

		panel2.add(lb2);// �̸�
		panel2.add(tf2);

		panel3.add(lb3);// email
		panel3.add(tf3);

		panel4.add(lb4);// ����
		panel4.add(tf4);

		panel5.add(lb5);// �ּ�
		panel5.add(tf5);

		panel6.add(lb6);// ��ȭ
		panel6.add(tf6);

		panel7.add(lb7);// �޿�
		panel7.add(tf7);

		panel8.add(lb8);// ��й�ȣ
		panel8.add(pwdUpdateBtn);

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		mainPanel.add(panel7);
		mainPanel.add(panel8);

		add(panel0, "North");
		add(mainPanel);
		add(updatePN, "South");
		setBounds(600, 200, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		updateBtn.addActionListener(this);
		completeBtn.addActionListener(this);
		pwdUpdateBtn.addActionListener(this);
		
		showInfo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(updateBtn)) {
			tf2.setEditable(true);
			tf3.setEditable(true);
			tf6.setEditable(true);
			tf5.setEditable(true);

		} else if (e.getSource().equals(completeBtn)) {
			updateData();
			tf2.setEditable(false);
			tf3.setEditable(false);
			tf6.setEditable(false);
			tf5.setEditable(false);
		} else if (e.getSource().equals(pwdUpdateBtn)) {
			UpdatePasswordView upw = new UpdatePasswordView(id, position);
		}
	}

	public void showInfo() {
		connectDB();
//		System.out.println("db ���� �Ϸ�");
		try {
			sql = "select * from professor where id=?"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tf1.setText(id);
				tf2.setText(rs.getString(2));
				tf3.setText(rs.getString(3));
				tf4.setText(rs.getString(4));
				tf5.setText(rs.getString(5));
				tf6.setText(rs.getString(6));
				tf7.setText(rs.getString(7));
			}
		} catch (Exception e) {
			System.out.println("������ ������ ����");
			e.toString();
		}

	}

	public void connectDB() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "driver loading failed");
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, "scott", "tiger");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "connection failed");
		}
	}

	public void updateData() {
		sql = "update professor set name=?,email=?,phone=?,address=? where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tf2.getText());
			pstmt.setString(2, tf3.getText());
			pstmt.setString(3, tf6.getText());
			pstmt.setString(4, tf7.getText());
			pstmt.setString(5, id);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(this, "Update success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Update failed");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();

				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ProfessorView professor = new ProfessorView();
	}

}
