package schoolGUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class updateInfo_manage extends JFrame{
	int size = 8;
	
	JFrame jf = new JFrame("����");
	
	JTextField tf[] = new JTextField[size-1];	//���� ��� �� ������ ���� �ؽ�Ʈ�ʵ�,��й�ȣ�� ��¾��ϱ� ������ size-1
	
	JButton btn[] = new JButton[size - 1];//���� ��� �� ������ ���� ��ư, ��й�ȣ�� ���x
	JButton finishBtn,cancelBtn;	//�Ϸ�,��� ��ư
	
	JPanel tfJp[] = new JPanel[size-1];	//������ ���� textField�� ���� �г�
	JPanel btnJp[] = new JPanel[size-1];	//������ ���� ��ư���� ���� �г�
	
	JPanel mainPn,btnPn;	//JFrame �ȿ� �־� �� ���� �г�,�Ϸ�,��ҹ�ư ���� �г�	
	
	
	public updateInfo_manage() {
		// TODO Auto-generated constructor stub
		
		mainPn = new JPanel(new GridLayout(7, 2));
		btnPn = new JPanel();
		
		
		finishBtn = new JButton("�Ϸ�");
		cancelBtn = new JButton("���");

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
