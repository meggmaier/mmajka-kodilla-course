package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Book {

    private final String author;
    private final String title;
    private final int yearOfPublication;
}
