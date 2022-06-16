package com.kag.service;

import com.kag.dao.ClientDao;
import com.kag.dao.ClientDaoImpl;
import com.kag.entity.Client;

/**
 * @apiNote 客户服务层
 * @author KHighness
 * @since 2020/5/24
 */
public class ClientService {

    private ClientDao clientDao = new ClientDaoImpl();

    public void addClientService(Client client) {
        clientDao.addClient(client);
    }

    public void updateClientService(int clientId, Client client) {
        clientDao.updateClientById(clientId, client);
    }

    public Client queryClientByIdService(int clientId) {
        return clientDao.queryClientById(clientId);
    }

    public Client queryClientByNameService(String clientName) {
        return clientDao.queryClientByName(clientName);
    }

    public void deleteClientService(int clientId) {
        clientDao.deleteClient(clientId);
    }
}
