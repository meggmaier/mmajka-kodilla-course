package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String textToBeautify, PoemDecorator poemDecorator){
        System.out.println(poemDecorator.decorate(textToBeautify));

    }
}

