package com.kata.io;

import com.kata.calculation.Calculator;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferInput {

    private BufferedReader br = null;

    public BufferInput(Calculator calculator) {
        if (calculator == null) {
            return;
        }
        br = new BufferedReader(new InputStreamReader((System.in)));
    }

    public String input() {
        try {
            return br.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void close() {
        try {
            br.close();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
