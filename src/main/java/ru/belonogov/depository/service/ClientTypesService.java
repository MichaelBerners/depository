package ru.belonogov.depository.service;

import ru.belonogov.depository.models.ClientType;

import java.util.List;
//сервис администратора
public interface ClientTypesService {

    //создать новый тип клиента
    void createClientType(ClientType clientType);

    //поиск по свойствам (названию) типа клиента
    ClientType readClientType(String s);

    //поиск по id клиента
    ClientType readClientType(int id);

    //показать весть список типов клиентов
    List<ClientType> readAllClientTypes();

    //изменить тип клиента
    boolean updateClientType(ClientType clientType, int id);

    //удалить тип клиента
    boolean deleteClientType(int id);
}
