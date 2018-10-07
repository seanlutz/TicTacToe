package com.sean.tictac.Interface.structs;

import java.util.Map;

public class Response {
    public Map<Space,Player> currentBoard; 
    public RequestStatus requestStatus; 
    public BoardStatus boardStatus;
    public String requestMessage; 

    public Response(
     Map<Space,Player> currentBoard,
     RequestStatus requestStatus, 
     BoardStatus boardStatus, 
     String requestMessage
    ){
        this.currentBoard = currentBoard;
        this.requestStatus = requestStatus;
        this.boardStatus = boardStatus;
        this.requestMessage=requestMessage;
    }
}