package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import lottoProject.LottoBuyingList;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import lottoProject.LottoPaper;
import lottoProject.RegiTiketManager;

public class BuyFrame extends JFrame {
	DepositFrame depositFrame = new DepositFrame(this);

	private JPanel contentPane;
	ArrayList<JButton> buttons; // 버튼 45개
	Set<Integer> buttonZip = new TreeSet<>(); // 로또 한줄
	Map<Integer, Set<Integer>> lottoMap; // 로또 5개 짜리 한장
	private List<Integer> autoCount = new ArrayList<>(); // 자동 반자동 리스트
	private List<LottoPaper> lottoMapList = new ArrayList<>();
	RegiTiketManager rtm = new RegiTiketManager(); // 생성자
	LottoPaper lottopaper = new LottoPaper(); // 생성자
	private LottoBuyingList lbl = new LottoBuyingList(); // 생성자
	private int count = 0; // 선택된 번호의 개수
	private int countList = 0; // 맵의 키 값
	int countNum = 0; // 자동 유무 확인하는 수치 임시저장 공간
	int 도박중독방지용 = 0;
	int price;
	int totalCost = 0;

	private JPanel[] choices;
	private JLabel[] isAutos;
	private JLabel[] numbers;
	private RoundButton[] btnResets;
	private RoundedButton button;
	private int labelClickindex = 0;
	private boolean isLabelClick = false;

	// 태경
	private void panelResetSetting(int i) {
		isAutos[i].setText("자동여부");
		numbers[i].setText("00 00 00 00 00 00");
		btnResets[i].setEnabled(false); // ????????????????
		// 여기가왜 true로 되어있는거지?
		RoundedButton btn = (RoundedButton) buttons.get(i);
		btn.decorate2();

	}

	public LottoPaper returnLottoPaper() {
		return lottopaper;
	}

	private void 라벨클릭액션리스너추가(MouseAdapter mouseAdapter) {
		for (int i = 0; i < 5; i++) {
			numbers[i].addMouseListener(mouseAdapter);
		}
	}

