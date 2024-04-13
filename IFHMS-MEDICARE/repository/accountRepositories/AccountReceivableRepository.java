package repository.accountRepositories;


import models.account.AccountReceivable;

import java.util.ArrayList;
import java.util.List;

public class AccountReceivableRepository {
    /**
     * List of account receivables
     */
    private List<AccountReceivable> accountReceivablesList = new ArrayList<>();

    /**
     * Adds to the list of account receivables
     */
    public void addAccountReceivable(AccountReceivable accountReceivable) {
        accountReceivablesList.add(accountReceivable);
    }

    /**
     * Returns the account receivable by id
     */
    public AccountReceivable getById(String id) {
        for (AccountReceivable ar : accountReceivablesList) {
            if (ar.getId().equalsIgnoreCase(id)) {
                return ar;
            }
        }
        return null;
    }

    /**
     * Updates the account receivable
     */
    public void updateAccountReceivable(AccountReceivable accountReceivable) {
        for (AccountReceivable ar : accountReceivablesList) {
            if (ar.getId() == accountReceivable.getId()) {
                ar.setReconciled(accountReceivable.isReconciled());
            }
        }
    }

    /**
     * Returns all account receivables
     */
    public List<AccountReceivable> getAllAccountReceivableEntries() {
        return accountReceivablesList;
    }

    /**
     * Removes an account receivable from the list
     */
    public void removeFromAccountReceivable(AccountReceivable accountReceivable) {
        accountReceivablesList.remove(accountReceivable);
    }

}
