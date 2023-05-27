package observer;

public class Program {

    /**
     * TODO: Доработать приложение, поработать с шаблоном проектирования Observer,
     * TODO: добавить новый тип соискателя.
     * TODO: Добавить новую сущность Вакансия, компания должна рассылать вакансии
     * @param args
     */
    public static void main(String[] args) {

        JobAgency jobAgency = new JobAgency();

        Company geekBrains = new Company("GeekBrains", 70000, jobAgency);
        Company google = new Company("Google", 100000, jobAgency);
        Company yandex = new Company("Yandex", 120000, jobAgency);
        Company nlmk = new Company("NLMK", 70000, jobAgency);

        Master ivanov = new Master("Ivanov", 80000, "Юрист");
        Master sidorov = new Master("Sidorov", 90000, "Веб-разработчик");
        Student petrov = new Student("Petrov", 5000, "Дизайнер");
        Worker sergeev = new Worker("Sergeev", 60000, "Бухгалтер");

        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(sergeev);

        for(int i = 0; i < 5; i++){
            geekBrains.needEmployee();
            google.needEmployee();
            yandex.needEmployee();
            nlmk.needEmployee();
        }

    }

}
