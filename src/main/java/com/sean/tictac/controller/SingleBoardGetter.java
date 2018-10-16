package com.sean.tictac.controller;

import com.sean.tictac.Interfaces.BoardGetter;
import com.sean.tictac.Interfaces.Game;

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