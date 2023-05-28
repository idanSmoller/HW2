public class DateTime extends Date{
    private int hour;
    private int minute;

    public DateTime(int year, int month, int day, int hour, int minute) {
        // TODO: ask if we allow to use super like this and like in other functions
        super(year, month, day);
        this.hour = ((0 <= hour && hour <= 23) ? hour : 0);
        this.minute = ((0 <= minute && minute <= 59) ? minute : 0);
    }

    // TODO: check if the documentation should be before @Override or after
    /**
     * calculate and return hash code per instance, and return the same integer for 2 instances
     * if and only if all their attributes are the same
     * @return hash code of the instance
     */
    @Override
    public int hashCode() {
        return this.minute + this. hour * 60 + super.hashCode() * 60 * 24;
    }

    /**
     * Check if all the attributes of this and other are the same
     * @param other Object to check if equal
     * @return True if exactly the same type, and all attributes are the same. False otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if(other instanceof DateTime) {
            return this.hashCode() == other.hashCode();
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
     * return a string that represents the DateTime in the following format: "<year>/<month>/<day> <hour>:<minute>"
     * @return the wished String
     */
    @Override
    public String toString() {
        String fullHour = DateTime.addZeroes(this.hour, 2 - DateTime.numDigits(this.hour));
        String fullMinute = DateTime.addZeroes(this.hour, 2 - DateTime.numDigits(this.minute));
        return super.toString() + " " + fullHour + ":" + fullMinute;
    }
}
