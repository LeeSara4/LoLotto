package lottoProject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class winningDetails extends JFrame {

	private JPanel contentPane;

	public winningDetails() {
		setTitle("당첨 내역");
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

		JLabel lblNewLabel_4 = new JLabel("수동");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 42, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_2);
		contentPane.add(lblNewLabel_4);

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

		JLabel lblNewLabel_11 = new JLabel("13");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 0, SpringLayout.NORTH, lblNewLabel_8);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_11, 49, SpringLayout.EAST, lblNewLabel_8);
		contentPane.add(lblNewLabel_11);

		JButton btnNewButton = new JButton("메인으로");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 42, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 36, SpringLayout.EAST, lblNewLabel);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_12 = new JLabel("낙첨");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_12, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_12, 206, SpringLayout.EAST, lblNewLabel_2);
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

		JLabel lblNewLabel_18 = new JLabel("26");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_18, 0, SpringLayout.NORTH, lblNewLabel_8);
		contentPane.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("25");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_18, 6, SpringLayout.EAST, lblNewLabel_19);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_19, 0, SpringLayout.NORTH, lblNewLabel_8);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_19, 6, SpringLayout.EAST, lblNewLabel_11);
		contentPane.add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("28");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_20, 0, SpringLayout.NORTH, lblNewLabel_8);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_20, 0, SpringLayout.WEST, lblNewLabel_17);
		contentPane.add(lblNewLabel_20);

		JLabel lblNewLabel_21 = new JLabel("32");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_21, 6, SpringLayout.EAST, lblNewLabel_20);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_21, 0, SpringLayout.SOUTH, lblNewLabel_8);
		contentPane.add(lblNewLabel_21);

		JLabel lblNewLabel_22 = new JLabel("35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_22, 0, SpringLayout.NORTH, lblNewLabel_8);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_22, 6, SpringLayout.EAST, lblNewLabel_21);
		contentPane.add(lblNewLabel_22);

		JLabel lblNewLabel_11_1 = new JLabel("13");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_11_1, 0, SpringLayout.NORTH, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_11_1, 0, SpringLayout.WEST, lblNewLabel_11);
		contentPane.add(lblNewLabel_11_1);

		JLabel lblNewLabel_18_1 = new JLabel("26");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_18_1, 0, SpringLayout.NORTH, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_18_1, 0, SpringLayout.EAST, lblNewLabel_18);
		contentPane.add(lblNewLabel_18_1);

		JLabel lblNewLabel_19_1 = new JLabel("25");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_19_1, 0, SpringLayout.NORTH, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_19_1, 0, SpringLayout.WEST, lblNewLabel_19);
		contentPane.add(lblNewLabel_19_1);

		JLabel lblNewLabel_20_1 = new JLabel("28");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_20_1, 0, SpringLayout.NORTH, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_20_1, 0, SpringLayout.WEST, lblNewLabel_17);
		contentPane.add(lblNewLabel_20_1);

		JLabel lblNewLabel_21_1 = new JLabel("32");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_21_1, 0, SpringLayout.NORTH, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_21_1, 0, SpringLayout.WEST, lblNewLabel_21);
		contentPane.add(lblNewLabel_21_1);

		JLabel lblNewLabel_22_1 = new JLabel("35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_22_1, 0, SpringLayout.NORTH, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_22_1, 0, SpringLayout.EAST, lblNewLabel_22);
		contentPane.add(lblNewLabel_22_1);

		JLabel lblNewLabel_3 = new JLabel("13");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_11);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("25");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_19);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 0, SpringLayout.SOUTH, lblNewLabel_6);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_9 = new JLabel("26");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_9, 0, SpringLayout.WEST, lblNewLabel_18);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("28");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_10, 0, SpringLayout.WEST, lblNewLabel_17);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_23 = new JLabel("32");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_23, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_23, 0, SpringLayout.WEST, lblNewLabel_21);
		contentPane.add(lblNewLabel_23);

		JLabel lblNewLabel_24 = new JLabel("35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_24, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_24, 0, SpringLayout.WEST, lblNewLabel_22);
		contentPane.add(lblNewLabel_24);

		JLabel lblNewLabel_25 = new JLabel("13");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_25, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_25, 0, SpringLayout.WEST, lblNewLabel_11);
		contentPane.add(lblNewLabel_25);

		JLabel lblNewLabel_26 = new JLabel("25");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_26, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_26, 0, SpringLayout.WEST, lblNewLabel_19);
		contentPane.add(lblNewLabel_26);

		JLabel lblNewLabel_27 = new JLabel("26");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_27, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_27, 0, SpringLayout.WEST, lblNewLabel_18);
		contentPane.add(lblNewLabel_27);

		JLabel lblNewLabel_28 = new JLabel("28");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_28, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_28, 0, SpringLayout.WEST, lblNewLabel_17);
		contentPane.add(lblNewLabel_28);

		JLabel lblNewLabel_29 = new JLabel("32");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_29, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_29, 0, SpringLayout.WEST, lblNewLabel_21);
		contentPane.add(lblNewLabel_29);

		JLabel lblNewLabel_30 = new JLabel("35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_30, 0, SpringLayout.NORTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_30, 0, SpringLayout.WEST, lblNewLabel_22);
		contentPane.add(lblNewLabel_30);

		JLabel lblNewLabel_31 = new JLabel("13");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_31, 0, SpringLayout.WEST, lblNewLabel_11);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_31, 0, SpringLayout.SOUTH, lblNewLabel_2);
		contentPane.add(lblNewLabel_31);

		JLabel lblNewLabel_32 = new JLabel("25");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_32, 0, SpringLayout.WEST, lblNewLabel_19);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_32, 0, SpringLayout.SOUTH, lblNewLabel_2);
		contentPane.add(lblNewLabel_32);

		JLabel lblNewLabel_33 = new JLabel("26");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_33, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_33, 0, SpringLayout.WEST, lblNewLabel_18);
		contentPane.add(lblNewLabel_33);

		JLabel lblNewLabel_34 = new JLabel("28");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_34, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_34, 0, SpringLayout.WEST, lblNewLabel_17);
		contentPane.add(lblNewLabel_34);

		JLabel lblNewLabel_35 = new JLabel("32");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_35, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_35, 0, SpringLayout.WEST, lblNewLabel_21);
		contentPane.add(lblNewLabel_35);

		JLabel lblNewLabel_36 = new JLabel("35");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_36, 0, SpringLayout.WEST, lblNewLabel_22);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_36, 0, SpringLayout.SOUTH, lblNewLabel_2);
		contentPane.add(lblNewLabel_36);

	}
}
