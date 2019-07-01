package com.kodilla.exceptions.main;

import com.kodilla.exceptions.io.FileReaderException;
import com.kodilla.exceptions.io.FileReaderWithoutHandling;

public class ExceptionModuleRunner {

    public static void main(String args[]){
        FileReaderWithoutHandling fileReader = new FileReaderWithoutHandling();
        try {
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.println("Problem while reading a file!");
        }
    }
}

