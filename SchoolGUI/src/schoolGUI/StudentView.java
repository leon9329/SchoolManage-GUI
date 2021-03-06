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

public class StudentView extends JFrame implements ActionListener {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	String sql;
	String pw;
	String id;
	String position = "student";
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

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

	public StudentView(String id) {
		super("학생 정보");
		JOptionPane.showMessageDialog(this, "학생 로그인 성공");

		this.id = id;

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

		lb1 = new JLabel("id", JLabel.CENTER);
		lb2 = new JLabel("학번", JLabel.CENTER);
		lb3 = new JLabel("이름", JLabel.CENTER);
		lb4 = new JLabel("전화번호", JLabel.CENTER);
		lb5 = new JLabel("주소", JLabel.CENTER);
		lb6 = new JLabel("Email", JLabel.CENTER);
		lb7 = new JLabel("전공", JLabel.CENTER);
		lb8 = new JLabel("비밀번호", JLabel.CENTER);

		updateBtn = new JButton("수정");
		completeBtn = new JButton("완료");
		pwdUpdateBtn = new JButton("변경");

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

		panel2.add(lb2);// 학번
		panel2.add(tf2);

		panel3.add(lb3);// 이름
		panel3.add(tf3);

		panel4.add(lb4);// 전화번호
		panel4.add(tf4);

		panel5.add(lb5);// 주소
		panel5.add(tf5);

		panel6.add(lb6);// 이메일
		panel6.add(tf6);

		panel7.add(lb7);// 전공
		panel7.add(tf7);

		panel8.add(lb8);// 비밀번호
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

		setResizable(false);
		updateBtn.addActionListener(this);
		completeBtn.addActionListener(this);
		pwdUpdateBtn.addActionListener(this);

		showInfo();

	}

	public void showInfo() {
		connectDB();

		sql = "select * from Student where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tf1.setText(rs.getString(1));
				tf2.setText(rs.getString(2));
				tf3.setText(rs.getString(3));
				tf4.setText(rs.getString(4));
				tf5.setText(rs.getString(5));
				tf6.setText(rs.getString(6));
				tf7.setText(rs.getString(7));
				 tf8.setText("**********");
//				pw = rs.getString(8);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("쿼리문 보내기 실패");
		}
	}

	void UpdateInfo() {
		try {
			sql = "update student set name=?,phone=?,address=?,email=? where id=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, tf3.getText());
			pstmt.setString(2, tf4.getText());
			pstmt.setString(3, tf5.getText());
			pstmt.setString(4, tf6.getText());
			pstmt.setString(5, id);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(this, "Update success");
			} else {
				JOptionPane.showMessageDialog(this, "Update failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.toString();
			System.out.println("failed Update");
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					System.out.println("pstmt closed");
				}
				if (con != null) {
					con.close();
					System.out.println("con closed");
				}
			} catch (Exception e) {
				e.toString();
			}
			showInfo();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(updateBtn)) {
			tf3.setEditable(true);
			tf4.setEditable(true);
			tf5.setEditable(true);
			tf6.setEditable(true);

		} else if (e.getSource().equals(completeBtn)) {
			if (tf3.isEditable()) {
				UpdateInfo();
			}
			tf3.setEditable(false);
			tf4.setEditable(false);
			tf5.setEditable(false);
			tf6.setEditable(false);

		} else if (e.getSource().equals(pwdUpdateBtn)) {
			UpdatePasswordView upw = new UpdatePasswordView(id,position);
		}
	}

	public void connectDB() {
		try {
			Class.forName(driver);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("driver loading faied");
		}

		try {
			con = DriverManager.getConnection(url, "scott", "tiger");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("connection failed");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// StudentView lg = new StudentView();
	}

}
