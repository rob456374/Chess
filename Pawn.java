import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLayeredPane;

public class Pawn extends FiguresBox{
    public Pawn(int x, int y, Color color, JLayeredPane game, Figures figures){
        super(x, y, game, figures, color);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x + 20, y + 75, 60, 15);
        g.fillRect(x + 27, y + 63, 46, 12);
        g.fillRect(x + 39, y + 40, 22, 23);
        g.fillArc(x + 28, y + 10, 44, 44, 180, 360);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void movement(){
        int direction;
        if (color == Color.WHITE) direction = -1;
        else direction = 1;

        if (boxFigures.isFigure(x, y + (50 * direction)) == 0) mp.add(new MovementPoint(x, (y + (50 * direction)), color));
        if (boxFigures.isFigure(x - 50, y + (50 * direction)) == 1) mp.add(new MovementPoint(x - 50, (y + (50 * direction)), color));
        if (boxFigures.isFigure(x + 50, y + (50 * direction)) == 1) mp.add(new MovementPoint(x + 50, (y + (50 * direction)), color));

        if(!alreadyMoved && boxFigures.isFigure(x, y + (50 * direction)) == 0 && boxFigures.isFigure(x, y + (100 * direction)) == 0) { 
            mp.add(new MovementPoint(x, (y + (100 * direction)), color));
        }

        for (int i = 0; i < mp.size(); i++) {
            game.add(mp.get(i), Integer.valueOf(3));
        }
    }
}