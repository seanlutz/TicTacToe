package com.sean.tictac.Interface;

import com.sean.tictac.Interface.structs.Player;
import com.sean.tictac.Interface.structs.Response;
import com.sean.tictac.Interface.structs.Space;

public interface Game {

    public Response makeMove(Player player, Space space);

    public Response getBoardInfo();

	public Response resetBoard();

}