package homework18;

import java.util.*;

public class DogMain {
    public static void main(String[] args) {
        Dog dog1 = new Dog(12, "Sobachka");
        Dog dog2 = new Dog(3, "Sharik");

        Set<Dog> hs = new TreeSet<>(new DogComparator());
        hs.add(dog1);
        hs.add(dog2);
        System.out.println(hs);
        Dog dog3 = new Dog(4, "Shar2ik");
        hs.add(dog3);
        System.out.println(hs);

        Map<Circle,Dog> map = new HashMap<>();
        map.put(new Circle(2,"blue"),dog1);
        map.put(new Circle(4,"red"),dog2);
        map.put(new Circle(2,"blue"),dog3);
        map.put(null,dog3);
        System.out.println(map);

        Map<String,List<Dog>> map1 = new HashMap<>();
        List<Dog> list = new ArrayList<>();
        list.add(dog1);
        map1.put("ww",list);
        List<Dog> list2 = new ArrayList<>();
        list2.add(dog2);
        list2.add(dog3);
        map1.put("www",list2);
        System.out.println(" ");
        System.out.println(map1);


    }
}
