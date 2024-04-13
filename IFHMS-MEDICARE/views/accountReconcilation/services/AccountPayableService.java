package views.accountReconcilation.services;


import models.account.AccountPayable;
import models.account.GeneralLedger;
import repository.accountRepositories.AccountPayableRepository;
import views.accountReconcilation.ReconciliationStrategy;

import java.util.List;


public class AccountPayableService implements ReconciliationStrategy {
    
    private GeneralLedger generalLedger;

    private GeneralLedgerService generalLedgerService = new GeneralLedgerService();

    private AccountPayableRepository accountPayableRepository = new AccountPayableRepository();

    /**
     * Implements the reconcile method in the ReconciliationStrategy interface
     */
    @Override
    public void reconcile(Object obj) {
        AccountPayable accountPayable = null;
        
        if (obj instanceof AccountPayable){
            accountPayable = (AccountPayable) obj;
        }

        saveToGeneralLedger(accountPayable);

        accountPayable.setReconciled(true);
        
        accountPayableRepository.updateAccountPayable(accountPayable);
    }

    /**
     * Saves the account payable to the general ledger
     */
    public void saveAccountPayable(AccountPayable accountPayable){
        accountPayable.setId("AP" + accountPayableRepository.getAllAccountPayableEntries().size() + 1);
        accountPayable.setReconciled(false);
        accountPayableRepository.addAccountPayable(accountPayable);
    }

    /**
     * Returns all account payables
     */
    public List<AccountPayable> getAllAccountPayableEntries(){
        return accountPayableRepository.getAllAccountPayableEntries();
    }

    /**
     * Saves the account payable to the general ledger
     */
    public void saveToGeneralLedger(AccountPayable accountPayable){
        generalLedger = new GeneralLedger();
        generalLedger.setAmount(accountPayable.getAmount());
        generalLedger.setId(accountPayable.getId());
        generalLedger.setDescription(accountPayable.getDescription());
        generalLedger.setReconciled(true);
        generalLedgerService.addGeneralLedger(generalLedger);
    }

    /**
     * Returns the account payable by id
     */
    public AccountPayable getById(String id){
        return accountPayableRepository.getAccountPayableById(id);
    }

}
