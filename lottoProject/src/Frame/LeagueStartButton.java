package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LeagueStartButton extends JButton {
    private Color borderColor;
    private Color hoverColor;
    private Timer timer;
    private float alpha;
    private int gradientHeight;

    public LeagueStartButton(String text) {
        super(text);
        decorate();
    }

    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
        setFont(new Font("Verdana", Font.BOLD, 14));
        borderColor = Color.YELLOW;
        setForeground(borderColor);
        hoverColor = Color.decode("#fdffb5");
        alpha = 0.0f;
        gradientHeight = 0;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	borderColor = hoverColor;
	            setForeground(hoverColor);
                startAnimation(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	borderColor = Color.YELLOW; 
	            setForeground(Color.YELLOW);
                startAnimation(false);
            }
        });
    }

    private void startAnimation(boolean fadeIn) {
        if (timer != null && timer.isRunning()) {
            return;
        }

        int fadeDuration = 1000; // 애니메이션 지속 시간 (밀리초)
        int numSteps = 50; // 애니메이션 단계 수

        final float fadeStep = fadeIn ? 1.0f / numSteps : -1.0f / numSteps;
        final int delay = fadeDuration / numSteps;

        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += fadeStep;
                gradientHeight = (int) (getHeight() * (1 - alpha)); // 아래부터 올라오도록 수정
                repaint();

                if (alpha <= 0.0f || alpha >= 1.0f) {
                    stopAnimation();
                }
            }
        });

        timer.setInitialDelay(0);
        timer.start();
    }

    private void stopAnimation() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
            alpha = 0.0f;
            gradientHeight = 0;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 그라데이션 색상
        Color startColor = new Color(255, 255, 255, (int) (alpha * 255));
        Color endColor = new Color(255, 255, 255, 0);

        // 그라데이션 페인트
        GradientPaint gradientPaint = new GradientPaint(0, getHeight(), startColor, // 아래부터 시작하도록 수정
                0, getHeight() - gradientHeight, endColor);

        graphics.setPaint(gradientPaint);
        graphics.fillRect(0, getHeight() - gradientHeight, getWidth(), gradientHeight);

        graphics.setColor(borderColor);
        graphics.setStroke(new BasicStroke(3));
        graphics.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);

        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(getText(), graphics).getBounds();

        int textX = (getWidth() - stringBounds.width) / 2;
        int textY = (getHeight() - stringBounds.height) / 2 + fontMetrics.getAscent();

        graphics.setColor(getForeground());
        graphics.setFont(getFont());
        graphics.drawString(getText(), textX, textY);
        graphics.dispose();

        super.paintComponent(g);
    }
}
