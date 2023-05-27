package code.kata.console;

import code.kata.exception.InputException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input implements AutoCloseable {
    private final BufferedReader br;

    public Input() {
        br = new BufferedReader(new InputStreamReader((System.in)));
    }

    public String[] command() {
        try{
            return br.readLine().split(" ");
        } catch (Exception e) {
            throw new InputException();
        }
    }

    @Override
    public void close() {
        try {
            br.close();
        } catch (Exception e) {
            throw new InputException();
        }
    }
}