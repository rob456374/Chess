import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public abstract class FiguresBox extends JPanel{
    protected int x;
    protected int y;
    protected JLayeredPane game;
    protected Figures boxFigures;
    protected ArrayList<MovementPoint> mp = new ArrayList<MovementPoint>();
    protected Color color;
    protected boolean alreadyMoved = false;

    public FiguresBox(int x, int y, JLayeredPane game, Figures figures, Color color){
        super();
        this.game = game;
        this.boxFigures = figures;
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
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void changePosition(int x, int y){
        setX(x);
        setY(y);
    }

    public ArrayList<MovementPoint> getMP(){
        return mp;
    }
    public Color getColor(){
        return color;
    }
    public boolean hasAlreadyMoved(){
        return alreadyMoved;
    }

    public abstract void movement();
}
