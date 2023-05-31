package Frame;
// 충전화면 프레임

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class DepositFrame extends JFrame {

	private JPanel contentPane;
	int totalCost = 0;
	int money = 0;// 예치금 입금 예정 , 결제시 여기에 입금 됨
	private JTextField txtT;

	public int getTotalCost() {
		return totalCost;
	}

	public DepositFrame(BuyFrame buyFrame) {

		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 241);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 334, 202);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea.setText("\uCDA9\uC804\uD560 \uAE08\uC561");
		textArea.setBounds(33, 27, 107, 32);
		panel.add(textArea);

		JComboBox<String> comboBox = new JComboBox();
		String[] price = { "1000 원", "5000 원", "10000 원", "50000 원", "직접 입력" };
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

// 콤보박스 선택		
				String str = comboBox.getSelectedItem().toString();

				if (str == "1000 원") {
					money = 1000;
					txtT.setText("1000");
				} else if (str == "5000 원") {
					money = 5000;
					txtT.setText("5000");
				} else if (str == "10000 원") {
					money = 10000;
					txtT.setText("10000");
				} else if (str == "50000 원") {
					money = 50000;
					txtT.setText("50000");
				} else if (str == "직접 입력") {
					txtT.setText("");
				}
			}
		});

		comboBox.setModel(new DefaultComboBoxModel<String>(price));
		comboBox.setBackground(UIManager.getColor("Button.background"));
		comboBox.setBounds(214, 79, 91, 48);
		panel.add(comboBox);
// 값을 출력하고 내보내는 텍스트 필드
		txtT = new JTextField();
		txtT.setText("1000");

		txtT.setFont(new Font("굴림", Font.PLAIN, 20));
		txtT.setHorizontalAlignment(SwingConstants.RIGHT);

		txtT.setBounds(12, 80, 190, 48);
		panel.add(txtT);
		txtT.setColumns(10);

		setDefaultCloseOperation(HIDE_ON_CLOSE);

// 충전화면에서 결제 버튼 영역		
		JButton btnNewButton = new JButton("\uACB0 \uC81C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyFrame.setVisible(true);
				if (money == 0) {
					money = 1000;
				}
				Integer tempMoney = Integer.valueOf(txtT.getText());
				System.out.println(tempMoney);
				money = tempMoney;
				// 결제 버튼 누르기
				totalCost = totalCost + money;
				buyFrame.setMyMoney(totalCost);

			}
		});
		btnNewButton.setBounds(33, 149, 118, 43);
		panel.add(btnNewButton);
// 충전화면에서 취소 버튼 영역
		JButton btnNewButton_1 = new JButton("\uCDE8 \uC18C");
		btnNewButton_1.addActionListener(new ActionListener() { // 충전 화면에서 취소 누를시 창만 닫힘
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(187, 149, 118, 43);
		panel.add(btnNewButton_1);

	}
}
