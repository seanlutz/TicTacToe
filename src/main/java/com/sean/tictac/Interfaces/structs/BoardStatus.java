package com.sean.tictac.Interfaces.structs;

public enum BoardStatus {
    WINX(Player.X, true),
    WINO(Player.O, true),
    DRAW(null, true),
    TURNX(Player.X, false),
    TURNO(Player.O, false);
    public final Player player;  
    public final Boolean isOver;
    BoardStatus(Player player, Boolean isOver) {
        this.player = player;
        this.isOver = isOver;
    }
    public BoardStatus swapTurns(){
        switch(this){
            case TURNX: return TURNO;
            case TURNO: return TURNX;
            default: return null;
        }
    }
}