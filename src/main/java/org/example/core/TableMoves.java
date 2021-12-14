package org.example.core;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class TableMoves {
    private static final String FORMAT_MESS = "%s - %s\n";

    public static void show(String[] moves){
        AtomicInteger index = new AtomicInteger(0);
        System.out.println("Available moves :" );
        Arrays.stream( moves ).forEach(move -> System.out.printf(FORMAT_MESS, index.getAndIncrement(), move));
        System.out.print(String.format( FORMAT_MESS, "0", "exit") + String.format( FORMAT_MESS,"?", "help"));
    }
}
