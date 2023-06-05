package Frame;
// 결제 확인창

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PaymentCheckFrame extends JDialog {
	private JPanel contentPane;
	private static int count = 0;

	public PaymentCheckFrame(BuyFrame buyFrame) {
		setModal(true);
		setBounds(100, 100, 300, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 284, 201);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new RoundButton("예");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buyFrame.payCheckMentYes();
				new Receipt(buyFrame.returnMapList().get(count));
				count++;
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
		
		JLabel paymentYesOrNo = new JLabel("");
		paymentYesOrNo.setIcon(new ImageIcon(PaymentCheckFrame.class.getResource("/imagepackage/결제 확인 프레임.jpg")));
		paymentYesOrNo.setBounds(40, 31, 232, 76);
		panel.add(paymentYesOrNo);
		
		JLabel paymentFrameBackImage = new JLabel("");
		paymentFrameBackImage.setIcon(new ImageIcon(PaymentCheckFrame.class.getResource("/imagepackage/배경2.png")));
		paymentFrameBackImage.setBounds(0, 0, 284, 201);
		panel.add(paymentFrameBackImage);

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}
}
