import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.Color;


public class PawnChangeButton extends JButton {
    public PawnChangeButton(String text, JLayeredPane game, Color activeColor, int pointX, int pointY, BlackFigures blackFigures, WhiteFigures whiteFigures, Board board) {
        super(text);
        addActionListener(e -> {
            if (text.equals("Queen")) {
                Queen figure1 = new Queen(pointX, pointY, activeColor, game, activeColor == Color.WHITE ? whiteFigures : blackFigures);
                game.add(figure1, Integer.valueOf(3));
                if (activeColor == Color.WHITE) {
                    whiteFigures.figures.add(figure1);
                } else {
                    blackFigures.figures.add(figure1);
                }
            } else if (text.equals("Rook")) {
                Rock figure2 = new Rock(pointX, pointY, activeColor, game, activeColor == Color.WHITE ? whiteFigures : blackFigures);
                game.add(figure2, Integer.valueOf(3));
                if (activeColor == Color.WHITE) {
                    whiteFigures.figures.add(figure2);
                } else {
                    blackFigures.figures.add(figure2);
                }
            } else if (text.equals("Bishop")) {
                Bishop figure3 = new Bishop(pointX, pointY, activeColor, game, activeColor == Color.WHITE ? whiteFigures : blackFigures);
                game.add(figure3, Integer.valueOf(3));
                if (activeColor == Color.WHITE) {
                    whiteFigures.figures.add(figure3);
                } else {
                    blackFigures.figures.add(figure3);
                }
            } else if (text.equals("Knight")) {
                Knight figure4 = new Knight(pointX, pointY, activeColor, game, activeColor == Color.WHITE ? whiteFigures : blackFigures);
                game.add(figure4, Integer.valueOf(3));
                if (activeColor == Color.WHITE) {
                    whiteFigures.figures.add(figure4);
                } else {
                    blackFigures.figures.add(figure4);
                }
            }
            for (int i = 0; i < game.getComponentCount(); i++) {
                if (game.getComponent(i) instanceof PawnChangePanel) {
                    game.remove(i);
                    break;
                }
            }
            board.setActiveColor(activeColor == Color.WHITE ? Color.BLACK : Color.WHITE);
        });
    } 
}
