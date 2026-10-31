import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CopyOnWriteArrayListDemo {
    static void method2() throws InterruptedException{
        List<Integer> lst = new CopyOnWriteArrayList<>(List.of(10));

        Thread t1 = new Thread(() -> lst.add(55));
        Thread t2 = new Thread(() ->lst.add(77));
        t1.start();
        t2.start();
        t2.join();
        Iterator<Integer> itr = lst.iterator();
//        t2.join();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
    static void method1() {
        CopyOnWriteArrayList<Integer> lst = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3));
        Iterator<Integer> itr = lst.iterator();
        new Thread(()->
        {
            while(itr.hasNext()){
                lst.add(5);
                itr.next();
            }
            lst.forEach(System.out::println);
        }).start();
    }

    static void main() throws InterruptedException{
        method2();
    }
}
