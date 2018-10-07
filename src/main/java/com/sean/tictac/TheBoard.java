package com.sean.tictac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sean.tictac.Interface.Board;
import com.sean.tictac.Interface.structs.BoardStatus;
import com.sean.tictac.Interface.structs.Player;
import com.sean.tictac.Interface.structs.Space;

import org.springframework.stereotype.Component;

@Component
public class TheBoard implements Board {
    Map<Space,Player> moves; 
    BoardStatus status;
    Set<Space> remainingMoves; 

    public TheBoard(){
        resetBoard();
    }

    public void resetBoard() {
        moves = new HashMap<Space,Player>();
        status = BoardStatus.TURNX;
        remainingMoves = new HashSet<Space>(Arrays.asList(Space.values()));
	}

    public Boolean isOver() {
        return status.isOver;
    }

    public BoardStatus getStatus() {
        return status;
    }

    public Player currentTurn() {
        switch(status){
            case TURNX: return Player.X;
            case TURNO: return Player.O;
            default: return null;
        }
    }

    public Set<Space> getValidMoves() {
        return isOver() ? new HashSet<Space>(): remainingMoves;
    }

    public Boolean makeMove(Player player, Space space) {
        if(!getValidMoves().contains(space)){
            return false;
        }
        else{
            moves.put(space, player);
            remainingMoves.remove(space);
            status = checkWinner(status);
            switch(status){
                case TURNX: status=BoardStatus.TURNO; break;
                case TURNO: status=BoardStatus.TURNX; break;
                default: break;
            }
            return true;
        }
    }
    public Map<Space, Player> cereal() {
        return moves;
    }

    private BoardStatus checkWinner(BoardStatus status) {
        Player horiz = checkHoriz();
        if (horiz != null){
            return horiz == Player.X ? BoardStatus.WINX : BoardStatus.WINO;
        }
        Player vert = checkVert();
        if (vert != null){
            return vert == Player.X ? BoardStatus.WINX : BoardStatus.WINO;
        }
        Player diag = checkDiag();
        if (diag != null){
            return diag == Player.X ? BoardStatus.WINX : BoardStatus.WINO;
        }
        if(moves.size() == 9){
            return BoardStatus.DRAW;
        }
        return status;
    }
    private Player check(Space a, Space b, Space c){
        if (moves.get(a) == moves.get(b)
         && moves.get(b) == moves.get(c) 
         && moves.get(c) != null)
         {
             return moves.get(c);
         }
         else{
              return null;}
    }

	private Player checkHoriz() {
        Player row1 = check(Space.A, Space.B, Space.C);
        if(row1 != null){return row1;}
        Player row2 = check(Space.D, Space.E, Space.F);
        if(row2 != null){return row2;}
        Player row3 = check(Space.G, Space.H, Space.I);
        if(row3 != null){return row3;}
        return null;
    }

    private Player checkVert() {
        Player row1 = check(Space.A, Space.D, Space.G);
        if(row1 != null){return row1;}
        Player row2 = check(Space.B, Space.E, Space.H);
        if(row2 != null){return row2;}
        Player row3 = check(Space.C, Space.F, Space.I);
        if(row3 != null){return row3;}
        return null;
    }

    private Player checkDiag(){
        Player row1 = check(Space.A, Space.E, Space.I);
        if(row1 != null){return row1;}
        Player row2 = check(Space.C, Space.E, Space.G);
        if(row2 != null){return row2;}
        return null;
    }

}