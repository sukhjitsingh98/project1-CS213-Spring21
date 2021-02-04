/**
 Contains constants which are referenced throughout other classes.
 All are made immutable as they are constants.
 @author German Munguia, Sukhjit Singh
 */

public final class Constants {
    //Constants for Month Names
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    //Constants for days in a Month
    public static final int DAYS_IN_LONG_MONTH = 31;
    public static final int DAYS_IN_SHORT_MONTH = 30;
    public static final int DAYS_IN_FEB_LEAP_YEAR = 29;
    public static final int DAYS_IN_FEB_NORMAL_YEAR = 28;

    //Constants for year limits
    public static final int MINIMUM_YEAR_LIMIT = 1900;

    //Constant for default value if date input is not an integer
    public static final int DEFAULT_DATE_IF_INPUT_INVALID = -1;

    //Constants for date substring positions
    public static final int MINIMUM_DATE_SUBSTRING_LENGTH = 5;

    public static final int SINGLE_DIGIT_MONTH_DASH_POSITION = 1;
    public static final int DOUBLE_DIGIT_MONTH_DASH_POSITION = 2;
    public static final int SINGLE_DIGIT_DAY_DASH_POSITION1 = 3;
    public static final int SINGLE_DIGIT_DAY_DASH_POSITION2 = 4;
    public static final int DOUBLE_DIGIT_DAY_DASH_POSITION1 = 4;
    public static final int DOUBLE_DIGIT_DAY_DASH_POSITION2 = 5;

    public static final int MONTH_SUBSTRING_START = 0;
    public static final int MONTH_SUBSTRING_END1 = 1;
    public static final int MONTH_SUBSTRING_END2 = 2;

    public static final int DAY_SUBSTRING_START1 = 2;
    public static final int DAY_SUBSTRING_START2 = 3;
    public static final int DAY_SUBSTRING_END1 = 3;
    public static final int DAY_SUBSTRING_END2 = 4;
    public static final int DAY_SUBSTRING_END3 = 5;

    public static final int YEAR_SUBSTRING_START1 = 4;
    public static final int YEAR_SUBSTRING_START2 = 5;
    public static final int YEAR_SUBSTRING_START3 = 6;

    //Constants for leap year calculation
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUARTERCENTENNIAL = 400;

    //Constants for the Book class
    public static final int SERIAL_NUMBER_SUBSTRING_START = 5;
    public static final int SERIAL_NUMBER_SUBSTRING_END = 10;

    //Constants for the Library class
    public static final int STARTING_ARRAY_SIZE = 4;
    public static final int INCREASE_ARRAY_BY = 4;
    public static final int BOOK_NOT_FOUND = -1;

    //Constants for the Kiosk class
    public static final int STARTING_SERIAL_NUMBER = 10001;


}
