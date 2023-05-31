package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BuyList extends JFrame {
	private JPanel contentPane;

	private JPanel[] choices;
	private JLabel[] isAutos;
	private JLabel[] numbers;

	public BuyList() {

		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new RoundButton("메인으로");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(275, 10, 97, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("LOTTO");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 31));
		lblNewLabel.setBounds(77, 51, 111, 85);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("LOTTO");
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_1.setBounds(37, 10, 97, 76);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("6 / 45");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_2.setBounds(194, 91, 57, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("6 / 45");
		lblNewLabel_2_1.setForeground(Color.PINK);
		lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(146, 49, 57, 15);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("발 행 일 :");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3.setBounds(37, 160, 83, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("추 첨 일 :");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(37, 185, 74, 15);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("금액");
		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_3_2.setBounds(51, 416, 83, 37);
		contentPane.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_2_1 = new JLabel("\\ 5,000");
		lblNewLabel_3_2_1.setText("\\ " + ",000");
		lblNewLabel_3_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_3_2_1.setBounds(277, 416, 83, 37);
		contentPane.add(lblNewLabel_3_2_1);

		JLabel lblNewLabel_1_1 = new JLabel("LOTTO");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(37, 433, 97, 76);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("6 / 45");
		lblNewLabel_2_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(146, 472, 57, 15);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_5 = new JLabel("2023 / 06 / 07 (수)");
		LocalDate nowDate = LocalDate.now();
		LocalTime nowTime = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = nowTime.format(formatter);
		lblNewLabel_5.setText(nowDate.toString() + " " + formattedTime);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(114, 162, 160, 15);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("2023-06-10 21:00:00");
		lblNewLabel_5_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(114, 185, 160, 15);
		contentPane.add(lblNewLabel_5_1);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(67, 224, 267, 173);
		contentPane.add(panel);

		choices = new JPanel[5];
		isAutos = new JLabel[5];
		numbers = new JLabel[5];

		for (int i = 0; i < 5; i++) {
			choices[i] = new JPanel();
			isAutos[i] = new JLabel("");
			numbers[i] = new JLabel("");

			choices[i].setBackground(Color.WHITE);
		}

		for (int i = 0; i < 5; i++) {
			choices[i].add(isAutos[i]);
			choices[i].add(numbers[i]);
			isAutos[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			numbers[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			panel.add(choices[i]);
		}

//		for (int i = 0; i < 사이즈; i++) {
//			isAutos[i].setText(isAuto(lottoPaper.getCount().get(i)));
//			String number = lottoPaper.getLotto().get(i).toString();
//			String text = number.replace(",", " ");
//			String text2 = text.replace("[", "").replace("]", "");
//			numbers[i].setText(text2);
//		}

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(37, 219, 323, 4);
		contentPane.add(panel_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.activeCaption);
		panel_1_1.setBounds(37, 413, 323, 4);
		contentPane.add(panel_1_1);

		JButton btnBack = new RoundButton("이전");
		btnBack.setBounds(88, 519, 62, 23);
		contentPane.add(btnBack);

		JButton btnFront = new RoundButton("다음");
		btnFront.setBounds(244, 519, 62, 23);
		contentPane.add(btnFront);

		JLabel lblNewLabel_4 = new JLabel("< 1 >");
		lblNewLabel_4.setBounds(183, 523, 30, 15);
		contentPane.add(lblNewLabel_4);

	}

}
