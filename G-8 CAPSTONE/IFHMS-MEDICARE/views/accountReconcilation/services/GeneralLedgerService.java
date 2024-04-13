package views.accountReconcilation.services;


import models.account.GeneralLedger;
import repository.accountRepositories.GeneralLedgerRepository;

import java.util.List;

public class GeneralLedgerService {
    private GeneralLedgerRepository generalLedgerRepository = new GeneralLedgerRepository();

    public List<GeneralLedger> getAllGeneralLedgerEntries(){
        return generalLedgerRepository.getAllGeneralLedgerEntries();
    }

    public void addGeneralLedger(GeneralLedger generalLedger){
        generalLedgerRepository.addGeneralLedger(generalLedger);
    }
}
