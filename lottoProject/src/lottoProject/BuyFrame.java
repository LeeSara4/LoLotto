package lottoProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BuyFrame extends JFrame {

	private JPanel contentPane;

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
		
		JButton btn1 = new JButton("1");
		pnlLottoNum.add(btn1);
		
		JButton btn2 = new JButton("2");
		pnlLottoNum.add(btn2);
		
		JButton btn3 = new JButton("3");
		pnlLottoNum.add(btn3);
		
		JButton btn4 = new JButton("4");
		pnlLottoNum.add(btn4);
		
		JButton btn5 = new JButton("5");
		pnlLottoNum.add(btn5);
		
		JButton btn1_1 = new JButton("1");
		pnlLottoNum.add(btn1_1);
		
		JButton btn2_1 = new JButton("2");
		pnlLottoNum.add(btn2_1);
		
		JButton btn3_1 = new JButton("3");
		pnlLottoNum.add(btn3_1);
		
		JButton btn4_1 = new JButton("4");
		pnlLottoNum.add(btn4_1);
		
		JButton btn5_1 = new JButton("5");
		pnlLottoNum.add(btn5_1);
		
		JButton btn1_2 = new JButton("1");
		pnlLottoNum.add(btn1_2);
		
		JButton btn2_2 = new JButton("2");
		pnlLottoNum.add(btn2_2);
		
		JButton btn3_2 = new JButton("3");
		pnlLottoNum.add(btn3_2);
		
		JButton btn4_2 = new JButton("4");
		pnlLottoNum.add(btn4_2);
		
		JButton btn5_2 = new JButton("5");
		pnlLottoNum.add(btn5_2);
		
		JButton btn1_3 = new JButton("1");
		pnlLottoNum.add(btn1_3);
		
		JButton btn2_3 = new JButton("2");
		pnlLottoNum.add(btn2_3);
		
		JButton btn3_3 = new JButton("3");
		pnlLottoNum.add(btn3_3);
		
		JButton btn4_3 = new JButton("4");
		pnlLottoNum.add(btn4_3);
		
		JButton btn5_3 = new JButton("5");
		pnlLottoNum.add(btn5_3);
		
		JButton btn1_4 = new JButton("1");
		pnlLottoNum.add(btn1_4);
		
		JButton btn2_4 = new JButton("2");
		pnlLottoNum.add(btn2_4);
		
		JButton btn3_4 = new JButton("3");
		pnlLottoNum.add(btn3_4);
		
		JButton btn4_4 = new JButton("4");
		pnlLottoNum.add(btn4_4);
		
		JButton btn5_4 = new JButton("5");
		pnlLottoNum.add(btn5_4);
		
		JButton btn1_5 = new JButton("1");
		pnlLottoNum.add(btn1_5);
		
		JButton btn2_5 = new JButton("2");
		pnlLottoNum.add(btn2_5);
		
		JButton btn3_5 = new JButton("3");
		pnlLottoNum.add(btn3_5);
		
		JButton btn4_5 = new JButton("4");
		pnlLottoNum.add(btn4_5);
		
		JButton btn5_5 = new JButton("5");
		pnlLottoNum.add(btn5_5);
		
		JButton btn1_6 = new JButton("1");
		pnlLottoNum.add(btn1_6);
		
		JButton btn2_6 = new JButton("2");
		pnlLottoNum.add(btn2_6);
		
		JButton btn3_6 = new JButton("3");
		pnlLottoNum.add(btn3_6);
		
		JButton btn4_6 = new JButton("4");
		pnlLottoNum.add(btn4_6);
		
		JButton btn5_6 = new JButton("5");
		pnlLottoNum.add(btn5_6);
		
		JButton btn1_7 = new JButton("1");
		pnlLottoNum.add(btn1_7);
		
		JButton btn2_7 = new JButton("2");
		pnlLottoNum.add(btn2_7);
		
		JButton btn3_7 = new JButton("3");
		pnlLottoNum.add(btn3_7);
		
		JButton btn4_7 = new JButton("4");
		pnlLottoNum.add(btn4_7);
		
		JButton btn5_7 = new JButton("5");
		pnlLottoNum.add(btn5_7);
		
		JPanel pnlChoice = new JPanel();
		pnlChoice.setBounds(339, 88, 327, 270);
		contentPane.add(pnlChoice);
		
		JPanel choice_1 = new JPanel();
		pnlChoice.add(choice_1);
		
		JLabel isAuto_1 = new JLabel("수동");
		choice_1.add(isAuto_1);
		
		JLabel number_1 = new JLabel("13 25 26 28 32 35");
		choice_1.add(number_1);
		number_1.setFont(new Font("굴림", Font.PLAIN, 22));
		
		JButton btnReset_1 = new JButton("초기화");
		choice_1.add(btnReset_1);
		
		JPanel choice_2 = new JPanel();
		pnlChoice.add(choice_2);
		
		JLabel isAuto_2 = new JLabel("수동");
		choice_2.add(isAuto_2);
		
		JLabel number_2 = new JLabel("13 25 26 28 32 35");
		number_2.setFont(new Font("굴림", Font.PLAIN, 22));
		choice_2.add(number_2);
		
		JButton btnReset_2 = new JButton("초기화");
		choice_2.add(btnReset_2);
		
		JPanel choice_3 = new JPanel();
		pnlChoice.add(choice_3);
		
		JLabel isAuto_3 = new JLabel("수동");
		choice_3.add(isAuto_3);
		
		JLabel number_3 = new JLabel("13 25 26 28 32 35");
		number_3.setFont(new Font("굴림", Font.PLAIN, 22));
		choice_3.add(number_3);
		
		JButton btnReset_3 = new JButton("초기화");
		choice_3.add(btnReset_3);
		
		JPanel choice_4 = new JPanel();
		pnlChoice.add(choice_4);
		
		JLabel isAuto_4 = new JLabel("수동");
		choice_4.add(isAuto_4);
		
		JLabel number_4 = new JLabel("13 25 26 28 32 35");
		number_4.setFont(new Font("굴림", Font.PLAIN, 22));
		choice_4.add(number_4);
		
		JButton btnReset_4 = new JButton("초기화");
		choice_4.add(btnReset_4);
		
		JPanel choice_5 = new JPanel();
		pnlChoice.add(choice_5);
		
		JLabel isAuto_5 = new JLabel("수동");
		choice_5.add(isAuto_5);
		
		JLabel number_5 = new JLabel("13 25 26 28 32 35");
		number_5.setFont(new Font("굴림", Font.PLAIN, 22));
		choice_5.add(number_5);
		
		JButton btnReset_5 = new JButton("초기화");
		choice_5.add(btnReset_5);
		
		JPanel panel_1 = new JPanel();
		pnlChoice.add(panel_1);
		
		JButton btnPayment = new JButton("결제하기");
		panel_1.add(btnPayment);
		btnPayment.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JButton btnResetAll = new JButton("전체 초기화");
		panel_1.add(btnResetAll);
		
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
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnAutoPlus);
		
		JButton btnResetList = new JButton("선택 초기화");
		btnResetList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnResetList);
		
		JButton btnPlus = new JButton("등록");
		panel.add(btnPlus);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
