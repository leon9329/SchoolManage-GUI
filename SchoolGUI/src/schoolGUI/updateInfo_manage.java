package schoolGUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class updateInfo_manage extends JFrame{
	int size = 8;
	
	JFrame jf = new JFrame("수정");
	
	JTextField tf[] = new JTextField[size-1];	//정보 출력 및 수정에 쓰일 텍스트필드,비밀번호는 출력안하기 때문에 size-1
	
	JButton btn[] = new JButton[size - 1];//정보 출력 및 수정에 쓰일 버튼, 비밀번호는 출력x
	JButton finishBtn,cancelBtn;	//완료,취소 버튼
	
	JPanel tfJp[] = new JPanel[size-1];	//위에서 만든 textField들 담을 패널
	JPanel btnJp[] = new JPanel[size-1];	//위에서 만든 버튼들을 담을 패널
	
	JPanel mainPn,btnPn;	//JFrame 안에 넣어 둘 메인 패널,완료,취소버튼 담을 패널	
	
	
	public updateInfo_manage() {
		// TODO Auto-generated constructor stub
		
		mainPn = new JPanel(new GridLayout(7, 2));
		btnPn = new JPanel();
		
		
		finishBtn = new JButton("완료");
		cancelBtn = new JButton("취소");

		btnPn.add(finishBtn);
		btnPn.add(cancelBtn);
		
		for(int i=0; i<size-1; i++) {
			tfJp[i] = new JPanel();
			btnJp[i] = new JPanel();
			btn[i] = new JButton();
			
		}
		
		jf.add(btnPn, "South");
		jf.add(mainPn,"Center");
		jf.setResizable(false);
		jf.setBounds(700, 300, 300, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		updateInfo_manage uim = new updateInfo_manage();
	}

}
