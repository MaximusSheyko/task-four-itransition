package org.example.core;

public class GameLogic {
    public static StatusWinners resultBattle(int movePlayer,int moveAI,int amountMoves){
        var winMove = (amountMoves + movePlayer - moveAI) % amountMoves;
        if (winMove != 0) return winMove % 2 == 1 ? StatusWinners.PLAYER_WIN : StatusWinners.AI_WIN;

        return StatusWinners.TIE;
    }
}






