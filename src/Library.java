public class Library {

    private Book[] books; // array-based implementation of the bag data structure
    private int numBooks; // the number of books currently in the bag

    public Library() { } //default constructor to create an empty bag
    private int find(Book book) { return -1; } // helper method to find a book in the bag
    private void grow() { } // helper method to grow the capacity by 4
    public void add(Book book) { }
    public boolean remove(Book book) { return false; }
    public boolean checkOut(Book book) { return false; }
    public boolean returns(Book book) { return false; }
    public void print() { } //print the list of books in the bag
    public void printByDate() { } //print the list of books by datePublished (ascending)
    public void printByNumber() { } //print the list of books by number (ascending)


}
