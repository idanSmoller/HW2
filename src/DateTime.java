public class DateTime extends Date{
    private int hour;
    private int minute;

    public DateTime(int year, int month, int day, int hour, int minute) {
        // TODO: ask if we allow to use super like this and like in other functions
        super(year, month, day);
        this.hour = ((0 <= hour && hour <= 23) ? hour : 0);
        this.minute = ((0 <= minute && minute <= 59) ? minute : 0);
    }

    @Override
    public int hashCode() {
        return this.minute + this. hour * 60 + super.hashCode() * 60 * 24;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof DateTime) {
            return this.hashCode() == other.hashCode();
        }
        return false;
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
        String fullHour = DateTime.addZeroes(this.hour, 2 - DateTime.numDigits(this.hour));
        String fullMinute = DateTime.addZeroes(this.hour, 2 - DateTime.numDigits(this.minute));
        return super.toString() + " " + fullHour + ":" + fullMinute;
    }
}
