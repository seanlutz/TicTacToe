package com.sean.tictac.controller;

import com.sean.tictac.Interfaces.API;
import com.sean.tictac.Interfaces.BoardGetter;
import com.sean.tictac.Interfaces.Game;
import com.sean.tictac.Interfaces.structs.Request;
import com.sean.tictac.Interfaces.structs.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasicController implements API {

    @Autowired
    private BoardGetter boardGetter; 

    public Response makeMove(String id, Request request) {
        Game game = boardGetter.getGame(id);
        Response resp = game.makeMove(request.player, request.space);
		return resp;
    }

    public Response getBoardInfo(String id) {
        Game game = boardGetter.getGame(id);
        Response resp = game.getBoardInfo();
		return resp;
    }

    public Response resetBoard(String id) {
        Game game = boardGetter.getGame(id);
        Response resp = game.resetBoard();
		return resp;
	}

}