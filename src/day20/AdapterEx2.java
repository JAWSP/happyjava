package day20;

interface ElectronicDevice {
    public void turnOn();
}

class OldDevice implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("걸걸걸걸걸걸걸(대충 오래된 전자기기 돌아가는 소리)");
    }
}

class NewDevice {
    public void powerOn() {
        System.out.println("새삥으로 전자기기가 켜짐");
    }
}

class DeviceAdaptor implements ElectronicDevice {
    public NewDevice nd;
    public DeviceAdaptor(NewDevice nd) {
        this.nd = nd;
        System.out.println("대충 아다리가 맞아서 들어가는 소리");
    }
    @Override
    public void turnOn() {
        nd.powerOn();
    }
}

//어뎁터 클래스를 구현

public class AdapterEx2 {
    public static void main(String[] args) {
        //기존 전자 기기
        ElectronicDevice oldDevide = new OldDevice();
        oldDevide.turnOn();
        NewDevice newDevice = new NewDevice();
        //turnOn으로 새로운 전자기기를 이용하고싶을때
        ElectronicDevice adapter = new DeviceAdaptor(newDevice);
        adapter.turnOn();
    }
}
