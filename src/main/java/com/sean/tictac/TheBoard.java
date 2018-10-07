package com.sean.tictac;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sean.tictac.Interface.Board;
import com.sean.tictac.Interface.structs.BoardStatus;
import com.sean.tictac.Interface.structs.Player;
import com.sean.tictac.Interface.structs.Space;

public class TheBoard implements Board {
    Map<Space,Player> moves; 
    BoardStatus status;

    public TheBoard(){
        moves = new HashMap<Space,Player>();
        status = BoardStatus.TURNX;
    }

    public Boolean isOver() {
        return over;
    }

    public BoardStatus getStatus() {
        if{}
        return null;
    }

    public Player currentTurn() {
        return turn;
    }

    public Set<Space> getValidMoves() {
        return null;
    }

    public Boolean makeMove(Player player, Space space) {
        
        return null;
    }

    @Override
    public Map<Space, Player> cereal() {
        return null;
	}

	@Override
	public void resetBoard() {
		
	}

}