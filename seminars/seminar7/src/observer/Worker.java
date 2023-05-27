package observer;

public class Worker implements Observer{

    private String name;
    private double salary;
    private String vacancy;

    @Override
    public String getVacancy() {
        return vacancy;
    }

    public Worker(String name, double salary, String vacancy) {
        this.name = name;
        this.salary = salary;
        this.vacancy = vacancy;
    }

    @Override
    public void receiveOffer(String companyName, String vacancyName, double salary) {
        if (this.salary < salary){
            System.out.printf("Рабочий (%s): %s >>> Мне нужна эта работа! [%s - %s - %f]\n", vacancy, name, companyName, vacancyName, salary);
            this.salary = salary;
        }
        else {
            System.out.printf("Рабочий (%s): %s >>> Я найду работу получше! [%s - %s - %f]\n", vacancy, name, companyName, vacancyName, salary);
        }
    }

}
