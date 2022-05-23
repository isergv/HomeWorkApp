package lesson5;

public class Person {
    //1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст
    private String name;
    private String level;
    private String email;
    private String phoneNumber;
    private int pay;
    private int age;

    public Person(String name, String level, String email, String phoneNumber, int pay, int age) {
        this.name = name;
        this.level = level;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pay = pay;
        this.age = age;
    }

    public void print() {
        if (age > 40) {
            System.out.println("ФИО: " + name + ";");
            System.out.println("Должность: " + level + ";");
            System.out.println("Email: " + email + ";");
            System.out.println("Телефон: " + phoneNumber + ";");
            System.out.println("Зарплата: " + pay + ";");
            System.out.println("Возраст: " + age + ";");
            System.out.println();
        }
    }
}
