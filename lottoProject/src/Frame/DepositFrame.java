// 충전화면 프레임

package Frame;

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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class DepositFrame extends JFrame {

	private JPanel contentPane;

	public DepositFrame() {
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

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// 찾았다 요놈  //comboBox.getSelectedItem().toString()) 선택한 항목의 스트링 값 반환
				// 지역변수로 쓰고 버릴검당
				String str = comboBox.getSelectedItem().toString();
				if (str == "직접 입력") {
					comboBox.setEditable(true); // // 콤보창에 입력 여부를 판단 하는 녀석

				} // 버그 발생 버그 발생!

			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1000\uC6D0", "5000\uC6D0", "10000\uC6D0",
				"50000\uC6D0", "\uC9C1\uC811 \uC785\uB825" }));
		comboBox.setBackground(UIManager.getColor("Button.background"));
		comboBox.setBounds(43, 71, 220, 51);
		panel.add(comboBox);

		JButton btnNewButton = new JButton("\uACB0 \uC81C");
		btnNewButton.setBounds(22, 132, 118, 43);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uCDE8 \uC18C");
		btnNewButton_1.setBounds(175, 132, 118, 43);
		panel.add(btnNewButton_1);
	}
}
