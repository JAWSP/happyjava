package day10;

public class Box {

    Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        Box box = new Box();
        box.setObj(new Book("ww"));

        ((Book)box.getObj()).bookTest();


    }
}
