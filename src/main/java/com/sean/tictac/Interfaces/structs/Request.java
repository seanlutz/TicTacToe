package com.sean.tictac.Interfaces.structs;

public class Request {
    public Player player;
    public Space space;

    public Request(Player player, Space space){
        this.player=player;
        this.space=space;
    }
}