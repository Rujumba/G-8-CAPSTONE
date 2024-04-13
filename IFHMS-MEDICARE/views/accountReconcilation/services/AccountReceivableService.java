package views.accountReconcilation.services;


import models.account.AccountReceivable;
import models.account.GeneralLedger;
import repository.accountRepositories.AccountReceivableRepository;
import views.accountReconcilation.ReconciliationStrategy;

import java.util.List;

public class AccountReceivableService implements ReconciliationStrategy {
    private GeneralLedger generalLedger;

    private GeneralLedgerService generalLedgerService = new GeneralLedgerService();

    private AccountReceivableRepository accountReceivableRepository = new AccountReceivableRepository();

    public void init(){
        generalLedgerService = new GeneralLedgerService();
    }

    @Override
    public void reconcile(Object obj) {
        AccountReceivable accountReceivable = null;

        if (obj instanceof AccountReceivable){
            accountReceivable = (AccountReceivable) obj;
        }

        saveToGeneralLedger(accountReceivable);

        accountReceivable.setReconciled(true);

        accountReceivableRepository.updateAccountReceivable(accountReceivable);
    }

    public void saveToGeneralLedger(AccountReceivable accountReceivable){
        generalLedger = new GeneralLedger();

        generalLedger.setAmount(accountReceivable.getAmount());
        generalLedger.setId(accountReceivable.getId());
        generalLedger.setDescription(accountReceivable.getDescription());
        generalLedger.setReconciled(true);
        generalLedgerService.addGeneralLedger(generalLedger);
    }

    public void saveToAccountsReceivable(AccountReceivable accountReceivable){
        accountReceivable.setId("AR"+ accountReceivableRepository.getAllAccountReceivableEntries().size() + 1);
        accountReceivable.setReconciled(false);
        accountReceivableRepository.addAccountReceivable(accountReceivable);
    }

    public List<AccountReceivable> getAllAccountReceivableEntries(){
        return accountReceivableRepository.getAllAccountReceivableEntries();
    }

    public AccountReceivable getById(String id){
        return accountReceivableRepository.getById(id);
    }

    /**
     * Getters and Setters
     */
    public AccountReceivableRepository getAccountReceivableRepository() {
        return accountReceivableRepository;
    }

    public void setAccountReceivableRepository(AccountReceivableRepository accountReceivableRepository) {
        this.accountReceivableRepository = accountReceivableRepository;
    }

    public GeneralLedgerService getGeneralLedgerService() {
        return generalLedgerService;
    }

    public void setGeneralLedgerService(GeneralLedgerService generalLedgerService) {
        this.generalLedgerService = generalLedgerService;
    }
}
