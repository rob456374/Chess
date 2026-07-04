import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

public class WhiteFigures extends Figures{
    public ArrayList<FiguresBox> figures = new ArrayList<FiguresBox>();
    protected BlackFigures blackFigures;

    public WhiteFigures(JLayeredPane game){
        super(game, Color.WHITE);
        for(int i = 0; i < 8; i++) {
            figures.add(new Pawn(i*50, 300, color, game, this));
        }

        figures.add(new Rock(0, 350, color, game, this));
        figures.add(new Rock(350, 350, color, game, this));

        figures.add(new Bishop(100, 350, color, game, this));
        figures.add(new Bishop(250, 350, color, game, this));

        figures.add(new Knight(50, 350, color, game, this));
        figures.add(new Knight(300, 350, color, game, this));

        figures.add(new King(200, 350, color, game, this));
        figures.add(new Queen(150, 350, color, game, this));
    }
    public void setBlackFigures(BlackFigures blackFigures) {
        this.blackFigures = blackFigures;
    }

    public int isFigure(int x, int y) {
        for (int i = 0; i < figures.size(); i++) {
            if (figures.get(i).getX() == x && figures.get(i).getY() == y ) {
                return 2;
            }
        }
        for (int i = 0; i < blackFigures.figures.size(); i++) {
            if (blackFigures.figures.get(i).getX() == x && blackFigures.figures.get(i).getY() == y ) {
                return 1;
            }
        }
        return 0;
    }
    public FiguresBox getFigure(int x, int y) {
        for (int i = 0; i < figures.size(); i++) {
            if (figures.get(i).getX() == x && figures.get(i).getY() == y ) {
                return figures.get(i);
            }
        }
        for (int i = 0; i < blackFigures.figures.size(); i++) {
            if (blackFigures.figures.get(i).getX() == x && blackFigures.figures.get(i).getY() == y ) {
                return blackFigures.figures.get(i);
            }
        }
        return null;
    }
}