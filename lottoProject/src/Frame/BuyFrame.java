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
	/*
	 * private JButton btnReset1; private JButton btnReset2; private JButton
	 * btnReset3; private JButton btnReset4; private JButton btnReset5;
	 */
	private JPanel[] choices;
	private JLabel[] isAutos;
	private JLabel[] numbers;
	private JButton[] btnResets;

	// Ticket ticket = new Ticket(numbers, price);
	/**
	 * Create the frame.
	 */
	private void 결제초기화액션리스너추가(ActionListener actionlistener) {
		for (int i = 0; i < 5; i++) {
			btnResets[i].addActionListener(actionlistener);
		}
	}
	private ActionListener 결제초기화액션리스너() {
		ActionListener actionlistener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn1 = (JButton) e.getSource();
				for (int i = 0; i < 5; i++) {
					if (btn1.equals(btnResets[i])) {
						isAutos[i].setText("자동여부");
						numbers[i].setText("00 00 00 00 00 00");
						System.out.println(i + 1 + "번째 초기화");
					}
				}
			}
		};
		return actionlistener;
	}
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

		choices = new JPanel[5];
		isAutos = new JLabel[5];
		numbers = new JLabel[5];
		btnResets = new JButton[5];

		for (int i = 0; i < 5; i++) {
			choices[i] = new JPanel();
			isAutos[i] = new JLabel("자동여부");
			numbers[i] = new JLabel("00 00 00 00 00 00");
			btnResets[i] = new JButton("초기화");
		}

		for (int i = 0; i < 5; i++) {
			pnlChoice.add(choices[i]);
			choices[i].add(isAutos[i]);
			choices[i].add(numbers[i]);
			numbers[i].setFont(new Font("굴림", Font.PLAIN, 22));
			btnResets[i] = new JButton("초기화");
			choices[i].add(btnResets[i]);
		}

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
		결제초기화액션리스너추가(결제초기화액션리스너());
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
