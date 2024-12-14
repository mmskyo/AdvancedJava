import javax.swing.*;

import javax.swing.filechooser.*; // 추가 

import java.awt.*;

import java.awt.event.*;



public class FileChooserEx extends JFrame{

	private JLabel imgLabel = new JLabel();

	

	public FileChooserEx() {

		setTitle("파일 탐색기 예제");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		Container c = getContentPane();

		

		c.add(imgLabel);

		createMenu();

		

		setSize(500, 250);

		setVisible(true);

	}

	

	private void createMenu() {

		JMenuBar mb = new JMenuBar();

		JMenu FileMenu = new JMenu("File");

		JMenuItem openItem = new JMenuItem("Open");

		

		openItem.addActionListener(new OpenFileActionListener());

		

		FileMenu.add(openItem);

		mb.add(FileMenu);

		setJMenuBar(mb);

	}

	

	class OpenFileActionListener implements ActionListener {

		private JFileChooser chooser;

		FileNameExtensionFilter filter;

		

		public OpenFileActionListener() {

			chooser = new JFileChooser();

			filter = new FileNameExtensionFilter("JPG, GIF, PNG", "jpg", "gif", "png");

		}

		

		public void actionPerformed(ActionEvent e) {

			chooser.setFileFilter(filter);

			int result  = chooser.showOpenDialog(null);

			

			if(result != JFileChooser.APPROVE_OPTION) {

				JOptionPane.showMessageDialog(null,  "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);

				return;

			}

			// 정상적으로 파일을 열었을 경우

			String filePath = chooser.getSelectedFile().getPath();

			imgLabel.setIcon(new ImageIcon(filePath)); // 이미지 출력

			pack(); // 이미지 크기에 맞추어 프레임 크기 조절

		}

	}

	public static void main(String[] args) {

		new FileChooserEx();

	}

}