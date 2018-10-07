package com.sean.tictac;

import com.sean.tictac.Interface.Board;
import com.sean.tictac.Interface.Game;
import com.sean.tictac.Interface.structs.Player;
import com.sean.tictac.Interface.structs.RequestStatus;
import com.sean.tictac.Interface.structs.Response;
import com.sean.tictac.Interface.structs.Space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Gametime implements Game {

    @Autowired
    public Board board; 


    public Response makeMove(Player player, Space space) {
        RequestStatus status = null;
        if(board.isOver()){
            status=RequestStatus.GAMEOVER;
        }
        else if(player != board.currentTurn()){
            status = RequestStatus.WRONGTURN;
        }
        else if(!board.getValidMoves().contains(space) ){
            status = RequestStatus.INVALIDMOVE;
        }
        else{
            board.makeMove(player, space);

            if(board.isOver()){
                status = RequestStatus.GAMEOVER;
            }
            else{
                status = RequestStatus.CONTINUE;
            }
        }
        return new Response(
            board.cereal(), status, board.getStatus(), "");
    }


    public Response getBoardInfo() {
        return new Response(
            board.cereal(), 
            board.isOver() ? RequestStatus.GAMEOVER : RequestStatus.CONTINUE,
            board.getStatus(), 
            ""
            );
    }


	public Response resetBoard() {
        board.resetBoard();
        return new Response(
            board.cereal(), 
            RequestStatus.CONTINUE,
            board.getStatus(), 
            ""
            );
	}

}