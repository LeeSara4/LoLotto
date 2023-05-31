package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 당첨화면 초안입니다!!
 *
 */
public class WinningDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public WinningDetails(MainFrame main) {
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

		JPanel panel = new JPanel();
		panel.setBounds(116, 216, 418, 216);
		contentPane.add(panel);

		JPanel pnl1 = new JPanel();
		panel.add(pnl1);

		JLabel isAuto_1_4 = new JLabel("0등");
		isAuto_1_4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1.add(isAuto_1_4);

		JLabel isAuto_1 = new JLabel("자동여부");
		pnl1.add(isAuto_1);
		isAuto_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		JLabel lbl1 = new JLabel("10");
		lbl1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1.add(lbl1);

		JLabel lbl2 = new JLabel("20");
		lbl2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1.add(lbl2);

		JLabel lbl2_1 = new JLabel("20");
		lbl2_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1.add(lbl2_1);

		JLabel lbl2_2 = new JLabel("20");
		lbl2_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1.add(lbl2_2);

		JLabel lbl2_3 = new JLabel("20");
		lbl2_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1.add(lbl2_3);

		JLabel lbl2_4 = new JLabel("20");
		lbl2_4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1.add(lbl2_4);

		JPanel pnl1_1 = new JPanel();
		panel.add(pnl1_1);

		JLabel isAuto_1_5 = new JLabel("0등");
		isAuto_1_5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_1.add(isAuto_1_5);

		JLabel isAuto_1_1 = new JLabel("자동여부");
		isAuto_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_1.add(isAuto_1_1);

		JLabel lbl1_1 = new JLabel("10");
		lbl1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_1.add(lbl1_1);

		JLabel lbl2_5 = new JLabel("20");
		lbl2_5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_1.add(lbl2_5);

		JLabel lbl2_1_1 = new JLabel("20");
		lbl2_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_1.add(lbl2_1_1);

		JLabel lbl2_2_1 = new JLabel("20");
		lbl2_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_1.add(lbl2_2_1);

		JLabel lbl2_3_1 = new JLabel("20");
		lbl2_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_1.add(lbl2_3_1);

		JLabel lbl2_4_1 = new JLabel("20");
		lbl2_4_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_1.add(lbl2_4_1);

		JPanel pnl1_2 = new JPanel();
		panel.add(pnl1_2);

		JLabel isAuto_1_6 = new JLabel("0등");
		isAuto_1_6.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_2.add(isAuto_1_6);

		JLabel isAuto_1_2 = new JLabel("자동여부");
		isAuto_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_2.add(isAuto_1_2);

		JLabel lbl1_2 = new JLabel("10");
		lbl1_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_2.add(lbl1_2);

		JLabel lbl2_6 = new JLabel("20");
		lbl2_6.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_2.add(lbl2_6);

		JLabel lbl2_1_2 = new JLabel("20");
		lbl2_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_2.add(lbl2_1_2);

		JLabel lbl2_2_2 = new JLabel("20");
		lbl2_2_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_2.add(lbl2_2_2);

		JLabel lbl2_3_2 = new JLabel("20");
		lbl2_3_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_2.add(lbl2_3_2);

		JLabel lbl2_4_2 = new JLabel("20");
		lbl2_4_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_2.add(lbl2_4_2);

		JPanel pnl1_3 = new JPanel();
		panel.add(pnl1_3);

		JLabel isAuto_1_7 = new JLabel("0등");
		isAuto_1_7.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3.add(isAuto_1_7);

		JLabel isAuto_1_3 = new JLabel("자동여부");
		isAuto_1_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3.add(isAuto_1_3);

		JLabel lbl1_3 = new JLabel("10");
		lbl1_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3.add(lbl1_3);

		JLabel lbl2_7 = new JLabel("20");
		lbl2_7.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3.add(lbl2_7);

		JLabel lbl2_1_3 = new JLabel("20");
		lbl2_1_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3.add(lbl2_1_3);

		JLabel lbl2_2_3 = new JLabel("20");
		lbl2_2_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3.add(lbl2_2_3);

		JLabel lbl2_3_3 = new JLabel("20");
		lbl2_3_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3.add(lbl2_3_3);

		JLabel lbl2_4_3 = new JLabel("20");
		lbl2_4_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3.add(lbl2_4_3);

		JPanel pnl1_3_1 = new JPanel();
		panel.add(pnl1_3_1);

		JLabel isAuto_1_8 = new JLabel("0등");
		isAuto_1_8.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_1.add(isAuto_1_8);

		JLabel isAuto_1_3_1 = new JLabel("자동여부");
		isAuto_1_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_1.add(isAuto_1_3_1);

		JLabel lbl1_3_1 = new JLabel("10");
		lbl1_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_1.add(lbl1_3_1);

		JLabel lbl2_7_1 = new JLabel("20");
		lbl2_7_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_1.add(lbl2_7_1);

		JLabel lbl2_1_3_1 = new JLabel("20");
		lbl2_1_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_1.add(lbl2_1_3_1);

		JLabel lbl2_2_3_1 = new JLabel("20");
		lbl2_2_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_1.add(lbl2_2_3_1);

		JLabel lbl2_3_3_1 = new JLabel("20");
		lbl2_3_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_1.add(lbl2_3_3_1);

		JLabel lbl2_4_3_1 = new JLabel("20");
		lbl2_4_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_1.add(lbl2_4_3_1);

		JPanel pnl1_3_2 = new JPanel();
		pnl1_3_2.setBounds(116, 152, 418, 54);
		contentPane.add(pnl1_3_2);

		JLabel isAuto_1_3_2_1_1 = new JLabel("총 9,000,000 원 당첨!");
		isAuto_1_3_2_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		pnl1_3_2.add(isAuto_1_3_2_1_1);

		JLabel isAuto_1_3_2 = new JLabel("");
		isAuto_1_3_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2.add(isAuto_1_3_2);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(181, 458, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(367, 458, 97, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("<1>");
		lblNewLabel.setBounds(314, 462, 22, 15);
		contentPane.add(lblNewLabel);

		JPanel pnl1_3_2_1 = new JPanel();
		pnl1_3_2_1.setBounds(116, 88, 418, 54);
		contentPane.add(pnl1_3_2_1);

		JLabel isAuto_1_3_2_1 = new JLabel("당첨번호");
		isAuto_1_3_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2_1.add(isAuto_1_3_2_1);

		JLabel lbl1_3_2_1 = new JLabel("10");
		lbl1_3_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2_1.add(lbl1_3_2_1);

		JLabel lbl2_7_2_1 = new JLabel("20");
		lbl2_7_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2_1.add(lbl2_7_2_1);

		JLabel lbl2_1_3_2_1 = new JLabel("20");
		lbl2_1_3_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2_1.add(lbl2_1_3_2_1);

		JLabel lbl2_2_3_2_1 = new JLabel("20");
		lbl2_2_3_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2_1.add(lbl2_2_3_2_1);

		JLabel lbl2_3_3_2_1 = new JLabel("20");
		lbl2_3_3_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2_1.add(lbl2_3_3_2_1);

		JLabel lbl2_4_3_2_1 = new JLabel("20");
		lbl2_4_3_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2_1.add(lbl2_4_3_2_1);

		JLabel lbl2_4_3_2_1_1 = new JLabel("+");
		lbl2_4_3_2_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2_1.add(lbl2_4_3_2_1_1);

		JLabel lbl2_4_3_2_1_2 = new JLabel("20");
		lbl2_4_3_2_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pnl1_3_2_1.add(lbl2_4_3_2_1_2);

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
	}
}
