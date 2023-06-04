package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import lottoProject.LottoPaper;

public class Receipt extends JDialog implements MouseListener {
	private JPanel contentPane;
	private Timer timer;
	private int windowHeight;
	private int animationSpeed;

	private JPanel[] choices;
	private JLabel[] isAutos;
	private JLabel[] numbers;
	private JLabel backLabel;
	
	
	public Receipt(LottoPaper lottoPaper) {

		setModal(true);

		System.out.println(lottoPaper.getCount().size()); // 카운트의 사이즈;
		setBounds(100, 100, 400, 10);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addMouseListener(this);
		
		int size = lottoPaper.getCount().size();

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
		lblNewLabel_3_2_1.setText("\\ " + size + ",000");
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
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		lottoPaper.setNowDate(LocalDate.now());
		lottoPaper.setNowTime(LocalTime.now());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = time.format(formatter);
		lblNewLabel_5.setText(date.toString() + " " + formattedTime);
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
			isAutos[i].setText(isAuto(lottoPaper.getCount().get(i)));
			String number = lottoPaper.getLotto().get(i).toString();
			String text = number.replace(",", " ");
			String text2 = text.replace("[", "").replace("]", "");
			numbers[i].setText(text2);
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(37, 219, 323, 4);
		contentPane.add(panel_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.activeCaption);
		panel_1_1.setBounds(37, 413, 323, 4);
		contentPane.add(panel_1_1);

		// 아래로 내려가는 애니메이션 속도 설정 (밀리초 단위)
		animationSpeed = 10;

		// 현재 창의 높이
		windowHeight = getHeight();

		// Timer를 사용하여 애니메이션을 구현
		timer = new Timer(animationSpeed, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 창의 높이를 2씩 증가시켜 창을 아래로 이동
				windowHeight += 2;
				setSize(getWidth(), windowHeight);

				// 원하는 창의 최대 높이에 도달하면 타이머를 멈춤
				if (windowHeight >= 560) {
					timer.stop();
				}
			}
		});

		// Timer 시작
		timer.start();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		windowHeight = 560;
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {	}
	@Override
	public void mouseExited(MouseEvent arg0) { }
	@Override
	public void mousePressed(MouseEvent arg0) {	}
	@Override
	public void mouseReleased(MouseEvent arg0) { }
}
