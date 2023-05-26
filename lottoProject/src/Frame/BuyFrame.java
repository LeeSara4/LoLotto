package Frame;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lottoProject.RegiTiketManager;

public class BuyFrame extends JFrame {

	private JPanel contentPane;
	ArrayList<JButton> buttons;
	private int count;
//	Set<Integer> numbers;
	Set<Integer> buttonZip = new TreeSet<>();
	int price;

	RegiTiketManager rtm = new RegiTiketManager();

	// Ticket ticket = new Ticket(numbers, price);
	/**
	 * Create the frame.
	 */
	public BuyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlLottoNum = new JPanel();
		pnlLottoNum.setBounds(55, 78, 248, 249);
		contentPane.add(pnlLottoNum);
		pnlLottoNum.setLayout(new GridLayout(9, 5));

		// 45개의 로또 번호 버튼배열입니다
		buttons = new ArrayList<>();
		// 선택한 번호들을 입력하는 공간

		for (int i = 1; i <= 45; i++) {
			JButton button = new JButton(Integer.toString(i));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (count < 6) {
						// 버튼 정보 보내줄 예정
						// numbers.add(Integer.parseInt(button.getText()));
						int bts = Integer.parseInt(button.getText());
						buttonZip.add(bts);

						System.out.println(buttonZip);
						button.setEnabled(false);
						if (count == 6) {
							button.setEnabled(true);
						}
						count++;
					}
				}
			});
			buttons.add(button);
			pnlLottoNum.add(button);
		}

		JPanel pnlChoice = new JPanel();
		pnlChoice.setBounds(339, 88, 327, 270);
		contentPane.add(pnlChoice);

		// ticket 부분 ! 수정했습니다
		JPanel choice1 = new JPanel();
		pnlChoice.add(choice1);
		JLabel isAuto1 = new JLabel("자동여부");
		choice1.add(isAuto1);
		JLabel number1 = new JLabel("00 00 00 00 00 00");
		choice1.add(number1);
		number1.setFont(new Font("굴림", Font.PLAIN, 22));
		JButton btnReset1 = new JButton("초기화");
		choice1.add(btnReset1);

		JPanel choice2 = new JPanel();
		pnlChoice.add(choice2);
		JLabel isAuto2 = new JLabel("자동여부");
		choice2.add(isAuto2);
		JLabel number2 = new JLabel("00 00 00 00 00 00");
		choice2.add(number2);
		number2.setFont(new Font("굴림", Font.PLAIN, 22));
		JButton btnReset2 = new JButton("초기화");
		choice2.add(btnReset2);

		JPanel choice3 = new JPanel();
		pnlChoice.add(choice3);
		JLabel isAuto3 = new JLabel("자동여부");
		choice3.add(isAuto3);
		JLabel number3 = new JLabel("00 00 00 00 00 00");
		choice3.add(number3);
		number3.setFont(new Font("굴림", Font.PLAIN, 22));
		JButton btnReset3 = new JButton("초기화");
		choice3.add(btnReset3);

		JPanel choice4 = new JPanel();
		pnlChoice.add(choice4);
		JLabel isAuto4 = new JLabel("자동여부");
		choice4.add(isAuto4);
		JLabel number4 = new JLabel("00 00 00 00 00 00");
		choice4.add(number4);
		number4.setFont(new Font("굴림", Font.PLAIN, 22));
		JButton btnReset4 = new JButton("초기화");
		choice4.add(btnReset4);

		JPanel choice5 = new JPanel();
		pnlChoice.add(choice5);
		JLabel isAuto5 = new JLabel("자동여부");
		choice5.add(isAuto5);
		JLabel number5 = new JLabel("00 00 00 00 00 00");
		choice5.add(number5);
		number5.setFont(new Font("굴림", Font.PLAIN, 22));
		JButton btnReset5 = new JButton("초기화");
		choice5.add(btnReset5);

		JPanel pnlSouth = new JPanel();
		pnlChoice.add(pnlSouth);

		JButton btnPayment = new JButton("결제하기");
		pnlSouth.add(btnPayment);
		btnPayment.setFont(new Font("굴림", Font.PLAIN, 20));

		JButton btnResetAll = new JButton("전체 초기화");
		pnlSouth.add(btnResetAll);

		JLabel lblTotal = new JLabel("***** 원");
		lblTotal.setFont(new Font("굴림", Font.PLAIN, 22));
		lblTotal.setBounds(365, 39, 95, 23);
		contentPane.add(lblTotal);

		JLabel lblMyMoney = new JLabel("예치금 : ***** 원");
		lblMyMoney.setFont(new Font("굴림", Font.PLAIN, 22));
		lblMyMoney.setBounds(62, 39, 188, 23);
		contentPane.add(lblMyMoney);

		JButton btnReload = new JButton("충전");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReload.setBounds(248, 39, 62, 23);
		contentPane.add(btnReload);

		JButton btnMain = new JButton("메인으로");
		btnMain.setBounds(544, 42, 97, 23);
		contentPane.add(btnMain);

		JPanel panel = new JPanel();
		panel.setBounds(22, 337, 303, 33);
		contentPane.add(panel);

		JButton btnAutoPlus = new JButton("자동버튼");
		btnAutoPlus.addActionListener(new ActionListener() {

			// 선택 화면에서 자동화를 담당하는 녀석
			public void actionPerformed(ActionEvent click) {
				if (count < 6) {
					// 선택하지 않은 번호 중에서 랜덤하게 선택
					Random random = new Random();
					while (buttonZip.size() < 6) {
						int randomNum = random.nextInt(45) + 1;
						buttonZip.add(randomNum);
					}
				}
				System.out.println(buttonZip);
			}
		});
		panel.add(btnAutoPlus);

		// 선택 및 등록화면에서 초기화 하는 용입니다. 선택화면 전체 리셋
		JButton btnResetList = new JButton("선택 초기화");
		btnResetList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel.add(btnResetList);

		// 선택한 하나의 로또 를 전달하기 위한 메소드
		JButton btnPlus = new JButton("등록");
		panel.add(btnPlus);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				if (rtm.티켓등록(buttonZip.size())) {
					// 이러한 조건에서 등록되야함.
				} else if (buttonZip.size() < 6) {
					System.out.println("선택한 수가 부족하다.");
				}
				// 여기서 맵을 보내줘야 함.
			}
		});
	}

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BuyFrame frame = new BuyFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
