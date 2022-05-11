package lesson5;

public class HomeWorkAppLesson5 {
    public static void main(String[] args) {
        int number = 5;
        Person[] persArray = new Person[number];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 930000, 30);
        persArray[1] = new Person("Petrov Petr", "Engineer2", "petrov@mailbox.com", "880020003", 313000, 36);
        persArray[2] = new Person("Sidorov Sidr", "Engineer3", "sidorov@mailbox.com", "899966452", 130000, 40);
        persArray[3] = new Person("Nikolaev Nokolai", "Engineer4", "nikolaev@mailbox.com", "81234568", 334000, 41);
        persArray[4] = new Person("Fedorov Fedr", "Engineer5", "fedorov@mailbox.com", "8754213", 450000, 90);

        for (int i = 0; i < number; i++) {
            persArray[i].print();
        }
    }
}

