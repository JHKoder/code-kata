package com.kata.common;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    private static Logger logger = Logger.getLogger(Log.class.getName());

    private Log() {
    }

    public static void info(String message) {
        logger.info(message);
    }
    public static void warning(String message) {
        logger.warning(message);
    }
    public static void log(Level level,String message) {
        logger.log(level,message);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return null;
    }
}
