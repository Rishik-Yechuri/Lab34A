import java.util.*;

public class Parent{
    public static void main(String[] args){
       Collection<String> collection;
       collection = new LinkedList<>();
       collection.add("foo");
       collection.add("bar");
       collection.add("baz");
       collection.forEach(System.out::println);
    }

}