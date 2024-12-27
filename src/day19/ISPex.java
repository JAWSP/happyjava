package day19;

interface  OrderService {
    void placeOrder(String item);
    //void cancelOrder(String orderID);
    //어? OrderClient에선 네가 사용이 안되었는데...
    // 이럴꺼면 차라리 독립적으로 각각의 인터페이스로 정의가 나을듯
}

interface CancelOperaton {
    void cancelOrder(String orderID);
}

class OrderClient {
    private final OrderService orderService;

    public OrderClient(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createNewOrder() {
        orderService.placeOrder("book");
    }
}

//둘다 쓰고 싶다면? 다중인용
class OnlineOrderServices implements CancelOperaton, OrderService {

    @Override
    public void cancelOrder(String orderID) {
        //대충 내용
    }

    @Override
    public void placeOrder(String item) {
        //대충 내용 2
    }
}

public class ISPex {
}
