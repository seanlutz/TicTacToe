package com.sean.tictac.Interface;

import com.sean.tictac.Interface.structs.Request;
import com.sean.tictac.Interface.structs.Response;

public interface API {

    public Response makeMove(Request request);

    public Response getBoardInfo();

    public Response resetBoard();
}