public class Date {
    private int year;
    private int month;
    private int day;
    public Date(String date) {
        this.year = Integer.parseInt(Character.toString(date.charAt(6))+Character.toString(date.charAt(7))+Character.toString(date.charAt(8))+Character.toString(date.charAt(9)));
        //this.year = Integer.parseInt(date.substring(6));
        this.day = Integer.parseInt(Character.toString(date.charAt(3))+Character.toString(date.charAt(4)));
        //this.year = Integer.parseInt(date.substring(3,5));
        this.month = Integer.parseInt(Character.toString(date.charAt(0))+Character.toString(date.charAt(1)));
        //this.year = Integer.parseInt(date.substring(0,2));
    } //taking mm/dd/yyyy and create a Date object

    public Date() {
    } //return today’s date
    public isValid() { }
}
