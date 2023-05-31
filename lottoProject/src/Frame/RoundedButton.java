package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

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

	public RoundedButton(Action action) {
		super(action);
		decorate();
	}

	public RoundedButton(Icon icon) {
		super(icon);
		decorate();
	}

	public RoundedButton(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(242, 151, 133)); // 배경색 설정 // 버튼색
		setForeground(Color.WHITE); // 전경색 설정
		isPossible = true; // 아직클릭안된 boolean값
	}

	protected void decorate2() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(Color.GRAY); // 배경색 설정 // 버튼색
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
			graphics.setColor(Color.GRAY); // 원하는 비활성화 배경색 설정
		} else if (getModel().isArmed()) {
			graphics.setColor(getBackground().darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(getBackground().brighter());
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

	public RoundButton(Icon icon) {
		super(icon);
		decorate();
	}

	public RoundButton(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(Color.decode("#f0f0f0")); // 배경색 설정
		setFont(new Font("맑은 고딕", Font.BOLD, 13));
		setForeground(Color.decode("#99b4d1"));
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