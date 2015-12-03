package view;

import controller.GameController;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

/**
 * This class is the main View Class
 * It is used to render all GUI Elements
 *
 * Created by an5ra on 9/18/2015.
 */
public class GameView {

    //main Game components
    public JFrame gameContainer = new JFrame("Chess Game");
    public JPanel chessBoard;
    public JPanel gameScreen;
    private JButton[][] chessBoxes;

    //toolbar components
    private JPanel toolBar;
    private JButton newButton;
    private JButton resetButton;
    private JButton undoButton;

    //player-pane components
    private JSplitPane playerPanes;
    private JPanel playerWhite;
    private JPanel playerBlack;
    private JLabel playerBlackName;
    private JLabel playerWhiteName;
    private JLabel playerBlackImage;
    private JLabel playerWhiteImage;
    private JButton playerBlackForfeitButton;
    private JButton playerWhiteForfeitButton;
    private JLabel playerBlackScore;
    private JLabel playerWhiteScore;

    //undo-game variables
    JButton lastSource;
    JButton lastDestination;
    Icon lastSourceIcon;
    Icon lastDestinationIcon;


    Image chessPieceImages[][];

    //These numbers are determined by each sub image in the sprite-sheet
    //as fitted in the 2D Images Array
    public static final int QUEEN = 0;
    public static final int KING = 1;
    public static final int BISHOP = 2;
    public static final int KNIGHT = 3;
    public static final int ROOK = 4;
    public static final int PAWN = 5;
    public static final int BLACK = 0;
    public static final int WHITE = 1;


    /**
     * Constructor method
     */
    public GameView()
    {
        prepareGUI();
    }

    public static void main(String[] args){
        GameView chessGame = new GameView();
    }

    /**
     * Calls all the helper functions to create the initial
     * game plan
     */
    private void prepareGUI(){

        //Setting Look and Feel of the Frame
        setLookAndFeel();

        gameContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Initializing Game Container and adding ChessBoard
        createAndAddGameContainer();
        createAndAddChessBoard();

        //toolbar
        createToolbar();

        //Creating and adding Player Panes
        setPlayerBlackPane();
        setPlayerWhitePane();
        addPlayerPanes();

        //Creating Piece Images and adding them to the ChessBoard
        createImages();
        drawPiecesForNewGame();
        gameContainer.pack();

    }

    /**
     * sets the look and feel of the UI
     */
    private void setLookAndFeel() {
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
    }

    /**
     * creates the Game Screen and adds to the container
     */
    private void createAndAddGameContainer() {
        gameScreen = new JPanel(new BorderLayout(3, 3));
        gameScreen.setBorder(new EmptyBorder(5, 5, 5, 5));

        gameContainer.getContentPane().add(gameScreen, BorderLayout.CENTER);
    }

    /**
     * creates the chessboard and adds to the gamescreen
     */
    private void createAndAddChessBoard() {
        chessBoard = new JPanel(new GridLayout(0, 9));
        //Black and White Board Boxes are created and added
        createChessBoxes();
        gameScreen.add(chessBoard, BorderLayout.CENTER);
    }

    /**
     * creates the player panes and calls
     */
    private void addPlayerPanes() {
        playerPanes = new JSplitPane(JSplitPane.VERTICAL_SPLIT,playerBlack,playerWhite);
        playerPanes.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        gameContainer.getContentPane().add(playerPanes, BorderLayout.LINE_END);

    }

