package Frame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author 이사라 그냥 로또볼 버튼 만들어봤습니다.
 */
public class RoundedButton extends JButton {
	private boolean isPossible;

	public boolean isPossible() {
		return isPossible;
	}

	public void setPossible(boolean isPossible) {
		this.isPossible = isPossible;
	}

	public RoundedButton() {
		super();
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(Color.decode("#dcc375")); // 배경색 설정 // 버튼색
		setForeground(Color.WHITE); // 전경색 설정
		isPossible = true; // 아직클릭안된 boolean값
	}

	protected void decorate2() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(Color.decode("#8a6436")); // 배경색 설정 // 버튼색
		setForeground(Color.WHITE); // 전경색 설정
		isPossible = false; // 클릭된 boolean값
	}

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		Graphics2D graphics = (Graphics2D) g;

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (!isEnabled()) { // 버튼이 비활성화된 상태일 때
			graphics.setColor(Color.decode("#8a6436")); // 원하는 비활성화 배경색 설정
		} else if (getModel().isArmed()) {
			graphics.setColor(getBackground().brighter());
		} else if (getModel().isRollover()) {
			graphics.setColor(getBackground().darker());
		} else {
			graphics.setColor(getBackground());
		}

		int diameter = Math.min(width, height) - 2;
		int x = (width - diameter) / 2;
		int y = (height - diameter) / 2;
		graphics.fillOval(x, y, diameter, diameter);

		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();

		super.paintComponent(g);
	}
}

class RoundButton extends JButton {

	public RoundButton() {
		super();
		decorate();
	}

	public RoundButton(String text) {
		super(text);
		decorate();
	}

	public RoundButton(Action action) {
		super(action);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(Color.decode("#0bc4e2")); // 배경색 설정
		setFont(new Font("맑은 고딕", Font.BOLD, 13));
		setForeground(Color.BLACK);
	}

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		Graphics2D graphics = (Graphics2D) g;

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (getModel().isArmed()) {
			graphics.setColor(getBackground().darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(getBackground().brighter());
		} else {
			graphics.setColor(getBackground());
		}

		graphics.fillRoundRect(0, 0, width, height, 10, 10);

		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();

		super.paintComponent(g);
	}
}

class RoundBorderButton extends JButton {

	private Color borderColor;
	private Color hoverColor;

	public RoundBorderButton() {
		super();
		decorate();
	}

	public RoundBorderButton(String text) {
		super(text);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setFont(new Font("맑은 고딕", Font.BOLD, 13));
		setForeground(new Color(250, 250, 210));
		borderColor = new Color(250, 250, 210); // 보더 색상 설정
		hoverColor = Color.decode("#fdffb5");
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				borderColor = hoverColor;
				setForeground(hoverColor);
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				borderColor = new Color(250, 250, 210);
				setForeground(new Color(250, 250, 210));
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		Graphics2D graphics = (Graphics2D) g;

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		graphics.setColor(borderColor);
		graphics.setStroke(new BasicStroke(2)); // 보더 굵기 설정
		graphics.drawRoundRect(0, 0, width - 1, height - 1, 10, 10); // 보더 그리기

		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();

		super.paintComponent(g);
	}
}

class RoundedLabel extends JPanel {

	private Color backgroundColor;
	private String text;

	public RoundedLabel(String text) {
		this.text = text;
		this.backgroundColor = Color.YELLOW;
		setOpaque(false);
	}

	public void setBackgroundColor(Color color) {
		this.backgroundColor = color;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D) g.create();

		int width = getWidth();
		int height = getHeight();

		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2D.setColor(backgroundColor);
		graphics2D.fill(new Ellipse2D.Double(0, 0, width, height));

		graphics2D.setColor(getForeground());
		FontMetrics fontMetrics = graphics2D.getFontMetrics();
		int textX = (width - fontMetrics.stringWidth(text)) / 2;
		int textY = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
		graphics2D.drawString(text, textX, textY);

		graphics2D.dispose();
	}
}
