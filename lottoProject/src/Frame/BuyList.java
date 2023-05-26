package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class BuyList extends JFrame {

	private JPanel contentPane;

	public BuyList() {
		setTitle("구매 내역");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JButton btnNewButton = new JButton("메인으로");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("그린컴퓨터배 로또 제 1회");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, -3, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 19, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 26, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 83, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -182, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("자동");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 61, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 109, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("New button");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 23, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -34, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, -42, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_2_1 = new JLabel("12 25 26 28 32 35");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2_1, -110, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, -5, SpringLayout.EAST, btnNewButton);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("12 25 26 28 32 35");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 0, SpringLayout.WEST, lblNewLabel_2_1_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_1, 25, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblNewLabel_2_1_1);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("12 25 26 28 32 35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_2, 18, SpringLayout.SOUTH, lblNewLabel_2_1_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2_1_1, 0, SpringLayout.EAST, lblNewLabel_2_1_2);
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_3 = new JLabel("12 25 26 28 32 35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_3, 24, SpringLayout.SOUTH, lblNewLabel_2_1_2);
		contentPane.add(lblNewLabel_2_1_3);

		JLabel lblNewLabel_2_1_4 = new JLabel("12 25 26 28 32 35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 6, SpringLayout.SOUTH, lblNewLabel_2_1_4);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1_4, 23, SpringLayout.SOUTH, lblNewLabel_2_1_3);
		contentPane.add(lblNewLabel_2_1_4);

		JLabel lblNewLabel_1_1 = new JLabel("자동");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_2, 115, SpringLayout.EAST, lblNewLabel_1_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 0, SpringLayout.NORTH, lblNewLabel_2_1_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("반자동");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_3, 103, SpringLayout.EAST, lblNewLabel_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1, 0, SpringLayout.SOUTH, lblNewLabel_2_1_3);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("수동");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2_1_4, 115, SpringLayout.EAST, lblNewLabel_1_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1, 0, SpringLayout.NORTH, lblNewLabel_2_1_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("수동");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1, 27, SpringLayout.SOUTH,
				lblNewLabel_1_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_2 = new JLabel("< 1 >");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 4, SpringLayout.NORTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 32, SpringLayout.EAST, btnNewButton_1);
		contentPane.add(lblNewLabel_2);
	}
}
