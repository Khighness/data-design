package com.kag.dao;

import com.kag.entity.Client;

import java.util.List;

/**
 * @apiNote 客户持久层
 * @author KHighness
 * @since 2020/5/21
 */
public interface ClientDao {

    public void addClient(Client client);

    public void updateClientById(int clientId, Client client);

    public List<Client> queryClient();

    public Client queryClientById(int clientId);

    public Client queryClientByName(String clientName);

    public void deleteClient(int clientId);

}
