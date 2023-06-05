package Frame;

import java.awt.Color;
import java.awt.FlowLayout;
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
	private int currentSelect = 0;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_1;
	private JLabel backLabel;

	public BuyList(List<LottoPaper> buyList, MainFrame main) {
		tempList = buyList;
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(BuyList.class.getResource("/imagepackage/배경라벨이미지.png")));
		backLabel.setBounds(0, 0, 1000, 600);
		contentPane.add(backLabel);

		JButton btnNewButton = new RoundButton("메인으로");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				main.setVisible(true);
			}
		});
		btnNewButton.setBounds(870, 36, 97, 23);
		backLabel.add(btnNewButton);

		ImageIcon upIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/위.png"));
		Image upImg = upIcon.getImage();

		JLabel lblDownLabel = new JLabel("");
		lblDownLabel.setBounds(320, 444, 330, 15);
		backLabel.add(lblDownLabel);
		ImageIcon downIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/아래.png"));
		Image downImage = downIcon.getImage();
		Image updateDownImage = downImage.getScaledInstance(lblDownLabel.getWidth(), lblDownLabel.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon updateDownIcon = new ImageIcon(updateDownImage);
		lblDownLabel.setIcon(updateDownIcon);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(320, 210, 330, 29);
		backLabel.add(lblNewLabel);
		Image updateImage2 = upImg.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon updateUpIcon = new ImageIcon(updateImage2);
		lblNewLabel.setIcon(updateUpIcon);

		JLabel lblNewLabel_3 = new JLabel("발 행 일 :");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(250, 250, 210));
		lblNewLabel_3.setBounds(341, 153, 83, 15);
		backLabel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("추 첨 일 :");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3_1.setForeground(new Color(250, 250, 210));
		lblNewLabel_3_1.setBounds(341, 178, 74, 15);
		backLabel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("금액");
		lblNewLabel_3_2.setForeground(new Color(250, 250, 210));
		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_3_2.setBounds(341, 450, 83, 37);
		backLabel.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_2_1 = new JLabel();
		lblNewLabel_3_2_1.setText(",000원");
		lblNewLabel_3_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_3_2_1.setBounds(567, 450, 83, 37);
		lblNewLabel_3_2_1.setForeground(new Color(250, 250, 210));
		backLabel.add(lblNewLabel_3_2_1);

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
		lblNewLabel_5.setBounds(418, 155, 160, 15);
		backLabel.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("2023-06-10 21:00:00");
		lblNewLabel_5_1.setForeground(new Color(250, 250, 210));
		lblNewLabel_5_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(418, 178, 160, 15);
		backLabel.add(lblNewLabel_5_1);

		// 번호들 출력되는 패널
		panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(357, 215, 267, 231);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		backLabel.add(panel);
