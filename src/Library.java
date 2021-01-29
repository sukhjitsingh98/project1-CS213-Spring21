public class Library {

    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag

    public Library() { } //default constructor to create an empty bag

    private int find(Book book) { // helper method to find a book in the bag.

        //iterate through the array until the specified book is found. Return the index in which its found.
        for(int i = 0; i < numBooks; i++) {
            if(books[i].getNumber().equals(book.getNumber())) {
                return i;
            }
        }

        //if its not found, return -1.
        return -1;
    }

    private void grow() { // Creates a new array that is bigger by four and copies the elements.
        int increaseArrayBy = 4; //the array will increase by size of 4.
        Book[] newArray = new Book[books.length + increaseArrayBy];

        //copy the current number of books.
        for(int i= 0; i < numBooks; i++) {
            newArray[i] = books[i];
        }

        //reassign books so that it refers to newArray.
        books = newArray;
    }

    //NOTE FOR GERMAN: I am making the assumption that everytime we remove a book, we shift the remaining books right to take its place
    //NOTE CONTINUED: Hence each new book is added next to the last book in the array.
    public void add(Book book) {
        //Grow the array if no empty index remains
        if(books[books.length-1]!=null){
            grow();
        }
        //Add new book to the first empty index available
        for(int i = 0; i<books.length; i++){
            if(books[i]==null){
                books[i] = book;
            }
        }
    }

    public boolean remove(Book book) {  //Removes the given book if it is in the library, if not returns false.

        //find the book using the helper method.
        int bookIndex = find(book);
        //if the index equals -1 than the book is not in the library and cannot be removed.
        if(bookIndex == -1) {
            return false;
        }

        //set the book at the given index as null to remove it.
        books[bookIndex] = null;

        //shift the elements to the right of it by one.
        for(int i = bookIndex+1; i < books.length; i++) {
            //will trail i by one that way the previous index can be replaced. Since i can never be zero there is not out of bound issue.
            int previousIndex = i-1;
            books[previousIndex] = books[i]; //make the swap of elements
        }

        //reduce the count by one as a book was successfully just removed.
        numBooks--;
        return true;
    }



    public boolean checkOut(Book book) { return false; }
    public boolean returns(Book book) { return false; }
    public void print() { } //print the list of books in the bag
    public void printByDate() { } //print the list of books by datePublished (ascending)
    public void printByNumber() { } //print the list of books by number (ascending)


}
