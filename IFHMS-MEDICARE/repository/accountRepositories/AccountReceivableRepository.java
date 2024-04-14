package repository.accountRepositories;


import models.account.AccountReceivable;

import java.util.HashMap;

import java.util.Map;

public class AccountReceivableRepository {

    private static AccountReceivableRepository accountReceivableRepository = null;
    public Map<String, AccountReceivable> accountReceivablesList;

    private AccountReceivableRepository() {
        accountReceivablesList = new HashMap<>();
    }

    public static AccountReceivableRepository getInstance() {
        if (accountReceivableRepository == null) {
            accountReceivableRepository = new AccountReceivableRepository();
        }
        return accountReceivableRepository;
    }


    public int getMapSize() {
        return accountReceivablesList.size();
    }

    //update a patient
    public void updateAccountReceivable(AccountReceivable accountReceivable) {
        accountReceivablesList.put(accountReceivable.getId(), accountReceivable);
    }

}
