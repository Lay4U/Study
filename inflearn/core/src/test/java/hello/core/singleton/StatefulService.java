package hello.core.singleton;

public class StatefulService {

    private int price; //상태를 유지하는 필드

    //아래와 같이 설계해야함.
    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제가 된다..!!
        // 공유 필드는 매우 조심해야 한다! 스프링 빈은 항상 무상태로 설계해야한다.
        return price;
    }
//    public void order(String name, int price){
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제가 된다..!!
//        // 공유 필드는 매우 조심해야 한다! 스프링 빈은 항상 무상태로 설계해야한다.
//    }

    public int getPrice(){
        return price;
    }
}
