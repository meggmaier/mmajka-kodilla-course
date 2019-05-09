package com.kodilla.exceptions.main;

import com.kodilla.exceptions.io.FileReader;

public class ExceptionModuleRunner {

    public static void main(String args[]){
        FileReader fileReader = new FileReader();
        fileReader.readFile();
    }
}

