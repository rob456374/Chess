import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

public abstract class Figures{
    public ArrayList<FiguresBox> figures = new ArrayList<FiguresBox>();
    protected JLayeredPane game;
    protected Color color;

    public Figures(JLayeredPane game, Color color){
        this.game = game;
        this.color = color;
    }

    public abstract int isFigure(int x, int y);
    public abstract FiguresBox getFigure(int x, int y);
}
