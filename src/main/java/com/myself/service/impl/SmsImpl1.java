package com.myself.service.impl;

import com.myself.service.SmsInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Primary
public class SmsImpl1 implements SmsInterface {


    Person person;

    private static final  ThreadLocal<Object> local = new ThreadLocal<>();

    static {

        local.set(1);
    }

    public void getT() {
        System.out.println("smsImpl1 test code");
    }


    public static void main(String[] avg) throws ClassNotFoundException {

        String[] c = new String[]{"a", "b", "c"};
        Integer[] d = new Integer[]{1, 23, 4};

        printArray(c);
        printArray(d);

        List<Person> bookList = new ArrayList<>();
        bookList.add(new Person("jack", "18163138123"));
        bookList.add(new Person("martin", null));
        bookList.add(new Person("jack", "18163138124"));


        Map<String, Person> r = bookList.stream().collect(
                Collectors.toMap(Person::getName, Function.identity(), ((x, y) -> y))
        );

        Map<String, List<Person>> re = bookList.stream().collect(Collectors.groupingBy(Person::getName));
    }

    @Override
    public String hello() {
        return null;
    }

    @Override
    public String hell2() {
        return null;
    }


    static class Person {
        private String name;
        private String phoneNumber;
        // getters and setters

        Person(String n, String v) {
            name = n;
            phoneNumber = v;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return phoneNumber;
        }
    }


    public static <E> void printArray(E[] array) {

        for (E element : array) {
            System.out.printf("%s", element);
            System.out.print("\r\n");
        }

    }

    @PostConstruct
    public void init() {
        this.person = new Person("wu", "qimeng");
    }
}
