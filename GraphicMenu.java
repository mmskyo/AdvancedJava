import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GraphicMenu extends JFrame {
    private MyPanel panel = new MyPanel();
    private ImageIcon icon = new ImageIcon("images/sunset.JPG");
    private int clipX = 0, clipY = 0; // 클리핑 영역 위치
    private int stringX = 100, stringY = 110; // 문자열 위치
    private int clipSize = 30; // 클리핑 크기
    private boolean showFlag = false; // 전체 이미지를 보여줄지 여부
    private Random rand = new Random();

    public GraphicMenu() {
        setTitle("숨은 문자열 찾기 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setContentPane(panel);

        createMenu();
        setVisible(true);
    }

    // 메뉴 생성
    private void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu gameMenu = new JMenu("게임 메뉴");

        JMenuItem setItem = new JMenuItem("클리핑 크기 설정");
        JMenuItem restartItem = new JMenuItem("다시 시작");
        JMenuItem showItem = new JMenuItem("전체 이미지 보기");

        // 메뉴 항목에 이벤트 리스너 추가
        setItem.addActionListener(new SetClipSizeActionListener());
        restartItem.addActionListener(new RestartActionListener());
        showItem.addActionListener(new ShowWholeImageActionListener());

        gameMenu.add(setItem);
        gameMenu.add(restartItem);
        gameMenu.add(showItem);

        mb.add(gameMenu);
        setJMenuBar(mb);
    }

    // 클리핑 크기 설정 리스너
    class SetClipSizeActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog("클리핑 크기를 입력하세요:");
            try {
                int newSize = Integer.parseInt(input);
                if (newSize > 0) {
                    clipSize = newSize; // 클리핑 크기 업데이트
                    repaint(); // 다시 그리기
                } else {
                    JOptionPane.showMessageDialog(null, "양수를 입력해주세요.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.");
            }
        }
    }

    // 다시 시작 리스너
    class RestartActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clipX = 0; // 클리핑 영역 초기화
            clipY = 0;
            stringX = rand.nextInt(icon.getIconWidth() - 100); // 문자열 위치 랜덤 설정
            stringY = rand.nextInt(icon.getIconHeight() - 20);
            showFlag = false; // 전체 이미지 보기 해제
            repaint();
        }
    }

    // 전체 이미지 보기 리스너
    class ShowWholeImageActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            showFlag = true; // 전체 이미지 보기 플래그 설정
            repaint();
        }
    }

    // 패널 클래스
    class MyPanel extends JPanel {
        //private java.awt.Image img = icon.getImage();

        public MyPanel() {
            setFocusable(true);
            requestFocus();
            addKeyListener(new MyKeyListener());
        }

        // 키보드 이벤트 처리
        class MyKeyListener extends KeyAdapter {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        clipX += 30;
                        break; // break 추가
                    case KeyEvent.VK_LEFT:
                        clipX -= 30;
                        break; // break 추가
                    case KeyEvent.VK_UP:
                        clipY -= 30;
                        break; // break 추가
                    case KeyEvent.VK_DOWN:
                        clipY += 30;
                        break; // break 추가
                }
                repaint();
            }
        }

        // 그래픽 그리기
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
         // 경계 설정
            if (clipX < 0) {
                clipX = 0;
            } else if (clipX + clipSize > icon.getIconWidth()) {
                clipX = icon.getIconWidth() - clipSize;
            }

            if (clipY < 0) {
                clipY = 0;
            } else if (clipY + clipSize > icon.getIconHeight()) {
                clipY = icon.getIconHeight() - clipSize;
            }

   			
            if (showFlag) {
                // 전체 이미지 보기
                g.setClip(0, 0, getWidth(), getHeight());
            } else {
                // 클리핑 영역 설정
                g.setClip(clipX, clipY, clipSize, clipSize);
            }

            // 이미지 그리기
            g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);           

         // 문자열 그리기
            if (showFlag) {
                // 전체 보기 상태에서도 문자열을 그리도록
                g.setColor(Color.BLUE);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Advanced JAVA", stringX, stringY);
            }
        }
    }

    public static void main(String[] args) {
        new GraphicMenu(); // 프로그램 실행
    }
}
