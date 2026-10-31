import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ConcurrentHashMapDemo {
    static void main() {
        ConcurrentHashMap<Integer,String> emp = new ConcurrentHashMap<>();
        emp.put(101,"aa");
        emp.put(102,"bb");
        emp.put(103,"cc");

        for(Map.Entry<Integer,String> entry:emp.entrySet()){
            System.out.println("Key: "+ entry.getKey() + " value: "+ entry.getValue());
        }
        emp.put(103,"dd");
        emp.computeIfAbsent(105,e->"ee");
        emp.computeIfAbsent(106,e->"kk");
        emp.clear();
        System.out.println(emp);
        String employee = emp.getOrDefault(106,"ff");
        System.out.println(employee);
    }
}
