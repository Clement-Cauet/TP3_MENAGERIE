import ihm.IHM;

public class Main implements Runnable {

    public static void main(String[] args) {
        new Main().run();
    }

    @Override
    public void run() {
        new IHM();
    }
}