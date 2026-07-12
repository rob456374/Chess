# Chess
I have developed a chess game that includes all standard pieces, special moves such as castling,
and the game currently ends when the king is captured rather than detecting checkmate according to the official chess rules.

The file ChessMain.java is managing it. It creats a JFrame, add the board and the black and white pieces. 
Every piece has an box with the size 100*100 px and are subclasses of FiguresBox.
Every piece has an movement-Funktion.
The board is made of JButtons and have EventListener.
If you click an button, it checks, if there is a piece over it and if there is, it execute the movement-Funktion of the piece.
This adds many MovementPoints to the board and if you click another button, it checks if there is an MovementPoint.
If there is, the piece is going there and if there is another figure, it captures it.
After moving it sets the AlwaysMoved_Attribute to true, so that you can't go two places with your pawn, or castle your king.
After every move it checks if there is the king still alive, else it shows "Game Over, _ wins".
If a pawn hits the other side it can promote into queen, rook, bishop or knight.

ps: I'm sorry for calling it "rock" most time
