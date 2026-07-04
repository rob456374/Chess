import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

public class PawnChangePanel extends JPanel {
    public PawnChangePanel(JLayeredPane game, Board board, Color activeColor, int pointX, int pointY, BlackFigures blackFigures, WhiteFigures whiteFigures) {
        super();
        setLayout(new GridLayout(1, 4));
        setBounds(200, 300, 400, 100);
        add(new PawnChangeButton("Queen", game, activeColor, pointX, pointY, blackFigures, whiteFigures, board));
        add(new PawnChangeButton("Rook", game, activeColor, pointX, pointY, blackFigures, whiteFigures, board));
        add(new PawnChangeButton("Bishop", game, activeColor, pointX, pointY, blackFigures, whiteFigures, board));
        add(new PawnChangeButton("Knight", game, activeColor, pointX, pointY, blackFigures, whiteFigures, board));
        game.add(this, Integer.valueOf(4));
    }
}
