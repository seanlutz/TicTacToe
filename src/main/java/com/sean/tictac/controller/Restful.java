package com.sean.tictac.controller;

import com.sean.tictac.Interfaces.API;
import com.sean.tictac.Interfaces.BoardGetter;
import com.sean.tictac.Interfaces.Game;
import com.sean.tictac.Interfaces.structs.Request;
import com.sean.tictac.Interfaces.structs.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// not used because switched to pure java swing based front end. uncomment line below for rest server
// @RestController
public class Restful implements API {

    @Autowired
    private BoardGetter boardGetter; 


    @PostMapping("/game/{id}/move")
    public Response makeMove(@PathVariable("id") String id, @RequestBody Request request) {
        Game game = boardGetter.getGame(id);
        Response resp = game.makeMove(request.player, request.space);
		return resp;
    }


    public Response getBoardInfo(@PathVariable("id") String id) {
        Game game = boardGetter.getGame(id);
        Response resp = game.getBoardInfo();
		return resp;
    }

    @PostMapping("/game/{id}/reset")
    public Response resetBoard(@PathVariable("id") String id) {
        Game game = boardGetter.getGame(id);
        Response resp = game.resetBoard();
		return resp;
    }

    @GetMapping("/")
    public String hi(){
        return "I'm Alive!";
    }

}