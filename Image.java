import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Image extends JFrame {
	public Image() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 경로 신경 **이노트북은 꼭 현재 폴더의 상위폴더 ../ 까지 입력해야함
		ImageIcon beauty = new ImageIcon("../Images/beauty.jpg");
		JLabel imageLabel = new JLabel(beauty);
		
		ImageIcon normalIcon = new ImageIcon("../Images/normalIcon.gif");
		// 정렬 체크 - flowLayout의 경우, 공간이 할당되어있어서 정렬이 안먹음. null으로 해보기
		JLabel label = new JLabel("전화하세요", normalIcon, SwingConstants.CENTER);
		
		c.add(imageLabel);
		c.add(label);
		
		setSize(800, 600);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Image();
	}
}