	private MouseAdapter 라벨클릭액션리스너() {
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				JLabel lbl2 = (JLabel) me.getSource();
				if (!lbl2.getText().equals("00 00 00 00 00 00")) { // 해당 리스트의 텍스트가 "00~"" 과 일치할때 자동 선택 불가
					btnAutoPlus.setEnabled(false);
					for (int i = 0; i < btnResets.length; i++) { // 해당 열의 초기화 길이값에 따라서 부분적 활성화
						btnResets[i].setEnabled(false);
					}
				} else {
					buttonZip.clear();
					for (int i = 0; i < autoCount.size(); i++) {
						btnResets[i].setEnabled(true);
					}
					btnAutoPlus.setEnabled(true);
				}

				for (int i = 0; i < 45; i++) {
					RoundedButton btn = (RoundedButton) buttons.get(i);
					btn.decorate();
				}

				isLabelClick = true;
				// System.out.println("라벨클릭됐음");
				int index = 0;
				JLabel lbl = (JLabel) me.getSource();
				for (int i = 0; i < 5; i++) {
					if (lbl.equals(numbers[i])) {
						index = i;
						break;
					}
				}
				// 선택한 라벨 숫자값 버튼올리기
				Set<Integer> mouseSet = lottopaper.getLotto().get(index);
				System.out.println(mouseSet);
				if (!(mouseSet == null)) {
					for (Integer set : mouseSet) {
						RoundedButton btn = (RoundedButton) buttons.get(set - 1);
						btn.decorate2();
						buttonZip.add(set);
					}
					labelClickindex = index;
				}

			} //
		};
		return mouseAdapter;
	}

	private JLabel lblMyMoney; // 예치금 표시 프레임
	private JLabel lblTotal; // 로또 개수에 따르는 지불받는 금액

	private RoundButton btnAutoPlus;

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
				int j = 0;
				for (int i = 0; i < 5; i++) {
					if (btn1.equals(btnResets[i])) {
						panelResetSetting(i);

						// System.out.println("i값 출력 : " + i);
						lottoMap.remove(i);
						autoCount.remove(i); // ??
						j = i;
						countList--;
						lblTotal.setText("총" + (countList * 1000) + "원");
						// System.out.println("여기가작동하냐?");
						btnResets[i].setEnabled(false);
						// System.out.println(btnResets[i].isEnabled());
						break;
					}
				}
				// System.out.println("가져온 로또맵" + lottoMap);
				for (int i = j; i < lottoMap.size(); i++) {
					Map<Integer, Set<Integer>> replaceMap = lottoMap;
					Set<Integer> replaceSet = replaceMap.get(i + 1);
					replaceMap.put(i, replaceSet);
				}
				resetBtnPrint();
			}
		};
		return actionlistener;
	}

	private void resetBtnPrint() {

		String str = "";
		int i;
		System.out.println("오토카운트 : " + autoCount);
		for (i = 0; i < autoCount.size(); i++) { // ?????????????????????????
			// System.out.println("오토카운트 사이즈 " + autoCount.size());
			Set<Integer> values = lottoMap.get(i);
			// System.out.println("왜 오류가뜰까 " + lottoMap);
			for (Integer set : values) {
				if (set < 10) {
					str += "0";
				}
				str += set + " ";
				System.out.println("str : " + str);
			}
			numbers[i].setText(str);
			isAutos[i].setText(rtm.자동버튼(autoCount.get(i)));
			btnResets[i].setEnabled(true);
			// btnResets[i].decorate();
			str = "";

		}
		for (int j = i; j < 5; j++) {
			panelResetSetting(j);
		}
		System.out.println("i : " + i);

		for (int k = 1; k <= 45; k++) {
			RoundedButton resetBtn = (RoundedButton) buttons.get(k - 1);
			resetBtn.decorate();
		}
	}

	private void selectNumPrint(Map<Integer, Set<Integer>> map, int count, int countList) {
		String str = "";

		Set<Integer> values = map.get(countList);
		for (Integer set : values) {
			if (set < 10) {
				str += "0";
			}
			str += set + " ";
		}
		numbers[countList].setText(str);
		isAutos[countList].setText(rtm.자동버튼(autoCount.get(countList)));
		btnResets[countList].setEnabled(true);
		// btnResets[countList].decorate();
	}

	public Map<Integer, Set<Integer>> returnMap() {
		return lottoMap;
	}

	public LottoPaper returnPaper() { // 로또 다섯줄
		return lottopaper;
	}

	public List<LottoPaper> returnMapList() { // 로또 페이퍼 묶음
		return lottoMapList;
	}

	public BuyFrame(MainFrame main) {

		setBackground(SystemColor.window);
		lottoMap = lottopaper.getLotto();
		lottoMapList = lbl.getBuyList();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel backLabel = new JLabel(new ImageIcon("back1.png"));
		backLabel.setBounds(0, 0, 1000, 600);
		contentPane.add(backLabel);

		JPanel pnlLottoNum = new JPanel();
		pnlLottoNum.setForeground(Color.BLACK);
		pnlLottoNum.setBackground(Color.WHITE);
		pnlLottoNum.setBounds(71, 62, 248, 282);
		backLabel.add(pnlLottoNum);
		pnlLottoNum.setLayout(new GridLayout(9, 5));

		// 45개의 로또 번호 버튼배열입니다
		buttons = new ArrayList<>();
		// 선택한 번호들을 입력하는 공간

		for (int i = 1; i <= 45; i++) {
			button = new RoundedButton(Integer.toString(i));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RoundedButton btn = (RoundedButton) e.getSource();
					for (int j = 1; j <= 45; j++) {
						RoundedButton pushBtn = (RoundedButton) buttons.get(j - 1);
						if (!pushBtn.isPossible()) {
							buttonZip.add(Integer.parseInt(pushBtn.getText()));
							// System.out.println("여기 무조건 하고있지?" + pushBtn.getText());
						}
						// System.out.println("범인이누구냐 " + buttonZip);
					}
					int cnt = buttonZip.size();
					if (btn.isPossible()) { // 분홍색
						if (cnt <= 5) {
							// 버튼 정보 보내줄 예정
							int bts = Integer.parseInt(btn.getText());
							buttonZip.add(bts);
							System.out.println(buttonZip);
							btn.decorate2();
							cnt++;
						}
					} else { // 회색

						// System.out.println("나한테왜이래" + buttonZip);

						int bts = Integer.parseInt(btn.getText());
						buttonZip.remove(bts);
						btn.decorate();
						cnt--;
					}

					count = cnt;

					System.out.println("여기맞아? " + buttonZip.size());

					if (count == 6) {
						countNum = count;
					}

				} // 함수

			}); // 액션리스너
			buttons.add(button);
			pnlLottoNum.add(button);

		}
		// for문

		JPanel pnlChoice = new JPanel();
		pnlChoice.setBackground(Color.WHITE);
		pnlChoice.setBounds(389, 98, 327, 235);
		backLabel.add(pnlChoice);

		choices = new JPanel[5];
		isAutos = new JLabel[5];
		numbers = new JLabel[5];
		btnResets = new RoundButton[5];

		for (int i = 0; i < 5; i++) {
			choices[i] = new JPanel();
			isAutos[i] = new JLabel("자동여부");
			numbers[i] = new JLabel("00 00 00 00 00 00");
			btnResets[i] = new RoundButton("초기화");
			choices[i].setBackground(Color.WHITE);
		}

		for (int i = 0; i < 5; i++) {
			pnlChoice.add(choices[i]);
			choices[i].add(isAutos[i]);
			choices[i].add(numbers[i]);
			isAutos[i].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
			numbers[i].setFont(new Font("맑은 고딕", Font.PLAIN, 18));
			btnResets[i] = new RoundButton("초기화");
			choices[i].add(btnResets[i]);
			btnResets[i].setEnabled(false);
		}
		for (int i = 0; i < 5; i++) { // 라벨 포커스 마우스리스너 정의
			numbers[i].addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
					LineBorder bb = new LineBorder(Color.WHITE, 2, true);
					JLabel lbl = (JLabel) e.getSource();
					lbl.setBorder(bb);
					lbl.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					LineBorder bb = new LineBorder(new Color(255, 207, 65), 2, true);
					JLabel lbl = (JLabel) e.getSource();
					lbl.setBorder(bb);
					lbl.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
				}

				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
		}

		RoundButton btnMain = new RoundButton("메인으로");
		btnMain.setBounds(655, 10, 97, 23);
		btnMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				main.setVisible(true);
			}
		});
		backLabel.add(btnMain);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(43, 362, 309, 37);
		backLabel.add(panel);

		btnAutoPlus = new RoundButton("자동버튼");
		btnAutoPlus.setBackground(SystemColor.menu);
		btnAutoPlus.setForeground(Color.PINK);
		btnAutoPlus.addActionListener(new ActionListener() {

			// 선택 화면에서 자동화를 담당하는 녀석
			public void actionPerformed(ActionEvent click) {
				System.out.println("자동버튼 카운트 출력 : " + count);

				int cnt = 0;
				for (int i = 1; i <= 45; i++) {
					RoundedButton btn = (RoundedButton) buttons.get(i - 1);
					if (!btn.isPossible()) {
						cnt++;
					}
				}

				if (cnt == 6) {
					for (int i = 0; i < buttons.size(); i++) {
						buttons.get(i).setEnabled(true);
						RoundedButton btn = (RoundedButton) buttons.get(i);
						btn.decorate();
						// System.out.println("오토카운트 : " + autoCount.get(i));
					}

					buttonZip = new TreeSet();
					while (buttonZip.size() < 6) {
						Random random = new Random();
						Integer randomNum = random.nextInt(45) + 1;
						buttonZip.add(randomNum);
						for (JButton elem : buttons) {
							if (elem.getText().equals(randomNum.toString())) {
								RoundedButton btn = (RoundedButton) elem;
								btn.decorate2();
							}
						}
						cnt = 6;
					}
					// isLabelClick = false;
				} else {

					if (count == 1) {
						countNum = count;
					} else if (count < 6) {
						countNum = count;
					}

					if (count < 6 && count >= 0) {
						// 선택하지 않은 번호 중에서 랜덤하게 선택
						Random random = new Random();
						while (buttonZip.size() < 6) {
							Integer randomNum = random.nextInt(45) + 1;
							buttonZip.add(randomNum);
							for (JButton elem : buttons) {
								if (elem.getText().equals(randomNum.toString())) {
									// elem.setEnabled(false); // 얘가 자동을 선택한 버튼을 비활성화 하는것같음
									RoundedButton btn = (RoundedButton) elem;
									btn.decorate2();
								}
							}
							count = 6;
						}
					}
					isLabelClick = false;
				}

				count = cnt;
			}
		});
		panel.add(btnAutoPlus);

		// 선택 및 등록화면에서 초기화 하는 용입니다. 선택화면 전체 리셋
		RoundButton btnResetList = new RoundButton("선택 초기화");
		btnResetList.setBackground(SystemColor.menu);
		btnResetList.setForeground(Color.PINK);
		btnResetList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("선택초기화 실행");

				for (int i = 1; i <= buttons.size(); i++) {
					RoundedButton btn = (RoundedButton) buttons.get(i - 1);
					btn.decorate();
				}
				buttonZip = new TreeSet();
				count = 0;
			}
		});
		panel.add(btnResetList);

		// 선택한 하나의 로또 를 전달하기 위한 메소드
		RoundButton btnPlus = new RoundButton("등록");
		btnPlus.setForeground(SystemColor.window);
		btnPlus.setBackground(Color.PINK);
		panel.add(btnPlus);

		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				btnAutoPlus.setEnabled(true);
				for (int i = 0; i < autoCount.size(); i++) {
					btnResets[i].setEnabled(true);
				}

				System.out.println("클릭 직후 카운트:" + count);
				if (countList < 5 || isLabelClick) {
					if (rtm.티켓등록(buttonZip.size())) {

						if (!isLabelClick) { // 라벨을 클릭하지않았을때
							System.out.println("라벨을 클릭하지 않았을때 -> 등록");
							// 이러한 조건에서 등록되야함.
							autoCount.add(countNum);
							lottoMap.put(countList, buttonZip);// 현재 0번째이기 때문에 숫자 0의 키를 가지는 맵
							selectNumPrint(lottoMap, count, countList);
							buttonZip = new TreeSet();
							count = 0;
							countList++;
							System.out.println(autoCount);
							for (int i = 0; i < buttons.size(); i++) {
								// buttons.get(i).setEnabled(true);
								RoundedButton btn = (RoundedButton) buttons.get(i);
								btn.decorate();
							}

							lbl.setBuyList(lottoMapList);
						} else if (isLabelClick) { // 라벨을 클릭했을때

							autoCount.remove(labelClickindex);
							// 이러한 조건에서 등록되야함.
							autoCount.add(labelClickindex, 6);
							lottoMap.put(labelClickindex, buttonZip);// 현재 0번째이기 때문에 숫자 0의 키를 가지는 맵
							selectNumPrint(lottoMap, count, labelClickindex);
							buttonZip = new TreeSet();
							count = 0;
							// countList++;
							System.out.println(autoCount);
							for (int i = 0; i < buttons.size(); i++) {
								// buttons.get(i).setEnabled(true);
								RoundedButton btn = (RoundedButton) buttons.get(i);
								btn.decorate();
							}

							lbl.setBuyList(lottoMapList);
						}

						isLabelClick = false;
						lbl.setBuyList(lottoMapList);

					} else if (buttonZip.size() < 6) {
						JOptionPane.showMessageDialog(null, "선택한 번호의 개수가 부족합니다.", "선택한 번호 개수 확인",
								JOptionPane.WARNING_MESSAGE);
//						buttonZip = new TreeSet();
//						count = 0;
//						for (int i = 0; i < buttons.size(); i++) {s
//							RoundedButton btn = (RoundedButton) buttons.get(i);
//							btn.decorate();
//						} 
						// 작동 안하는거 같은데 확인 필요;

					}

				} else {
					System.out.println("한장이 가득 찹니다.");
					System.out.println(lottoMap);
				}
				// 여기서 맵을 보내줘야 함.
				if (buttonZip.size() == 6) {
					for (JButton elem : buttons) { // 선택화면 불 켜기
						// elem.setEnabled(true);
						RoundedButton btn = (RoundedButton) elem;
						btn.decorate();
					}
				}
