package sample.bean;

public class MyBean {
    //대충 빈에 대한 예시임
    //아무고토 아닌 레알 이노센스한 클라스
    private String name;
    private int count;

    public MyBean() {
        System.out.println("ㅎㅇ");
    }
    public MyBean(String name, int count) {
        System.out.println("나는 생성자야");
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "sample.bean.MyBean{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
