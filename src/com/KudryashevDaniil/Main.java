package com.KudryashevDaniil;

import com.KudryashevDaniil.car.Car;
import com.sun.org.apache.xalan.internal.xsltc.dom.ArrayNodeListIterator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Лада", "Седан"));
        cars.add(new Car("Бмв", "Кроссовер"));
        cars.add(new Car("Мерседес", "Седан"));
        cars.add(new Car("Форд", "Хэтчбек"));
        cars.add(new Car("Бмв", "Хэтчбек"));
        cars.add(new Car("Пежо", "Кроссовер"));
        cars.add(new Car("Тойота", "Седан"));

        Collection<List<Car>> groupOfCars = cars.stream().collect(Collectors.groupingBy(x -> x.getType())).values();

        for (List<Car> list : groupOfCars) {
            System.out.println(list.toString());
        }

        HashMap<String, Integer> wordsAndNumbers = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("input.txt"));
            for (String line : lines) {
                for (String word : line.split(" ")) {
                    if (wordsAndNumbers.containsKey(word)) {
                        wordsAndNumbers.put(word, wordsAndNumbers.get(word) + 1);
                    } else {
                        wordsAndNumbers.put(word, 1);
                    }
                }
            }
            System.out.println("1. ");
            System.out.println(wordsAndNumbers.keySet().size());
            System.out.println("2. ");
            System.out.println(wordsAndNumbers.keySet().stream().sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo)).collect(Collectors.joining("\n")));
            System.out.println("3. ");
            System.out.println(wordsAndNumbers.keySet().stream().map(x -> x + " - " + wordsAndNumbers.get(x)).collect(Collectors.joining("\n")));
            System.out.println("4. ");
            ListIterator iter = lines.listIterator(lines.size());
            while (iter.hasPrevious()) {
                System.out.println(iter.previous());
            }
            System.out.println("5. ");
            MyReverseIterator iterMy = new MyReverseIterator(lines);
            while (iterMy.hasNext()) {
                System.out.println(iterMy.next());
            }
            System.out.println("6. ");
            List<Integer> writeLines = new ArrayList<>();
            writeLines.add(1);
            writeLines.add(5);
            writeLines.add(3);
            writeLines.add(4);
            for (Integer i : writeLines) {
                System.out.print(i + " - ");
                if (i >= 0 && i < lines.size())
                    System.out.println(lines.get(i));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
