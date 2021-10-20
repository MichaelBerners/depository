package ru.belonogov.depository.service;

import ru.belonogov.depository.models.Client;

import java.util.List;

public interface ClientsService {

    //создать нового пользователя
    void create(Client client);

    //прочитать данные пользователя по id
    Client read(int id);

    //вывести весь список пользователей
    List<Client> readAll();

    //изменить пользователя с id
    boolean update(Client client, int id);

    //удалить пользовател с id
    boolean delete(int id);


}
