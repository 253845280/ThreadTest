package Singleton;

public class singleton {

    //private volatile static singleton myinstance;
    private static singleton myinstance;

    public static singleton getInstance() {
        if (myinstance == null) {
            synchronized (singleton.class) {
                if (myinstance == null) {
                    myinstance = new singleton();
                }
            }
        }
        return myinstance;
    }

    public static void main(String[] args) {
        singleton.getInstance();
    }
}