//				count = 0;
//				lottoMapList.add(lottopaper);// 로또를 여러장 가지기 위해 추가중 여기서 추가
//				System.out.println(lottoMapList.indexOf(1));  // 여러장 추가할때 사용예정
				System.out.println(lottoMap);
				lblTotal.setText("총" + (countList * 1000) + "원"); // 로또 추가된 수만큼 가격 책정

			}
		});

		RoundButton btnPayment = new RoundButton("결제하기");
		btnPayment.setForeground(SystemColor.window);
		btnPayment.setBackground(SystemColor.activeCaption);
		btnPayment.setBounds(408, 362, 170, 35);
		btnPayment.addActionListener(new ActionListener() {
//			PaymentCheckFrame pcf = new PaymentCheckFrame(BuyFrame.this);
			public void actionPerformed(ActionEvent arg0) {
//				pcf.isVisible();
				totalCost = depositFrame.getTotalCost(); // 결제를 위한 토탈코스트 변수

//				if()
				// if ( 선택된 게임수가 0이면 결제 버튼 못쓰게 )
				if (도박중독방지용 <= 100) {
					if (totalCost >= countList * 1000) {
						if (autoCount.size() != 0) {

							new PaymentCheckFrame(BuyFrame.this); // checkFrame에 보내기

						} else {
							JOptionPane.showMessageDialog(null, "\t 등록 된 게임이 없습니다.", "등록 확인",
									JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "\t예치금을 확인하세요(확인 클릭시 창이 닫힙니다.)", "금액확인",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "더이상 구매가 불가합니다.", "구매 한도 초과", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		backLabel.add(btnPayment);
		btnPayment.setFont(new Font("맑은 고딕", Font.BOLD, 17));

		RoundButton btnReset = new RoundButton("모두 초기화");
		btnReset.setForeground(SystemColor.activeCaption);
		btnReset.setBackground(SystemColor.menu);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < 5; i++) {

					btnResets[0].doClick();
				}
				lblTotal.setText("총" + (countList * 1000) + "원"); // 로또 추가된 수만큼 가격 책정
			}

		});
		btnReset.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnReset.setBounds(590, 362, 113, 35);
		backLabel.add(btnReset);

		결제초기화액션리스너추가(결제초기화액션리스너());
		라벨클릭액션리스너추가(라벨클릭액션리스너());

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(122, 10, 212, 37);
		backLabel.add(panel_1);

		lblMyMoney = new JLabel("예치금 : " + "원");

		panel_1.add(lblMyMoney);
		lblMyMoney.setForeground(Color.WHITE);
		lblMyMoney.setFont(new Font("맑은 고딕", Font.BOLD, 19));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.PINK, 2));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(56, 45, 278, 313);
		backLabel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.PINK, 2));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(56, 10, 69, 37);
		backLabel.add(panel_3);

		RoundButton btnReload = new RoundButton("충전");
		panel_3.add(btnReload);
		btnReload.setForeground(Color.PINK);
		btnReload.setBackground(SystemColor.menu);
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depositFrame.setVisible(true);
			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(SystemColor.activeCaption, 2));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(374, 78, 356, 274);
		backLabel.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.activeCaption);
		panel_5.setBounds(374, 43, 202, 37);
		backLabel.add(panel_5);

		lblTotal = new JLabel("총 0원");
		panel_5.add(lblTotal);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}

	public void setMyMoney(int totalCost) {
		lblMyMoney.setText("예치금 : " + totalCost + "원");
	}

	public void payCheckMentYes() {
		// lottopaper 초기화?

		// 한장에 입력받은 값을 담기
		lottopaper.setLotto(lottoMap);
		System.out.println("넣을 로또맵" + lottoMap);
		lottopaper.setCount(autoCount);

		lottoMapList.add(lottopaper);

		도박중독방지용 += autoCount.size();

		// 결제하러갈때 전체적인 초기화필요; '예'일 경우 필요한 동작 모으기
		// set 필요한 부분을 메소드로 만들기
		// 메소드로 만들면 payCheckMent프레임에서 메소드호출만 하면된다.
		lottopaper = new LottoPaper(); // 초기화
		lottoMap = new HashMap<>();
		autoCount = new ArrayList<>();
		count = 0;

		// get 필요한 부분
		System.out.println("현시점의 예치금: " + totalCost);
		System.out.println("현시점의 결제금액: " + countList * 1000);
		System.out.println("현시점의 카운트: " + countList);
		lblMyMoney.setText("예치금: " + (totalCost - (countList * 1000)) + "원"); // 결제한 만큼 차감된 값이 출력
		totalCost -= countList * 1000;
		depositFrame.setTotalCost(totalCost);

		countList = 0;

		lblTotal.setText("총" + (countList * 1000) + "원"); // 로또 추가된 수만큼 가격 책정

		for (int i = 0; i < 5; i++) {
			isAutos[i].setText("자동여부");
			numbers[i].setText("00 00 00 00 00 00");
		}

		// 이렇게 다 해줘야 새로운거 받을수있음;
		// 1개 선택하고 등록시 autoCount에 등록되지않게 해야함; - 처리함 등록처리부분에서 if문 안에 넣음
		// 자동4개 수동전부 1개 하면 0 0 0 0 6 0 이렇게 6개가 되버림
	}
}
