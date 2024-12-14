import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.awt.*;

public class centerCircle extends JFrame{
	private MyPanel panel = new MyPanel();
	private int x, y;
	private Vector<Integer> vector = new Vector<Integer>();
	
	public centerCircle() {
		setTitle("Center Pivot Circle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(700, 700);
		setVisible(true);
	}
	
	public class MyPanel extends JPanel {
		public MyPanel() {
			// 패널 배치관리자 없음
			setLayout(null);
			setSize(700, 700);
			addMouseListener(new MyMouseListener());
			// 마우스 움직일때마다 좌표출력
			addMouseMotionListener(new MyMouseListener());
		}
		
		class MyMouseListener extends MouseAdapter {
			
			// 마우스가 눌려진 좌표 == 원의 중심
			public void mousePressed(MouseEvent e) {
				vector.add(e.getX());
				vector.add(e.getY());
			}
			
			// 마우스가 떼진 좌표 == 원의 반지름
			public void mouseReleased(MouseEvent e) {
				vector.add(e.getX());
				vector.add(e.getY());
				repaint();
			}
			
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				repaint();
			}
		}
		
		// how should i use vector 벡터를 그니까 변수가 네개 들어가니까 범위를 +4한거를 그대로 넣기
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// 문자열 출력
			g.setColor(Color.GREEN);
			g.drawString("(" + x +", " + y + ")", x, y);
			
			// 원 그리기
			g.setColor(Color.MAGENTA);
			// 여기에서 초기화해줘야 한번 그리면 남아있음
			int i = 0;
			 while (i + 3 < vector.size()) {
				 g.drawOval(vector.elementAt(i), vector.elementAt(i+1), vector.elementAt(i+2), vector.elementAt(i+3));
				 i += 4; // 다음 원의 정보를 저장할 수 있도록 인덱스 이동!!
			 }
		}
	}
	
	public static void main(String[] args) {
		new centerCircle();
	}
}
