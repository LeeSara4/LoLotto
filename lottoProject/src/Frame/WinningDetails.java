package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lottoProject.LottoPaper;

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

	private JPanel pnl_Winning;
	private JPanel panel;
	private JLabel lblNewLabel;

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
		setBounds(100, 100, 673, 561);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title_lotto = new JLabel("Lotto");
		title_lotto.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title_lotto.setBounds(261, 15, 87, 53);
		contentPane.add(title_lotto);

		JLabel title = new JLabel("6/45");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		title.setBounds(349, 39, 57, 15);
		contentPane.add(title);

		JLabel title_lotto_1 = new JLabel("Lotto");
		title_lotto_1.setForeground(Color.PINK);
		title_lotto_1.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		title_lotto_1.setBounds(241, -12, 71, 46);
		contentPane.add(title_lotto_1);

		JLabel title_1 = new JLabel("6/45");
		title_1.setForeground(Color.PINK);
		title_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		title_1.setBounds(326, 9, 57, 15);
		contentPane.add(title_1);

		panel = new JPanel();
		panel.setBounds(116, 216, 418, 216);
		contentPane.add(panel);

		JPanel pnl1_3_2 = new JPanel();
		pnl1_3_2.setBounds(116, 152, 418, 54);
		contentPane.add(pnl1_3_2);

		JLabel isAuto_1_3_2_1_1 = new JLabel("총 9,000,000 원 당첨!");
		isAuto_1_3_2_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		pnl1_3_2.add(isAuto_1_3_2_1_1);

		JLabel isAuto_1_3_2 = new JLabel("");
		isAuto_1_3_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2.add(isAuto_1_3_2);

		JButton btnNewButton = new JButton("이전");
		btnNewButton.setBounds(181, 458, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentSelect - 1 >= 0) {
					currentSelect--;
					lblNewLabel.setText("< " + (currentSelect + 1) + " >");
					resetLottoPaper();
					printLottoPaper(currentSelect);
				}
			}
		});

		JButton btnNewButton_1 = new JButton("다음");
		btnNewButton_1.setBounds(367, 458, 97, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentSelect + 1 < buyList.size()) {
					currentSelect++;
					lblNewLabel.setText("< " + (currentSelect + 1) + " >");
					resetLottoPaper();
					printLottoPaper(currentSelect);
				}
			}
		});

		lblNewLabel = new JLabel("< " + (currentSelect + 1) + " >");
		lblNewLabel.setBounds(314, 462, 30, 15);
		contentPane.add(lblNewLabel);

		// 당첨번호 출력부분
		pnl_Winning = new JPanel();
		pnl_Winning.setBounds(116, 90, 418, 54);
		contentPane.add(pnl_Winning);

		JLabel lbl_Winning = new JLabel("당첨번호");
		lbl_Winning.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		pnl_Winning.add(lbl_Winning);

		// 당첨번호 출력메소드
		printWinningNumbers();

		JButton btn = new RoundButton("메인으로");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				main.setVisible(true);
			}
		});
		btn.setBounds(548, 6, 97, 23);
		contentPane.add(btn);

		System.out.println(tempList.size());
		if (tempList.size() > 0) {
			printLottoPaper(0);
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

	public void printWinningNumbers() {
		if (shootNumImage != null) {
			JLabel lbl_Winning_Num1 = new JLabel(winning_Numbers.get(0).toString());
			lbl_Winning_Num1.setFont(new Font("맑은 고딕", Font.BOLD, 28));
			pnl_Winning.add(lbl_Winning_Num1);

			JLabel lbl_Winning_Num2 = new JLabel(winning_Numbers.get(1).toString());
			lbl_Winning_Num2.setFont(new Font("맑은 고딕", Font.BOLD, 28));
			pnl_Winning.add(lbl_Winning_Num2);

			JLabel lbl_Winning_Num3 = new JLabel(winning_Numbers.get(2).toString());
			lbl_Winning_Num3.setFont(new Font("맑은 고딕", Font.BOLD, 28));
			pnl_Winning.add(lbl_Winning_Num3);

			JLabel lbl_Winning_Num4 = new JLabel(winning_Numbers.get(3).toString());
			lbl_Winning_Num4.setFont(new Font("맑은 고딕", Font.BOLD, 28));
			pnl_Winning.add(lbl_Winning_Num4);

			JLabel lbl_Winning_Num5 = new JLabel(winning_Numbers.get(4).toString());
			lbl_Winning_Num5.setFont(new Font("맑은 고딕", Font.BOLD, 28));
			pnl_Winning.add(lbl_Winning_Num5);

			JLabel lbl_Winning_Num6 = new JLabel(winning_Numbers.get(5).toString());
			lbl_Winning_Num6.setFont(new Font("맑은 고딕", Font.BOLD, 28));
			pnl_Winning.add(lbl_Winning_Num6);

			JLabel lbl_Winning_Plus = new JLabel("+");
			lbl_Winning_Plus.setFont(new Font("맑은 고딕", Font.BOLD, 28));
			pnl_Winning.add(lbl_Winning_Plus);

			JLabel lbl_Winning_Bouns = new JLabel(String.valueOf(bonusNumber));
			lbl_Winning_Bouns.setFont(new Font("맑은 고딕", Font.BOLD, 28));
			pnl_Winning.add(lbl_Winning_Bouns);
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
					// 디버그용
//					System.out.println("here" + " target의 " + j + "번째 " + lbl.getText());
				}
				numbers.add(tempLabelList);
				// 디버그용
//				for (int j = 0; j < 6; j++) {
//					System.out.println("잘들어있니" + numbers.get(i).get(j).getText());
//				}
			}

			for (int i = 0; i < size; i++) {
				choices[i] = new JPanel();
				ranks[i] = new JLabel("");
				isAutos[i] = new JLabel("");
				choices[i].setBackground(Color.WHITE);
			}

			for (int i = 0; i < size; i++) {
				ranks[i].setFont(new Font("맑은 고딕", Font.PLAIN, 18));
				choices[i].add(ranks[i]);
				isAutos[i].setFont(new Font("맑은 고딕", Font.PLAIN, 18));
				choices[i].add(isAutos[i]);
//				choices[i].add(numbers.get(i));
				for (int j = 0; j < 6; j++) {
					numbers.get(i).get(j).setFont(new Font("맑은 고딕", Font.PLAIN, 18));
					choices[i].add(numbers.get(i).get(j));
				}
				System.out.println("뭐가문제니");
				System.out.println(choices[i].getComponentCount());
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
						numbers.get(i).get(j).setForeground(new Color(255, 0, 0));
						count++;
					}
					// 보너스번호와 맞는 번호
					if (isInBonusNumber(numbers.get(i).get(j).getText())) {
						numbers.get(i).get(j).setForeground(new Color(0, 255, 0));
						isBonus = true;
					}
				}
				System.out.println("당첨번호랑 맞는 개수" + count);
				System.out.println("2등번호가 있는지" + isBonus);
				ranks[i].setText(isRank(count, isBonus));
				isAutos[i].setText(isAuto(tempList.get(index).getCount().get(i)));
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
		return "낙첨";
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

}
