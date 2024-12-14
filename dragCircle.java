import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
// 학교에서 실습할때는 image를 import하지 않아도 오류가 뜨지 않았는데...

public class dragCircle extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public dragCircle() {
		setTitle("Drag Circle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500, 350);
		setVisible(true);
	}
	
	public class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("Images/sunset.JPG");
		private Image img = icon.getImage();
		private int x, y;
		private boolean mouseDraggedFlag = false;
		
		public MyPanel() {
			// 패널 배치관리자 없음 setsize가 두번쓰여도되는가
			setSize(icon.getIconWidth(), icon.getIconHeight());
			setLayout(null);
			addMouseMotionListener(new MyMouseListener());
		}
		
		// 마우스를 드래그할 때 좌표 반환 실시간으로 초록 원이 따라다니게
		class MyMouseListener extends MouseAdapter {
			// 마우스 드래그
			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				mouseDraggedFlag = !mouseDraggedFlag;
				repaint();
			}
			
			// 드래그가 끝날때
			public void mouseReleased(MouseEvent e) {
                mouseDraggedFlag = false;
                repaint();
                mouseDraggedFlag = !mouseDraggedFlag;
            }
		}
		
		// 이미지와 초록원 작성
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// 이미지
			g.drawImage(img,  0,  0, getWidth(), getHeight(),  this);
			
			// 초록원
			g.setColor(Color.GREEN);
            if (mouseDraggedFlag) {
                g.fillOval(x, y, 40, 40);
            } else {
            	// 처음 좌표 else문에 안넣으면 원이 두개가됨
                g.fillOval(200, 100, 40, 40); 
            }
		}
	}
	
	public static void main(String[] args) {
		new dragCircle();
	}
}
