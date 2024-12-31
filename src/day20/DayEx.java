package day20;

class Today {
    private Day day;

    public void setDay(Day day) {
        this.day = day;
        System.out.println(day);
    }
    public Day getDay() {
        return this.day;
    }

}
public class DayEx {
    public static void main(String[] args) {
        Today today = new Today();
        today.setDay(Day.SUNDAY);
        //순서가 0부터 시작해서 순서대로 숫자가 나오게 된다
        System.out.println(today.getDay().ordinal());
    }
}
