package from_doc2;

public class Time {
    private int sec;
    private int min;
    private int hour;

    public Time(int sec, int min, int hour) {
        this.sec = sec;
        this.min = min;
        this.hour = hour;
    }

    public Time() {
        sec = 0;
        min = 0;
        hour = 0;
    }

    public int getSeconds() {
        return sec;
    }

    public void setSeconds(int sec) {
        this.sec = sec;
    }

    public int getMinutes() {
        return min;
    }

    public void setMinutes(int min) {
        this.min = min;
    }

    public int getHours() {
        return hour;
    }

    public void setHours(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Time{" +
                "seconds=" + sec +
                ", minutes=" + min +
                ", hours=" + hour +
                '}';
    }

    public int getSecondsCount() {
        return sec + min * 60 + hour * 3600;
    }

    public void addFiveSecond() {
        int newSeconds = sec + 5;
        sec = newSeconds % 60;
        int newMinutes = min + newSeconds / 60;
        min = newMinutes % 60;
        hour += newMinutes / 60;
    }

    public static void main(String[] args) {
        Time time = new Time(56, 59, 5);
        assert 56 + 59 * 60 + 5 * 3600 == time.getSecondsCount();

        time.addFiveSecond();
        assert time.getSeconds() == 1;
        assert time.getMinutes() == 0;
        assert time.getHours() == 6;
        assert 1 + 6 * 3600 == time.getSecondsCount();

        Time time1 = new Time();
        assert time1.getSeconds() == 0;
        assert time1.getMinutes() == 0;
        assert time1.getHours() == 0;

        System.out.println(time);
    }
}
