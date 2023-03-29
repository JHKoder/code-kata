package code.kata.console;

import code.kata.exception.InputException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleInput implements AutoCloseable {
    private final BufferedReader br;

    public ConsoleInput() {
        br = new BufferedReader(new InputStreamReader((System.in)));
    }

    public int input() {
        try{
            return br.read() - '0';
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
