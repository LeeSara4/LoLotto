package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lottoProject.LottoPaper;

public class BuyList extends JFrame {
	private JPanel contentPane;
	private List<LottoPaper> tempList;
	private JPanel[] choices;
	private JLabel[] isAutos;
	private JLabel[] numbers;
	private JPanel panel;
	private JLabel lbl_temp;
	private int currentSelect = 0;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	public BuyList(List<LottoPaper> buyList, MainFrame main) {


		tempList = buyList;

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
				main.setVisible(true);
			}
		});
		btnNewButton.setBounds(275, 10, 97, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("발 행 일 :");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(250, 250, 210));
		lblNewLabel_3.setBounds(37, 160, 83, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("추 첨 일 :");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3_1.setForeground(new Color(250, 250, 210));
		lblNewLabel_3_1.setBounds(37, 185, 74, 15);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("금액");
		lblNewLabel_3_2.setForeground(new Color(250, 250, 210));
		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_3_2.setBounds(51, 416, 83, 37);
		contentPane.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_2_1 = new JLabel();
		lblNewLabel_3_2_1.setText("\\ " + ",000");
		lblNewLabel_3_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_3_2_1.setBounds(277, 416, 83, 37);
		lblNewLabel_3_2_1.setForeground(new Color(250, 250, 210));
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

		lblNewLabel_5 = new JLabel("2023 / 06 / 07 (수)");
		lblNewLabel_5.setForeground(new Color(250, 250, 210));
		if (buyList.size() > 0) {
			LocalDate date = buyList.get(currentSelect).getNowDate();
			LocalTime time = buyList.get(currentSelect).getNowTime();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formattedTime = time.format(formatter);
			lblNewLabel_5.setText(date.toString() + " " + formattedTime);
		}
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(114, 162, 160, 15);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("2023-06-10 21:00:00");
		lblNewLabel_5_1.setForeground(new Color(250, 250, 210));
		lblNewLabel_5_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(114, 185, 160, 15);
		contentPane.add(lblNewLabel_5_1);

		panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(67, 224, 267, 188);
		contentPane.add(panel);

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
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentSelect - 1 >= 0) {
					currentSelect--;
					LocalDate date = buyList.get(currentSelect).getNowDate();
					LocalTime time = buyList.get(currentSelect).getNowTime();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
					String formattedTime = time.format(formatter);
					lblNewLabel_5.setText(date.toString() + " " + formattedTime);
					lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
					lblNewLabel_3_2_1.setText("\\ " + tempList.get(currentSelect).getCount().size() + ",000");
					lblNewLabel_4.setText("< " + (currentSelect + 1) + " / " + buyList.size() + " >");
					lblNewLabel_4.setForeground(new Color(250, 250, 210));
					resetLottoPaper();
					printLottoPaper(currentSelect);
				}
			}
		});

		JButton btnFront = new RoundButton("다음");
		btnFront.setBounds(244, 519, 62, 23);
		contentPane.add(btnFront);
		btnFront.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentSelect + 1 < buyList.size()) {
					currentSelect++;
					LocalDate date = buyList.get(currentSelect).getNowDate();
					LocalTime time = buyList.get(currentSelect).getNowTime();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
					String formattedTime = time.format(formatter);
					lblNewLabel_5.setText(date.toString() + " " + formattedTime);
					lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
					lblNewLabel_3_2_1.setText("\\ " + tempList.get(currentSelect).getCount().size() + ",000");
					lblNewLabel_4.setText("< " + (currentSelect + 1) + " / " + buyList.size() + " >");
					lblNewLabel_4.setForeground(new Color(250, 250, 210));
					resetLottoPaper();
					printLottoPaper(currentSelect);
				}
			}
		});

		lblNewLabel_4 = new JLabel("< " + (currentSelect + 1) + " / " + buyList.size() + " >");
		lblNewLabel_4.setForeground(new Color(250, 250, 210));
		lblNewLabel_4.setBounds(183, 523, 40, 15);
		contentPane.add(lblNewLabel_4);

		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(37, 43, 297, 107);
		contentPane.add(logoLabel);
		ImageIcon logoIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/리그오브로또.png"));
		Image img = logoIcon.getImage();
		Image updateImage = img.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon updateLogoIcon = new ImageIcon(updateImage);
		logoLabel.setIcon(updateLogoIcon);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(BuyList.class.getResource("/imagepackage/배경라벨이미지.png")));
		lblNewLabel_7.setBounds(-5, 0, 389, 561);
		contentPane.add(lblNewLabel_7);

		System.out.println(tempList.size());
		if (tempList.size() > 0) {
			printLottoPaper(0);
			lblNewLabel_3_2_1.setText("\\ " + tempList.get(currentSelect).getCount().size() + ",000");
		} else {
			lbl_temp = new JLabel("저장된 로또용지가 없습니다.");
			panel.add(lbl_temp);
		}
	}

	public void resetLottoPaper() {
		panel.removeAll(); // 해도 화면에서는 지워지지 않고 컴포넌트만 사라짐
		panel.invalidate();
		panel.setVisible(false);
	}

	public void printLottoPaper(int index) {
		if (tempList.get(index).getCount().size() != 0) {
			int size = tempList.get(index).getCount().size(); // 0번째 카운트 사이즈;

			choices = new JPanel[size];
			isAutos = new JLabel[size];
			numbers = new JLabel[size];

			for (int i = 0; i < size; i++) {
				choices[i] = new JPanel();
				isAutos[i] = new JLabel("");
				numbers[i] = new JLabel("");

				choices[i].setBackground(Color.WHITE);
			}

			for (int i = 0; i < size; i++) {
				choices[i].add(isAutos[i]);
				choices[i].add(numbers[i]);
				isAutos[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				numbers[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				panel.add(choices[i]);
			}

			for (int i = 0; i < size; i++) {
				isAutos[i].setText(isAuto(tempList.get(index).getCount().get(i)));
				String number = tempList.get(index).getLotto().get(i).toString();
				String text = number.replace(",", " ");
				String text2 = text.replace("[", "").replace("]", "");
				numbers[i].setText(text2);
			}
		}
		panel.setVisible(true);
	}

	public String isAuto(int target) {
		if (target == 0) {
			return "자동";
		} else if (target == 6) {
			return "수동";
		} else {
			return "반자동";
		}
	}
}
