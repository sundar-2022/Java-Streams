package com.java.javafeatures;

import java.util.Arrays;
import java.util.List;

public class LambdaAndStreams {

    public void print(){
        Runnable runnable = () -> System.out.println("Hello I'm from lamda");
        runnable.run();
    }
    public void sortingList(){
        List<String> names = Arrays.asList("Vikram", "Surya", "Ajith", "Kamal", "Aamai");
//        names.sort((a,b) -> a.compareTo(b)); // lambda expression
        names.sort(String :: compareTo); // method reference
        System.out.println(names);
    }

    public void printEvenNumbers(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(evenNumbers);
    }

    public void smallerToUpperCase(){
        List<String> smallerCase = Arrays.asList("Ajith", "Vijay", "Dhoni");
        List<String> upperCase = smallerCase.stream()
//                .map( n -> n.toUpperCase()) // lambda expression
                .map(String::toUpperCase) // method reference
                .toList();
        System.out.println(upperCase);
    }
    @FunctionalInterface
    interface Hello{
        void helloWorld(String name);
    }
    Hello hello = (name) -> System.out.println("Hello " + name);
    public void useHello(){
        hello.helloWorld("Sundar");
    }

    public void vowel(){
        List<Character> characters = Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'i');
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Character> ans = characters.stream()
//                .filter(c -> vowels.contains(c)) // lambda
                .filter(vowels::contains) // method reference
                .toList();
        System.out.println(ans);
    }

    public void anyMatch(){
        List<String> st = Arrays.asList("Ajith", "Vijay", "Surya");
        boolean ans = st.stream()
                .anyMatch(value -> (value.startsWith("A")));
        System.out.println(ans);
    }

    public void allMatch(){
        List<String> st = Arrays.asList("Ajith", "Vijay", "Surya");
        boolean ans = st.stream().allMatch(a -> a.contains("i"));
        System.out.println(ans);
    }

    public void noneMatch(){
        List<String> st = Arrays.asList("Ajith", "Vijay", "Surya");
        boolean ans = st.stream().noneMatch("Surya"::equals); // returns true if no elements matched by none match
        System.out.println(ans);
    }
}