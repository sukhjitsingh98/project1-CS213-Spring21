import java.util.Calendar;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(String date) {
        this.year = Integer.parseInt(date.substring(6));
        this.year = Integer.parseInt(date.substring(3,5));
        this.year = Integer.parseInt(date.substring(0,2));
    } //taking mm/dd/yyyy and create a Date object

    public Date() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DATE);
    } //return today’s date

    private Boolean isLeapYear(){
        if (year%Constants.LEAP_YEAR_INTERVAL==0){
            if (year%Constants.LEAP_YEAR_CENTURY==0){
                if(year%Constants.CONFIRM_LEAP_YEAR_CENTURY==0){
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

    public Boolean isValid() {
        Calendar calendar = Calendar.getInstance();
        //If year is not within bounds return false
        if(year<Constants.MINIMUM_YEAR_LIMIT || year>calendar.get(Calendar.YEAR)){
            return false;
        }
        else if(year==calendar.get(Calendar.YEAR)) {
            //If it is current year, and month is greater than current month return false
            if(month>(calendar.get(Calendar.MONTH)+1)) {
                return false;
            }
            //If it is current year and month, and date is greater than current date return false
            else if (month==(calendar.get(Calendar.MONTH)+1)) {
                if(day>calendar.get(Calendar.DATE)) {
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
            if(isLeapYear() == true){
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
}
