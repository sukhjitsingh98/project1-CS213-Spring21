public class Book {
    private String number; //a 5-digit serial number unique to the book
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    public Book(String number, String name, String datePublished){
        this.number = number; //MAYBE????
        this.name = name;
        this.datePublished = new Date(datePublished);
        checkedOut = false;
    }

    @Override
    public boolean equals(Object obj){ //Check if the two books are the same by comparing the serial number of the two books.

        //if null always false
        if(obj == null) {
            return false;
        }

        //will take the toString output cut the first 5 chars, and only leave the next 5 which will be the serial number.
        String serialNumber = obj.toString().substring(5, 10);

        //compare the values of the two serial numbers, if they are the same then the books are equal
        if(serialNumber.equals(number)) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() { //Return a string with the number,name,date,and checkout status formatted.
        String result =
                "Book#" + number + "::" + name + "::" + datePublished.getMonth()+ "/" + datePublished.getDay() + "/" + datePublished.getYear() + "::";
        if(checkedOut) {
            result += "is available.";
        }
        else{
            result += "is checked out.";
        }
        return result;
    }

    //helper method which returns the serial number of a book.
    public String getNumber() {
        return number;
    }

    //returns the date the book was published.
    public Date getDatePublished() { return datePublished; }

    //Added by Sukhjit
    //helper method which sets the availability status of a book.
    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    //helper method which returns the availability status of a book.
    public Boolean getCheckedOutStatus(){
        return checkedOut;
    }

}
