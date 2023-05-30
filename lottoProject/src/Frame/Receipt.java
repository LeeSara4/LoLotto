package Frame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Receipt extends JFrame {
	private JPanel contentPane;
	private Timer timer;
	private int windowHeight;
	private int animationSpeed;

	public Receipt() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 10);
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon imageIcon = new ImageIcon("loottoo2.png");
				imageIcon.paintIcon(this, g, 0, 0);
			}
		};
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		// 아래로 내려가는 애니메이션 속도 설정 (밀리초 단위)
		animationSpeed = 10;

		// 현재 창의 높이
		windowHeight = getHeight();

		// Timer를 사용하여 애니메이션을 구현
		timer = new Timer(animationSpeed, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 창의 높이를 2씩 증가시켜 창을 아래로 이동
				windowHeight += 2;
				setSize(getWidth(), windowHeight);

				// 원하는 창의 최대 높이에 도달하면 타이머를 멈춤
				if (windowHeight >= 560) {
					timer.stop();
				}
			}
		});

		// Timer 시작
		timer.start();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}
}
