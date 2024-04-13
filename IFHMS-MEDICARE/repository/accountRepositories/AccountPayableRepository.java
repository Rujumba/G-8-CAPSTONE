package repository.accountRepositories;


import models.account.AccountPayable;

import java.util.ArrayList;
import java.util.List;

public class AccountPayableRepository {

    private List<AccountPayable> accountPayablesList = new ArrayList<>();

    /**
     * Adds to the list of account payables
     */
    public void addAccountPayable(AccountPayable accountPayable) {
        accountPayablesList.add(accountPayable);
    }

    /**
     * Returns all account payables
     */
    public List<AccountPayable> getAllAccountPayableEntries() {
        return accountPayablesList;
    }

    /**
     * Removes an account payable from the list
     */
    public void removeFromAccountPayable(AccountPayable accountPayable) {
        accountPayablesList.remove(accountPayable);
    }

    /**
     * Updates the account payable
     */
    public void updateAccountPayable(AccountPayable accountPayable) {
        for (AccountPayable ap : accountPayablesList) {
            if (ap.getId() == accountPayable.getId()) {
                ap.setReconciled(accountPayable.isReconciled());
            }
        }
    }

    /**
     * Getters and Setters
     */
    public List<AccountPayable> getAccountPayablesList() {
        return accountPayablesList;
    }

    public void setAccountPayablesList(List<AccountPayable> accountPayablesList) {
        this.accountPayablesList = accountPayablesList;
    }

    //method to return the account payable by id and ignore the case
    public AccountPayable getAccountPayableById(String id) {
        for (AccountPayable ap : accountPayablesList) {
            if (ap.getId().equalsIgnoreCase(id)) {
                return ap;
            }
        }
        return null;
    }

}
