package Frame;

import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ShootNumImage extends JFrame {
	private Set<Integer> numbers = new TreeSet<>(); // 당첨 번호
	private int bonusNumber = 0; // 보너스 번호

	private JPanel contentPane;
	private List<Integer> nums;

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

	public ShootNumImage(MainFrame main) {
		DrawWinningNumber();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
			}
		});

		btnNewButton.setBounds(875, 10, 97, 23);
		contentPane.add(btnNewButton);

		JLabel defaultCard0 = new JLabel();
		defaultCard0.setFont(new Font("Rosewood Std Regular", Font.PLAIN, 40));
		defaultCard0.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard0.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard0.setBounds(12, 133, 130, 229);
		contentPane.add(defaultCard0);

		JLabel defaultCard1 = new JLabel();
		defaultCard1.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard1.setBounds(154, 133, 130, 229);
		contentPane.add(defaultCard1);
		defaultCard1.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));

		JLabel defaultCard2 = new JLabel();
		defaultCard2.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard2.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard2.setBounds(296, 133, 130, 229);
		contentPane.add(defaultCard2);

		JLabel defaultCard3 = new JLabel();
		defaultCard3.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard3.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard3.setBounds(438, 133, 130, 229);
		contentPane.add(defaultCard3);

		JLabel defaultCard4 = new JLabel();
		defaultCard4.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard4.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard4.setBounds(580, 133, 130, 229);
		contentPane.add(defaultCard4);

		JLabel defaultCard5 = new JLabel();
		defaultCard5.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard5.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard5.setBounds(722, 133, 130, 229);
		contentPane.add(defaultCard5);

		JLabel defaultCard6 = new JLabel();
		defaultCard6.setHorizontalAlignment(SwingConstants.CENTER);
		defaultCard6.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 기본.gif")));
		defaultCard6.setBounds(858, 133, 130, 229);
		contentPane.add(defaultCard6);

		////////////////////// 아래쪽은 액션 연출 카드 들

		JLabel actionCard0 = new JLabel();
		actionCard0.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard0.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard0.setBounds(12, 133, 130, 229);
		contentPane.add(actionCard0);

		JLabel actionCard1 = new JLabel();
		actionCard1.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard1.setBounds(154, 133, 130, 229);
		actionCard1.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		contentPane.add(actionCard1);

		JLabel actionCard2 = new JLabel();
		actionCard2.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard2.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard2.setBounds(296, 133, 130, 229);
		contentPane.add(actionCard2);

		JLabel actionCard3 = new JLabel();
		actionCard3.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard3.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard3.setBounds(438, 133, 130, 229);
		contentPane.add(actionCard3);

		JLabel actionCard4 = new JLabel();
		actionCard4.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard4.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard4.setBounds(580, 133, 130, 229);
		contentPane.add(actionCard4);

		JLabel actionCard5 = new JLabel();
		actionCard5.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard5.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard5.setBounds(722, 133, 130, 229);
		contentPane.add(actionCard5);

		JLabel actionCard6 = new JLabel();
		actionCard6.setHorizontalAlignment(SwingConstants.CENTER);
		actionCard6.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/카드 액션.gif")));
		actionCard6.setBounds(858, 133, 130, 229);
		contentPane.add(actionCard6);

		JLabel num_1 = new JLabel(nums.get(0).toString());
		num_1.setHorizontalAlignment(SwingConstants.CENTER);
		num_1.setForeground(Color.BLACK);
		num_1.setBounds(12, 133, 130, 229);
		contentPane.add(num_1);
		num_1.setFont(new Font("Rosewood Std Regular", Font.BOLD, 40));
		
				JLabel num2 = new JLabel(nums.get(1).toString());
				num2.setHorizontalAlignment(SwingConstants.CENTER);
				num2.setBounds(154, 133, 130, 229);
				contentPane.add(num2);
				num2.setFont(new Font("Rosewood Std Regular", Font.BOLD, 40));
		
				JLabel num3 = new JLabel(nums.get(2).toString());
				num3.setHorizontalAlignment(SwingConstants.CENTER);
				num3.setBounds(296, 133, 130, 229);
				contentPane.add(num3);
				num3.setFont(new Font("Rosewood Std Regular", Font.BOLD, 40));
		
				JLabel num4 = new JLabel(nums.get(3).toString());
				num4.setHorizontalAlignment(SwingConstants.CENTER);
				num4.setBounds(438, 133, 130, 229);
				contentPane.add(num4);
				num4.setFont(new Font("Rosewood Std Regular", Font.BOLD, 40));
		
				JLabel num5 = new JLabel(nums.get(4).toString());
				num5.setHorizontalAlignment(SwingConstants.CENTER);
				num5.setBounds(580, 133, 130, 229);
				contentPane.add(num5);
				num5.setFont(new Font("Rosewood Std Regular", Font.BOLD, 40));
		
				JLabel num6 = new JLabel(nums.get(5).toString());
				num6.setHorizontalAlignment(SwingConstants.CENTER);
				num6.setBounds(722, 133, 130, 229);
				contentPane.add(num6);
				num6.setFont(new Font("Rosewood Std Regular", Font.BOLD, 40));
		
				JLabel bonus = new JLabel(String.valueOf(bonusNumber));
				bonus.setForeground(new Color(210, 180, 140));
				bonus.setHorizontalAlignment(SwingConstants.CENTER);
				bonus.setBackground(Color.RED);
				bonus.setBounds(875, 133, 97, 229);
				contentPane.add(bonus);
				bonus.setFont(new Font("Rosewood Std Regular", Font.BOLD, 45));

		JLabel radomNum0 = new JLabel();
		radomNum0.setHorizontalAlignment(SwingConstants.CENTER);
		radomNum0.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		radomNum0.setBounds(12, 133, 130, 229);
		contentPane.add(radomNum0);

		JLabel radomNum1 = new JLabel();
		radomNum1.setHorizontalAlignment(SwingConstants.CENTER);
		radomNum1.setBounds(154, 133, 130, 229);
		radomNum1.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		contentPane.add(radomNum1);

		JLabel radomNum2 = new JLabel();
		radomNum2.setHorizontalAlignment(SwingConstants.CENTER);
		radomNum2.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		radomNum2.setBounds(296, 133, 130, 229);
		contentPane.add(radomNum2);

		JLabel radomNum3 = new JLabel();
		radomNum3.setHorizontalAlignment(SwingConstants.CENTER);
		radomNum3.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		radomNum3.setBounds(438, 133, 130, 229);
		contentPane.add(radomNum3);

		JLabel radomNum4 = new JLabel();
		radomNum4.setHorizontalAlignment(SwingConstants.CENTER);
		radomNum4.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		radomNum4.setBounds(580, 133, 130, 229);
		contentPane.add(radomNum4);

		JLabel radomNum5 = new JLabel();
		radomNum5.setHorizontalAlignment(SwingConstants.CENTER);
		radomNum5.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		radomNum5.setBounds(722, 133, 130, 229);
		contentPane.add(radomNum5);

		JLabel radomNum6 = new JLabel();
		radomNum6.setHorizontalAlignment(SwingConstants.CENTER);
		radomNum6.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/추첨번호배경.gif")));
		radomNum6.setBounds(858, 133, 130, 229);
		contentPane.add(radomNum6);

		Timer cardOpen = new Timer(2500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCard0.setVisible(false);
				actionCard1.setVisible(false);
				actionCard2.setVisible(false);
				actionCard3.setVisible(false);
				actionCard4.setVisible(false);
				actionCard5.setVisible(false);
				actionCard6.setVisible(false);
				radomNum0.setVisible(true);
				radomNum1.setVisible(true);
				radomNum2.setVisible(true);
				radomNum3.setVisible(true);
				radomNum4.setVisible(true);
				radomNum5.setVisible(true);
				radomNum6.setVisible(true);
			}
		});

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent open) {

				defaultCard0.setVisible(false);
				defaultCard1.setVisible(false);
				defaultCard2.setVisible(false);
				defaultCard3.setVisible(false);
				defaultCard4.setVisible(false);
				defaultCard5.setVisible(false);
				defaultCard6.setVisible(false);
				radomNum0.setVisible(false);
				radomNum1.setVisible(false);
				radomNum2.setVisible(false);
				radomNum3.setVisible(false);
				radomNum4.setVisible(false);
				radomNum5.setVisible(false);
				radomNum6.setVisible(false);
				cardOpen.start();

			}
		});

		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\팀4이미지\\KakaoTalk_20230601_214306061.png"));
		btnNewButton_1.setBounds(368, 472, 177, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/블리츠크랭크.gif")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(791, 313, 197, 195);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShootNumImage.class.getResource("/imagepackage/배경라벨이미지.png")));
		lblNewLabel.setBounds(0, 0, 1000, 600);
		contentPane.add(lblNewLabel);

	}
}
