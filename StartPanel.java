import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 창이아니라 화면이 바뀌는 연출을 위해 JFrame이 아닌 JPanel 사용
public class StartPanel extends JPanel {
    public StartPanel(GameFrame gameFrame) {
        setLayout(new BorderLayout(30, 30));
        ImageIcon originalIcon = new ImageIcon("images/pizza.png");
        Image image = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel titleLabel = new JLabel("피자킹", scaledIcon, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        add(titleLabel, BorderLayout.CENTER);
        
        // 게임설명 버튼 - 단순 메세지 팝업 다이어로그 
        JButton menualButton = new JButton("게임 설명");
        menualButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "어떤 가게라도 살린다는 피자 킹인 당신은 \n"
                		+ "폐업 위기에 놓인 변방의 어떤 피자가게에서\n"
                		+ "의뢰를 받았다...\n"
                		+ "주어진 시간은 오늘 하루!!\n"
                		+ "당신이 이 가게의 폐업 여부를 결정한다!\n"
                		+ "최대한 많은 고객을 만족시키자!", "게임 설명", JOptionPane.PLAIN_MESSAGE);
        	}
        });
        add(menualButton, BorderLayout.WEST);
        
        // 게임 시작 버튼 
        JButton startButton = new JButton("게임 시작");
        startButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		gameFrame.showPanel("order");
        	}
        });
        add(startButton, BorderLayout.EAST);
    }
}
