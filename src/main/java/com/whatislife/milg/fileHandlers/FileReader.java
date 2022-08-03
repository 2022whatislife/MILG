package com.whatislife.milg.fileHandlers;

import com.whatislife.milg.MILG;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileReader {

    JFileChooser fileChooser;

    public FileReader() {
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(MILG.NAME + " -" + MILG.VERSION);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    }
    
    public File openFileChooser(FileFilters filter) {
        setFileFilter(filter);
        File file = null;
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        return file;
    }

    public Image readSystemImage(File file) {
        try {
            return ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setFileFilter(FileFilters filter) {
        switch (filter) {
            case IMAGE -> fileChooser.setFileFilter(new FileNameExtensionFilter("Image (*.png, *.jpg)", "png", "jpg"));
            case JSON -> fileChooser.setFileFilter(new FileNameExtensionFilter("Json Files", ".json"));
        }
    }
}
