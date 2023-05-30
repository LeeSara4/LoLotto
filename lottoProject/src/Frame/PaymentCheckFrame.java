package Frame;
// 결제 확인창

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import lottoProject.LottoPaper;

public class PaymentCheckFrame extends JFrame {
	private JPanel contentPane;

	public PaymentCheckFrame(LottoPaper lottoPaper) {
		setBounds(100, 100, 300, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 284, 201);
		contentPane.add(panel);
		panel.setLayout(null);

		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("굴림", Font.BOLD, 18));
		formattedTextField.setText("\uACB0\uC81C\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C");
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setBounds(40, 31, 204, 76);
		panel.add(formattedTextField);

		JButton btnNewButton = new RoundButton("예");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Receipt(lottoPaper);
				dispose();
			}
		});
		btnNewButton.setBounds(32, 136, 97, 44);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new RoundButton("아니요");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(157, 136, 97, 44);
		panel.add(btnNewButton_1);

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}
}
