public class VisibilityDemo {
    private volatile boolean running = true;
    private void startFlagChecker(){
        Thread checker = new Thread(()->{
            System.out.println("Flagchecker started");
            System.out.println("Thread name: "+ Thread.currentThread().getName());
            while(running){

                // without volatile this might become infinite loop
            }
            System.out.println("Flag checker detected stop signal.");
        });
        checker.start();
    }
    private void stopFlagChecker(){
        System.out.println("Inside stopflagchecker method");
        System.out.println("Thread name: "+ Thread.currentThread().getName());
        running = false;
        System.out.println("Stop signal sent.");
    }

    static void main() throws InterruptedException {
        VisibilityDemo vd = new VisibilityDemo();
        vd.startFlagChecker();
        Thread.sleep(1000);
        vd.stopFlagChecker();
        Thread.sleep(5000);
    }

}
