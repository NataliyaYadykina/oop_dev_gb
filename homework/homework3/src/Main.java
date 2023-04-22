import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    /**
     * TODO: generateEmployee должен создавать различных сотрудников (Worker, Freelancer)
     * @return
     */
    static Employee generateEmployee(){
        String[] names = new String[] {"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Сергей", "Андрей", "Федор", "Иван"};
        String[] surNames = new String[] {"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Бородин", "Пушкин", "Сидоров", "Гагарин", "Суриков"};
        int age = random.nextInt(20, 65);
        int typeEmployee = random.nextInt(1, 4);
        double salary = 250;
        int hours = 168;

        Employee employee = new Worker(names[random.nextInt(0, 10)], surNames[random.nextInt(0, 10)], age, salary * hours);

        switch (typeEmployee){
            case 1:
                salary = random.nextInt(200, 300);
                hours = random.nextInt(150, 170);
                employee = new Worker(names[random.nextInt(0, 10)], surNames[random.nextInt(0, 10)], age, salary * hours);
                break;
            case 2:
                salary = random.nextInt(500, 1000);
                hours = random.nextInt(30, 100);
                employee = new Freelancer(names[random.nextInt(0, 10)], surNames[random.nextInt(0, 10)], age, salary, hours);
                break;
            case 3:
                salary = random.nextInt(50000, 130000);
                employee = new ContractWorker(names[random.nextInt(0, 10)], surNames[random.nextInt(0, 10)], age, salary);
                break;
        }

        return employee;
    }

    public static void main(String[] args) {

        Employee[] employees = new Employee[15];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
        }

        for (Employee employee: employees){
            System.out.println(employee);
        }

        // Arrays.sort(employees, new NameComparator());
        Arrays.sort(employees, new AgeComparator());
        // Arrays.sort(employees);

        System.out.printf("\n*** Отсортированный массив сотрудников ***\n\n");

        for (Employee employee: employees){
            System.out.println(employee);
        }

    }

}

class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        // 1 - o1 первый
        // 0 - равны
        // -1 - o1 второй
        // return o1.calculateSalary() == o2.calculateSalary() ? 0 : (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
        return Double.compare(o2.calculateSalary(), o1.calculateSalary());
    }
}

class AgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.age, o2.age);
    }
}

class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        // 1 - o1 первый
        // 0 - равны
        // -1 - o1 второй
        return o1.name.compareTo(o2.name);
    }
}

abstract class Employee implements Comparable<Employee> {

    protected String name;
    protected String surName;
    protected int age;
    protected double salary;

    public Employee(String name, String surName, int age, double salary) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Среднемесячная заработная плата: %.2f", name, surName, salary);
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
    }
}

class Worker extends Employee{

    public Worker(String name, String surName, int age, double salary) {
        super(name, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
        // TODO: Для фрилансера - return 20 * 8 * salary
    }

    @Override
    public String toString() {
        return String.format("%s %s; %d; Рабочий; Среднемесячная заработная плата: %.2f (руб.)", name, surName, age, salary);
    }
}

/**
 * TODO: Доработать самостоятельно в рамках домашней работы
 */
class Freelancer extends Employee{

    private double hours;

    public Freelancer(String name, String surName, int age, double salary, double hours) {
        super(name, surName, age, salary);
        this.hours = hours;
    }

    @Override
    public double calculateSalary() {
        return hours * salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; %d; Фрилансер; Отработано часов: %.2f; Часовая ставка: %.2f; Оплата за месяц: %.2f (руб.)", name, surName, age, hours, salary, hours * salary);
    }
}

class ContractWorker extends Employee{

    public ContractWorker(String name, String surName, int age, double salary) {
        super(name, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; %d; Договор; Оплата по договору: %.2f (руб.)", name, surName, age, salary);
    }
}
