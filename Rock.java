import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLayeredPane;

public class Rock extends FiguresBox{
    public Rock(int x, int y, Color color, JLayeredPane game, Figures figures){
        super(x, y, game, figures, color);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x + 20, y + 75, 60, 15);
        g.fillRect(x + 25, y + 30, 50, 45);
        g.fillRect(x + 42, y + 15, 16, 20);
        g.fillRect(x + 23, y + 15, 16, 20);
        g.fillRect(x + 61, y + 15, 16, 20);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        draw(g);
    }

    private boolean xFigure = false;
    private boolean yFigure = false;
    public void movement(){
        for (int i = (getX() / 50) + 1; i < 8; i++) {
            if (boxFigures.isFigure(i * 50, y) == 0 && !xFigure) {
                mp.add(new MovementPoint(i * 50, y, color));
            } else if (boxFigures.isFigure(i * 50, y) == 1 && !xFigure) {
                    mp.add(new MovementPoint(i * 50, y, color));
                    xFigure = true;
            } else xFigure = true;
        }
        xFigure = false;
        for (int i = (getX() / 50) - 1; i > -1; i--) {
            if (boxFigures.isFigure(i * 50, y) == 0 && !xFigure) {
                mp.add(new MovementPoint(i * 50, y, color));
            } else if (boxFigures.isFigure(i * 50, y) == 1 && !xFigure) {
                    mp.add(new MovementPoint(i * 50, y, color));
                    xFigure = true;
            } else xFigure = true;
        }



        xFigure = false;
        for (int i = (getY() / 50) + 1; i < 8; i++) {
            if (boxFigures.isFigure(x, i * 50) == 0 && !yFigure) {
                mp.add(new MovementPoint(x, i * 50, color));
            } else if (boxFigures.isFigure(x, i * 50) == 1 && !yFigure) {
                    mp.add(new MovementPoint(x, i * 50, color));
                    yFigure = true;
            } else yFigure = true;
        }
        yFigure = false;
        for (int i = (getY() / 50) - 1; i > -1; i--) {
            if (boxFigures.isFigure(x, i * 50) == 0 && !yFigure) {
                mp.add(new MovementPoint(x, i * 50, color));
            } else if (boxFigures.isFigure(x, i * 50) == 1 && !yFigure) {
                    mp.add(new MovementPoint(x, i * 50, color));
                    yFigure = true;
            } else yFigure = true;
        }
        yFigure = false;

        
        for (int i = 0; i < mp.size(); i++) {
            game.add(mp.get(i), Integer.valueOf(3));
        }
        alreadyMoved = true;
    }
}