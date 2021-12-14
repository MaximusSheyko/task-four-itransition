package org.example.utils;

import org.example.core.StatusWinners;
import org.example.core.GameLogic;

public class Cheats {
    private static final String FORMAT_MESS = "%s - %s\n";

    public static void help(int moveAi, String[] moves){
        System.out.println("Moves for win Ai");
        var position = 1;

        for (int index = 0; index < moves.length ; index++){
            if ( GameLogic.resultBattle(index, moveAi,moves.length).equals( StatusWinners.PLAYER_WIN)){
                System.out.printf(FORMAT_MESS, position++, moves[index]);
            }
        }
    }
}
