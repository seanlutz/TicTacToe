package com.sean.tictac;

import java.util.HashMap;

import com.sean.tictac.Interface.API;
import com.sean.tictac.Interface.Board;
import com.sean.tictac.Interface.BoardGetter;
import com.sean.tictac.Interface.Game;
import com.sean.tictac.Interface.structs.Player;
import com.sean.tictac.Interface.structs.Request;
import com.sean.tictac.Interface.structs.RequestStatus;
import com.sean.tictac.Interface.structs.Response;
import com.sean.tictac.Interface.structs.Space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restful implements API {

    @Autowired
    private BoardGetter boardGetter; 


    @PostMapping("/game/{id}/move")
    public Response makeMove(@PathVariable("id") String id, @RequestBody Request request) {
        HashMap<Space, Player> map = new HashMap<Space, Player>();
        map.put(request.space, request.player);
        return new Response(map, RequestStatus.SUCCESS, null, id);
    }
    @GetMapping("/game/{id}/info")
    public Response getBoardInfo(@PathVariable("id") String id) {
        HashMap<Space, Player> map = new HashMap<Space, Player>();
        map.put(Space.A, Player.X);
        return new Response(map, RequestStatus.SUCCESS, null, id);
    }
    @PostMapping("/game/{id}/reset")
    public Response resetBoard(@PathVariable("id") String id) {
        Game game = boardGetter.getGame(id);
        Response resp = game.resetBoard();
		return null;
    }
    @GetMapping("/")
    public String hi() {
        return "I'm Alive!";
    }

}