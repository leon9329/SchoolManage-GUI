package schoolManage;
//라벨 크기 조정할것
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	JFrame j = new JFrame("초기 화면");	//프레임
	
	JLabel jl = new JLabel("학사관리 시스템");
	
	JPanel jp = new JPanel();//버튼 담을 패널
	JPanel jp1 = new JPanel();//제목(학사관리시스템) 라벨 담을 패널
	
	JButton btn1 = new JButton("관리자 모드");//버튼1
	JButton btn2 = new JButton("학생 모드");//버튼2
	JButton btn3 = new JButton("교수 모드");//버튼3
	JButton btn4 = new JButton("종료");//버튼4
	
	//20180403
	Main(){
		
		btn4.addActionListener(new ActionListener() {
			//종료버튼 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		jp.add(btn1);//패널에 버튼추가
		jp.add(btn2);
		jp.add(btn3);
		jp.add(btn4);
		
		jp1.add(jl,"Center");
		
		
		j.add(jp1,"North");//프레임에 라벨을 담은 패널 추가
		j.add(jp,"South");	//프레임에 버튼을 담은 패널 추가
		
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
