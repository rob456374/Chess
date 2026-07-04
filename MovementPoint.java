import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MovementPoint extends JPanel{
    private int x;
    private int y;
    private Color color;
    private String specialMove = null;

    public MovementPoint(int x, int y, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.color = color;
        setOpaque(false);
        setBounds(0, 0, 800, 800);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getSpecialMove() {
        return specialMove;
    }
    public void setSpecialMove(String specialMove) {
        this.specialMove = specialMove;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillArc(x + 30, y + 30, 40, 40, 180, 360);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
}
