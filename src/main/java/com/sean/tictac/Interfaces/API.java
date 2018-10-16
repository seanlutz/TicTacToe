package com.sean.tictac.Interfaces;

import com.sean.tictac.Interfaces.structs.Request;
import com.sean.tictac.Interfaces.structs.Response;

public interface API {

    public Response makeMove(String id, Request request);

    public Response getBoardInfo(String id);

    public Response resetBoard(String id);
}