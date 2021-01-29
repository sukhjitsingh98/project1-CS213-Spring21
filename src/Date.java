import java.util.Calendar;

public class Date {
    private int year;
    private int month;
    private int day;
    public Date(String date) {
        //this.year = Integer.parseInt(Character.toString(date.charAt(6))+Character.toString(date.charAt(7))+Character.toString(date.charAt(8))+Character.toString(date.charAt(9)));
        this.year = Integer.parseInt(date.substring(6));
        //this.day = Integer.parseInt(Character.toString(date.charAt(3))+Character.toString(date.charAt(4)));
        this.year = Integer.parseInt(date.substring(3,5));
        //this.month = Integer.parseInt(Character.toString(date.charAt(0))+Character.toString(date.charAt(1)));
        this.year = Integer.parseInt(date.substring(0,2));
    } //taking mm/dd/yyyy and create a Date object

    public Date() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DATE);
    } //return today’s date

    private Boolean isLeapYear(){
        if (year%4==0){
            if (year%100==0){
                if(year%400==0){
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
        if(year<1900 || year>calendar.get(Calendar.YEAR)){
            return false;
        }
        else if(year==calendar.get(Calendar.YEAR)) {
            if(month>(calendar.get(Calendar.MONTH)+1)) {
                return false;
            }
            else if (month==(calendar.get(Calendar.MONTH)+1)) {
                if(day>calendar.get(Calendar.DATE)) {
                    return false;
                }
            }
        }
        else if(month<1 || month>12) {
            return false;
        }
        else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            if(day>31 || day<1){
                return false;
            }
        }
        else if(month== 4 || month==6 || month==9 || month==11){
            if(day>30 || day<1){
                return false;
            }
        }
        else if(month==2){
            //Check for leap year
            if(isLeapYear() == true){
                if (day>29 || day<1) {
                    return false;
                }
            }
            else if(day>28 || day<1){
                return false;
            }
        }
        return true;
    }
}
