import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();

    JFrame frame = new JFrame();
    JLabel textField = new JLabel();
    JPanel title = new JPanel();
    JPanel button = new JPanel();
    JButton[] buttons = new JButton[9];
    JButton reset = new JButton("Reset Board");

    boolean player1Turn;


    TicTacToe(){
        // Setting up frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(new BorderLayout()); //try null
        frame.setVisible(true);

        // Setting up text
        textField.setBackground(new Color(50,50,50));
        textField.setForeground(Color.green);
        textField.setFont(new Font("Onyx", Font.PLAIN, 100));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,100);

        button.setLayout(new GridLayout(3,3));
        button.setBackground(new Color(255,255,50)); //This will be covered so the color standing out is a good thing

        //reset.setBounds(700,25,100,700);


        //loop to take care of buttons
        for(int i=0; i<9; i++){
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("Helvetica", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title.add(textField);
        //frame.add(reset);
        frame.add(title,BorderLayout.NORTH);
        frame.add(button);

        firstTurn();

    }

    public void firstTurn(){
        try {
            Thread.sleep(3000); // Displays beautiful title text before showing who's turn it is
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2) == 0){
            player1Turn = true;
            textField.setText("X's turn");
        }
        else{
            player1Turn = false;
            textField.setText("O's turn");
        }
    }
    public void winner(int a, int b, int c, String winner){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText(winner + " wins");
    }

    public void check(){
        for(int i=0; i<9; i++){

            if(buttons[0].getText() == "X"
            && buttons[1].getText() == "X"
            && buttons[2].getText() == "X"){
                winner(0,1,2,"X");
            }

            if(buttons[3].getText() == "X"
                    && buttons[4].getText() == "X"
                    && buttons[5].getText() == "X"){
                winner(3,4,5,"X");
            }

            if(buttons[6].getText() == "X"
                    && buttons[7].getText() == "X"
                    && buttons[8].getText() == "X"){
                winner(6,7,8,"X");
            }
            if(
                    (buttons[0].getText()=="X") &&
                            (buttons[3].getText()=="X") &&
                            (buttons[6].getText()=="X")
            ) {
                winner(0,3,6,"X");
            }
            if(
                    (buttons[1].getText()=="X") &&
                            (buttons[4].getText()=="X") &&
                            (buttons[7].getText()=="X")
            ) {
                winner(1,4,7,"X");
            }
            if(
                    (buttons[2].getText()=="X") &&
                            (buttons[5].getText()=="X") &&
                            (buttons[8].getText()=="X")
            ) {
                winner(2,5,8,"X");
            }
            if(
                    (buttons[0].getText()=="X") &&
                            (buttons[4].getText()=="X") &&
                            (buttons[8].getText()=="X")
            ) {
                winner(0,4,8,"X");
            }
            if(
                    (buttons[2].getText()=="X") &&
                            (buttons[4].getText()=="X") &&
                            (buttons[6].getText()=="X")
            ) {
                winner(2,4,6,"X");
            }
            //check O win conditions
            if(
                    (buttons[0].getText()=="O") &&
                            (buttons[1].getText()=="O") &&
                            (buttons[2].getText()=="O")
            ) {
                winner(0,1,2,"O");
            }
            if(
                    (buttons[3].getText()=="O") &&
                            (buttons[4].getText()=="O") &&
                            (buttons[5].getText()=="O")
            ) {
                winner(3,4,5,"O");
            }
            if(
                    (buttons[6].getText()=="O") &&
                            (buttons[7].getText()=="O") &&
                            (buttons[8].getText()=="O")
            ) {
                winner(6,7,8,"O");
            }
            if(
                    (buttons[0].getText()=="O") &&
                            (buttons[3].getText()=="O") &&
                            (buttons[6].getText()=="O")
            ) {
                winner(0,3,6,"O");
            }
            if(
                    (buttons[1].getText()=="O") &&
                            (buttons[4].getText()=="O") &&
                            (buttons[7].getText()=="O")
            ) {
                winner(1,4,7,"O");
            }
            if(
                    (buttons[2].getText()=="O") &&
                            (buttons[5].getText()=="O") &&
                            (buttons[8].getText()=="O")
            ) {
                winner(2,5,8,"O");
            }
            if(
                    (buttons[0].getText()=="O") &&
                            (buttons[4].getText()=="O") &&
                            (buttons[8].getText()=="O")
            ) {
                winner(0,4,8,"O");
            }
            if(
                    (buttons[2].getText()=="O") &&
                            (buttons[4].getText()=="O") &&
                            (buttons[6].getText()=="O")
            ) {
                winner(2,4,6,"O");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //checking each of the buttons
        for(int i=0; i<9; i++){
            if(e.getSource() == buttons[i]){
                if(player1Turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1Turn=false;
                        textField.setText("O's turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,120,255));
                        buttons[i].setText("O");
                        player1Turn=true;
                        textField.setText("X's turn");
                        check();
                    }
                }
            }
        }
    }
}
