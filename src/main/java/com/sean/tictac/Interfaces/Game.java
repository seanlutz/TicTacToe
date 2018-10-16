package com.sean.tictac.Interfaces;

import com.sean.tictac.Interfaces.structs.Player;
import com.sean.tictac.Interfaces.structs.Response;
import com.sean.tictac.Interfaces.structs.Space;

public interface Game {

    public Response makeMove(Player player, Space space);

    public Response getBoardInfo();

	public Response resetBoard();

}