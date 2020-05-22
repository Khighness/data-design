package com.kag.dao;

import com.kag.entity.Ledger;

import java.util.Date;
import java.util.List;

/**
 * @Description: 账本持久层
 * @Author: 陈子康
 * @Date: 2020/5/6
 */
public interface LedgerDao {

    public void addLedger(Ledger ledger);

    public List<Ledger> queryLedger();

    public Ledger queryLedgerById(String LedgerId);

}
