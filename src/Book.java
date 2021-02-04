/**
 This class defines the abstract data type Book, which encapsulates the data fields and methods of a book.
 Contains getters and setters for the book fields.
 @author German Munguia, Sukhjit Singh
 */

public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    /**
     Constructor which creates a book type with the given parameters.
     A book is set as not checked out upon creation.
     @param number representing the book's serial number
     @param name assigned to the book as its name
     @param datePublished representing the day the book was first published
     */
    public Book(String number, String name, String datePublished){
        this.number = number;
        this.name = name;
        this.datePublished = new Date(datePublished);
        checkedOut = false;
    }

    /**
     Compares the given book object with the current book based on its serial number.
     @param obj the given book who's serial number will be compared
     @return true if the serial numbers of both books are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj){ //Check if the two books are the same by comparing the serial number of the two books.

        //if null always false
        if(obj == null) {
            return false;
        }
        //will take the toString output cut the first 5 chars, and only leave the next 5 which will be the serial number.
        String serialNumber = obj.toString().substring(Constants.SERIAL_NUMBER_SUBSTRING_START, Constants.SERIAL_NUMBER_SUBSTRING_END);

        //compare the values of the two serial numbers, if they are the same then the books are equal
        if(serialNumber.equals(number)) {
            return true;
        }
        return false;
    }

    /**
     Returns a String with the book fields in a specified format.
     @return String with the serial number, name, date, and checkedOut fields
     */
    @Override
    public String toString() {
        String result =
                "Book#" + number + "::" + name + "::" + datePublished.getMonth()+ "/" + datePublished.getDay() + "/" + datePublished.getYear() + "::";
        if(checkedOut) {
            result += "is checked out.";
        }
        else{
            result += "is available.";
        }
        return result;
    }

    /**
     Helper method which returns the string representing the serial number of a book.
     @return number representing the serial number of a book
     */
    public String getNumber() {
        return number;
    }

    /**
     Helper method which returns a Date class object representing the date a book was published.
     @return datePublished representing the date a book was published
     */
    public Date getDatePublished() {
        return datePublished;
    }

    /**
     Helper method which sets the availability status of a book based on an input Boolean parameter.
     An input Boolean of true means the book was checked out, false otherwise.
     @param checkedOut is a Boolean representing the availability of a book.
     */
    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    /**
     Helper method which returns a Boolean value representing the availability status of a book.
     @return checkedOut is true if a book is checked out, false otherwise.
     */
    public Boolean getCheckedOutStatus(){
        return checkedOut;
    }

}
