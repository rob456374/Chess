import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLayeredPane;

public class Knight extends FiguresBox{
    public Knight(int x, int y, Color color, JLayeredPane game, Figures figures){
        super(x, y, game, figures, color);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x + 20, y + 75, 60, 15);
        g.fillRect(x + 27, y + 63, 46, 12);
        
        g.fillPolygon(new int[]{x + 30, x + 70, x + 68, x + 46}, new int[]{y + 63, y + 63, y + 35, y + 35}, 4);
        g.fillPolygon(new int[]{x + 68, x + 46, x + 34, x + 22, x + 18, x + 34, x + 61}, new int[]{y + 35, y + 35, y + 46, y + 44, y + 34, y + 12, y + 12},7);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        draw(g);
    }
    public void movement(){
        if (boxFigures.isFigure(x + 100, y + 50) < 2) mp.add(new MovementPoint(x + 100, y + 50, color));
        if (boxFigures.isFigure(x + 100, y - 50) < 2) mp.add(new MovementPoint(x + 100, y - 50, color));
        if (boxFigures.isFigure(x - 100, y + 50) < 2) mp.add(new MovementPoint(x - 100, y + 50, color));
        if (boxFigures.isFigure(x - 100, y - 50) < 2) mp.add(new MovementPoint(x - 100, y - 50, color));
        if (boxFigures.isFigure(x + 50, y + 100) < 2) mp.add(new MovementPoint(x + 50, y + 100, color));
        if (boxFigures.isFigure(x - 50, y + 100) < 2) mp.add(new MovementPoint(x - 50, y + 100, color));
        if (boxFigures.isFigure(x + 50, y - 100) < 2) mp.add(new MovementPoint(x + 50, y - 100, color));
        if (boxFigures.isFigure(x - 50, y - 100) < 2) mp.add(new MovementPoint(x - 50, y - 100, color));

        for (int i = 0; i < mp.size(); i++) {
            game.add(mp.get(i), Integer.valueOf(3));
        }
    }
}