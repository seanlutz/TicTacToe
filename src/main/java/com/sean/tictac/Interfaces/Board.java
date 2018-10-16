package com.sean.tictac.Interfaces;

import java.util.Map;
import java.util.Set;

import com.sean.tictac.Interfaces.structs.BoardStatus;
import com.sean.tictac.Interfaces.structs.Player;
import com.sean.tictac.Interfaces.structs.Space;


public interface Board {
    
    public Boolean isOver();

    public BoardStatus getStatus();

    public Player currentTurn();

    public Set<Space> getValidMoves();

    public Boolean makeMove(Player player, Space space);

    public Map<Space,Player> cereal();

    public void resetBoard(); 
}
