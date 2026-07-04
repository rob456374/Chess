import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLayeredPane;

public class Queen extends FiguresBox{
    public Queen(int x, int y, Color color, JLayeredPane game, Figures figures){
        super(x, y, game, figures, color);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x + 20, y + 75, 60, 15);
        g.fillRect(x + 27, y + 63, 46, 12);
        g.fillPolygon(
            new int[]{x + 27, x + 18, x + 29, x + 41, x + 50, x + 59, x + 71, x + 82, x + 73},
            new int[]{y + 63, y + 36, y + 54, y + 32, y + 50, y + 32, y + 54, y + 36, y + 63},
            9);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        draw(g);
    }


    private boolean checkFigure = false;
    private int realI;
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



        for (int i = (getX() / 50) + 1; i < 8; i++) {
            realI = i - (getX() / 50);
            if (((y * 2) + ((realI) * 100)) <= 700) {
                if (boxFigures.isFigure(x + (realI * 50), y + (realI * 50)) == 0 && !checkFigure) {
                    mp.add(new MovementPoint((x) + (realI * 50), (y) + (realI * 50), color));
                } else if (boxFigures.isFigure(x + (realI * 50), y + (realI * 50)) == 1 && !checkFigure) {
                    mp.add(new MovementPoint((x) + (realI * 50), (y) + (realI * 50), color));
                    checkFigure = true;
                } else checkFigure = true;
            }
        }
        checkFigure = false;
        for (int i = (getX() / 50) - 1; i >= 0; i--) {
            realI = (getX() / 50) - i;
            if (((y * 2) - (realI * 100)) >= 0) {
                if (boxFigures.isFigure(x - (realI * 50), y - (realI * 50)) == 0 && !checkFigure) {
                    mp.add(new MovementPoint((x) - (realI * 50), (y) - (realI * 50), color));
                } else if (boxFigures.isFigure(x - (realI * 50), y - (realI * 50)) == 1 && !checkFigure) {
                    mp.add(new MovementPoint((x) - (realI * 50), (y) - (realI * 50), color));
                    checkFigure = true;
                } else checkFigure = true;
            }
        }
        checkFigure = false;
        for (int i = (getX() / 50) - 1; i >= 0; i--) {
            realI = (getX() / 50) - i;
            if (((y * 2) + (realI * 100)) <= 700) {
                if (boxFigures.isFigure(x - (realI * 50), y + (realI * 50)) == 0 && !checkFigure) {
                    mp.add(new MovementPoint((x) - (realI * 50), (y) + (realI * 50), color));
                } else if (boxFigures.isFigure(x - (realI * 50), y + (realI * 50)) == 1 && !checkFigure) {
                    mp.add(new MovementPoint((x) - (realI * 50), (y) + (realI * 50), color));
                    checkFigure = true;
                } else checkFigure = true;
            }
        }
        checkFigure = false;
        for (int i = (getX() / 50) + 1; i < 8; i++) {
            realI = i - (getX() / 50);
            if (((y * 2) - (realI * 100)) >= 0) {
                if (boxFigures.isFigure(x + (realI * 50), y - (realI * 50)) == 0 && !checkFigure) {
                    mp.add(new MovementPoint((x) + (realI * 50), (y) - (realI * 50), color));
                } else if (boxFigures.isFigure(x + (realI * 50), y - (realI * 50)) == 1 && !checkFigure) {
                    mp.add(new MovementPoint((x) + (realI * 50), (y) - (realI * 50), color));
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