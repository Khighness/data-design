package com.kag.service;

import com.kag.dao.ClientDao;
import com.kag.dao.ClientDaoImpl;
import com.kag.entity.Client;

/**
 * @Description: 客户服务层
 * @Author: 陈子康
 * @Date: 2020/5/24
 */
public class ClientService {

    private ClientDao clientDao = new ClientDaoImpl();

    public void addClientService(Client client) {
        clientDao.addClient(client);
    }

    public Client queryClientByIdService(int clientId) {
        return clientDao.queryClientById(clientId);
    }
}
