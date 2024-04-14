package views.accountReconcilation.services;


import models.account.AccountReceivable;
import models.account.GeneralLedger;
import repository.accountRepositories.AccountReceivableRepository;
import views.accountReconcilation.ReconciliationStrategy;


import java.util.Map;

public class AccountReceivableService implements ReconciliationStrategy {
    private GeneralLedger generalLedger;

    private GeneralLedgerService generalLedgerService = new GeneralLedgerService();

    private AccountReceivableRepository accountReceivableRepository = AccountReceivableRepository.getInstance();

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
        accountReceivable.setId("AR"+ accountReceivableRepository.getMapSize() + 1);
        accountReceivable.setReconciled(false);
        accountReceivableRepository.accountReceivablesList.put(accountReceivable.getId(),accountReceivable);
    }

    public Map<String, AccountReceivable> getAllAccountReceivableEntries(){
        return accountReceivableRepository.accountReceivablesList;
    }

    public AccountReceivable getById(String id){
        return accountReceivableRepository.accountReceivablesList.get(id);
    }

}
