import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLayeredPane;


public class Bishop extends FiguresBox{
    public Bishop(int x, int y, Color color, JLayeredPane game, Figures figures){
        super(x, y, game, figures, color);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x + 20, y + 75, 60, 15);
        g.fillRect(x + 27, y + 63, 46, 12);
        g.fillArc(x + 28, y + 24, 44, 44, 180, 360);
        g.fillArc(x + 40, y + 6, 20, 20, 180, 360);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        draw(g);
    }


    private boolean checkFigure = false;
    private int realI;
    public void movement(){
        for (int i = (getX() / 50) + 1; i < 8; i++) {
            realI = i - (getX() / 50);
            if ((y + ((realI) * 50)) <= 350) {
                if (boxFigures.isFigure(x + (realI * 50), y + (realI * 50)) == 0 && !checkFigure) {
                    mp.add(new MovementPoint(x + (realI * 50), y + (realI * 50), color));
                } else if (boxFigures.isFigure(x + (realI * 50), y + (realI * 50)) == 1 && !checkFigure) {
                    mp.add(new MovementPoint(x + (realI * 50), y + (realI * 50), color));
                    checkFigure = true;
                } else checkFigure = true;
            }
        }
        checkFigure = false;
        for (int i = (getX() / 50) - 1; i >= 0; i--) {
            realI = (getX() / 50) - i;
            if ((y - (realI * 50)) >= 0) {
                if (boxFigures.isFigure(x - (realI * 50), y - (realI * 50)) == 0 && !checkFigure) {
                    mp.add(new MovementPoint(x - (realI * 50), y - (realI * 50), color));
                } else if (boxFigures.isFigure(x - (realI * 50), y - (realI * 50)) == 1 && !checkFigure) {
                    mp.add(new MovementPoint(x - (realI * 50), y - (realI * 50), color));
                    checkFigure = true;
                } else checkFigure = true;
            }
        }
        checkFigure = false;
        for (int i = (getX() / 50) - 1; i >= 0; i--) {
            realI = (getX() / 50) - i;
            if ((y + (realI * 50)) <= 350) {
                if (boxFigures.isFigure(x - (realI * 50), y + (realI * 50)) == 0 && !checkFigure) {
                    mp.add(new MovementPoint(x - (realI * 50), y + (realI * 50), color));
                } else if (boxFigures.isFigure(x - (realI * 50), y + (realI * 50)) == 1 && !checkFigure) {
                    mp.add(new MovementPoint(x - (realI * 50), y + (realI * 50), color));
                    checkFigure = true;
                } else checkFigure = true;
            }
        }
        checkFigure = false;
        for (int i = (getX() / 50) + 1; i < 8; i++) {
            realI = i - (getX() / 50);
            if ((y - (realI * 50)) >= 0) {
                if (boxFigures.isFigure(x + (realI * 50), y - (realI * 50)) == 0 && !checkFigure) {
                    mp.add(new MovementPoint(x + (realI * 50), y - (realI * 50), color));
                } else if (boxFigures.isFigure(x + (realI * 50), y - (realI * 50)) == 1 && !checkFigure) {
                    mp.add(new MovementPoint(x + (realI * 50), y - (realI * 50), color));
                    checkFigure = true;
                } else checkFigure = true;
            }
        }
        checkFigure = false;

        
        for (int i = 0; i < mp.size(); i++) {
            game.add(mp.get(i), Integer.valueOf(3));
        }
    }
}