//		panel.setOpaque(false);

		JButton btnBack = new JButton(new ImageIcon(getClass().getResource("/imagepackage/BeforeFrame.png")));
		btnBack.setBounds(378, 512, 62, 23);
		btnBack.setRolloverIcon(new ImageIcon(getClass().getResource("/imagepackage/BeforeFrame_1.png")));
		btnBack.setBorderPainted(false);
		backLabel.add(btnBack);
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
					lblNewLabel_3_2_1.setText(tempList.get(currentSelect).getCount().size() + ",000원");
					lblNewLabel_4.setText("< " + (currentSelect + 1) + " / " + buyList.size() + " >");
					lblNewLabel_4.setForeground(new Color(250, 250, 210));
					resetLottoPaper();
					printLottoPaper(currentSelect);
				}
			}
		});

		JButton btnFront = new JButton(new ImageIcon(getClass().getResource("/imagepackage/NextFrame.png")));
		btnFront.setBounds(534, 512, 62, 23);
		btnFront.setRolloverIcon(new ImageIcon(getClass().getResource("/imagepackage/NextFrame_1.png")));
		btnFront.setBorderPainted(false);
		backLabel.add(btnFront);
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
					lblNewLabel_3_2_1.setText(tempList.get(currentSelect).getCount().size() + ",000원");
					lblNewLabel_4.setText("< " + (currentSelect + 1) + " / " + buyList.size() + " >");
					lblNewLabel_4.setForeground(new Color(250, 250, 210));
					resetLottoPaper();
					printLottoPaper(currentSelect);
				}
			}
		});

		lblNewLabel_4 = new JLabel("< " + (currentSelect + 1) + " / " + buyList.size() + " >");
		lblNewLabel_4.setForeground(new Color(250, 250, 210));
		lblNewLabel_4.setBounds(466, 517, 59, 15);
		backLabel.add(lblNewLabel_4);

		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(342, 39, 297, 122);
		backLabel.add(logoLabel);
		ImageIcon logoIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/리그오브로또.png"));
		Image img = logoIcon.getImage();
		Image updateImage = img.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon updateLogoIcon = new ImageIcon(updateImage);
		logoLabel.setIcon(updateLogoIcon);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(50, 40, 220, 500);
		ImageIcon leftIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/터렛(left).png"));
		Image leftimg = leftIcon.getImage();
		Image updateleftImage = leftimg.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon updateleftIcon = new ImageIcon(updateleftImage);
		lblNewLabel_2.setIcon(updateleftIcon);
		backLabel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(700, 40, 220, 500);
		ImageIcon rightIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/터렛(right).png"));
		Image rightimg = rightIcon.getImage();
		Image updaterightImage = rightimg.getScaledInstance(lblNewLabel_6.getWidth(), lblNewLabel_6.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon updaterightIcon = new ImageIcon(updaterightImage);
		lblNewLabel_6.setIcon(updaterightIcon);	
		backLabel.add(lblNewLabel_6);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(0, 0, 267, 230);
		ImageIcon centerIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/영수증안쪽.png"));
		Image centerImg = centerIcon.getImage();
		Image updateCenterImage = centerImg.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon updateCenterIcon = new ImageIcon(updateCenterImage);
		lblNewLabel_1.setIcon(updateCenterIcon);
		lblNewLabel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// panel.add(lblNewLabel_1);

		if (tempList.size() > 0) {
			printLottoPaper(0);
			lblNewLabel_3_2_1.setText(tempList.get(currentSelect).getCount().size() + ",000RP");
		} else {

			panel.add(lblNewLabel_1);
		}

	}

	public void resetLottoPaper() {
		panel.removeAll(); // 해도 화면에서는 지워지지 않고 컴포넌트만 사라짐
		panel.invalidate();
		panel.setVisible(false);
		lblNewLabel_1.removeAll();
		lblNewLabel_1.invalidate();
		lblNewLabel_1.setVisible(false);

	}

	public void printLottoPaper(int index) {
		panel.setOpaque(false);
		if (tempList.get(index).getCount().size() != 0) {
			int size = tempList.get(index).getCount().size(); // 0번째 카운트 사이즈;
			choices = new JPanel[size];
			isAutos = new JLabel[size];
			numbers = new JLabel[size];

			for (int i = 0; i < size; i++) {
				choices[i] = new JPanel();
				isAutos[i] = new JLabel("");
				numbers[i] = new JLabel("");
				choices[i].setOpaque(false);
			}

			for (int i = 0; i < size; i++) {
				choices[i].add(isAutos[i]);
				choices[i].add(numbers[i]);
				isAutos[i].setFont(new Font("맑은 고딕", Font.BOLD, 18));
				isAutos[i].setForeground(new Color(250, 250, 210));
				numbers[i].setFont(new Font("맑은 고딕", Font.BOLD, 18));
				numbers[i].setForeground(new Color(250, 250, 210));
				lblNewLabel_1.add(choices[i]);

			}

			for (int i = 0; i < size; i++) {
				isAutos[i].setText(isAuto(tempList.get(index).getCount().get(i)));
				String number = tempList.get(index).getLotto().get(i).toString();
				String text = number.replace(",", " ");
				String text2 = text.replace("[", "").replace("]", "");
				numbers[i].setText(text2);
			}
		}
		panel.add(lblNewLabel_1);
		panel.setVisible(true);
		lblNewLabel_1.setVisible(true);

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
