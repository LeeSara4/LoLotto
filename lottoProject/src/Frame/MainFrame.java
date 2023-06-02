package Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	BuyFrame buyFrame = new BuyFrame(this);
	ShootNumImage shootNumImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame(); // 메인 프레임
					Dimension frameSize = frame.getSize(); // 프레임 사이즈
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation((screenSize.width - frameSize.width) / 2,
							(screenSize.height - frameSize.height) / 2);
					JLabel label = new JLabel("그냥 해봤쓤", JLabel.CENTER);
					frame.add(label, BorderLayout.CENTER);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {

		setTitle("4조 대박당첨");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(SystemColor.window);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 10, 410, 129);
		panel.add(lblNewLabel);

		JButton btnNewButton = new RoundButton("구매하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(90, 149, 97, 33);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new RoundButton("구매내역");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyList buyList = new BuyList(buyFrame.returnMapList(), MainFrame.this);
				buyList.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(249, 149, 97, 33);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new RoundButton("추첨");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shootNumImage = new ShootNumImage(MainFrame.this);
				shootNumImage.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(90, 204, 97, 33);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new RoundButton("당첨 확인");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinningDetails winningDetails = new WinningDetails(MainFrame.this, shootNumImage,
						buyFrame.returnMapList());
				winningDetails.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(249, 204, 97, 33);
		panel.add(btnNewButton_3);
//		EndCheckFrame
	}
}
