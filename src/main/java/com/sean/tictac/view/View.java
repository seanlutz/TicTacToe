package com.sean.tictac.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sean.tictac.Interfaces.API;
import com.sean.tictac.Interfaces.structs.Player;
import com.sean.tictac.Interfaces.structs.Request;
import com.sean.tictac.Interfaces.structs.Response;
import com.sean.tictac.Interfaces.structs.Space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class View {
    public JFrame gui;
    public Player player;
    public int movesLeft;
    public JButton[][] blocks;
    public JButton reset;
    public JTextArea playerturn;

    @Autowired
    private API api;   

    public View(){
        makeNewGameboard();
        gui.setVisible(true);
    }
    public void makeNewGameboard(){
        gui = new JFrame("Tic Tac Toe");
        blocks = new JButton[3][3];
        reset = new JButton("Reset");
        playerturn= new JTextArea();
        player = Player.X;
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(1000, 700));
        gui.setResizable(true);

        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerturn);
        playerturn.setText("Player 1 to play 'X'");

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
            });
        for(int row = 0; row<3 ;row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                blocks[row][column].setText("");
                blocks[row][column].putClientProperty( "place", getPlace(row,column) );

                game.add(blocks[row][column]);
                blocks[row][column].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        attemptMove((Space)((JButton)e.getSource()).getClientProperty("place"));
                    }
                });
            }
        }
    }


    private void resetGame(){
        api.resetBoard("0");
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                blocks[i][j].setText("");
                blocks[i][j].setEnabled(true);
            }
        }
        player = Player.X;
        playerturn.setText("Its X's turn");
    }

    private void attemptMove(Space place){
        Response resp = api.makeMove("null", new Request(player, place));
        switch(resp.requestStatus){
            case CONTINUE:{
                blocks[place.row][place.col].setText(player.toString());
                blocks[place.row][place.col].setEnabled(false);
                player = player.swap();
                playerturn.setText("Its "+player+ "'s turn");
                break;
            }
            case GAMEOVER:{
                blocks[place.row][place.col].setText(player.toString());
                for(int i=0; i<3; i++) {
                    for(int j=0; j<3; j++) {
                        blocks[i][j].setEnabled(false);
                    }
                }
                playerturn.setText(resp.boardStatus.toString());
                break;
            }
            default:break;
        }
    }
 
    private Space getPlace(int row, int column){
        return Space.values()[3*row + column];
    }

    
}