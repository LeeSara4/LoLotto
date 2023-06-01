package Frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	BuyFrame buyFrame = new BuyFrame(this);
	ShootNumImage shootNumImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {

		setTitle("4조 대박당첨");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon image = new ImageIcon("img.png");
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#111111"));

		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\GGG\\Desktop\\img.png"));
		lblNewLabel.setBounds(292, 28, 359, 262);
		panel.add(lblNewLabel);

		JButton btnNewButton = new RoundButton("구매하기");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyFrame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(112, 399, 143, 44);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new RoundButton("구매내역");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyList buyList = new BuyList(buyFrame.returnMapList(), MainFrame.this);
				buyList.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(508, 400, 143, 44);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new RoundButton("추첨");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shootNumImage = new ShootNumImage(MainFrame.this);
				shootNumImage.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(308, 399, 143, 44);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new RoundButton("당첨 확인");
		btnNewButton_3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinningDetails winningDetails = new WinningDetails(MainFrame.this, shootNumImage,
						buyFrame.returnMapList());
				winningDetails.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(713, 400, 143, 44);
		panel.add(btnNewButton_3);
//		EndCheckFrame
	}
}
