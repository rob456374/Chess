import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

public class BlackFigures extends Figures{
    public ArrayList<FiguresBox> figures = new ArrayList<FiguresBox>();
    protected WhiteFigures whiteFigures;

    public BlackFigures(JLayeredPane game){
        super(game, Color.BLACK);
        for(int i = 0; i < 8; i++) {
            figures.add(new Pawn(i*50, 50, color, game, this));
        }

        figures.add(new Rock(0, 0, color, game, this));
        figures.add(new Rock(350, 0, color, game, this));

        figures.add(new Bishop(100, 0, color, game, this));
        figures.add(new Bishop(250, 0, color, game, this));

        figures.add(new Knight(50, 0, color, game, this));
        figures.add(new Knight(300, 0, color, game, this));

        figures.add(new King(200, 0, color, game, this));
        figures.add(new Queen(150, 0, color, game, this));
    }
    public void setWhiteFigures(WhiteFigures whiteFigures) {
        this.whiteFigures = whiteFigures;
    }


    public int isFigure(int x, int y) {
        for (int i = 0; i < figures.size(); i++) {
            if (figures.get(i).getX() == x && figures.get(i).getY() == y ) {
                return 2;
            }
        }
        for (int i = 0; i < whiteFigures.figures.size(); i++) {
            if (whiteFigures.figures.get(i).getX() == x && whiteFigures.figures.get(i).getY() == y ) {
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
        for (int i = 0; i < whiteFigures.figures.size(); i++) {
            if (whiteFigures.figures.get(i).getX() == x && whiteFigures.figures.get(i).getY() == y ) {
                return whiteFigures.figures.get(i);
            }
        }
        return null;
    }
}
