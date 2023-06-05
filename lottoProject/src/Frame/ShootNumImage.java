package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class ShootNumImage extends JFrame {
	private Set<Integer> numbers = new TreeSet<>(); // 당첨 번호
	private int bonusNumber = 0; // 보너스 번호
	private JPanel contentPane;
	private List<Integer> nums;
	private int count = 0; // 타이머야... 타이머야....
	private int countBlitz = 0; // 타이머야... 타이머야....

	public Set<Integer> getNumbers() {
		return numbers;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}

	public void DrawWinningNumber() {
		Random random = new Random();
		while (numbers.size() < 6) {
			int number = random.nextInt(45) + 1;
			numbers.add(number);
		}
		boolean bool = true;
		while (bool) {
			bonusNumber = random.nextInt(45) + 1;
			if (!numbers.contains(bonusNumber)) {
				bool = false;
			}
		}
		nums = new ArrayList<>(numbers);
	}

	public void printNumbers() {
		System.out.println("당첨번호는 : ");
		for (int elem : numbers) {
			System.out.println(elem);
		}
		System.out.println("보너스 번호는: " + bonusNumber);
	}

	public ShootNumImage(final MainFrame main) {
		DrawWinningNumber();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JButton btnNewButton = new RoundButton("메인으로");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				main.setVisible(true);
				main.getBtnNewButton_3().setEnabled(true);
				main.getBtnNewButton_4().setEnabled(false);
				main.getBtnNewButton_2().setEnabled(false);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 93, 1000, 2);
		contentPane.add(panel);
		panel.setBackground(new Color(250,250,210));
		btnNewButton.setBounds(870, 36, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setEnabled(false);

		JLabel redJewel = new JLabel("");
		redJewel.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/1.png")));
		redJewel.setHorizontalAlignment(SwingConstants.CENTER);
		redJewel.setBounds(897, 134, 52, 50);
		contentPane.add(redJewel);
		redJewel.setVisible(false);

		final JLabel blitzStillHandsUp = new JLabel("");
		blitzStillHandsUp.setIcon(new ImageIcon(
				ShootNumImage.class.getResource("/imagepackage/\uB9C8\uC9C0\uB9C9 \uBC18\uBCF5\uC7AC\uC0DD.gif")));
		blitzStillHandsUp.setHorizontalAlignment(SwingConstants.CENTER);
		blitzStillHandsUp.setBounds(820, 280, 246, 228);
		contentPane.add(blitzStillHandsUp);
		blitzStillHandsUp.setVisible(false);

		final JLabel defaultCard0 = new JLabel();
		defaultCard0.setFont(new Font("Rosewood Std Regular", Font.PLAIN, 40));
		defaultCard0.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard0.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard0.setBounds(12, 133, 130, 229);
		contentPane.add(defaultCard0);

		final JLabel defaultCard1 = new JLabel();
		defaultCard1.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard1.setBounds(154, 133, 130, 229);
		contentPane.add(defaultCard1);
		defaultCard1.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));

		final JLabel defaultCard2 = new JLabel();
		defaultCard2.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard2.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard2.setBounds(296, 133, 130, 229);
		contentPane.add(defaultCard2);

		final JLabel defaultCard3 = new JLabel();
		defaultCard3.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard3.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard3.setBounds(438, 133, 130, 229);
		contentPane.add(defaultCard3);

		final JLabel defaultCard4 = new JLabel();
		defaultCard4.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard4.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard4.setBounds(580, 133, 130, 229);
		contentPane.add(defaultCard4);

		final JLabel defaultCard5 = new JLabel();
		defaultCard5.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard5.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard5.setBounds(722, 133, 130, 229);
		contentPane.add(defaultCard5);

		final JLabel defaultCard6 = new JLabel();
		defaultCard6.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard6.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard6.setBounds(858, 133, 130, 229);
		contentPane.add(defaultCard6);
		defaultCard6.setVisible(false);

		////////////////////// 아래쪽은 액션 연출 카드 들

		final JLabel actionCard0 = new JLabel();
		actionCard0.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard0.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard0.setBounds(12, 133, 130, 229);
		contentPane.add(actionCard0);

		final JLabel actionCard1 = new JLabel();
		actionCard1.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard1.setBounds(154, 133, 130, 229);
		actionCard1.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		contentPane.add(actionCard1);

		final JLabel actionCard2 = new JLabel();
		actionCard2.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard2.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard2.setBounds(296, 133, 130, 229);
		contentPane.add(actionCard2);

		final JLabel actionCard3 = new JLabel();
		actionCard3.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard3.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard3.setBounds(438, 133, 130, 229);
		contentPane.add(actionCard3);

		final JLabel actionCard4 = new JLabel();
		actionCard4.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard4.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard4.setBounds(580, 133, 130, 229);
		contentPane.add(actionCard4);

		final JLabel actionCard5 = new JLabel();
		actionCard5.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard5.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard5.setBounds(722, 133, 130, 229);
		contentPane.add(actionCard5);

		final JLabel actionCard6 = new JLabel();
		actionCard6.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard6.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard6.setBounds(858, 133, 130, 229);
		contentPane.add(actionCard6);
		actionCard6.setVisible(false);

		JLabel num_1 = new JLabel(nums.get(0).toString());
		num_1.setHorizontalAlignment(SwingConstants.CENTER);
		num_1.setForeground(Color.BLACK);
		num_1.setBounds(12, 133, 130, 229);
		contentPane.add(num_1);
		num_1.setFont(new Font("Nirmala UI", Font.BOLD, 40));

		JLabel num2 = new JLabel(nums.get(1).toString());
		num2.setHorizontalAlignment(SwingConstants.CENTER);
		num2.setBounds(154, 133, 130, 229);
		contentPane.add(num2);
		num2.setFont(new Font("Nirmala UI", Font.BOLD, 40));

		JLabel num3 = new JLabel(nums.get(2).toString());
		num3.setHorizontalAlignment(SwingConstants.CENTER);
		num3.setBounds(296, 133, 130, 229);
		contentPane.add(num3);
		num3.setFont(new Font("Nirmala UI", Font.BOLD, 40));

		JLabel num4 = new JLabel(nums.get(3).toString());
		num4.setHorizontalAlignment(SwingConstants.CENTER);
		num4.setBounds(438, 133, 130, 229);
		contentPane.add(num4);
		num4.setFont(new Font("Nirmala UI", Font.BOLD, 40));

		JLabel num5 = new JLabel(nums.get(4).toString());
		num5.setHorizontalAlignment(SwingConstants.CENTER);
		num5.setBounds(580, 133, 130, 229);
		contentPane.add(num5);
		num5.setFont(new Font("Nirmala UI", Font.BOLD, 40));

		JLabel num6 = new JLabel(nums.get(5).toString());
		num6.setHorizontalAlignment(SwingConstants.CENTER);
		num6.setBounds(722, 133, 130, 229);
		contentPane.add(num6);
		num6.setFont(new Font("Nirmala UI", Font.BOLD, 40));

		final JLabel bonus = new JLabel(String.valueOf(bonusNumber));
		bonus.setForeground(new Color(255, 0, 51));
		bonus.setHorizontalAlignment(SwingConstants.CENTER);
		bonus.setBackground(Color.RED);
		bonus.setBounds(875, 133, 97, 229);
		contentPane.add(bonus);
		bonus.setFont(new Font("Nirmala UI", Font.BOLD, 45));
		bonus.setVisible(false);

		final JLabel randomNum0 = new JLabel();
		randomNum0.setHorizontalAlignment(SwingConstants.CENTER);
		randomNum0.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		randomNum0.setBounds(12, 133, 130, 229);
		contentPane.add(randomNum0);

		final JLabel randomNum1 = new JLabel();
		randomNum1.setHorizontalAlignment(SwingConstants.CENTER);
		randomNum1.setBounds(154, 133, 130, 229);
		randomNum1.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		contentPane.add(randomNum1);

		final JLabel randomNum2 = new JLabel();
		randomNum2.setHorizontalAlignment(SwingConstants.CENTER);
		randomNum2.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		randomNum2.setBounds(296, 133, 130, 229);
		contentPane.add(randomNum2);

		final JLabel randomNum3 = new JLabel();
		randomNum3.setHorizontalAlignment(SwingConstants.CENTER);
		randomNum3.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		randomNum3.setBounds(438, 133, 130, 229);
		contentPane.add(randomNum3);

		final JLabel randomNum4 = new JLabel();
		randomNum4.setHorizontalAlignment(SwingConstants.CENTER);
		randomNum4.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		randomNum4.setBounds(580, 133, 130, 229);
		contentPane.add(randomNum4);

		final JLabel randomNum5 = new JLabel();
		randomNum5.setHorizontalAlignment(SwingConstants.CENTER);
		randomNum5.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		randomNum5.setBounds(722, 133, 130, 229);
		contentPane.add(randomNum5);

		final JLabel randomNum6 = new JLabel();
		randomNum6.setHorizontalAlignment(SwingConstants.CENTER);
		randomNum6.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		randomNum6.setBounds(858, 133, 130, 229);
		contentPane.add(randomNum6);
		randomNum6.setVisible(false);

		// 당첨 번호 6개 보여주기
		final Timer cardOpen = new Timer(2300, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCard0.setVisible(false);
				actionCard1.setVisible(false);
				actionCard2.setVisible(false);
				actionCard3.setVisible(false);
				actionCard4.setVisible(false);
				actionCard5.setVisible(false);
				randomNum0.setVisible(true);
				randomNum1.setVisible(true);
				randomNum2.setVisible(true);
				randomNum3.setVisible(true);
				randomNum4.setVisible(true);
				randomNum5.setVisible(true);

			}

		});
		/////////////// 보너스 카드 생성 예정
		final Timer bonusAction1 = new Timer(7500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (count == 0) {
					defaultCard6.setVisible(true);
					redJewel.setVisible(true);
				}
				count++;
			}
		});
		final Timer bonusAction2 = new Timer(8200, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count == 1) {
					defaultCard6.setVisible(false);

					actionCard6.setVisible(true);

				}
				count++;
			}
		});
		final Timer bonusAction3 = new Timer(11100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count == 2) {
					actionCard6.setVisible(false);
					bonus.setVisible(true);
					randomNum6.setVisible(true);
					btnNewButton.setEnabled(true);
				}
				count++;
			}
		});

		final JLabel blitzAuto = new JLabel("");
		blitzAuto.setHorizontalAlignment(SwingConstants.CENTER);
		blitzAuto.setIcon(new ImageIcon(ShootNumImage.class
				.getResource("/imagepackage/\uD314\uC774 \uB098\uAC00 \uC788\uB294 \uBCF8\uCCB4.gif")));
		blitzAuto.setBounds(773, 296, 211, 229);
		contentPane.add(blitzAuto);
		blitzAuto.setVisible(false);

		final JLabel blitzPunch = new JLabel("");
		blitzPunch
				.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uBE14\uCE20 \uD380\uCE58.gif")));
		blitzPunch.setHorizontalAlignment(SwingConstants.CENTER);
		blitzPunch.setBounds(771, 296, 201, 235);
		contentPane.add(blitzPunch);
		blitzPunch.setVisible(false);

		final JLabel blitzNomal = new JLabel("");
		blitzNomal.setIcon(new ImageIcon(
				ShootNumImage.class.getResource("/imagepackage/\uAE4C\uB531\uAE4C\uB532 \uBE14\uCE20.gif")));
		blitzNomal.setHorizontalAlignment(SwingConstants.CENTER);
		blitzNomal.setBounds(788, 296, 184, 235);
		contentPane.add(blitzNomal);
		blitzNomal.setVisible(false);

		// 카드 끌고 오기 왼 -> 오
		final JLabel movingCard0 = new JLabel("");
		movingCard0.setIcon(
				new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uB04C\uC5B4\uC62C \uCE74\uB4DC.png")));
		movingCard0.setHorizontalAlignment(SwingConstants.CENTER);
		movingCard0.setBounds(614, 322, 147, 229);
		contentPane.add(movingCard0);
		movingCard0.setVisible(false);

		final JLabel movingCard1 = new JLabel("");
		movingCard1.setIcon(
				new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uB04C\uC5B4\uC62C \uCE74\uB4DC.png")));
		movingCard1.setHorizontalAlignment(SwingConstants.CENTER);
		movingCard1.setBounds(496, 322, 147, 229);
		contentPane.add(movingCard1);
		movingCard1.setVisible(false);

		final JLabel movingCard2 = new JLabel("");
		movingCard2.setIcon(
				new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uB04C\uC5B4\uC62C \uCE74\uB4DC.png")));
		movingCard2.setHorizontalAlignment(SwingConstants.CENTER);
		movingCard2.setBounds(407, 322, 147, 229);
		contentPane.add(movingCard2);
		movingCard2.setVisible(false);

		final JLabel movingCard3 = new JLabel("");
		movingCard3.setIcon(
				new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uB04C\uC5B4\uC62C \uCE74\uB4DC.png")));
		movingCard3.setHorizontalAlignment(SwingConstants.CENTER);
		movingCard3.setBounds(313, 322, 147, 229);
		contentPane.add(movingCard3);
		movingCard3.setVisible(false);

		final JLabel movingCard4 = new JLabel("");
		movingCard4.setIcon(
				new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uB04C\uC5B4\uC62C \uCE74\uB4DC.png")));
		movingCard4.setHorizontalAlignment(SwingConstants.CENTER);
		movingCard4.setBounds(221, 322, 147, 229);
		contentPane.add(movingCard4);
		movingCard4.setVisible(false);

		final JLabel movingCard5 = new JLabel("");
		movingCard5.setIcon(
				new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uB04C\uC5B4\uC62C \uCE74\uB4DC.png")));
		movingCard5.setHorizontalAlignment(SwingConstants.CENTER);
		movingCard5.setBounds(137, 322, 147, 229);
		contentPane.add(movingCard5);
		movingCard5.setVisible(false);

		final JLabel movingCard6 = new JLabel("");
		movingCard6.setIcon(
				new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uB04C\uC5B4\uC62C \uCE74\uB4DC.png")));
		movingCard6.setHorizontalAlignment(SwingConstants.CENTER);
		movingCard6.setBounds(54, 322, 147, 229);
		contentPane.add(movingCard6);
		movingCard6.setVisible(false);

		// 블츠 팔 전진 왼 <- 오
		final JLabel shotArm1_0 = new JLabel("");
		shotArm1_0.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uC190 \uC804\uC9C4.gif")));
		shotArm1_0.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm1_0.setBounds(661, 322, 147, 229);
		contentPane.add(shotArm1_0);
		shotArm1_0.setVisible(false);

		final JLabel shotArm1_1 = new JLabel("");
		shotArm1_1.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uC190 \uC804\uC9C4.gif")));
		shotArm1_1.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm1_1.setBounds(557, 322, 147, 229);
		contentPane.add(shotArm1_1);
		shotArm1_1.setVisible(false);

		final JLabel shotArm1_2 = new JLabel("");
		shotArm1_2.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uC190 \uC804\uC9C4.gif")));
		shotArm1_2.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm1_2.setBounds(448, 322, 147, 229);
		contentPane.add(shotArm1_2);
		shotArm1_2.setVisible(false);

		final JLabel shotArm1_3 = new JLabel("");
		shotArm1_3.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uC190 \uC804\uC9C4.gif")));
		shotArm1_3.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm1_3.setBounds(337, 322, 147, 229);
		contentPane.add(shotArm1_3);
		shotArm1_3.setVisible(false);

		final JLabel shotArm1_4 = new JLabel("");
		shotArm1_4.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uC190 \uC804\uC9C4.gif")));
		shotArm1_4.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm1_4.setBounds(234, 322, 147, 229);
		contentPane.add(shotArm1_4);
		shotArm1_4.setVisible(false);

		final JLabel shotArm1_5 = new JLabel("");
		shotArm1_5.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uC190 \uC804\uC9C4.gif")));
		shotArm1_5.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm1_5.setBounds(154, 322, 147, 229);
		contentPane.add(shotArm1_5);
		shotArm1_5.setVisible(false);

		final JLabel shotArm1_6 = new JLabel("");
		shotArm1_6.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uC190 \uC804\uC9C4.gif")));
		shotArm1_6.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm1_6.setBounds(54, 322, 147, 229);
		contentPane.add(shotArm1_6);
		shotArm1_6.setVisible(false);

		final JLabel shotArm1_7 = new JLabel("");
		shotArm1_7.setIcon(new ImageIcon(
				ShootNumImage.class.getResource("/imagepackage/\uD314\uB9CC \uC654\uB2E4 \uAC14\uB2E4.gif")));
		shotArm1_7.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm1_7.setBounds(-33, 322, 147, 229);
		contentPane.add(shotArm1_7);
		shotArm1_7.setVisible(false);

		// 블츠 팔 유지
		final JLabel shotArm2_0 = new JLabel("");
		shotArm2_0.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uD314\uB9CC.gif")));
		shotArm2_0.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm2_0.setBounds(661, 322, 147, 229);
		contentPane.add(shotArm2_0);
		shotArm2_0.setVisible(false);

		final JLabel shotArm2_1 = new JLabel("");
		shotArm2_1.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uD314\uB9CC.gif")));
		shotArm2_1.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm2_1.setBounds(557, 322, 147, 229);
		contentPane.add(shotArm2_1);
		shotArm2_1.setVisible(false);

		final JLabel shotArm2_2 = new JLabel("");
		shotArm2_2.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uD314\uB9CC.gif")));
		shotArm2_2.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm2_2.setBounds(448, 322, 147, 229);
		contentPane.add(shotArm2_2);
		shotArm2_2.setVisible(false);

		final JLabel shotArm2_3 = new JLabel("");
		shotArm2_3.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uD314\uB9CC.gif")));
		shotArm2_3.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm2_3.setBounds(337, 322, 147, 229);
		contentPane.add(shotArm2_3);
		shotArm2_3.setVisible(false);

		final JLabel shotArm2_4 = new JLabel("");
		shotArm2_4.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uD314\uB9CC.gif")));
		shotArm2_4.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm2_4.setBounds(234, 322, 147, 229);
		contentPane.add(shotArm2_4);
		shotArm2_4.setVisible(false);

		final JLabel shotArm2_5 = new JLabel("");
		shotArm2_5.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uD314\uB9CC.gif")));
		shotArm2_5.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm2_5.setBounds(154, 322, 147, 229);
		contentPane.add(shotArm2_5);
		shotArm2_5.setVisible(false);

		final JLabel shotArm2_6 = new JLabel("");
		shotArm2_6.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uD314\uB9CC.gif")));
		shotArm2_6.setHorizontalAlignment(SwingConstants.CENTER);
		shotArm2_6.setBounds(54, 322, 147, 229);
		contentPane.add(shotArm2_6);
		shotArm2_6.setVisible(false);

		// 팔들기
		final JLabel blitzHandsUp = new JLabel("");
		blitzHandsUp.setIcon(new ImageIcon(ShootNumImage.class
				.getResource("/imagepackage/\uCE74\uB4DC \uAC00\uC838\uC640\uC11C \uC62C\uB9AC\uAE30.gif")));
		blitzHandsUp.setHorizontalAlignment(SwingConstants.CENTER);
		blitzHandsUp.setBounds(785, 280, 220, 229);
		contentPane.add(blitzHandsUp);
		blitzHandsUp.setVisible(false);

		// 움직여라 블리츠!
		final Timer blitzAction1 = new Timer(100, new ActionListener() {
			// 블리츠 확인용 메세지
			@Override
			public void actionPerformed(ActionEvent e) {
				if (countBlitz == 30) {
					blitzNomal.setVisible(true);
				} else if (countBlitz == 40) {
					blitzNomal.setVisible(false);
					blitzPunch.setVisible(true);
				} else if (countBlitz == 42) {
					blitzPunch.setVisible(false);
					blitzAuto.setVisible(true);
				} else if (countBlitz == 44) {
					shotArm1_0.setVisible(true);
				} else if (countBlitz == 45) {
					shotArm1_0.setVisible(false);
					shotArm2_0.setVisible(true);
					shotArm1_1.setVisible(true);
				} else if (countBlitz == 46) {
					shotArm1_1.setVisible(false);
					shotArm2_1.setVisible(true);
					shotArm1_2.setVisible(true);
				} else if (countBlitz == 47) {
					shotArm1_2.setVisible(false);
					shotArm2_2.setVisible(true);
					shotArm1_3.setVisible(true);
				} else if (countBlitz == 48) {
					shotArm1_3.setVisible(false);
					shotArm2_3.setVisible(true);
					shotArm1_4.setVisible(true);
				} else if (countBlitz == 49) {
					shotArm1_4.setVisible(false);
					shotArm2_4.setVisible(true);
					shotArm1_5.setVisible(true);
				} else if (countBlitz == 50) {
					shotArm1_5.setVisible(false);
					shotArm2_5.setVisible(true);
					shotArm1_6.setVisible(true);
				} else if (countBlitz == 51) {
					shotArm1_6.setVisible(false);
					shotArm2_6.setVisible(true);
					shotArm1_7.setVisible(true);
				} else if (countBlitz == 52) {
					shotArm1_7.setVisible(false);
					movingCard6.setVisible(true);
				} else if (countBlitz == 53) {
					shotArm2_6.setVisible(false);
					movingCard6.setVisible(false);
					movingCard5.setVisible(true);
				} else if (countBlitz == 54) {
					shotArm2_5.setVisible(false);
					movingCard5.setVisible(false);
					movingCard4.setVisible(true);
				} else if (countBlitz == 55) {
					shotArm2_4.setVisible(false);
					movingCard4.setVisible(false);
					movingCard3.setVisible(true);
				} else if (countBlitz == 56) {
					shotArm2_3.setVisible(false);
					movingCard3.setVisible(false);
					movingCard2.setVisible(true);
				} else if (countBlitz == 57) {
					shotArm2_2.setVisible(false);
					movingCard2.setVisible(false);
					movingCard1.setVisible(true);
				} else if (countBlitz == 58) {
					shotArm2_1.setVisible(false);
					movingCard1.setVisible(false);
					movingCard0.setVisible(true);
				} else if (countBlitz == 59) {
					shotArm2_0.setVisible(false);
					movingCard0.setVisible(false);
					blitzAuto.setVisible(false);
					blitzHandsUp.setVisible(true);
				} else if (countBlitz == 67) {
					blitzHandsUp.setVisible(false);
					blitzStillHandsUp.setVisible(true);
				}
				countBlitz++;
			}
		});

		// 카드 오픈
		final JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent open) {
				btnNewButton_1.setVisible(false);
				defaultCard0.setVisible(false);
				defaultCard1.setVisible(false);
				defaultCard2.setVisible(false);
				defaultCard3.setVisible(false);
				defaultCard4.setVisible(false);
				defaultCard5.setVisible(false);

				randomNum0.setVisible(false);
				randomNum1.setVisible(false);
				randomNum2.setVisible(false);
				randomNum3.setVisible(false);
				randomNum4.setVisible(false);
				randomNum5.setVisible(false);
				cardOpen.start();
				bonusAction1.start();
				bonusAction2.start();
				bonusAction3.start();
				blitzAction1.start();

			}
		});

		btnNewButton_1
				.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uCD94\uCCA8 \uBC84\uD2BC.png")));
		btnNewButton_1.setBounds(348, 433, 220, 75);
		contentPane.add(btnNewButton_1);

		JLabel jandi1 = new JLabel("");
		jandi1.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uD4801.png")));
		jandi1.setBounds(-194, 411, 748, 189);
		contentPane.add(jandi1);

		JLabel Jandi2 = new JLabel("");
		Jandi2.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/\uD4802.png")));
		Jandi2.setBounds(444, 411, 561, 189);
		contentPane.add(Jandi2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/배경라벨이미지.png")));
		lblNewLabel.setBounds(0, 0, 1000, 600);
		contentPane.add(lblNewLabel);

		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(10, 10, 200, 80);
		ImageIcon logoIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/리그오브로또.png"));
		Image img = logoIcon.getImage();
		Image updateImage = img.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon updateLogoIcon = new ImageIcon(updateImage);
		logoLabel.setIcon(updateLogoIcon);
		lblNewLabel.add(logoLabel);
	}
}
