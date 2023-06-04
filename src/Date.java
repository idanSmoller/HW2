public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int year, int month, int day) {
        this.year = ((-3999 <= year && year <= 3999) ? year : 0);
        this.month = ((1 <= month && month <= 12) ? month : 1);
        this.day = ((1 <= day && day <= 31) ? day : 1);
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * calculate and return hash code per instance, and return the same integer for 2 instances
     * if and only if all their attributes are the same
     * @return hash code of the instance
     */
    @Override
    public int hashCode() {
        return Integer.MIN_VALUE + (this.day - 1) + 31 * (this.month - 1) + 31 * 12 * (this.year + 3999);
    }

    /**
     * Check if all the attributes of this and other are the same
     * @param other Object to check if equal
     * @return True if exactly the same type, and all attributes are the same. False otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Date) {
            return this.toString().equals(other.toString());
        }
        return false;
    }

    /**
     * Counts how many digits are in an integer
     * @param num the num to count his digits
     * @return number of digits
     */
    private static int numDigits(int num) {
        // TODO: do you think this and the following functions should be in this Class? should be static?
        int counter = 0;
        while(num > 0) {
            num /= 10;
            counter++;
        }
        return counter;
    }

    /**
     * Calculate a string in the following format: "-00...00|<num>|" if num is negative, and "00...00<num>" otherwise.
     * Number of zeros is 'times'.
     * @param num the number to show his string
     * @param times number of zeros to add
     * @return The calculated string
     */
    private static String addZeroes(int num, int times) {
        int absNum = (num >= 0 ? num : -num);
        String result = Integer.toString(absNum);
        for(int i = 0; i < times; i++) {
            result = "0" + result;
        }
        result = (num >= 0 ? result : "-" + result);
        return result;
    }

    /**
     * return a string that represents the DateTime in the following format: "<year>/<month>/<day>"
     * @return the wished String
     */
    @Override
    public String toString() {
        String fullDay = Date.addZeroes(this.day, 2 - Date.numDigits(this.day));
        String fullMonth = Date.addZeroes(this.month, 2 - Date.numDigits(this.month));
        String fullYear = Date.addZeroes(this.year, 4 - Date.numDigits(this.year));
        return (fullDay + "/" + fullMonth + "/" + fullYear);
    }
}
