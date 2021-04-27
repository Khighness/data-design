package com.kag.service;

import com.kag.dao.LedgerDao;
import com.kag.dao.LedgerDaoImpl;
import com.kag.entity.Ledger;

import java.util.List;

/**
 * @Description: 账本服务层
 * @Author: 陈子康
 * @Date: 2020/5/24
 */
public class LedgerService {

    private LedgerDao ledgerDao = new LedgerDaoImpl();

    public void addLedgerService(Ledger ledger) {
        ledgerDao.addLedger(ledger);
    }

    public List<Ledger> queryLedgerService() {
        return ledgerDao.queryLedger();
    }
}
