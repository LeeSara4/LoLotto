// 결제 확인창
package Frame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class PaymentCheckFrame extends JFrame {

	private JPanel contentPane;

	public PaymentCheckFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnNewButton = new JButton("\uC608");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton.setBounds(32, 136, 97, 44);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC544\uB2C8\uC624");
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton_1.setBounds(157, 136, 97, 44);
		panel.add(btnNewButton_1);
	}
}
