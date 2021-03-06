package com.kodilla.testing.library;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }


    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }
    @Test
    public void testListBooksInHandsOfZero() {
        //Given books borrowed = 0;
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "0");
        List<Book> emptyList = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser))
                .thenReturn(emptyList);

        //When
        List<Book> theEmptyList = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(0, theEmptyList.size());
        verify(libraryDatabaseMock, times(0)).listBooksInHandsOf(libraryUser);
    }

    @Test
    public void testListBooksInHandsOfOne() {
        //Given books borrowed = 1;
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary2 = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser2 = new LibraryUser("Joan", "Smite", "1");
        List<Book> oneBookList = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser2))
                .thenReturn(oneBookList);

        //When
        List<Book> theOneBookList = bookLibrary2.listBooksInHandsOf(libraryUser2);

        //Then
        assertEquals(1, theOneBookList.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser2);
    }

    @Test
    public void testListBooksInHandsOfFive(){
        //Given books borrowed = 5;
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary5 = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser5 = new LibraryUser("Matt", "Kale", "5");
        List<Book> fiveBooksList = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser5))
                .thenReturn(fiveBooksList);

        //When
        List<Book> theFiveBooksList = bookLibrary5.listBooksInHandsOf(libraryUser5);


        //Then
        assertEquals(5, theFiveBooksList.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser5);
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}
