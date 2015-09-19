package view;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

/**
 * This class is used to
 * Created by an5ra on 9/18/2015.
 */
public class ChessGUI{

    private JFrame gameContainer = new JFrame("Chess Game");
    private JPanel chessBoard;
    private JPanel gameScreen;
    private JButton[][] chessBox;

    Image chessPieceImages[][];

    //These numbers are determined by each sub image in the sprite-sheet
    //as fitted in the 2D Images Array
    public static final int QUEEN = 0;
    public static final int KING = 1;
    public static final int ROOK = 4;
    public static final int KNIGHT = 3;
    public static final int BISHOP = 2;
    public static final int PAWN = 5;
    public static final int BLACK = 0;
    public static final int WHITE = 1;


    public ChessGUI()
    {
        prepareGUI();
    }

    public static void main(String[] args){
        ChessGUI chessGame = new ChessGUI();
    }

    /**
     * Calls all the helper functions to create the initial
     * game plan
     */
    private void prepareGUI(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, default LAF is used
        }

        createImages();

        gameScreen = new JPanel(new BorderLayout(3, 3));
        gameScreen.setBorder(new EmptyBorder(5, 5, 5, 5));

        chessBoard = new JPanel(new GridLayout(0, 9));
        gameScreen.add(chessBoard);
        gameContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameContainer.getContentPane().add(gameScreen, BorderLayout.CENTER);
        gameContainer.pack();

        //Black and White Board Boxes are created and added
        createChessBoxes();
        drawPiecesForNewGame();

        //show the JFrame
        gameContainer.setVisible(true);
        gameContainer.setSize(1500, 1500);

    }

    /**
     * Creates and adds ChessBoxes to the ChessBoard
     */
    public void createChessBoxes(){
        LayoutManager layout = new GridLayout(8, 8);
        chessBoard.setLayout(layout);

        chessBox = new JButton[8][8];

        for(int row = 7; row >= 0; row--){
            for(int col = 0; col < 8; col++){

                chessBox[row][col] = new JButton();
                chessBox[row][col].setOpaque(true);
                chessBox[row][col].setBackground(getBoxColor(row, col));
                chessBox[row][col].setForeground(getBoxColor(row, col));
                chessBoard.add(chessBox[row][col]);
            }
        }
    }


    /**
     * This function uses an online sprite sheet to extract piece images
     */
    public void createImages() {

        chessPieceImages = new Image[2][6];
        try {
            //Online source for the Chess Piece Images
            URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Chess_Pieces_Sprite.svg/800px-Chess_Pieces_Sprite.svg.png");
            BufferedImage bi = ImageIO.read(url);
            for (int imageRow = 0; imageRow < 2; imageRow++) {
                for (int imageCol = 0; imageCol < 6; imageCol++) {
                    chessPieceImages[imageRow][imageCol] = bi.getSubimage(
                            imageCol * 133, imageRow * 133, 133, 133);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Img Src Unavailable");
            System.exit(1);
        }

        //special pieces
        //http://www.rhinoink.ca/rhinos/images/games/chess-piece.png
    }
    /**
     * This function returns the appropriate chessBox color
     *
     * @param row
     * @param col
     * @return Color of the Box
     */
    public Color getBoxColor(int row, int col){

        //Calculation for spot color
        if((row + col) % 2 == 0)
            return new Color(102, 102, 102);
        else
            return new Color(255, 255, 255);
    }
    /**
     * This function gets the image from the chessPieceImages array and sets the appropriate chessBox's icon
     */
    public void drawPiecesForNewGame(){

        for(int row = 7; row>= 0; row--){
            for(int col = 0; col < 8; col++){

                //WHITE PAWNS
                if(row == 1){
                    chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][PAWN]));
                }
                //BLACK PAWNS
                else if(row == 6){
                    chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][PAWN]));
                }
                //WHITE FACE PIECES
                else if(row == 0){
                    if(col == 0 || col == 7)
                        chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][ROOK]));
                    else if(col == 1 || col == 6)
                        chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][KNIGHT]));
                    else if(col == 2 || col == 5)
                        chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][BISHOP]));
                    else if(col == 3)
                        chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][QUEEN]));
                    else if(col == 4)
                        chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][KING]));
                }
                //BLACK FACE PIECES
                else if(row == 7){
                    if(col == 0 || col == 7)
                        chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][ROOK]));
                    else if(col == 1 || col == 6)
                        chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][KNIGHT]));
                    else if(col == 2 || col == 5)
                        chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][BISHOP]));
                    else if(col == 3)
                        chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][QUEEN]));
                    else if(col == 4)
                        chessBox[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][KING]));
                }
            }
        }
    }
}
