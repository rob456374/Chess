import javax.swing.JFrame ;
import javax.swing.JLayeredPane;
import java.awt.Dimension;


public class ChessMain extends JFrame {
    private BlackFigures blackFigures;
    private WhiteFigures whiteFigures;

    public ChessMain() {
        super("Chess");
        
        JLayeredPane game = new JLayeredPane();
        game.setPreferredSize(new Dimension(800, 800));
        Board board = new Board(game);
        board.setBounds(0, 0, 800, 800);

        blackFigures = new BlackFigures(game);
        whiteFigures = new WhiteFigures(game);
        blackFigures.setWhiteFigures(whiteFigures);
        whiteFigures.setBlackFigures(blackFigures);
        board.setFigures(blackFigures, whiteFigures);

        game.add(board, Integer.valueOf(0));
        for (int i = 0; i < blackFigures.figures.size(); i++) {
            game.add(blackFigures.figures.get(i), Integer.valueOf(1));
        }
        for (int i = 0; i < whiteFigures.figures.size(); i++) {
            game.add(whiteFigures.figures.get(i), Integer.valueOf(2));
        }

        add(game);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible ( true );
    }

    public static void main(String[] args) {
        new ChessMain();
    }
}