import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.random.*;

public class Hello extends JFrame{
	JLabel la = new JLabel("Hello!");
	Random rand = new Random();
	//int seed = rand.nextInt(4);
	
	public Hello() {
		
		setTitle("과제1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		la.addMouseListener(new MyMouseListener());
		// 키를 입력받을 때는 라벨에 포커스가 가지않으니까 컨텐트팬에 추가
		c.addKeyListener(new MyKeyListener());
		la.setSize(50, 50);
		la.setLocation(100, 30);
		la.setFocusable(true);
		c.add(la);
		
		setSize(500, 500);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
	}
	
	// 마우스 리스너 클래스
    class MyMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            moveLabelWithinBounds();
        }
    }

    // 키보드 리스너 클래스
    class MyKeyListener extends KeyAdapter {
    	// 문자 키가 눌렸을 때만 호출되는 keyTyped를 사용하는게 좋다
        public void keyPressed(KeyEvent e) {
        	// getKeyChar() == 'c'
            if (e.getKeyCode() == KeyEvent.VK_C) {
                moveLabelWithinBounds();
                // int x = (int)(Math.random()*450);
            }
        }
    }

    // 라벨을 화면 안에서만 이동시키는 메서드
    private void moveLabelWithinBounds() {
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int labelWidth = la.getWidth();
        int labelHeight = la.getHeight();

        // X 좌표는 0 ~ (frameWidth - labelWidth) 범위에서 생성
        int x = rand.nextInt(frameWidth - labelWidth);

        // Y 좌표는 0 ~ (frameHeight - labelHeight) 범위에서 생성
        int y = rand.nextInt(frameHeight - labelHeight);

        la.setLocation(x, y);
    }
 
	
	public static void main(String [] args) {
		new Hello();
	}
}
