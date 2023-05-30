package Frame;
import java.awt.*;
import javax.swing.*;

/**
 * @author 이사라
 * 그냥 로또볼 버튼 만들어봤습니다.
 */
public class RoundedButton extends JButton {

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
        setBackground(new Color(242, 151, 133)); // 배경색 설정
        setForeground(Color.WHITE); // 전경색 설정
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