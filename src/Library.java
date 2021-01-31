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

    private void grow() { // Creates a new array that is bigger by four indexes and copies the elements.
        int increaseArrayBy = 4; //the array will increase by size of 4.
        Book[] newArray = new Book[books.length + increaseArrayBy];

        //copy the current number of books.
        for(int i= 0; i < numBooks; i++) {
            newArray[i] = books[i];
        }

        //reassign books so that it refers to newArray.
        books = newArray;
    }

    public void add(Book book) {
        //Grow the array if no empty index remains
        if(books[books.length-1]!=null){
            grow();
        }
        //Add new book to the first empty index available
        for(int i = 0; i<books.length; i++){
            if(books[i]==null){
                books[i] = book;
                break;
            }
        }
        numBooks++;
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
            //will trail i by one that way the previous index can be replaced. Since i can never be zero there is no out of bound issue.
            int previousIndex = i-1;
            books[previousIndex] = books[i]; //make the swap of elements
        }

        //reduce the count by one as a book was successfully just removed.
        numBooks--;
        return true;
    }

    //NOTE TO GERMAN: Here I am assuming that false means book is not available for check out and true means that it is
    public boolean checkOut(Book book) {
        //find the book using the helper method.
        int bookIndex = find(book);
        //if the index equals -1 than the book is not in the library and cannot be checked out.
        if(bookIndex == -1) {
            return false;
        }
        //if the book is found but it is checked out, it cannot be check out until it is returned
        else if(books[bookIndex].getCheckedOutStatus()==true){
            return false;
        }

        //if the book is found but it is not checked out, it can be check out and it is marked as checked out
        books[bookIndex].setCheckedOut(true);
        return true;
    }

    //NOTE TO GERMAN: Here I am assuming that false means book cannot be returned and true means that it can
    public boolean returns(Book book) {
        //find the book using the helper method.
        int bookIndex = find(book);
        //if the index equals -1 than the book is not in the library and cannot be returned.
        if(bookIndex == -1) {
            return false;
        }
        //if the book is found but it is not checked out, it cannot be returned
        else if(books[bookIndex].getCheckedOutStatus()==false){
            return false;
        }

        //if the book is found and it is checked out, it can be returned and it is marked as such
        books[bookIndex].setCheckedOut(false);
        return true;
    }
    public void print() {  //print the list of books in the bag
        for(int i = 0; i < numBooks; i++){
            System.out.println(books[i].toString());
        }
    }

    public void printByDate() { } //print the list of books by datePublished (ascending)
    public void printByNumber() { } //print the list of books by number (ascending)


}
