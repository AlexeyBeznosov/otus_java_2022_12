package homework;

import java.util.*;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private Map<Customer, String> map = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        TreeMap<Customer, String> treeMap = (TreeMap<Customer, String>) map;
        Map.Entry<Customer, String> en = treeMap.firstEntry();
        if (en != null) {
            return new AbstractMap.SimpleEntry<>(new Customer(en.getKey().getId(), en.getKey().getName(), en.getKey().getScores()), en.getValue());
        }
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        return null; // это "заглушка, чтобы скомилировать"
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        TreeMap<Customer, String> treeMap = (TreeMap<Customer, String>) map;
        Map.Entry<Customer, String> entryNext = null;
        for (Map.Entry<Customer, String> entry : treeMap.entrySet()) {
            if (entry.getKey().getScores() > customer.getScores()) {
                entryNext = entry;
                break;
            }
        }
        if (entryNext != null) {
            return new AbstractMap.SimpleEntry<>(new Customer(entryNext.getKey().getId(), entryNext.getKey().getName(), entryNext.getKey().getScores()), entryNext.getValue());
        }
        return null; // это "заглушка, чтобы скомилировать"
    }

    public void add(Customer customer, String data) {
        map.put(customer, data);
    }
}
