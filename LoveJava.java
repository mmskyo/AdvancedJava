import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// JLabel 컴포넌트에 마우스를 올리면 "Love Java", 마우스를 내리면 "사랑해"가 출력됨
// 처음 실행때는 "START!!" 출력
public class LoveJava extends JFrame {
	
	private JLabel la = new JLabel("START!!");
	
	// 생성자함수
	public LoveJava() {
		// 제목과 종료 설정
		setTitle("과제1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컨테이너 배치관리자 설정
		Container c = getContentPane();
		c.setLayout(null);
		
		// 레이블 이벤트리스너 지정, 크기와 위치, 컨텐트팬에 추가하기
		la.addMouseListener(new MyMouseListener());
		la.setSize(100, 100);
		la.setLocation(100, 30);
		c.add(la);
		
		setSize(300, 300);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	// 마우스 리스너 클래스
	class MyMouseListener extends MouseAdapter {
		
		public void mouseEntered(MouseEvent e) {
			// 없애고 setText만
			JLabel textLa = (JLabel)e.getSource();
			// 더 확실하게 코딩하려면 if문으로 lovejava인지 아닌지 확인
			textLa.setText("Love Java");
		}
			
		public void mouseExited(MouseEvent e) {
			JLabel textLa = (JLabel)e.getSource();
			textLa.setText("사랑해");
		}
		
	}
	
	public static void main(String [] args) {
		new LoveJava();
	}
}
