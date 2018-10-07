package com.sean.tictac;

import com.sean.tictac.Interface.BoardGetter;
import com.sean.tictac.Interface.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleBoardGetter implements BoardGetter {

    @Autowired
    Game game;

    public Game getGame(String id) {
        return game;
	}

}