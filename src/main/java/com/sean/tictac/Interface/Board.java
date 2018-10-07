package com.sean.tictac.Interface;

import java.util.Map;
import java.util.Set;

import com.sean.tictac.Interface.structs.BoardStatus;
import com.sean.tictac.Interface.structs.Player;
import com.sean.tictac.Interface.structs.Space;


public interface Board {
    
    public Boolean isOver();

    public BoardStatus getStatus();

    public Player currentTurn();

    public Set<Space> getValidMoves();

    public Boolean makeMove(Player player, Space space);

    public Map<Space,Player> cereal();

    public void resetBoard(); 
}
