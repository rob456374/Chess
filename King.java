import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLayeredPane;

public class King extends FiguresBox{
    public King(int x, int y, Color color, JLayeredPane game, Figures figures){
        super(x, y, game, figures, color);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x + 20, y + 75, 60, 15);
        g.fillRect(x + 27, y + 63, 46, 12);
        g.fillRect(x + 41, y + 17, 18, 46);
        g.fillRect(x + 27, y + 30, 46, 18);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        draw(g);
    }

    public void movement(){
        if (boxFigures.isFigure(x + 50, y) < 2) mp.add(new MovementPoint(x + 50, y, color));
        if (boxFigures.isFigure(x - 50, y) < 2) mp.add(new MovementPoint(x - 50, y, color));
        if (boxFigures.isFigure(x, y + 50) < 2) mp.add(new MovementPoint(x, y + 50, color));
        if (boxFigures.isFigure(x, y - 50) < 2) mp.add(new MovementPoint(x, y - 50, color));
        if (boxFigures.isFigure(x + 50, y + 50) < 2) mp.add(new MovementPoint(x + 50, y + 50, color));
        if (boxFigures.isFigure(x + 50, y - 50) < 2) mp.add(new MovementPoint(x + 50, y - 50, color));
        if (boxFigures.isFigure(x - 50, y + 50) < 2) mp.add(new MovementPoint(x - 50, y + 50, color));
        if (boxFigures.isFigure(x - 50, y - 50) < 2) mp.add(new MovementPoint(x - 50, y - 50, color));


        if (!alreadyMoved) {
            for (int i = getX() / 50 - 1; i >= 0; i--) {
                if (boxFigures.isFigure(i * 50, y) != 0) {
                    if (boxFigures.getFigure(i * 50, y) instanceof Rock && !boxFigures.getFigure(i * 50, y).alreadyMoved) {
                        MovementPoint mp1 = new MovementPoint(x - 100, y, color);
                        mp1.setSpecialMove("castlingLeft");
                        mp.add(mp1);
                    }
                    break;
                }
            }
            for (int i = getX() / 50 + 1; i < 8; i++) {
                if (boxFigures.isFigure(i * 50, y) != 0) {
                    if (boxFigures.getFigure(i * 50, y) instanceof Rock && !boxFigures.getFigure(i * 50, y).alreadyMoved) {
                        MovementPoint mp1 = new MovementPoint(x + 100, y, color);
                        mp1.setSpecialMove("castlingRight");
                        mp.add(mp1);
                    }
                    break;
                }
            }
        }


        for (int i = 0; i < mp.size(); i++) {
            game.add(mp.get(i), Integer.valueOf(3));
        }
    }
}