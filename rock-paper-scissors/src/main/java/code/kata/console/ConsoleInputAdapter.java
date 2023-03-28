package code.kata.console;

import code.kata.exception.RockPaperScissorsInputException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleInputAdapter {
    private final BufferedReader br;

    public ConsoleInputAdapter() {
        br = new BufferedReader(new InputStreamReader((System.in)));
    }

    public int input() {
        try {
            return br.read() - '0';
        } catch (Exception e) {
            throw new RockPaperScissorsInputException();
        }
    }

    public void close() {
        try {
            br.close();
        } catch (Exception e) {
            throw new RockPaperScissorsInputException();
        }
    }
}
