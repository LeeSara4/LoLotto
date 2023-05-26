package Frame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;

public class BuyFrame extends JFrame {

	private JPanel contentPane;
	ArrayList<JButton> buttons;
	
	private int count;
	Set<Integer> numbers;
	int price;
	//Ticket ticket = new Ticket(numbers, price);
	/**
	 * Create the frame.
	 */
	public BuyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlLottoNum = new JPanel();
		pnlLottoNum.setBounds(55, 78, 248, 249);
		contentPane.add(pnlLottoNum);
		pnlLottoNum.setLayout(new GridLayout(9,5));

		// 45개의 로또 번호 버튼배열입니다
	    buttons = new ArrayList<>();
	 
        for (int i = 1; i <= 45; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	if(count < 6) {
                	// 버튼 정보 보내줄 예정
                	// numbers.add(Integer.parseInt(button.getText())); 
                    button.setEnabled(false);
                    	if(count == 6) {
                    		button.setEnabled(true);
                    	}
                    count++;
                	}
                }
            });
            buttons.add(button);
            pnlLottoNum.add(button);
        }
	    
		JPanel pnlChoice = new JPanel();
		pnlChoice.setBounds(339, 88, 327, 270);
		contentPane.add(pnlChoice);
		
		for(int i = 0; i < 5; i++) {
			JPanel choice = new JPanel();
			pnlChoice.add(choice);
			JLabel isAuto = new JLabel("자동여부");
			choice.add(isAuto);
			JLabel number = new JLabel("00 00 00 00 00 00");
			choice.add(number);
			number.setFont(new Font("굴림", Font.PLAIN, 22));
			JButton btnReset = new JButton("초기화");
			choice.add(btnReset);
		} // 기본 값
		
		JPanel pnlSouth = new JPanel();
		pnlChoice.add(pnlSouth);
		
		JButton btnPayment = new JButton("결제하기");
		pnlSouth.add(btnPayment);
		btnPayment.setFont(new Font("굴림", Font.PLAIN, 20));
		
		JButton btnResetAll = new JButton("전체 초기화");
		pnlSouth.add(btnResetAll);
		
		JLabel lblTotal = new JLabel("***** 원");
		lblTotal.setFont(new Font("굴림", Font.PLAIN, 22));
		lblTotal.setBounds(365, 39, 95, 23);
		contentPane.add(lblTotal);
		
		JLabel lblMyMoney = new JLabel("예치금 : ***** 원");
		lblMyMoney.setFont(new Font("굴림", Font.PLAIN, 22));
		lblMyMoney.setBounds(62, 39, 188, 23);
		contentPane.add(lblMyMoney);
		
		JButton btnReload = new JButton("충전");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReload.setBounds(248, 39, 62, 23);
		contentPane.add(btnReload);
		
		JButton btnMain = new JButton("메인으로");
		btnMain.setBounds(544, 42, 97, 23);
		contentPane.add(btnMain);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 337, 303, 33);
		contentPane.add(panel);
		
		JButton btnAutoPlus = new JButton("자동버튼");
		btnAutoPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if (count < 6) {
	                    // 선택하지 않은 번호 중에서 랜덤하게 선택
	                    Random random = new Random();
	                    int randomNum = random.nextInt(45)+1;
	                    while (count < 6)
	                    	//buttons(randomNum).setEnabled(false);
	                        count++;
				  }
			}
		});
		panel.add(btnAutoPlus);
		
		JButton btnResetList = new JButton("선택 초기화");
		btnResetList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnResetList);
		
		JButton btnPlus = new JButton("등록");
		panel.add(btnPlus);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}