package com.kata.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferInput {

    private static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

    private BufferInput() {
    }

    public static String readLine() throws IOException {
        return br.readLine();
    }

}
