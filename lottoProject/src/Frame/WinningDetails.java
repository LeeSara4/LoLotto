package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lottoProject.LottoPaper;
import java.awt.TextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * 당첨화면 초안입니다!!
 *
 */
public class WinningDetails extends JFrame {

	private JPanel contentPane;
	private int currentSelect = 0;
	private List<LottoPaper> tempList;
	private List<Integer> winning_Numbers;
	private ShootNumImage shootNumImage;
	private int bonusNumber;
	private JLabel lbl_temp;

	private JPanel[] choices;
	private JLabel[] isAutos;
	private List<List<JLabel>> numbers; // 로또번호 라벨들 저장할 곳
	private JLabel[] ranks;
	private int maxIsInWinningMoney = 0;

	private JPanel pnl_Winning;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblMoney;
	private int winMoney = 0;
	private List<Integer> winMoneyList = new ArrayList<>();
	private JPanel pnl2;
	private JLabel winImageGif;
	private Timer winwin;

	/**
	 * Create the frame.
	 */
	public WinningDetails(MainFrame main, ShootNumImage shootNumImage, List<LottoPaper> buyList) {
		tempList = buyList; // 로또 리스트
		if (shootNumImage != null) {
			// 추첨이되어있고, 로또를 구매한 시점에 동작되어야 하고 그전에는 디폴트값을 가져야함
			this.shootNumImage = shootNumImage;
			winning_Numbers = new ArrayList<>(shootNumImage.getNumbers()); // 당첨번호 리스트
			bonusNumber = shootNumImage.getBonusNumber(); // 보너스번호
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		winImageGif = new JLabel("");
		winImageGif.setIcon(new ImageIcon(WinningDetails.class.getResource("/imagepackage/승리화면.gif")));
		winImageGif.setHorizontalAlignment(SwingConstants.CENTER);
		winImageGif.setBounds(194, 10, 616, 547);
		contentPane.add(winImageGif);
		winImageGif.setVisible(false);

		lblMoney = new JLabel("당첨여부");
		lblMoney.setBounds(605, 103, 383, 36);
		contentPane.add(lblMoney);
		lblMoney.setForeground(Color.WHITE);
		lblMoney.setFont(new Font("맑은 고딕", Font.BOLD, 26));

		JLabel lblNewLabel_3_1 = new JLabel("보너스 번호 일치");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_3_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_3_1.setIcon(new ImageIcon(WinningDetails.class.getResource("/imagepackage/Red27.png")));
		lblNewLabel_3_1.setBounds(736, 304, 139, 27);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3 = new JLabel("당첨 번호 일치");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(51, 204, 0));
		lblNewLabel_3.setIcon(new ImageIcon(WinningDetails.class.getResource("/imagepackage/Green27.png")));
		lblNewLabel_3.setBounds(736, 267, 147, 27);
		contentPane.add(lblNewLabel_3);

		panel = new JPanel();
		panel.setBounds(290, 267, 437, 241);
		panel.setOpaque(false);
		contentPane.add(panel);

		pnl2 = new JPanel();
		pnl2.setBounds(161, 148, 694, 54);
		pnl2.setOpaque(false);
		contentPane.add(pnl2);

		calcWinningMoney();
		JButton btnBack = new JButton(new ImageIcon(getClass().getResource("/imagepackage/SecondBeforeFrame.png")));
		btnBack.setBounds(350, 534, 95, 35);
		btnBack.setRolloverIcon(new ImageIcon(getClass().getResource("/imagepackage/SecondBeforeFrame_1.png")));
		btnBack.setBorderPainted(false);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentSelect - 1 >= 0) {
					currentSelect--;
					lblNewLabel.setText("< " + (currentSelect + 1) + " / " + buyList.size() + " >");
					resetLottoPaper();
					printLottoPaper(currentSelect);
				}
			}
		});

		winwin = new Timer(2150, new ActionListener() { // 승리 축하 이미지 // 종료 타이머
			@Override
			public void actionPerformed(ActionEvent e) {
				winImageGif.setVisible(false);
			}
		});

		JButton btnFront = new JButton(new ImageIcon(getClass().getResource("/imagepackage/SecondNextFrame.png")));
		btnFront.setBounds(570, 534, 95, 35);
		btnFront.setRolloverIcon(new ImageIcon(getClass().getResource("/imagepackage/SecondNextFrame_1.png")));
		btnFront.setBorderPainted(false);
		contentPane.add(btnFront);
		btnFront.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentSelect + 1 < buyList.size()) {
					currentSelect++;
					lblNewLabel.setText("< " + (currentSelect + 1) + " / " + buyList.size() + " >");
					resetLottoPaper();
					printLottoPaper(currentSelect);
				}
			}
		});

		lblNewLabel = new JLabel("< " + (currentSelect + 1) + " / " + buyList.size() + " >");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(487, 542, 50, 15);
		contentPane.add(lblNewLabel);

		// 당첨번호 출력부분
		pnl_Winning = new JPanel();
		pnl_Winning.setBounds(161, 30, 694, 54);
		pnl_Winning.setOpaque(false);
		contentPane.add(pnl_Winning);

		JLabel lbl_Winning = new JLabel("당첨번호 ");
		lbl_Winning.setForeground(new Color(250, 250, 210));
		lbl_Winning.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		pnl_Winning.add(lbl_Winning);

		JLabel winImage1_1 = new JLabel("");
		pnl_Winning.add(winImage1_1);
		winImage1_1.setHorizontalAlignment(SwingConstants.CENTER);

		// 당첨번호 출력메소드
		printWinningNumbers();

		JButton btn = new RoundButton("메인으로");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				main.setVisible(true);
				main.getBtnNewButton_4().setEnabled(false);
				main.getBtnNewButton_2().setEnabled(false);
			}
		});
		btn.setBounds(861, 37, 97, 23);
		contentPane.add(btn);

		JPanel p1 = new JPanel();
		p1.setBackground(new Color(250, 250, 210));
		p1.setBounds(0, 90, 1000, 3);
		p1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}
		});

		JLabel logoLabel = new JLabel("New label");
		logoLabel.setBounds(12, 8, 170, 83);
		contentPane.add(logoLabel);
		contentPane.add(p1);
		ImageIcon logoIcon = new ImageIcon(WinningDetails.class.getResource("/imagepackage/리그오브로또.png"));
		Image img = logoIcon.getImage();
		Image updateImg = img.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon updateLogoIcon = new ImageIcon(updateImg);
		logoLabel.setIcon(updateLogoIcon);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(WinningDetails.class.getResource("/imagepackage/kill1.png")));
		lblNewLabel_1.setBounds(358, 106, 293, 151);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(WinningDetails.class.getResource("/imagepackage/배경라벨이미지.png")));
		lblNewLabel_2.setBounds(0, 0, 1000, 600);
		contentPane.add(lblNewLabel_2);

		if (tempList.size() > 0) {
			resetLottoPaper();
			printLottoPaper(0);
		} else {
			lbl_temp = new JLabel("저장된 로또용지가 없습니다.");
			lbl_temp.setFont(new Font("맑은 고딕", Font.BOLD, 28));
			panel.add(lbl_temp);
		}

		setRankImage();

	}

	public void resetLottoPaper() {
		panel.removeAll(); // 해도 화면에서는 지워지지 않고 컴포넌트만 사라짐
		panel.invalidate();
		panel.setVisible(false);
	}

	public void printWinningNumbers() {
		if (shootNumImage != null) {
			for (int i = 0; i < 6; i++) {
				JLabel number = new JLabel(" " + winning_Numbers.get(i).toString());
				number.setFont(new Font("맑은 고딕", Font.BOLD, 32));
				number.setForeground(new Color(250, 250, 210));
				pnl_Winning.add(number);
			}

			JLabel lbl_Winning_Plus = new JLabel(" + ");
			lbl_Winning_Plus.setFont(new Font("맑은 고딕", Font.BOLD, 32));
			lbl_Winning_Plus.setForeground(new Color(250, 250, 210));
			pnl_Winning.add(lbl_Winning_Plus);

			JLabel lbl_Winning_Bonus = new JLabel(String.valueOf(bonusNumber));
			lbl_Winning_Bonus.setFont(new Font("맑은 고딕", Font.BOLD, 32));
			lbl_Winning_Bonus.setForeground(new Color(250, 250, 210));
			pnl_Winning.add(lbl_Winning_Bonus);
		}
	}

	public void printLottoPaper(int index) {
		if (tempList.get(index).getCount().size() != 0) {
			int size = tempList.get(index).getCount().size(); // 0번째 카운트 사이즈;

			choices = new JPanel[size];
			ranks = new JLabel[size]; // 등수
			isAutos = new JLabel[size]; // 자동여부

			// numbers 각 라벨을 담아둘 리스트
			numbers = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				List<JLabel> tempLabelList = new ArrayList<>();
				for (int j = 0; j < 6; j++) {
					List<Integer> tempLottoList = new ArrayList<>(tempList.get(index).getLotto().get(i));
					String target = String.valueOf(tempLottoList.get(j));
					JLabel lbl = new JLabel(target);
					tempLabelList.add(lbl);
				}
				numbers.add(tempLabelList);
			}

			for (int i = 0; i < size; i++) {
				choices[i] = new JPanel();
				ranks[i] = new JLabel("");
				isAutos[i] = new JLabel("");
				choices[i].setOpaque(false);
			}

			for (int i = 0; i < size; i++) {
				ranks[i].setFont(new Font("맑은 고딕", Font.PLAIN, 20));
				ranks[i].setForeground(Color.WHITE);
				choices[i].add(ranks[i]);
				isAutos[i].setFont(new Font("맑은 고딕", Font.PLAIN, 20));
				isAutos[i].setForeground(Color.WHITE);
				choices[i].add(isAutos[i]);

				for (int j = 0; j < 6; j++) {
					numbers.get(i).get(j).setFont(new Font("맑은 고딕", Font.PLAIN, 20));
					numbers.get(i).get(j).setForeground(Color.WHITE);
					choices[i].add(numbers.get(i).get(j));
				}
				panel.add(choices[i]);
			}

			for (int i = 0; i < size; i++) {
				// 등수 넣기

				// for해서 count세고
				int count = 0;
				String tempRank;
				boolean isBonus = false;
				for (int j = 0; j < 6; j++) {
					// 당첨번호와 맞는 번호
					if (isInWinningNumbers(numbers.get(i).get(j).getText())) {
						numbers.get(i).get(j).setForeground(Color.GREEN);
						count++;
					}
					// 보너스번호와 맞는 번호
					if (isInBonusNumber(numbers.get(i).get(j).getText())) {
						numbers.get(i).get(j).setForeground(Color.RED);
						isBonus = true;
					}
					if (numbers.get(i).get(j).getText().length() == 1) {
						numbers.get(i).get(j).setText("   " + numbers.get(i).get(j).getText());
					} else {
						numbers.get(i).get(j).setText("  " + numbers.get(i).get(j).getText());
					}
				}
				ranks[i].setText(isRank(count, isBonus) + " ");
				if (isInWinningMoney(count, isBonus) > maxIsInWinningMoney) {
					maxIsInWinningMoney = isInWinningMoney(count, isBonus);
				}
				winMoneyList.add(isInWinningMoney(count, isBonus));
				isAutos[i].setText(isAuto(tempList.get(index).getCount().get(i)) + " ");
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

	public String isRank(int target, boolean isBonus) {
		if (target == 3) {
			return "5등";
		} else if (target == 4) {
			return "4등";
		} else if (target == 5 && isBonus) {
			return "2등";
		} else if (target == 5) {
			return "3등";
		} else if (target == 6) {
			return "1등";
		}
		return "0등";
	}

	public boolean isInWinningNumbers(String str) {
		for (int i = 0; i < 6; i++) {
			if (winning_Numbers.get(i).toString().equals(str)) {
				return true;
			}
		}
		return false;
	}

	public boolean isInBonusNumber(String str) {
		for (int i = 0; i < 6; i++) {
			if (String.valueOf(bonusNumber).equals(str)) {
				return true;
			}
		}
		return false;
	}

	public int isInWinningMoney(int target, boolean isBonus) {
		if (target == 3) {
			return 5000;
		} else if (target == 4) {
			return 50000;
		} else if (target == 5 && isBonus) {
			return 1446277;
		} else if (target == 5) {
			return 55031743;
		} else if (target == 6) {
			return 1863217554;
		}
		return 0;
	}

	public void calcWinningMoney() {

		// 로또 리스트랑 비교해서 당첨확인.
		for (int i = 0; i < tempList.size(); i++) {
			printLottoPaper(i);
		}
		// 당첨된 녀석은 금액추가
		for (int i = 0; i < winMoneyList.size(); i++) {
			winMoney += winMoneyList.get(i);
		}
		lblMoney.setText("총 " + winMoney + " RP");
		// 총 금액 계산후 setText
	}

	public void setRankImage() {
		if (maxIsInWinningMoney == 0) { // 낙첨
			JLabel winningImage = new JLabel(
					new ImageIcon(WinningDetails.class.getResource("/imagepackage/kill0.png")));
			winningImage.setSize(155, 34);
			pnl2.add(winningImage);
		} else if (maxIsInWinningMoney == 5000) { // 5등
			JLabel winningImage = new JLabel(
					new ImageIcon(WinningDetails.class.getResource("/imagepackage/kill3.png")));

			winningImage.setSize(155, 34);
			pnl2.add(winningImage);
		} else if (maxIsInWinningMoney == 50000) { // 4등
			JLabel winningImage = new JLabel(
					new ImageIcon(WinningDetails.class.getResource("/imagepackage/kill4.png")));
			winningImage.setSize(155, 34);
			pnl2.add(winningImage);
		} else if (maxIsInWinningMoney == 1446277) { // 3등
			JLabel winningImage = new JLabel(
					new ImageIcon(WinningDetails.class.getResource("/imagepackage/kill5.png")));
			winningImage.setSize(155, 34);
			pnl2.add(winningImage);
		} else if (maxIsInWinningMoney == 55031743) { // 2등
			JLabel winningImage = new JLabel(
					new ImageIcon(WinningDetails.class.getResource("/imagepackage/kill5+1.png")));
			winningImage.setSize(155, 34);
			pnl2.add(winningImage);
		} else if (maxIsInWinningMoney == 1863217554) { // 1등
			JLabel winningImage = new JLabel(
					new ImageIcon(WinningDetails.class.getResource("/imagepackage/kill6.png")));
			winningImage.setSize(155, 34);
			winImageGif.setVisible(true);
			winwin.start();
			pnl2.add(winningImage);
		}
	}

}
