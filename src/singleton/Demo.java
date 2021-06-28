package singleton;

public class Demo {
    public static void main(String[] args) {
        Singleton objOne = Singleton.getInstance();
        Singleton objTwo = Singleton.getInstance();

        if(objOne == objTwo){
            System.out.println("Thre are same object");
        }
    }
}
