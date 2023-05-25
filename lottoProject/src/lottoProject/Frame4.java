package lottoProject;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class Frame4 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame4 frame = new Frame4();
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
	public Frame4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("그림컴퓨터배 로또 제 1회 ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 29, SpringLayout.NORTH, contentPane);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("당첨번호자리");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 36, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 41, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("자동");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 145, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 23, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("13 25 26 28 32 35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 49, SpringLayout.EAST, lblNewLabel_2);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("수동");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 42, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_2);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("13 25 26 28 32 35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel_3);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("수동");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 42, SpringLayout.SOUTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_6, 0, SpringLayout.EAST, lblNewLabel_2);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("반자동");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 49, SpringLayout.SOUTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblNewLabel_2);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("자동");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 39, SpringLayout.SOUTH, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_8, 0, SpringLayout.EAST, lblNewLabel_2);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("13 25 26 28 32 35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_9, 0, SpringLayout.WEST, lblNewLabel_3);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("13 25 26 28 32 35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 0, SpringLayout.NORTH, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_10, 0, SpringLayout.WEST, lblNewLabel_3);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("13 25 26 28 32 35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 0, SpringLayout.NORTH, lblNewLabel_8);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_11, 0, SpringLayout.WEST, lblNewLabel_3);
		contentPane.add(lblNewLabel_11);

		JButton btnNewButton = new JButton("메인으로");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 42, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 36, SpringLayout.EAST, lblNewLabel);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_12 = new JLabel("낙첨");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_12, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_12, 65, SpringLayout.EAST, lblNewLabel_3);
		contentPane.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("낙첨");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_13, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_13, 0, SpringLayout.WEST, lblNewLabel_12);
		contentPane.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("낙첨");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_14, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_14, 0, SpringLayout.WEST, lblNewLabel_12);
		contentPane.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("낙첨");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_15, 0, SpringLayout.NORTH, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_15, 0, SpringLayout.WEST, lblNewLabel_12);
		contentPane.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("낙첨");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_16, 0, SpringLayout.NORTH, lblNewLabel_8);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_16, 0, SpringLayout.WEST, lblNewLabel_12);
		contentPane.add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("< 1 >");
		contentPane.add(lblNewLabel_17);

		JButton btnNewButton_1 = new JButton("이전");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 13, SpringLayout.EAST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_17, 45, SpringLayout.EAST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -42, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_17, 4, SpringLayout.NORTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 47, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("다음");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, -4, SpringLayout.NORTH, lblNewLabel_17);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 46, SpringLayout.EAST, lblNewLabel_17);
		contentPane.add(btnNewButton_2);
	}

}
