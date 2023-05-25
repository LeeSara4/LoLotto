// 종료 확인창
package lottoProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;

public class EndCheckFrame extends JFrame {

	private JPanel contentPane;

	public EndCheckFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 291, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 275, 167);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setFont(new Font("Monospaced", Font.BOLD, 20));
		textArea.setText("\uC885\uB8CC\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C");
		textArea.setBounds(55, 38, 191, 63);
		panel.add(textArea);

		JButton btnNewButton = new JButton("\uC608");
		btnNewButton.setBounds(22, 111, 114, 41);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uC544\uB2C8\uC624");
		btnNewButton_1.setBounds(148, 111, 114, 41);
		panel.add(btnNewButton_1);
	}
}
