public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int year, int month, int day) {
        this.year = ((-9999 <= year && year <= 9999) ? year : 0);
        this.month = ((1 <= month && month <= 12) ? month : 1);
        this.day = ((1 <= day && day <= 31) ? day : 1);
    }

    @Override
    public int hashCode() {
        // TODO: ask how to overcome the fact there are more options for Date than integers in int
        return Integer.MIN_VALUE + (this.day - 1) + 31 * (this.month - 1) + 31 * 12 * (this.year + 9999);
    }

    @Override
    public boolean equals(Object other) {
        // TODO: understand how to undestand type is Date without saying "DateTime"
    }

    private static int numDigits(int num) {
        // TODO: do you think this and the following functions should be in this Class? should be static?
        int counter = 0;
        while(num > 0) {
            num /= 10;
            counter++;
        }
        return counter;
    }

    private static String addZeroes(int num, int times) {
        int absNum = (num >= 0 ? num : -num);
        String result = Integer.toString(absNum);
        for(int i = 0; i < times; i++) {
            result = "0" + result;
        }
        result = (num >= 0 ? result : "-" + result);
        return result;
    }

    @Override
    public String toString() {
        String fullDay = Date.addZeroes(this.day, 2 - Date.numDigits(this.day));
        String fullMonth = Date.addZeroes(this.month, 2 - Date.numDigits(this.month));
        String fullYear = Date.addZeroes(this.year, 4 - Date.numDigits(this.year));
        return (fullDay + "/" + fullMonth + "/" + fullYear);
    }
}
