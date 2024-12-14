import javax.swing.*;

import java.awt.*;

import java.awt.event.*;



public class paintButtonEx extends JFrame{

	MyButton b = new MyButton("버튼");

	

	// 그래픽 컴포넌트들은 이벤트를 생성할수없으니까 우회적으로 버튼이 눌렸다는 시그널

	// 둘 중 하나만

	//Boolean check;

	int count;

	

	public paintButtonEx() {

		setTitle("Button");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//check = false;

		count = 0;

		Container c = getContentPane();

		c.setLayout(null);

		b.addActionListener(new NewBtn());

		

		b.setBackground(Color.CYAN);

		b.setBounds(50, 20, 100, 50);

		b.setBorderPainted(true);

		c.add(b);

		

		setSize(250, 200);

		setVisible(true);

	}

	public class NewBtn implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			//check = true;

			count++;

			b.repaint();

		}

	}

	

	class MyButton extends JButton {

		MyButton(String s) {

			super(s);

		}

		

		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			b.setOpaque(false);

			

			// 처음 자동으로 호출했을 때는 안됨. 단, 버튼이 눌렸을 때 호출

			/* 구글링해서 버튼 꾸미는거 다 그랠픽 활용 찾아보아라*/

			if(/*check &&*/ count % 2 == 1) {

				b.setBorderPainted(false);

				g.setColor(Color.GREEN);

				g.fillOval(0,  0,  this.getWidth(), this.getHeight());

				g.setColor(Color.WHITE);

				g.setFont(new Font("Verdana", Font.PLAIN, 20));

				g.drawString("again", this.getX()-25, this.getY()+10);

			} else {

				b.setBackground(Color.CYAN);

				b.setBorderPainted(true);

			}

		}

	}

	

	public static void main(String [] args) {

		new paintButtonEx();

	}

}