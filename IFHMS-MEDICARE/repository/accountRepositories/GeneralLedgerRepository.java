package repository.accountRepositories;


import models.account.GeneralLedger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GeneralLedgerRepository {
    /**
     * Map of general ledger entries
     */
    private Map<String, GeneralLedger> generalLedgerMap;

    private static GeneralLedgerRepository instance;

    private GeneralLedgerRepository() {
        generalLedgerMap = new HashMap<>();
    }

    public static GeneralLedgerRepository getInstance() {
        if (instance == null) {
            synchronized (GeneralLedgerRepository.class) {
                if (instance == null) {
                    instance = new GeneralLedgerRepository();
                }
            }
        }
        return instance;
    }




    public Map<String, GeneralLedger> getAllGeneralLedgerEntries() {
        return this.generalLedgerMap;
  }

 

}
