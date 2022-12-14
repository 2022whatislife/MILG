package com.whatislife.milg;

import com.whatislife.milg.fileHandlers.FileFilters;
import com.whatislife.milg.fileHandlers.FileReader;

import java.awt.*;

public class MILG {

    public static final String NAME = "Minecraft Item Lyric Generator";
    public static final String NAME_SHORT = "com.whatislife.milg.MILG";

    public static final String VERSION = "0.1";

    public MILG() {
        init();
        run();
    }

    private void init() {
        Helper.printInfo("INIT");
        Helper.setLookAndFeelToSystem();
    }

    private void run() {
        Helper.printInfo("RUN");

        FileReader fileReader = new FileReader();
        System.out.println(fileReader.readSystemJsonFile(fileReader.openFileChooser(FileFilters.JSON)).get("Test"));
    }

    public static void main(String[] args) {
        Helper.printProgramDetails();
        new MILG();
    }
}
