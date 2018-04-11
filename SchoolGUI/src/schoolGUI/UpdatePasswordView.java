package schoolGUI;

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
import javax.swing.JPasswordField;

public class UpdatePasswordView extends JFrame implements ActionListener {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	String newPw = null;
	String originPw = null;
	String sql = null;

	JLabel lb1, lb2, lb3;
	JPasswordField tf1, tf2, tf3;
	JPanel mainPanel, pn1, pn2, pn3, pn4;
	JButton btn;

	public UpdatePasswordView(String pw) {
		// TODO Auto-generated constructor stub
		super("비밀번호 변경");

		originPw = pw;

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));

		lb1 = new JLabel("origin PW", JLabel.CENTER);
		lb1.setAlignmentY(CENTER_ALIGNMENT);
		lb2 = new JLabel("new PW", JLabel.CENTER);
		lb3 = new JLabel("new PW(confirm)", JLabel.CENTER);

		tf1 = new JPasswordField(10);
		tf2 = new JPasswordField(10);
		tf3 = new JPasswordField(10);

		pn1 = new JPanel(new GridLayout(3, 1));
		pn1.add(lb1);
		pn1.add(lb2);
		pn1.add(lb3);

		pn2 = new JPanel(new GridLayout(3, 1));
		pn2.add(tf1);
		pn2.add(tf2);
		pn2.add(tf3);

		pn4 = new JPanel();

		btn = new JButton("변경");

		pn4.add(btn);

		mainPanel.add(pn1);
		mainPanel.add(pn2);

		add(mainPanel);
		add(pn4, "South");

		setBounds(700, 300, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		btn.addActionListener(this);

	}

	public boolean connectDB() {
		boolean test = false;

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "driver loading failed");
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, "scott", "tiger");
			test = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "connection faied");
			e.printStackTrace();
		}

		return test;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (connectDB()) {
			if (passwordCompare()) {
				updatePassword();
			} else {
				JOptionPane.showMessageDialog(this, "변경 실패");
			}
		} else {
			JOptionPane.showMessageDialog(this, "DB 연결 실패");
		}

	}

	public boolean passwordCompare() {
		boolean test = false;
//		try {
//			if (rs.next()) {
//				originPw = rs.getString("password");// 기존 비밀번호
//				System.out.println("기존 비번 받아오기 성공");
//			} else
//				System.out.println("기존 비번 받아오기 실패");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog(this, "기존 비밀번호 얻어오기 실패");
//			e.printStackTrace();
//		}
		if(originPw.equals(tf1.getText())) {
			if(tf2.getText().equals(tf3.getText()))
				test = true;
			else
				JOptionPane.showMessageDialog(this, "새 비밀번호 확인");
		}else {
			JOptionPane.showMessageDialog(this, "기존 pw를 확인하세요");
		}

//		if (originPw.equals(tf1.getText())) {// 기존 비밀번호가 일치하면
//			test = true;
//		} else {
//			JOptionPane.showMessageDialog(this, "기존 pw를 확인하세요");
//		}
		return test;
	}

	public void updatePassword() {
		
		sql = "update student set password = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tf2.getText());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(this, "success");
			} else {
				JOptionPane.showMessageDialog(this, "failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("pstmt = con.prepareSta 에러");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// UpdatePasswordView pw = new UpdatePasswordView();
	}

}
