package schoolGUI;

import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JPanel lbJp[] = new JPanel[size-1];//�� ���� �г�
	
	JPanel mainPn,subBtnPn;	//JFrame �ȿ� �־� �� ���� �г�,�Ϸ�,��ҹ�ư ���� �г�	
	
	JLabel lb[] = new JLabel[size-1];//�Ʒ��� �÷� ���� ��
	
	String stuColumn[] = {"id","�й�","�̸�","��ȭ��ȣ","�ּ�","email","����"};
	String proColumn[] = {"id","�̸�","email","����","�ּ�","��ȭ��ȣ","�޿�"};
	
	
	
	
	public updateInfo_manage() {
		// TODO Auto-generated constructor stub
		
		mainPn = new JPanel(new GridLayout(7, 3));
		subBtnPn = new JPanel();
		
		
		finishBtn = new JButton("�Ϸ�");
		cancelBtn = new JButton("���");

		subBtnPn.add(finishBtn);
		subBtnPn.add(cancelBtn);
		
		for(int i=0; i<size-1; i++) {
			tfJp[i] = new JPanel();
			btnJp[i] = new JPanel();
			lbJp[i] = new JPanel();
		
			btn[i] = new JButton("����");		
		
			tf[i] = new JTextField(10);
			
			lb[i] = new JLabel(stuColumn[i],JLabel.CENTER);
		
			tfJp[i].add(tf[i]);
			btnJp[i].add(btn[i]);
			lbJp[i].add(lb[i]);
			
			mainPn.add(lbJp[i]);
			mainPn.add(tfJp[i]);
			mainPn.add(btnJp[i]);
		}
		
		
		
		jf.add(subBtnPn, "South");
		jf.add(mainPn,"Center");
		jf.setResizable(false);
		jf.setBounds(700, 300, 400, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		updateInfo_manage uim = new updateInfo_manage();
	}

}
