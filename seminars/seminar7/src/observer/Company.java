package observer;

import java.util.Random;

public class Company {

    private Random random;
    private String nameCompany;
    private double maxSalary;

    private Publisher jobAgancy;

    public String getNameCompany() {
        return nameCompany;
    }

    public Company(String nameCompany, double maxSalary, Publisher jobAgancy) {
        this.nameCompany = nameCompany;
        this.maxSalary = maxSalary;
        this.jobAgancy = jobAgancy;
        random = new Random();
    }

    /**
     * TODO: Доработать метод, компания должна генерировать объект Вакансия
     * TODO: и передавать объект в агенство
     * Поиск сотрудника
     */
    public void needEmployee(){
        double salary = random.nextDouble(3000, maxSalary);
        Vacancy vacancy = new Vacancy();
        jobAgancy.sendOffer(nameCompany, vacancy.getTypeVacancy(), salary);
    }

}
