package com.kata.alarmclock;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Pint {
    private static final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(String s) {
        try {
            out.write(s + "\n");
            out.flush();
        } catch (IOException ignored) {
        }
    }
    public void shutdown(){
        try {
            out.close();
        } catch (IOException ignored) {
        }
    }
}
