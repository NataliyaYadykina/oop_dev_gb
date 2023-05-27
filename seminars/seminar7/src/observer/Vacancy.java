package observer;

import java.util.Random;

public class Vacancy {

    private String vacancy;
    final String[] vacancies = {"Веб-разработчик", "Бухгалтер", "Юрист", "Маркетолог", "Дизайнер"};
    Random random = new Random();

    public String getTypeVacancy() {
        return vacancy;
    }

    public Vacancy() {
        this.vacancy = getRandomVacancy();
    }

    public String getRandomVacancy(){
        return vacancies[random.nextInt(vacancies.length)];
    }

}
