package repository.accountRepositories;


import models.account.GeneralLedger;

import java.io.*;
 
import java.util.Map;

public class GeneralLedgerRepository {
    /**
     * Map of general ledger entries
     */
    public Map<String, GeneralLedger> generalLedgerMap;

    private static GeneralLedgerRepository instance;

    private GeneralLedgerRepository() {
        // Private constructor to prevent instantiation
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

    /**
     * Adds to a file all the general ledger objects
     */
    public void addGeneralLedger(GeneralLedger generalLedger) {

        String id = generalLedger.getId();

        String filename = "GeneralLedger2.dat";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))) {
            oos.writeObject(generalLedger);
            System.out.println("GeneralLedger object saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

 

}
