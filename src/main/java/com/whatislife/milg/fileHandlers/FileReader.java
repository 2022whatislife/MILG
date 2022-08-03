package com.whatislife.milg.fileHandlers;

import com.whatislife.milg.MILG;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
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

    public JSONObject readSystemJsonFile(File file) {
        JSONParser parser = new JSONParser();
        try (java.io.FileReader reader = new java.io.FileReader(file.getAbsolutePath())) {
            JSONObject object = (JSONObject) parser.parse(reader);
            return object;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void setFileFilter(FileFilters filter) {
        switch (filter) {
            case IMAGE -> fileChooser.setFileFilter(new FileNameExtensionFilter("Image (*.png, *.jpg)", "png", "jpg"));
            case JSON -> fileChooser.setFileFilter(new FileNameExtensionFilter("Json Files (*.json)", "json"));
        }
    }
}
