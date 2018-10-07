package com.sean.tictac.Interface;

import com.sean.tictac.Interface.structs.Request;
import com.sean.tictac.Interface.structs.Response;

public interface API {

    public Response makeMove(String id, Request request);

    public Response getBoardInfo(String id);

    public Response resetBoard(String id);
}