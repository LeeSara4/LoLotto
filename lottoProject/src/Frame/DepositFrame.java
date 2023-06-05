package Frame;
// 충전화면 프레임

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DepositFrame extends JDialog {

	private JPanel contentPane;
	int totalCost = 0;
	int money = 0;// 예치금 입금 예정 , 결제시 여기에 입금 됨
	private JTextField txtT;

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public DepositFrame(BuyFrame buyFrame) {
		setModal(true);
		setBounds(0, 0, 350, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel backLabel = new JLabel(new ImageIcon(getClass().getResource("/imagepackage/back1.png")));
		backLabel.setBounds(0, 0, 350, 241);
		contentPane.add(backLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 350, 241);
		panel.setOpaque(false);
		panel.setLayout(null);
		backLabel.add(panel);

		JComboBox<String> comboBox = new JComboBox();
		String[] price = { "1000RP", "5000RP", "10000RP", "50000RP", "직접입력" };
		comboBox.setOpaque(false);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

// 콤보박스 선택		
				String str = comboBox.getSelectedItem().toString();
				txtT.setEnabled(false);
				if (str == "1000RP") {
					money = 1000;
					txtT.setText("1000");

				} else if (str == "5000RP") {
					money = 5000;
					txtT.setText("5000");
				} else if (str == "10000RP") {
					money = 10000;
					txtT.setText("10000");
				} else if (str == "50000RP") {
					money = 50000;
					txtT.setText("50000");
				} else if (str == "직접입력") {
					txtT.setEnabled(true);
					txtT.setText("");
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(price));
		comboBox.setBounds(215, 70, 78, 48);
		comboBox.setForeground(new Color(250, 250, 210));
		comboBox.setBackground(new Color(70, 70, 70));

		panel.add(comboBox);

// 값을 출력하고 내보내는 텍스트 필드
		txtT = new JTextField();
		txtT.setForeground(new Color(250, 250, 0));
		txtT.setText("1000");
		txtT.setOpaque(false);
		txtT.setEnabled(false);
		txtT.setFont(new Font("굴림", Font.PLAIN, 20));
		txtT.setHorizontalAlignment(SwingConstants.RIGHT);
		txtT.setBounds(40, 70, 165, 48);
		panel.add(txtT);
		txtT.setColumns(10);

// 충전화면에서 결제 버튼 영역
		RoundButton btnNewButton = new RoundButton("결제");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyFrame.setVisible(true);
				if (money == 0) { // 아무런 입력이 없을 때 기본 가격을 1000원이 되게끔 설정
					money = 1000;
				}

				Integer tempMoney = Integer.valueOf(txtT.getText());

				if (tempMoney < 0) {
					JOptionPane.showMessageDialog(null, "마이너스 금액은 입금 할 수 없습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				} else if (tempMoney > 100000) {
					JOptionPane.showMessageDialog(null, "10만원 이상의 금액은 추가할 수 없습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				} else {

					money = tempMoney;
					// 결제 버튼 누르기
					totalCost = totalCost + money;
					buyFrame.setMyMoney(totalCost);
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(40, 140, 118, 43);
		panel.add(btnNewButton);

// 충전화면에서 취소 버튼 영역
		RoundButton btnNewButton_1 = new RoundButton("취소");
		btnNewButton_1.addActionListener(new ActionListener() { // 충전 화면에서 취소 누를시 창만 닫힘
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(180, 140, 118, 43);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("충전할 RP");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(250, 250, 210));
		lblNewLabel.setBounds(40, 23, 190, 34);
		panel.add(lblNewLabel);

	}
}
