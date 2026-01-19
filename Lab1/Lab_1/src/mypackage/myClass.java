package mypackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

class Person {
    private String name;
    private int age;
    private double salary;
    private LocalDate hireDate;

    public Person(String name, int age, double salary, LocalDate hireDate) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.hireDate = hireDate;
    }

 //Все rerutn`ы, чтоб не ругалась Java
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public LocalDate getHireDate() { return hireDate; }
    
 //Override для переопределения (Без него работает тоже, но пусть лучше останется)
    @Override
    public String toString() {
        return name + "," + age + "," + String.format("%.2f", salary) + "," + hireDate;
    }
}
//создаем и заполняем класс

public class myClass {
    public static void main(String[] args) {
        Person[] people = {
            new Person("Alice", 30, 1.0, LocalDate.of(2020, 3, 15)),
            new Person("Bob", 25, 6.0, LocalDate.of(2022, 7, 1)),
            new Person("Charlie", 35, 8.0, LocalDate.of(2018, 11, 10)),
            new Person("Diana", 28, 400.0, LocalDate.of(2021, 5, 20)),
            new Person("Eve", 40, 32.0, LocalDate.of(2015, 9, 3)),
            new Person("Frank", 22, 122.0, LocalDate.of(2023, 1, 10)),
            new Person("Grace", 33, 0.0, LocalDate.of(2019, 8, 14)),
            new Person("Henry", 27, 5665.0, LocalDate.of(2021, 12, 5)),
            new Person("Ivy", 29, 111111.0, LocalDate.of(2020, 10, 22)),
            new Person("Jack", 31, 14.0, LocalDate.of(2019, 4, 18)),
            new Person("Kate", 26, 322.0, LocalDate.of(2022, 2, 28)),
            new Person("Leo", 38, 7.0, LocalDate.of(2017, 6, 12)),
            new Person("Mia", 34, 98989898.0, LocalDate.of(2018, 3, 30))
        };

        System.out.println("=== Исходный массив ===");
        printArray(people);

        //сортировка по зарплате
        Arrays.sort(people, Comparator.comparingDouble(Person::getSalary));
        System.out.println("\n=== После сортировки по зарплате ===");
        printArray(people);
        
        //Запись на рабочий стол
        String desktopPath = System.getProperty("user.home") + "/Desktop/peopleSalary.txt";
        try {
            writeArrayToFile(people, desktopPath);
            System.out.println("\nМассив успешно записан в файл 'peopleSalary.txt' на рабочем столе.");
        } catch (IOException e) {
            System.err.println(" Ошибка записи файла: " + e.getMessage());
        }
        
        //сортировка по возрасту
        Arrays.sort(people, Comparator.comparingInt(Person::getAge));
        System.out.println("\n=== Отсортируем по возрасту===");
        printArray(people);

        // Запись на рабочий стол
        String desktopPath1 = System.getProperty("user.home") + "/Desktop/peopleAge.txt";
        try {
            writeArrayToFile(people, desktopPath1);
            System.out.println("\nМассив успешно записан в файл 'peopleAge.txt' на рабочем столе.");
        } catch (IOException e) {
            System.err.println(" Ошибка записи файла: " + e.getMessage());
        }
    }
    
//Выводим массив
    public static void printArray(Person[] arr) {
        for (Person p : arr) {
            System.out.println(p);
        }
    }
//Выводим тоже
    public static void writeArrayToFile(Person[] arr, String filepath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (Person p : arr) {
                writer.write(p.toString());
                writer.newLine();
            }
        }
    }
}