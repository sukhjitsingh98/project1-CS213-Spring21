public class Date {
    private int year;
    private int month;
    private int day;
    public Date(String date) {
        this.year = Integer.parseInt(Character.toString(date.charAt(6))+Character.toString(date.charAt(7))+Character.toString(date.charAt(8))+Character.toString(date.charAt(9)));
        //this.year = Integer.parseInt(date.substring(6));

        //MIGHT NEED TO ACCOUNT FOR 0 INFRONT OF SINGLE DIGIT NUMBER
        this.day = Integer.parseInt(Character.toString(date.charAt(3))+Character.toString(date.charAt(4)));
        //this.year = Integer.parseInt(date.substring(3,5));
        this.month = Integer.parseInt(Character.toString(date.charAt(0))+Character.toString(date.charAt(1)));
        //this.year = Integer.parseInt(date.substring(0,2));
    } //taking mm/dd/yyyy and create a Date object

    public Date() {
    } //return today’s date

    private Boolean isLeapYear(){
        if (this.year%4==0){
            if (this.year%100==0){
                if(this.year%400==0){
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

    public isValid() {
        if(this.year<1900 /*|| this.year> current year*/){
            //Return invalid
        }

        if(this.month==1 || this.month==3 || this.month==5 || this.month==7 || this.month==8 || this.month==10 ||this.month==12){
            if(this.day>31 || this.day<1){
                //Invalid date
            }
        }
        else if(this.month== 4 || this.month==6 || this.month==9 || this.month==11){
            if(this.day>30 || this.day<1){
                //Invalid date
            }
        }
        else if(this.month==2){
            //Check for leap year
            if(isLeapYear() == true)
                if (this.day>29 || this.day<1) {
                    //Invalid date
                }
            }
            else if(this.day>28 || this.day<1){
                //invalid date
            }
        }

    }
}
