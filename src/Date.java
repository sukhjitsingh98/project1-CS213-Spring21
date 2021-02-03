/**
 First, a single, very descriptive sentence describing the class.
 Then, a couple more sentences of description to elaborate.
 @author German Munguia, Sukhjit Singh
 */

import java.util.Calendar;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(String date) {
        if(date.length()<5){
            year = -1;
            month = -1;
            day = -1;
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
                    month = -1;
                    day = -1;
                    year = -1;

            }
        }
    } //taking mm/dd/yyyy and create a Date object

    public Date() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DATE);
    } //return today’s date

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    private Boolean isLeapYear(){
        if (year%Constants.QUADRENNIAL==0){
            if (year%Constants.CENTENNIAL==0){
                if(year%Constants.QUATERCENTENNIAL==0){
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

    //Testbed Main
    public static void main(String[] args){
        Date date1 = new Date();
        System.out.println("2/2/2021 is a valid date?: "+date1.isValid());
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

        Date date11 = new Date("3/3/2020");
        System.out.println("3/3/2020 is a valid date?: "+date11.isValid());
        Date date12 = new Date("3/30/2020");
        System.out.println("3/30/2020 is a valid date?: "+date12.isValid());
        Date date13 = new Date("12/3/2020");
        System.out.println("12/3/2020 is a valid date?: "+date13.isValid());
        Date date14 = new Date("12/12/2020");
        System.out.println("12/12/2020 is a valid date?: "+date14.isValid());

        Date date15 = new Date("A/3/2020");
        System.out.println("A/3/2020 is a valid date?: "+date15.isValid());
        Date date16 = new Date("3/A/2020");
        System.out.println("3/A/2020 is a valid date?: "+date16.isValid());
        Date date17 = new Date("3/A0/2020");
        System.out.println("3/A0/2020 is a valid date?: "+date17.isValid());
        Date date18 = new Date("3/3A/2020");
        System.out.println("3/3A/2020 is a valid date?: "+date18.isValid());
        Date date19 = new Date("A0/3/2020");
        System.out.println("A0/3/2020 is a valid date?: "+date19.isValid());
        Date date20 = new Date("1A/3/2020");
        System.out.println("1A/3/2020 is a valid date?: "+date20.isValid());
        Date date21 = new Date("12/12/A");
        System.out.println("12/12/A is a valid date?: "+date21.isValid());
        Date date22 = new Date("12/12/20A0");
        System.out.println("12/12/20A0 is a valid date?: "+date22.isValid());

        Date date23 = new Date("1-3/2020");
        System.out.println("1-3/2020 is a valid date?: "+date23.isValid());
        Date date24 = new Date("1-3/2020");
        System.out.println("1/3-2020 is a valid date?: "+date24.isValid());

        Date date25 = new Date("1 3/2020");
        System.out.println("1 3/2020 is a valid date?: "+date25.isValid());
        Date date26 = new Date("1/3 2020");
        System.out.println("1/3 2020 is a valid date?: "+date26.isValid());
        Date date27 = new Date(" /3/2020");
        System.out.println("/3/2020 is a valid date?: "+date27.isValid());
        Date date28 = new Date("1/ /2020");
        System.out.println("1/ /2020 is a valid date?: "+date28.isValid());
    }
}
