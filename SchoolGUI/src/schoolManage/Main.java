package schoolManage;
//�� ũ�� �����Ұ�
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	JFrame j = new JFrame("�ʱ� ȭ��");	//������
	
	JLabel jl = new JLabel("�л���� �ý���");
	
	JPanel jp = new JPanel();//��ư ���� �г�
	JPanel jp1 = new JPanel();//����(�л�����ý���) �� ���� �г�
	
	JButton btn1 = new JButton("������ ���");//��ư1
	JButton btn2 = new JButton("�л� ���");//��ư2
	JButton btn3 = new JButton("���� ���");//��ư3
	JButton btn4 = new JButton("����");//��ư4
	
	//20180403
	Main(){
		
		btn4.addActionListener(new ActionListener() {
			//�����ư �̺�Ʈ ó��
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		jp.add(btn1);//�гο� ��ư�߰�
		jp.add(btn2);
		jp.add(btn3);
		jp.add(btn4);
		
		jp1.add(jl,"Center");
		
		
		j.add(jp1,"North");//�����ӿ� ���� ���� �г� �߰�
		j.add(jp,"South");	//�����ӿ� ��ư�� ���� �г� �߰�
		
		j.setResizable(false);
		j.setLocation(700,350);
		j.setSize(500,500);
		j.setVisible(true);
		j.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main jf = new Main();
	}

}
