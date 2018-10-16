package com.sean.tictac.Interfaces.structs;

public enum Player {
    X,
    O;
    public Player swap(){
        if(this==X){
            return O;
        }
        else{
            return X;
        }
    }
}