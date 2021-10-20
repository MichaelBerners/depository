package ru.belonogov.depository.service.impl;

import org.springframework.stereotype.Service;
import ru.belonogov.depository.models.Client;
import ru.belonogov.depository.service.ClientsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientsServiceImpl implements ClientsService {

    //Хранилище пользователей
    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID пользователя
    private static int count;


    @Override
    public void create(Client client) {
        final int clientId = ++count;
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);

    }

    @Override
    public Client read(int id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public List<Client> readAll() {

        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public boolean update(Client client, int id) {
        if(CLIENT_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null;
    }
}
