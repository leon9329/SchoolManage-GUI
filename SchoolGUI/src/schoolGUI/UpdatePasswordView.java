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

	String id;
	String sql = null;
	String position;

	JLabel lb1, lb2, lb3;
	JPasswordField tf1, tf2, tf3;
	JPanel mainPanel, pn1, pn2, pn3, pn4;
	JButton btn;

	public UpdatePasswordView(String id,String position) {
		// TODO Auto-generated constructor stub
		super("비밀번호 변경");

		this.position = position;
		this.id = id;
//		originPw = pw;

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

		
		setResizable(false);
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
		this.setVisible(false);

	}

	public boolean passwordCompare() {
		boolean test = false;
		if(position.equals("student"))
			sql = "select password from student where id=?";
		else
			sql = "select password from professor where id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password").equals(tf1.getText())) {
					if(tf2.getText().equals(tf3.getText())) {
						test = true;
					}else {
						System.out.println("새 비밀번호 불일치");
					}
				}else {
					System.out.println("기존 비번 확인 실패");
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return test;
	}

	public void updatePassword() {
		if(position.equals("student"))
			sql = "update student set password = ? where id=?";
		else
			sql = "update professor set password = ? where id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tf2.getText());
			pstmt.setString(2, id);

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
