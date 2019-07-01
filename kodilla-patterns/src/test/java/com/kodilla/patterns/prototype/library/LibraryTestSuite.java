package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {


    @Test
    public void testGetBooks(){

        //Given
        Library library = new Library("Test Library");
        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("Book", "Author", LocalDate.of(n,n,n))));

        Library shallowCopy = null;
        try {
            shallowCopy = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception: " + e);
        }

        Library deepCopy = null;
        try {
            deepCopy = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception: " + e);
        }

        //When&Then

        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals(5, shallowCopy.getBooks().size());
        Assert.assertEquals(5, deepCopy.getBooks().size());
        Assert.assertEquals(shallowCopy.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepCopy.getBooks(), library.getBooks());
    }
}
