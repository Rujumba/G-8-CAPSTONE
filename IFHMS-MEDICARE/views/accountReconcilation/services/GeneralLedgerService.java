package views.accountReconcilation.services;


import models.account.GeneralLedger;
import repository.accountRepositories.GeneralLedgerRepository;
import views.logger.services.DebugLogger;

import java.util.Map;

public class GeneralLedgerService {


    GeneralLedgerRepository generalLedgerRepository2 = GeneralLedgerRepository.getInstance();

    Map<String, GeneralLedger> generalLedgerEntries = generalLedgerRepository2.getAllGeneralLedgerEntries();
    DebugLogger logger = DebugLogger.getLogger();

    /**
     * Adds to a file all the general ledger objects
     */
    public void addGeneralLedger(GeneralLedger generalLedger) {

        String id = generalLedger.getId();

        generalLedgerEntries.put(id, generalLedger);
        logger.logSuccess("Ledger has been added succussfully");

    }

    public Map<String, GeneralLedger> getAllGeneralLedgerEntries() {
        return this.generalLedgerEntries;
   }

    /**
     * Returns all general ledger entries for the file and stores them in a list
     */
    


   
}
