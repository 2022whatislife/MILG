package com.whatislife.milg;

import javax.swing.*;

public class Helper {

    public static void printProgramDetails() {
        System.out.println(MILG.NAME + " - (" + MILG.NAME_SHORT + ")");
        System.out.println("Version: " + MILG.VERSION + System.lineSeparator());
    }

    public static void printInfo(String info) {
        System.out.println(MILG.NAME_SHORT + " - " + info);
    }

    public static void setLookAndFeelToSystem() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
}
