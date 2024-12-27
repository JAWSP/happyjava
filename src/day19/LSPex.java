package day19;
//LSP = 엄마 말 잘들어야지
//상속 받았으면 원래 가지고 있었던 기능에 오류가 잆어야 된다


class Rectangle{
    protected int width;
    protected int height;

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int area(){
        return width * height;
    }
}

class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }// 이렇게만 만들면 이후 수정이 될때 문제가 생김

    //따라서 높이가
    public void setWidth(int width) {
        super.width = width;
        super.height = width;
    }

    public void setHeight(int height) {
        super.width = height;
        super.height = height;
    }
}

public class LSPex {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(3, 5);
        System.out.println(rect.area());
        rect.setWidth(6);
        System.out.println(rect.area());

        Rectangle square = new Square(5);
        System.out.println(square.area());
        square.setWidth(6);//높이가 바뀌면 너비도 같이 바뀌어야 한다
        System.out.println(square.area());

    }
}
