/**
 This class defines the abstract data type Date, which encapsulates the data fields and methods of a Date.
 Contains constructors to generate Date objects based on input strings, or the today's date by default.
 Contains getters and setters for the date fields.
 @author German Munguia, Sukhjit Singh
 */

import java.util.Calendar;

public class Date {
    private int year;
    private int month;
    private int day;

    /**
     Constructor used to generate a Date object with a given String input representing mm/dd/yyyy.
     The length of the input string is first tested to see if it meets the minimum length for parsing. If so it is
     then parsed based on the position of the / symbols. If the input is incorrectly formatted, the year, month, and
     day variables are assigned a default value of -1.
     @param date on which the book was published
     */
    public Date(String date) {
        //Check if input meets minimum length of 5 characters. m/d/y
        if(date.length()<Constants.MINIMUM_DATE_SUBSTRING_LENGTH){
            year = Constants.DEFAULT_DATE_IF_INPUT_INVALID;
            month = Constants.DEFAULT_DATE_IF_INPUT_INVALID;
            day = Constants.DEFAULT_DATE_IF_INPUT_INVALID;
        }
        else{
            try {
                //Check if input has format: m/...
                if(date.charAt(Constants.SINGLE_DIGIT_MONTH_DASH_POSITION) == '/') {
                    month = Integer.parseInt(date.substring(Constants.MONTH_SUBSTRING_START, Constants.MONTH_SUBSTRING_END1));
                    //Check if input has format: m/d/...
                    if(date.charAt(Constants.SINGLE_DIGIT_DAY_DASH_POSITION1) == '/') {
                        day = Integer.parseInt(date.substring(Constants.DAY_SUBSTRING_START1,Constants.DAY_SUBSTRING_END1));
                        year = Integer.parseInt(date.substring(Constants.YEAR_SUBSTRING_START1));
                    }
                    //Check if input has format: m/dd/...
                    else if(date.charAt(Constants.DOUBLE_DIGIT_DAY_DASH_POSITION1) == '/'){
                        day = Integer.parseInt(date.substring(Constants.DAY_SUBSTRING_START1,Constants.DAY_SUBSTRING_END2));
                        year = Integer.parseInt(date.substring(Constants.YEAR_SUBSTRING_START2));
                    }
                }
                //Check if input has format: mm/...
                else if(date.charAt(Constants.DOUBLE_DIGIT_MONTH_DASH_POSITION) == '/'){
                    month = Integer.parseInt(date.substring(Constants.MONTH_SUBSTRING_START, Constants.MONTH_SUBSTRING_END2));
                    //Check if input has format: mm/d/...
                    if(date.charAt(Constants.SINGLE_DIGIT_DAY_DASH_POSITION2) == '/') {
                        day = Integer.parseInt(date.substring(Constants.DAY_SUBSTRING_START2,Constants.DAY_SUBSTRING_END2));
                        year = Integer.parseInt(date.substring(Constants.YEAR_SUBSTRING_START2));
                    }
                    //Check if input has format: mm/dd/...
                    else if(date.charAt(Constants.DOUBLE_DIGIT_DAY_DASH_POSITION2) == '/'){
                        day = Integer.parseInt(date.substring(Constants.DAY_SUBSTRING_START2,Constants.DAY_SUBSTRING_END3));
                        year = Integer.parseInt(date.substring(Constants.YEAR_SUBSTRING_START3));
                    }
                }
            } catch (NumberFormatException ex) {
                //If the input is incorrectly formatted or has a non integer value, the class data members are
                // assigned a default value of -1.
                month = Constants.DEFAULT_DATE_IF_INPUT_INVALID;
                day = Constants.DEFAULT_DATE_IF_INPUT_INVALID;
                year = Constants.DEFAULT_DATE_IF_INPUT_INVALID;

            }
        }
    }

