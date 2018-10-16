package com.sean.tictac.Interfaces.structs;

// A | B | C
//----------
// D | E | F
// ---------
// G | H | I 
public enum Space {
    A(0,0),
    B(0,1),
    C(0,2),
    D(1,0),
    E(1,1),
    F(1,2),
    G(2,0),
    H(2,1),
    I(2,2);
    
    public final int col;
    public final int row;
    Space(int row, int col){
        this.row=row;
        this.col=col;
    }
}