package com.company;

public class Main {

    public static void main(String[] args) {
	    Brainfuck bf = new Brainfuck();
	    bf.interpret("+++++++++[>++++++<-]>+++.<+++++++++[>-.<-]");
    }
}
