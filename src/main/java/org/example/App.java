package org.example;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.example.core.GameLogic;
import org.example.core.TableMoves;
import org.example.exception.AmountElementsException;
import org.example.utils.Cheats;

import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;

import static org.example.crypto.GameCryptoTrails.*;

public class App {
    private static final String AMOUNT_EXCEPTION = "Arguments less than 3. Enter the number of arguments greater than or equal to 3";
    private static final String NUMBER_ODD_EXCEPTION = "The number of elements is odd";
    private static final String ENTER = "Enter your move : ";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        validationArgs( args );

        var input = new Scanner( System.in );
        var movePlayer = "";
        var moveAI = 0;

        moveAI = new Random().nextInt( args.length );
        var key = securityKey();

        message( "HMAC : " + hmac(HmacAlgorithms.HMAC_SHA_256.getName(), args[moveAI], key) + System.lineSeparator() );
        TableMoves.show( args );

        message( ENTER );
        movePlayer = input.next();

        if ( movePlayer.equals( "?" ) ) {
            Cheats.help( moveAI,args );
            message( ENTER );
            movePlayer = input.next();
        } else if ( movePlayer.equals( "0" ) ) message("bye!");

        var result = GameLogic.resultBattle(Integer.parseInt(movePlayer),moveAI,args.length );

        message( "computer move : " + args[moveAI] + '\n' + "player move : " + args[Integer.parseInt(movePlayer)]);
        message( result.getStatus());
        message( "HMACkey : " + key);

    }

    private static void message(String mess) {
        System.out.println( mess );
    }

    private static void validationArgs(String[] args) {
        if ( args.length < 3 ) throw new AmountElementsException( AMOUNT_EXCEPTION );
        if ( args.length % 2 != 1 ) throw new AmountElementsException( NUMBER_ODD_EXCEPTION );
    }
}
