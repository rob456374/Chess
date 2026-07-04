import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.EventListener;

public class Board extends JPanel implements EventListener{
    private JButton[][] buttonList = new JButton[8][8];
    private BlackFigures blackFigures;
    private WhiteFigures whiteFigures;
    private JLayeredPane game;

    public Board(JLayeredPane game){
        this.game = game;

        setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int s = 0; s < 8; s++) {
                buttonList[i][s] = new JButton();
                buttonList[i][s].setBackground((i + s) % 2 == 0 ? Color.GRAY : Color.GREEN);
                buttonList[i][s].setOpaque(true);
                buttonList[i][s].setContentAreaFilled(true);
                buttonList[i][s].setBorderPainted(false);
                buttonList[i][s].setPreferredSize(new Dimension(100, 100));
                final int x = i;
                final int y = s;
                buttonList[i][s].addActionListener(e -> {eventAction(y, x);});

                add(buttonList[i][s]);
            }
        }
    }

    public void setFigures(BlackFigures blackFigures, WhiteFigures whiteFigures){
        this.blackFigures = blackFigures;
        this.whiteFigures = whiteFigures;
    }


    private String eventStateString = null;
    private FiguresBox figure;
    private Color activeColor = Color.WHITE;

    public void eventAction(int pointX, int pointY){
        System.out.println("Klick: " + pointX + ", " + pointY);
        if (eventStateString == null) {
            if (activeColor == Color.BLACK) {
                for (int i = 0; i < blackFigures.figures.size(); i++) {
                    if (blackFigures.figures.get(i).getX() == pointX * 50 && blackFigures.figures.get(i).getY() == pointY * 50) {
                        figure = blackFigures.figures.get(i);
                        blackFigures.figures.get(i).movement();
                        eventStateString = "SelectedFigure";
                        return;
                    }
                }
            }
            if (activeColor == Color.WHITE) {
                for (int i = 0; i < whiteFigures.figures.size(); i++) {
                    if (whiteFigures.figures.get(i).getX() == pointX * 50 && whiteFigures.figures.get(i).getY() == pointY * 50) {
                        figure = whiteFigures.figures.get(i);
                        whiteFigures.figures.get(i).movement();
                        eventStateString = "SelectedFigure";
                        return;
                    }
                }
            }
        } 
        
        


        else if(eventStateString.equals("SelectedFigure")){
            for (int i = 0; i < figure.getMP().size(); i++) {
                if (figure.getMP().get(i).getX() == pointX * 50 && figure.getMP().get(i).getY() == pointY * 50) {
                    if (figure.getColor() == Color.WHITE) {
                        for (int s = 0; s < blackFigures.figures.size(); s++) {
                            if (blackFigures.figures.get(s).getX() == pointX * 50 && blackFigures.figures.get(s).getY() == pointY * 50 ) {
                                for (int j = 0; j < game.getComponentCount(); j++) {
                                    if (game.getComponent(j).equals(blackFigures.figures.get(s))) {
                                        game.remove(j);
                                        continue;
                                    }
                                }
                                if(blackFigures.figures.get(s) instanceof King){
                                    game.removeAll();
                                    JLabel gameOverLabel = new JLabel("Game Over, White wins!");
                                    gameOverLabel.setForeground(Color.RED);
                                    gameOverLabel.setBounds(100, 100, 800, 50);
                                    gameOverLabel.setFont(gameOverLabel.getFont().deriveFont(50.0f));
                                    game.add(gameOverLabel, BorderLayout.CENTER);
                                }
                                blackFigures.figures.remove(s);
                                continue;
                            }
                        }
                    }

                    if (figure.getColor() == Color.BLACK) {
                        for (int s = 0; s < whiteFigures.figures.size(); s++) {
                            if (whiteFigures.figures.get(s).getX() == pointX * 50 && whiteFigures.figures.get(s).getY() == pointY * 50) {
                                for (int j = 0; j < game.getComponentCount(); j++) {
                                    if (game.getComponent(j).equals(whiteFigures.figures.get(s))) {
                                        game.remove(j);
                                        continue;
                                    }
                                }
                                if(whiteFigures.figures.get(s) instanceof King){
                                    game.removeAll();
                                    JLabel gameOverLabel = new JLabel("Game Over, Black wins!");
                                    gameOverLabel.setForeground(Color.RED);
                                    gameOverLabel.setBounds(100, 100, 800, 50);
                                    gameOverLabel.setFont(gameOverLabel.getFont().deriveFont(50.0f));
                                    game.add(gameOverLabel, BorderLayout.CENTER);
                                }
                                whiteFigures.figures.remove(s);
                                continue;
                            }
                        }
                    }
                    figure.changePosition(pointX * 50, pointY * 50);
                    figure.alreadyMoved = true;

                    if (figure instanceof King) {
                        if (figure.getMP().get(i).getSpecialMove() != null && figure.getMP().get(i).getSpecialMove().equals("castlingLeft")) {
                            for (int s = 0; s < blackFigures.figures.size(); s++) {
                                if (blackFigures.figures.get(s) instanceof Rock && blackFigures.figures.get(s).getX() == 0 && blackFigures.figures.get(s).getY() == pointY * 50) {
                                    blackFigures.figures.get(s).changePosition(150, pointY * 50);
                                    continue;
                                }
                            }
                            for (int s = 0; s < whiteFigures.figures.size(); s++) {
                                if (whiteFigures.figures.get(s) instanceof Rock && whiteFigures.figures.get(s).getX() == 0 && whiteFigures.figures.get(s).getY() == pointY * 50) {
                                    whiteFigures.figures.get(s).changePosition(150, pointY * 50);
                                    continue;
                                }
                            }
                        } else if (figure.getMP().get(i).getSpecialMove() != null && figure.getMP().get(i).getSpecialMove().equals("castlingRight")) {
                            for (int s = 0; s < blackFigures.figures.size(); s++) {
                                if (blackFigures.figures.get(s) instanceof Rock && blackFigures.figures.get(s).getX() == 350 && blackFigures.figures.get(s).getY() == pointY * 50) {
                                    blackFigures.figures.get(s).changePosition(250, pointY * 50);
                                    continue;
                                }
                            }
                            for (int s = 0; s < whiteFigures.figures.size(); s++) {
                                if (whiteFigures.figures.get(s) instanceof Rock && whiteFigures.figures.get(s).getX() == 350 && whiteFigures.figures.get(s).getY() == pointY * 50) {
                                    whiteFigures.figures.get(s).changePosition(250, pointY * 50);
                                    continue;
                                }
                            }
                        } 
                    }
                    if (figure instanceof Pawn) {
                        if ((figure.getColor() == Color.WHITE && figure.getY() == 0) || (figure.getColor() == Color.BLACK && figure.getY() == 350)) {
                            for (MovementPoint p : figure.getMP()) {
                                game.remove(p);
                            }
                            figure.getMP().clear();
                            game.repaint();
                            

                            game.add(new PawnChangePanel(game, this, activeColor, pointX * 50, pointY * 50, blackFigures, whiteFigures), Integer.valueOf(4));
                            if (figure.getColor() == Color.BLACK) {
                                for (int s = 0; s < blackFigures.figures.size(); s++) {
                                    if (blackFigures.figures.get(s).equals(figure)) {
                                        for (int j = 0; j < game.getComponentCount(); j++) {
                                            if (game.getComponent(j).equals(blackFigures.figures.get(s))) {
                                                game.remove(j);
                                                continue;
                                            }
                                        }
                                        blackFigures.figures.remove(s);
                                        continue;
                                    }
                                }
                            }

                            if (figure.getColor() == Color.WHITE) {
                                for (int s = 0; s < whiteFigures.figures.size(); s++) {
                                    if (whiteFigures.figures.get(s).equals(figure)) {
                                        for (int j = 0; j < game.getComponentCount(); j++) {
                                            if (game.getComponent(j).equals(whiteFigures.figures.get(s))) {
                                                game.remove(j);
                                                continue;
                                            }
                                        }
                                        whiteFigures.figures.remove(s);
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                    activeColor = (activeColor == Color.WHITE) ? Color.BLACK : Color.WHITE;



                }
            }
            for (MovementPoint p : figure.getMP()) {
                game.remove(p);
            }
            figure.getMP().clear();
            game.repaint();
            figure = null;
            eventStateString = null;
        } 
    }

    public void setActiveColor(Color color){
        this.activeColor = color;
    }
}
