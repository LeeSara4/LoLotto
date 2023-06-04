package Frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
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
	private JLabel backgroundLabel;
	private JLabel centerLabel;
	
	
	public Receipt(LottoPaper lottoPaper) {

		setModal(true);

		System.out.println(lottoPaper.getCount().size()); // 카운트의 사이즈;
		setBounds(100, 100, 400, 10); //10 이었음
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addMouseListener(this);
		
		backgroundLabel = new JLabel();
		//backgroundLabel.setBounds(0, 0, 384, 661);
		backgroundLabel.setIcon(new ImageIcon(BuyList.class.getResource("/imagepackage/배경라벨이미지.png")));
		backgroundLabel.setBounds(0, 0, 1000, 600);
		contentPane.add(backgroundLabel);
		
		int size = lottoPaper.getCount().size();

		JLabel lblNewLabel_3 = new JLabel("발 행 일 :");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(250, 250, 210));
		lblNewLabel_3.setBounds(37, 160, 83, 15);
		backgroundLabel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("추 첨 일 :");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_3_1.setForeground(new Color(250, 250, 210));
		lblNewLabel_3_1.setBounds(37, 185, 74, 15);
		backgroundLabel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("금액");
		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_3_2.setForeground(new Color(250, 250, 210));
		lblNewLabel_3_2.setBounds(51, 432, 83, 37);
		backgroundLabel.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_2_1 = new JLabel("\\ 5,000");
		lblNewLabel_3_2_1.setText("\\ " + size + ",000");
		lblNewLabel_3_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_3_2_1.setForeground(new Color(250, 250, 210));
		lblNewLabel_3_2_1.setBounds(277, 432, 83, 37);
		backgroundLabel.add(lblNewLabel_3_2_1);

		JLabel lblNewLabel_5 = new JLabel("2023 / 06 / 07 (수)");
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		lottoPaper.setNowDate(LocalDate.now());
		lottoPaper.setNowTime(LocalTime.now());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = time.format(formatter);
		lblNewLabel_5.setText(date.toString() + " " + formattedTime);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_5.setForeground(new Color(250, 250, 210));
		lblNewLabel_5.setBounds(114, 162, 160, 15);
		backgroundLabel.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("2023-06-10 21:00:00");
		lblNewLabel_5_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lblNewLabel_5_1.setForeground(new Color(250, 250, 210));
		lblNewLabel_5_1.setBounds(114, 185, 160, 15);
		backgroundLabel.add(lblNewLabel_5_1);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(67, 222, 267, 190);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		backgroundLabel.add(panel);

		centerLabel = new JLabel();
		//centerLabel.setBounds(42, 478, 237, 173);
		centerLabel.setBounds(42, 478, 237, 177);
		ImageIcon centerIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/영수증안쪽.png"));
		Image centerImg = centerIcon.getImage();
		Image updateCenterImage = centerImg.getScaledInstance(panel.getWidth(), panel.getHeight(),
				Image.SCALE_SMOOTH);
		System.out.println(panel.getWidth());
		ImageIcon updateCenterIcon = new ImageIcon(updateCenterImage);
		centerLabel.setIcon(updateCenterIcon);
		centerLabel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(centerLabel);
		panel.setOpaque(false);
		
		choices = new JPanel[size];
		isAutos = new JLabel[size];
		numbers = new JLabel[size];

		for (int i = 0; i < size; i++) {
			choices[i] = new JPanel();
			isAutos[i] = new JLabel("");
			numbers[i] = new JLabel("");
			choices[i].setOpaque(false);
			//choices[i].setBackground(Color.WHITE);
		}

		for (int i = 0; i < size; i++) {
			choices[i].add(isAutos[i]);
			choices[i].add(numbers[i]);
			isAutos[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			isAutos[i].setForeground(new Color(250, 250, 210));
			numbers[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			numbers[i].setForeground(new Color(250, 250, 210));
			centerLabel.add(choices[i]);
		}

		for (int i = 0; i < size; i++) {
			isAutos[i].setText(isAuto(lottoPaper.getCount().get(i)));
			String number = lottoPaper.getLotto().get(i).toString();
			String text = number.replace(",", " ");
			String text2 = text.replace("[", "").replace("]", "");
			numbers[i].setText(text2);
		}
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(67, 20, 267, 112);
		backgroundLabel.add(logoLabel);
		ImageIcon logoIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/리그오브로또.png"));
		Image img = logoIcon.getImage();
		Image updateImage = img.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon updateLogoIcon = new ImageIcon(updateImage);
		logoLabel.setIcon(updateLogoIcon);
		
		JLabel upLabel = new JLabel();
		upLabel.setBounds(27, 219, 330, 29);
		ImageIcon upIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/위.png"));
		Image upImg = upIcon.getImage();
		Image updateImage2 = upImg.getScaledInstance(upLabel.getWidth(), upLabel.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon updateUpIcon = new ImageIcon(updateImage2);
		upLabel.setIcon(updateUpIcon);
		backgroundLabel.add(upLabel);
		
		
		
		JLabel downLabel = new JLabel("New label");
		downLabel.setBounds(34, 412, 337, 15);
		ImageIcon downIcon = new ImageIcon(BuyList.class.getResource("/imagepackage/아래.png"));
		Image downImage = downIcon.getImage();
		Image updateDownImage = downImage.getScaledInstance(downLabel.getWidth(), downLabel.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon updateDownIcon = new ImageIcon(updateDownImage);
		downLabel.setIcon(updateDownIcon);
		
		backgroundLabel.add(downLabel);
		
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
