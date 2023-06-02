package Frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\팀4이미지\\카드 기본 연출.gif"));
		lblNewLabel_2_2.setBounds(567, 80, 127, 233);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_4 = new JLabel("New label");
		lblNewLabel_2_4.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\팀4이미지\\카드 액션.gif"));
		lblNewLabel_2_4.setBounds(845, 80, 127, 233);
		contentPane.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\팀4이미지\\카드 기본 연출.gif"));
		lblNewLabel_2_1.setBounds(429, 80, 127, 233);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\1.gif"));
		lblNewLabel.setBounds(12, 80, 127, 233);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\팀4이미지\\카드 액션.gif"));
		lblNewLabel_2.setBounds(290, 80, 127, 233);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\카드 기본 연출.gif"));
		lblNewLabel_1.setBounds(151, 80, 127, 233);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2_3 = new JLabel("New label");
		lblNewLabel_2_3.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\1.gif"));
		lblNewLabel_2_3.setBounds(706, 80, 127, 233);
		contentPane.add(lblNewLabel_2_3);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\팀4이미지\\KakaoTalk_20230601_214306061.png"));
		btnNewButton_1.setBounds(379, 374, 177, 36);
		contentPane.add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(213, 420, 532, 81);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel num_1 = new JLabel(nums.get(0).toString());
		num_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel.add(num_1);

		JLabel num3 = new JLabel(nums.get(2).toString());
		num3.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel.add(num3);

		JLabel num4 = new JLabel(nums.get(3).toString());
		num4.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel.add(num4);

		JLabel num5 = new JLabel(nums.get(4).toString());
		num5.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel.add(num5);

		JLabel num2 = new JLabel(nums.get(1).toString());
		num2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel.add(num2);

		JLabel num6 = new JLabel(nums.get(5).toString());
		num6.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel.add(num6);

		JLabel plus = new JLabel("+");
		plus.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel.add(plus);

		JLabel bonus = new JLabel(String.valueOf(bonusNumber));
		bonus.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel.add(bonus);

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
	}
}
