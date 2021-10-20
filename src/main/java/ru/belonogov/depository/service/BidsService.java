package ru.belonogov.depository.service;

import ru.belonogov.depository.models.Bid;

import java.util.List;

public interface BidsService {

    //создание новой клиентской заявки (клиентом)
    void createBids();

    //весь список заявок доступен кладовщику и бухгалтеру, клиенту только свои
    Bid readBid(int id);

    //весь список заявок может смотреть кладовщик и бухгалтер, клиент только свои
    List<Bid> readAllBids();

    //изменять заявку клиент может во всех случаях кроме PAYMENT_YES
    boolean updateBids(Bid bid, int id);
}