    /**
     * creates and adds white player pane
     */
    private void setPlayerWhitePane() {
        playerWhite = new JPanel();
        playerWhite.setLayout(new BoxLayout(playerWhite, BoxLayout.Y_AXIS));
        playerWhiteName = new JLabel("Amaze");
        playerWhiteName.setFont(new Font("Arial", Font.BOLD, 65));
        playerWhite.add(playerWhiteName);
        try {
            //Online source for the Chess Piece Images
            URL url = new URL("https://upload.wikimedia.org/wikipedia/en/e/ee/Roadrunner_looney_tunes.png");
            BufferedImage bi = ImageIO.read(url);
            playerWhiteImage = new JLabel(new ImageIcon(bi));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Img Src Unavailable");
            System.exit(1);
        }
        playerWhiteImage.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));
        playerWhite.add(playerWhiteImage);
        playerWhiteForfeitButton = new JButton("FORFEIT");
        setAndAddForfeitButton(playerWhiteForfeitButton, playerWhite);
        playerWhiteScore = new JLabel("Score: 0");
        setAndAddScore(playerWhiteScore,playerWhite);
        playerWhiteName.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerWhiteImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerWhiteForfeitButton.setActionCommand("w");
    }

    /**
     * Used to set forfeit buttons for player panes
     * @param forfeitButton the button to be added
     * @param playerPane the pane to be added to
     */
    private void setAndAddForfeitButton(JButton forfeitButton, JPanel playerPane) {
        forfeitButton.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        forfeitButton.setPreferredSize(new Dimension(300, 100));
        forfeitButton.setFont(new Font("Arial", Font.BOLD, 40));
        playerPane.add(forfeitButton);
        forfeitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * Used to set score for player panes
     * @param score JLabel playerscore
     * @param playerPane the pane to be added
     */
    private void setAndAddScore(JLabel score, JPanel playerPane)
    {
        score.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        score.setPreferredSize(new Dimension(300, 100));
        score.setFont(new Font("Arial", Font.BOLD, 60));
        playerPane.add(score);
        score.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * creates and adds black player pane
     */
    private void setPlayerBlackPane() {
        playerBlack = new JPanel();
        playerBlack.setLayout(new BoxLayout(playerBlack, BoxLayout.Y_AXIS));
        playerBlackName = new JLabel("Rob");
        playerBlackName.setFont(new Font("Arial", Font.BOLD, 65));
        playerBlack.add(playerBlackName);
        try {
            //Online source for the Chess Piece Images
            URL url = new URL("https://upload.wikimedia.org/wikipedia/en/5/56/Wile_E_Coyote.png");
            BufferedImage bi = ImageIO.read(url);
            playerBlackImage = new JLabel(new ImageIcon(bi));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Img Src Unavailable");
            System.exit(1);
        }
        playerBlackImage.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));
        playerBlack.add(playerBlackImage);
        playerBlackForfeitButton = new JButton("FORFEIT");
        setAndAddForfeitButton(playerBlackForfeitButton, playerBlack);
        playerBlackScore = new JLabel("Score: 0");
        setAndAddScore(playerBlackScore, playerBlack);
        playerBlackName.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerBlackImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerBlackForfeitButton.setActionCommand("b");
    }

    /**
     * Used to create and add the toolbar to the gamescreen
     */
    private void createToolbar() {
        newButton = new JButton("New");
        resetButton = new JButton("Reset");
        undoButton = new JButton("Undo");
        newButton.setPreferredSize(new Dimension(300, 100));
        resetButton.setPreferredSize(new Dimension(300, 100));
        undoButton.setPreferredSize(new Dimension(300, 100));
        resetButton.setFont(new Font("Arial", Font.PLAIN, 40));
        undoButton.setFont(new Font("Arial", Font.PLAIN, 40));
        newButton.setFont(new Font("Arial", Font.PLAIN, 40));


        toolBar = new JPanel();
        toolBar.add(newButton);
        toolBar.add(resetButton);
        toolBar.add(undoButton);

        //setting Action Commands
        newButton.setActionCommand("n");
        undoButton.setActionCommand("u");
        resetButton.setActionCommand("r");

        undoButton.setEnabled(false);

        gameScreen.add(toolBar, BorderLayout.PAGE_START);
    }

    /**
     * Used to show the entire JFrame or the Game window
     */
    public void show()
    {
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

        chessBoxes = new JButton[8][8];

        for(int row = 7; row >= 0; row--){
            for(int col = 0; col < 8; col++){

                chessBoxes[row][col] = new JButton();
                chessBoxes[row][col].setOpaque(true);
                chessBoxes[row][col].setBackground(getBoxColor(row, col));
                chessBoxes[row][col].setForeground(getBoxColor(row, col));
                chessBoard.add(chessBoxes[row][col]);
                chessBoxes[row][col].setActionCommand(row + " " + col);
            }
        }
    }

    /**
     * to add listeners to the chessbox buttons
     * @param listener the listener passed from the Controller
     */
    public void addBoxListeners(ActionListener listener)
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0;j<8;j++)
            {
                chessBoxes[i][j].addActionListener(listener);
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
     * This function returns the appropriate chessBoxes color
     *
     * @param row
     * @param col
     * @return Color of the Box
     */
    public Color getBoxColor(int row, int col){

        //Calculation for spot color
        if((row + col) % 2 == 0)
            return new Color(102, 102, 102); //BLACK RGB
        else
            return new Color(255, 255, 255); //WHITE RGB
    }
    /**
     * This function gets the image from the chessPieceImages array and sets the appropriate chessBoxes's icon
     */
    public void drawPiecesForNewGame(){

        for(int row = 7; row>= 0; row--){
            for(int col = 0; col < 8; col++){

                //WHITE PAWNS
                if(row == 6){
                    chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][PAWN]));
                }
                //BLACK PAWNS
                else if(row == 1){
                    chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][PAWN]));
                }
                //WHITE FACE PIECES
                else if(row == 7){
                    if(col == 0 || col == 7)
                        chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][ROOK]));
                    else if(col == 1 || col == 6)
                        chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][KNIGHT]));
                    else if(col == 2 || col == 5)
                        chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][BISHOP]));
                    else if(col == 4)
                        chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][QUEEN]));
                    else if(col == 3)
                        chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[WHITE][KING]));
                }
                //BLACK FACE PIECES
                else if(row == 0){
                    if(col == 0 || col == 7)
                        chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][ROOK]));
                    else if(col == 1 || col == 6)
                        chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][KNIGHT]));
                    else if(col == 2 || col == 5)
                        chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][BISHOP]));
                    else if(col == 4)
                        chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][QUEEN]));
                    else if(col == 3)
                        chessBoxes[row][col].setIcon(new ImageIcon(chessPieceImages[BLACK][KING]));
                }
            }

        }
        try {
            //Online source for the Chess Piece Images
            URL url = new URL("http://www.rhinoink.ca/rhinos/images/games/chess-piece.png");
            BufferedImage bi = ImageIO.read(url);
            chessBoxes[0][0].setIcon(new ImageIcon(bi));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Img Src Unavailable");
            System.exit(1);
        }
    }

    /**
     * Used to mark a selected box
     * @param row
     * @param col
     */
    public void setBoxAsSelected(int row, int col) {
        chessBoxes[row][col].setBackground(Color.CYAN);
    }

    /**
     * Used to mark a box as one of the possible moves
     * ONLY CALLED AFTER THE SOURCE BOX IS SELECTED
     * @param row of the possible box
     * @param col of the possible box
     */
    public void setBoxAsPossible(int row, int col) {
        chessBoxes[row][col].setBackground(Color.GREEN);
    }

    /**
     * Main view logic for moving a piece
     * Does that by setting the destination's icon
     * as the Source's icon
     * @param sourceRow
     * @param sourceCol
     * @param destRow
     * @param destCol
     */
    public void moveBox(int sourceRow, int sourceCol, int destRow, int destCol) {
        undoButton.setEnabled(true);
        JButton source = chessBoxes[sourceRow][sourceCol];
        lastSource = source;
        JButton destination = chessBoxes[destRow][destCol];
        lastDestination = destination;
        Icon sourceIcon = source.getIcon();
        lastSourceIcon = sourceIcon;
        lastDestinationIcon = destination.getIcon();
        destination.setIcon(sourceIcon);
        source.setIcon(null);
    }

    /**
     * Used to set all the boxes to their initial color
     * Used to reset color after a valid/invalid move is made
     */
    public void setBoxesToNormal() {
        for(int i=0; i<8; i++)
        {
            for(int j=0;j<8;j++)
            {

                chessBoxes[i][j].setBackground(getBoxColor(i,j));
            }
        }
    }

    /**
     * Used to set a box in danger (RED)
     * @param row
     * @param col
     */
    public void setBoxAsInDanger(int row, int col) {
        chessBoxes[row][col].setBackground(Color.RED);
    }

    /**
     * Used to change both players' panes' color
     * to show which is in turn
     * @param playerColor
     */
    public void changePlayerPaneColor(String playerColor)
    {
        if(playerColor.equalsIgnoreCase("black"))
        {
            playerBlack.setBackground(Color.YELLOW);
            playerWhite.setBackground(Color.LIGHT_GRAY);
        }
        else
        {
            playerWhite.setBackground(Color.YELLOW);
            playerBlack.setBackground(Color.LIGHT_GRAY);
        }
    }

    /**
     * resets all pieces (i.e. their icons) to their positions
     * @param specialOrNot
     */
    public void resetGame(boolean specialOrNot)
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0;j<8;j++)
            {
                chessBoxes[i][j].setBackground(getBoxColor(i,j));
                chessBoxes[i][j].setIcon(null);
                drawPiecesForNewGame();
            }
        }
        undoButton.setEnabled(false);
    }

    /**
     * sets the score of the black player
     * @param score
     */
    public void setBlackScore(int score)
    {
        playerBlackScore.setText("Score: " + Integer.toString(score));
    }

    /**
     * sets the score of the white player
     * @param score
     */
    public void setWhiteScore(int score)
    {
        playerWhiteScore.setText("Score: " + Integer.toString(score));
    }

    /**
     * adds listeners for forfiet and other buttons
     * @param forfeitListener
     */
    public void addForFeitAndResetListeners(ActionListener forfeitListener) {
        playerBlackForfeitButton.addActionListener(forfeitListener);
        playerWhiteForfeitButton.addActionListener(forfeitListener);
        newButton.addActionListener(forfeitListener);
        resetButton.addActionListener(forfeitListener);


    }

    /**
     * main logic for undoing last move
     */
    public void undoGame() {

//        System.out.println("Im being called!");

        lastSource.setIcon(lastSourceIcon);
        lastDestination.setIcon(lastDestinationIcon);

    }

    /**
     * function to add listener to the undo button
     * @param undoListener
     */
    public void addUndoListeneer(ActionListener undoListener) {

        undoButton.addActionListener(undoListener);
    }
}
