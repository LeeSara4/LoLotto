package lottoProject;
// 결과창 종료 시
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultNextFrame extends JFrame {

	private JPanel contentPane;

	public ResultNextFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 318, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("굴림", Font.BOLD, 18));
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setText("\uCD95 \uB2F9 \uCCA8");
		formattedTextField.setBounds(34, 26, 256, 66);
		panel.add(formattedTextField);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		// 그냥 확인 창이라서 한번 해봤습니다..  // 확인에 커서 올리면 참조 뜹니다!~
		btnNewButton.setToolTipText("확인을 누르면 창이 닫힙니다.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(95, 111, 125, 40);
		panel.add(btnNewButton);
	}

}
