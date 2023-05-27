package observer;

import java.util.ArrayList;
import java.util.List;

public class JobAgency implements Publisher {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Реализация рассылки сообщений
     */
    @Override
    public void sendOffer(String nameCompany, String vacancyName, double salary) {
        for (Observer observer : observers){
            if (observer.getVacancy() == vacancyName){
                observer.receiveOffer(nameCompany, vacancyName, salary);
            }
            /*else {
                System.out.println("Соискателю вакансия не подходит и поэтому не отправляется.");
            }*/
        }
    }

}
