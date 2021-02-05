/**
 The library class defines the abstract Library type which contains the bag array of books.
 The class allows for books to be removed, added, checked out, and can be printed.
 The bag array length grows with the addition of books.
 Then, a couple more sentences of description to elaborate.
 @author German Munguia, Sukhjit Singh
 */

public class Library {

    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag

    /**
     Constructor to generate a Library object with an array to hold book objects.
     By default the Library has zero books.
     */
    public Library() { //default constructor to create an empty bag
        books = new Book[Constants.STARTING_ARRAY_SIZE];
        numBooks = 0;
    }

    /**
     Finds the index of the given book within the bag.
     If the given book is not in the array then return a negative one.
     @param book The book object which is being searched for
     @return the index location of the given book, -1 if the book was not found in the array
    */
    private int find(Book book) {
        //iterate through the array until the specified book is found. Return the index in which its found.
        for(int i = 0; i < numBooks; i++) {
            if(books[i].getNumber().equals(book.getNumber())) {
                return i;
            }
        }
        //if its not found, return -1.
        return Constants.BOOK_NOT_FOUND;
    }

    /**
     Increases the size of the bag array by four indexes.
     The books are copied into a new array and the bag gets reassigned.
     */
    private void grow() {
        Book[] newArray = new Book[books.length + Constants.INCREASE_ARRAY_BY];
        //copy the current number of books.
        for(int i = 0; i < numBooks; i++) {
            newArray[i] = books[i];
        }
        //reassign books so that it refers to newArray.
        books = newArray;
    }

    /**
     Add the given book into the bag array.
     If the bag array is full, then increase the size with the grow() method.
     @param book the book which is being added to the bag
     */
    public void add(Book book) {
        //Grow the array if no empty index remains
        if(books[books.length - 1] != null){
            grow();
        }
        //Add new book to the first empty index available
        for(int i = 0; i < books.length; i++){
            if(books[i] == null){
                books[i] = book;
                break;
            }
        }
        numBooks++;
    }

    /**
     Remove the given book from the bag array.
     Use the find() method to check if the book is inside the bag.
     @param book The book that is being removed from the bag
     @return true if the book was deleted, false if it was not
     */
    public boolean remove(Book book) {  //Removes the given book if it is in the library, if not returns false.
        //find the book using the helper method.
        int bookIndex = find(book);
        //if the index equals -1 than the book is not in the library and cannot be removed.
        if(bookIndex == Constants.BOOK_NOT_FOUND) {
            return false;
        }
        //set the book at the given index as null to remove it.
        books[bookIndex] = null;
        //shift the elements to the right of it by one.
        for(int i = bookIndex+1; i < books.length; i++) {
            //will trail i by one that way the previous index can be replaced. Since i can never be zero there is no out of bound issue.
            int previousIndex = i - 1;
            books[previousIndex] = books[i]; //make the swap of elements
        }
        //reduce the count by one as a book was successfully just removed.
        numBooks--;
        return true;
    }

    /**
     Checks out the given book if it is available.
     The check out status is used to determine if possible.
     @param book the book that is being checked out
     @return true if it was checked out, false otherwise
     */
    public boolean checkOut(Book book) {
        //find the book using the helper method.
        int bookIndex = find(book);
        //if the index equals -1 than the book is not in the library and cannot be checked out.
        if(bookIndex == Constants.BOOK_NOT_FOUND) {
            return false;
        }
        //if the book is found but it is checked out, it cannot be check out until it is returned
        else if(books[bookIndex].getCheckedOutStatus() == true){
            return false;
        }
        //if the book is found but it is not checked out, it can be check out and it is marked as checked out
        books[bookIndex].setCheckedOut(true);
        return true;
    }

    /**
     Returns the given book that was previously checked out.
     @param book the book that is being returned
     @return true if it removed, false otherwise
     */
    public boolean returns(Book book) {
        //find the book using the helper method.
        int bookIndex = find(book);
        //if the index equals -1 than the book is not in the library and cannot be returned.
        if(bookIndex == Constants.BOOK_NOT_FOUND) {
            return false;
        }
        //if the book is found but it is not checked out, it cannot be returned
        else if(books[bookIndex].getCheckedOutStatus() == false){
            return false;
        }

        //if the book is found and it is checked out, it can be returned and it is marked as such
        books[bookIndex].setCheckedOut(false);
        return true;
    }

    /**
     Prints all of the books in the bag in no specific order.
     */
    public void print() {  //print the list of books in the bag
        for(int i = 0; i < numBooks; i++){
            System.out.println(books[i].toString());
        }
    }

    /**
     Compares the two books based on the date they are published.
     Continuously checks more specific dates if they are the same.
     @param book1 the first book being compared
     @param book2 the second book being compared
     @return return true if the first book is newer than the second, if book two is newer or the same then false.
     */
    private boolean compareDatePublished(Book book1, Book book2){
        //If book1 year is greater than book2 year, return true
        if(book1.getDatePublished().getYear() > book2.getDatePublished().getYear()){
            return true;
        }
        else if(book1.getDatePublished().getYear() == book2.getDatePublished().getYear()){
            //If same year and book1 month is greater than book2 month, return true
            if(book1.getDatePublished().getMonth() > book2.getDatePublished().getMonth()){
                return true;
            }
            else if(book1.getDatePublished().getMonth() == book2.getDatePublished().getMonth()){
                //If same year and month and book1 day is greater than book2 day, return true
                if(book1.getDatePublished().getDay()>book2.getDatePublished().getDay()){
                    return true;
                }
                return false;
            }
            return false;
        }
        //Otherwise book2 has the greater date
        return false;
    }

    /**
     Sort the bag from oldest to newest book.
    */
    private void sortBooksDateAscending(){
        for (int i = 1; i < books.length; i++) {
            Book[] tempBook = new Book[1];
            tempBook[0] = books[i];
            int j = i - 1;
            while(j >= 0 && books[j] != null && tempBook[0] != null && compareDatePublished(books[j],tempBook[0]) == true) {
                    books[j + 1] = books[j];
                    j = j - 1;
            }
            books[j + 1] = tempBook[0];
        }
    }

    /**
     Print the books in the bag from oldest to newest.
     call the sort by date method to sort and the print method to print.
    */
    public void printByDate() {  //print the list of books by datePublished (ascending)
        if (numBooks > 1) {
            //call the sorting method
            sortBooksDateAscending();
        }
        print();
    }

    /**
     Sort the bag from smallest serial number to largest.
     */
    private void sortBooksNumberAscending(){
        for (int i = 1; i < books.length; i++) {
            Book[] tempBook = new Book[1];
            tempBook[0] = books[i];
            int j = i - 1;
            while(j >= 0 && books[j] != null && tempBook[0] != null &&
                     Integer.parseInt(books[j].getNumber()) > Integer.parseInt(tempBook[0].getNumber())) {
                books[j + 1] = books[j];
                j = j - 1;
            }
            books[j + 1] = tempBook[0];
        }
    }

    /**
     Print the bag of books by smallest serial number to largest.
     */
    public void printByNumber() {
        if(numBooks > 1) {
            //call the sorting method
            sortBooksNumberAscending();
        }
        print();
    } //print the list of books by number (ascending)

    /**
     Helper method which returns the number of books in the bag.
     @return the number of books in the bag array
     */
    public int getNumBooks(){
        return numBooks;
    }

}
