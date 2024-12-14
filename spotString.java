import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class spotString extends JFrame {
    private MyPanel panel = new MyPanel();
    private int x, y = 0;

    spotString() {
        setTitle("이미지 패널에 숨은 문자열 찾기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setContentPane(panel);
        setVisible(true);
    }

    public class MyPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("Images/sunset.JPG");
        private java.awt.Image img = icon.getImage();

        public MyPanel() {
            setSize(icon.getIconWidth(), icon.getIconHeight());
            setLayout(null);
            setFocusable(true); // 키 이벤트를 받기 위해 포커스 설정
            requestFocus(); // 포커스 요청
            addKeyListener(new MyKeyListener());
        }

        class MyKeyListener extends KeyAdapter {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    x += 30;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    x -= 30;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    y -= 30;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    y += 30;
                }
                repaint();
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // bound설정 
            if(x > icon.getIconWidth() || x < 0)
      			x = 0;
   			if(y > icon.getIconHeight() || y < 0)
   				y = 0;
            
            // 클리핑 설정
            // setclip을 먼저해야 클리핑이 돼서 나옴!!!
            g.setClip(x, y, 30, 30);

            // 배경 이미지 그리기
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

            // 숨은 문자열
            g.setColor(Color.BLUE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Advanced JAVA", 100, 110);
        }
    }

    public static void main(String[] args) {
        new spotString();
    }
}