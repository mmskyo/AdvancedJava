import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Ex03 extends JFrame {
    private JRadioButton colorRadioButton, sizeRadioButton;
    private JSlider rSlider, gSlider, bSlider, sizeSlider;
    private JLabel label;
    private JPanel sliderPanel;

    public Ex03() {
        setTitle("과제 03");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 라디오 버튼 그룹 (색상, 크기)
        JPanel radioPanel = new JPanel();
        colorRadioButton = new JRadioButton("색상", true);
        sizeRadioButton = new JRadioButton("크기");
        ButtonGroup group = new ButtonGroup();
        group.add(colorRadioButton);
        group.add(sizeRadioButton);
        radioPanel.add(colorRadioButton);
        radioPanel.add(sizeRadioButton);
        add(radioPanel, BorderLayout.NORTH);

        // 슬라이더 패널
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(3, 1)); // 기본적으로 R, G, B 슬라이더 3개를 배치

        // R, G, B 슬라이더
        rSlider = new JSlider(0, 255, 128);
        gSlider = new JSlider(0, 255, 128);
        bSlider = new JSlider(0, 255, 128);
        configureSlider(rSlider, "R");
        configureSlider(gSlider, "G");
        configureSlider(bSlider, "B");

        sliderPanel.add(rSlider);
        sliderPanel.add(gSlider);
        sliderPanel.add(bSlider);
        add(sliderPanel, BorderLayout.CENTER);

        // 라벨
        label = new JLabel("I Love Coffee", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(new Color(128, 128, 128));
        add(label, BorderLayout.SOUTH);

        // 크기 슬라이더 (처음에는 보이지 않음)
        sizeSlider = new JSlider(0, 70, 20);
        configureSlider(sizeSlider, "크기");

        // 라디오 버튼 이벤트 처리
        colorRadioButton.addActionListener(e -> showColorSliders());
        sizeRadioButton.addActionListener(e -> showSizeSlider());

        // 슬라이더 이벤트 처리
        rSlider.addChangeListener(e -> updateLabelColor());
        gSlider.addChangeListener(e -> updateLabelColor());
        bSlider.addChangeListener(e -> updateLabelColor());
        sizeSlider.addChangeListener(e -> updateLabelSize());

        setVisible(true);
    }

    // 슬라이더 설정 (레이블, 큰 틱 간격 추가)
    private void configureSlider(JSlider slider, String label) {
        slider.setMajorTickSpacing(50);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBorder(BorderFactory.createTitledBorder(label));
    }

    // 색상 라디오 버튼 선택 시 색상 슬라이더 표시
    private void showColorSliders() {
        sliderPanel.removeAll();
        sliderPanel.setLayout(new GridLayout(3, 1));
        sliderPanel.add(rSlider);
        sliderPanel.add(gSlider);
        sliderPanel.add(bSlider);
        sliderPanel.revalidate();
        sliderPanel.repaint();
        updateLabelColor(); // 색상 슬라이더로 돌아왔을 때 색상 다시 적용
    }

    // 크기 라디오 버튼 선택 시 크기 슬라이더 표시
    private void showSizeSlider() {
        sliderPanel.removeAll();
        sliderPanel.setLayout(new GridLayout(1, 1));
        sliderPanel.add(sizeSlider);
        sliderPanel.revalidate();
        sliderPanel.repaint();
        updateLabelSize(); // 크기 변경 시 색상은 검정으로 설정
    }

    // 라벨의 색상 업데이트
    private void updateLabelColor() {
        if (colorRadioButton.isSelected()) {
            int r = rSlider.getValue();
            int g = gSlider.getValue();
            int b = bSlider.getValue();
            label.setForeground(new Color(r, g, b));
        }
    }

    // 라벨의 크기 업데이트
    private void updateLabelSize() {
        if (sizeRadioButton.isSelected()) {
            int size = sizeSlider.getValue();
            label.setFont(new Font("Arial", Font.PLAIN, size));
            label.setForeground(Color.BLACK); // 크기를 변경하면 글자 색상은 검정
        }
    }

    public static void main(String[] args) {
        new Ex03();
    }
}
