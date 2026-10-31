import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityDemo {
    private AtomicInteger volatileCounter = new AtomicInteger(0);
     void withoutAtomicity(){

    }
    private  void startCounters(){
        Thread volatileIncrementer1 = new Thread(() -> {
            System.out.println("First volatile incrementor started, volatilecounter = " + volatileCounter);
            for(int j =0;j<10000;j++){
                volatileCounter.incrementAndGet();
            }
            System.out.println("Volatile increments done.");
        });

        Thread volatileIncrementer2 = new Thread(()->{
            System.out.println("Second volatile incrementor started, volatilecounter = "+ volatileCounter);
            for(int i=0;i<10000;i++){
                volatileCounter.incrementAndGet();
            }
            System.out.println("Volatile increments done.");
        });

        volatileIncrementer1.start();
        volatileIncrementer2.start();
    }
    private void print(){
        System.out.println("volatile counter "+ volatileCounter);
    }

    static void main() {
        AtomicityDemo ad = new AtomicityDemo();
        ad.startCounters();
        ad.print();
    }
}
