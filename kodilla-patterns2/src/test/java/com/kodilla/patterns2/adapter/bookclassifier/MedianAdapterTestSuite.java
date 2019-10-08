package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest(){
        //Given
        Book book1 = new Book("J.R.R.Tolkien", "The Lord of the Rings", 1954, "000001");
        Book book2 = new Book("Paulo Coelho", "The Alchemist", 1988, "000002");
        Book book3 = new Book("Antoine de Saint-Exupery", "The Little Prince", 1943, "000003");
        Book book4 = new Book("Jacob and Wilhelm Grimm", "Grimms' Fairy Tales", 1812, "000004");
        Book book5 = new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", 1997, "000001");
        Set<Book> bookSet = new HashSet<>();

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int publicationYearMedian = medianAdapter.calculatePublicationYearMedian(bookSet);

        //Then
        assertEquals(1954, publicationYearMedian);

    }
}
