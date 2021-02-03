package com.company;

import java.util.Scanner;

public class Brainfuck {
    private Scanner sc = new Scanner(System.in);
    private final int LENGTH = 65535;
    private byte[] memory = new byte[LENGTH];
    private int dataPointer = 0;

    public void interpret(String code) {
        char[] charCode = code.toCharArray();

        for(int i = 0; i < code.length(); i++) {
            switch (charCode[i]) {
                case '+' -> {
                    memory[dataPointer]++;
                    break;
                }
                case '-' -> {
                    memory[dataPointer]--;
                }
                case '>' -> {
                    dataPointer++;
                }
                case '<' -> {
                    dataPointer--;
                }
                case '.' -> {
                    System.out.print((char)memory[dataPointer]);
                }
                case ',' -> {
                    memory[dataPointer] = (byte) Integer.parseInt(sc.next());
                }
                case '[' -> {
                    i += executeLoop(retrieveLoopCode(code, i));
                }
            }
        }
    }

    private String retrieveLoopCode(String code, int pos) {
        String cutCode = code.substring(pos);
        cutCode = cutCode.substring(1, cutCode.indexOf(']'));
        return cutCode;
    }

    private int executeLoop(String loopedCode) {
        while((int)memory[dataPointer] != 0) {
            interpret(loopedCode);
        }
        return loopedCode.length() + 1;
    }
}