package repository.accountRepositories;


import models.account.AccountPayable;

import java.util.HashMap;
import java.util.Map;

public class AccountPayableRepository {

    private Map<String, AccountPayable> accountPayableMap;

    private AccountPayableRepository() {
        this.accountPayableMap = new HashMap<>();

    }
    private static AccountPayableRepository instance;

    public static AccountPayableRepository getInstance() {
        if (instance == null) {
            synchronized (AccountPayableRepository.class) {
                if (instance == null) {
                    instance = new AccountPayableRepository();
                }
            }
        }
        return instance;
    }


    /**
     * Adds to the list of account payables
     */
    public void addAccountPayable(AccountPayable accountPayable) {
        accountPayableMap.put(accountPayable.getId(), accountPayable);

    }

    /**
     * Returns all account payables
     */
    public Map<String,AccountPayable> getAllAccountPayableEntries() {
        return accountPayableMap;
    }

    /**
     * Removes an account payable from the list
     */
    public void removeFromAccountPayable(AccountPayable accountPayable) {
        accountPayableMap.remove(accountPayable.getId());
    }

    /**
     * Updates the account payable
     */
    public void updateAccountPayable(AccountPayable accountPayable) {
        AccountPayable existingAccountPayable = accountPayableMap.get(accountPayable.getId());
        if (existingAccountPayable != null) {
            existingAccountPayable.setReconciled(accountPayable.isReconciled());
        }
    }

   
    

    //method to return the account payable by id and ignore the case
    public AccountPayable getAccountPayableById(String id) {
        return accountPayableMap.get(id.toLowerCase());

    }

}
