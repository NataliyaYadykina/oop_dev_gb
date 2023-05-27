package observer;

/**
 * Интерфейс наблюдателя (соискателя, человека в поиске работы)
 */
public interface Observer {

    void receiveOffer(String companyName, String vacancyName, double salary);
    String getVacancy();

}