    /**
     Constructor used to generate a Date object with today's date as default
     A Calendar class object is used to extract today's date. By default month starts at 0 instead of 1, so +1 is
     added to correct this.
     */
    public Date() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DATE);
    }

    /**
     Helper method which returns an integer representing the 'year' data member of the Date class.
     @return year the book was published in.
     */
    public int getYear(){
        return year;
    }

    /**
     Helper method which returns an integer representing the 'month' data member of the Date class.
     @return month the book was published in.
     */
    public int getMonth(){
        return month;
    }

    /**
     Helper method which returns an integer representing the 'day' data member of the Date class.
     @return day the book was published on.
     */
    public int getDay(){
        return day;
    }

    /**
     Helper method which checks if the Date object's 'year' data member represents a leap year, returning the
     Boolean value true if it is, false otherwise.
     The method first checks if the year is divisible by 4 returning false otherwise. Then it checks if it is divisible
     by 100, returning true otherwise, and it checks if it is further divisible by 400, returning false otherwise.
     @return true if the year is a leap year, false otherwise.
     */
    private Boolean isLeapYear(){
        if (year%Constants.QUADRENNIAL==0){
            if (year%Constants.CENTENNIAL==0){
                if(year%Constants.QUARTERCENTENNIAL==0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    /**
     Method to check to see if a Date object has a valid date and returns a Boolean value of true if the date is
     valid, false otherwise.
     First check the year. If it is valid, check the month. If month is valid, check the day. Uses the isLeapYear()
     helper method to aid in calculating the maximum number of days in February.
     @return true if the date is valid, false otherwise.
     */
    public Boolean isValid() {
        //Calendar calendar = Calendar.getInstance();
        Date today = new Date();
        //If year is not within bounds return false
        if(year<Constants.MINIMUM_YEAR_LIMIT || year> today.getYear()){
            return false;
        }
        else if(year==today.getYear()){//calendar.get(Calendar.YEAR)) {
            //If it is current year, and month is greater than current month return false
            if(month>(today.getMonth())){
                return false;
            }
            //If it is current year and month, and date is greater than current date return false
            else if (month==(today.getMonth())){
                if(day> today.getDay()){
                    return false;
                }
            }
        }
        //If month is not within bounds return false
        else if(month<Constants.JANUARY || month>Constants.DECEMBER) {
            return false;
        }
        //If it is a long month, and day is outside of bounds return false
        else if(month==Constants.JANUARY || month==Constants.MARCH || month==Constants.MAY || month==Constants.JULY || month==Constants.AUGUST || month==Constants.OCTOBER || month==Constants.DECEMBER){
            if(day>Constants.DAYS_IN_LONG_MONTH || day<1){
                return false;
            }
        }
        //If it is a short month, and day is outside of bounds return false
        else if(month==Constants.APRIL || month==Constants.JUNE || month==Constants.SEPTEMBER || month==Constants.NOVEMBER){
            if(day>Constants.DAYS_IN_SHORT_MONTH || day<1){
                return false;
            }
        }
        //If month is February determine if it is a leap year and if day is outside of bounds return false
        else if(month==Constants.FEBRUARY){
            if(isLeapYear()){
                if (day>Constants.DAYS_IN_FEB_LEAP_YEAR || day<1) {
                    return false;
                }
            }
            else if(day>Constants.DAYS_IN_FEB_NORMAL_YEAR || day<1){
                return false;
            }
        }
        return true;
    }

    /**
     This method runs the Testbed Main cases on the isValid() method and prints the Boolean results for each case.
     Date objects are instantiated and then individually tested using the isValid() method.
     @param args Unused parameter
     */
    public static void main(String[] args){
        //Test today's date
        Date date1 = new Date();
        System.out.println("2/2/2021 is a valid date?: "+date1.isValid());

        //Test cases given in the project document - Expected result is false for all cases
        Date date2 = new Date("31/2/2000");
        System.out.println("31/2/2000 is a valid date?: "+date2.isValid());
        Date date3 = new Date("13/2/2020");
        System.out.println("13/2/2020 is a valid date?: "+date3.isValid());
        Date date4 = new Date("2/29/2021");
        System.out.println("2/29/2021 is a valid date?: "+date4.isValid());
        Date date5 = new Date("2/29/2009");
        System.out.println("2/29/2009 is a valid date?: "+date5.isValid());
        Date date6 = new Date("4/31/2009");
        System.out.println("4/31/2009 is a valid date?: "+date6.isValid());
        Date date7 = new Date("3/32/2009");
        System.out.println("3/32/2009 is a valid date?: "+date7.isValid());
        Date date8 = new Date("3/31/1800");
        System.out.println("3/31/1800 is a valid date?: "+date8.isValid());
        Date date9 = new Date("10/30/2022");
        System.out.println("10/30/2022 is a valid date?: "+date9.isValid());
        Date date10 = new Date("3/30/2021");
        System.out.println("3/30/2021 is a valid date?: "+date10.isValid());
        Date date11 = new Date("0/1/2020");
        System.out.println("0/1/2020 is a valid date?: "+date11.isValid());
        Date date12 = new Date("3/0/2020");
        System.out.println("3/0/2020 is a valid date?: "+date12.isValid());

        //Test cases using valid input dates - Expected result is true for all cases
        Date date13 = new Date("3/3/2020");
        System.out.println("3/3/2020 is a valid date?: "+date13.isValid());
        Date date14 = new Date("3/30/2020");
        System.out.println("3/30/2020 is a valid date?: "+date14.isValid());
        Date date15 = new Date("12/3/2020");
        System.out.println("12/3/2020 is a valid date?: "+date15.isValid());
        Date date16 = new Date("12/12/2020");
        System.out.println("12/12/2020 is a valid date?: "+date16.isValid());
        Date date17 = new Date("2/29/2020");
        System.out.println("2/29/2020 is a valid date?: "+date17.isValid());
        Date date18 = new Date("1/1/1900");
        System.out.println("1/1/1900 is a valid date?: "+date18.isValid());

        //Test cases with letters in the dates - Expected result is false for all cases
        Date date19 = new Date("A/3/2020");
        System.out.println("A/3/2020 is a valid date?: "+date19.isValid());
        Date date20 = new Date("3/A/2020");
        System.out.println("3/A/2020 is a valid date?: "+date20.isValid());
        Date date21 = new Date("3/A0/2020");
        System.out.println("3/A0/2020 is a valid date?: "+date21.isValid());
        Date date22 = new Date("3/3A/2020");
        System.out.println("3/3A/2020 is a valid date?: "+date22.isValid());
        Date date23 = new Date("A0/3/2020");
        System.out.println("A0/3/2020 is a valid date?: "+date23.isValid());
        Date date24 = new Date("1A/3/2020");
        System.out.println("1A/3/2020 is a valid date?: "+date24.isValid());
        Date date25 = new Date("12/12/A");
        System.out.println("12/12/A is a valid date?: "+date25.isValid());
        Date date26 = new Date("12/12/20A0");
        System.out.println("12/12/20A0 is a valid date?: "+date26.isValid());

        //Test cases with incorrect dashes - Expected result is false for all cases
        Date date27 = new Date("1-3/2020");
        System.out.println("1-3/2020 is a valid date?: "+date27.isValid());
        Date date28 = new Date("1-3/2020");
        System.out.println("1/3-2020 is a valid date?: "+date28.isValid());

        //Test cases with missing dashes - Expected result is false for all cases
        Date date29 = new Date("1 3/2020");
        System.out.println("1 3/2020 is a valid date?: "+date29.isValid());
        Date date30 = new Date("1/3 2020");
        System.out.println("1/3 2020 is a valid date?: "+date30.isValid());
        Date date31 = new Date(" /3/2020");
        System.out.println("/3/2020 is a valid date?: "+date31.isValid());
        Date date32 = new Date("1/ /2020");
        System.out.println("1/ /2020 is a valid date?: "+date32.isValid());
    }
}
