package repository.accountRepositories;


import models.account.GeneralLedger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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


    }

    /**
     * Returns all general ledger entries for the file and stores them in a list
     */
    // public List<GeneralLedger> getAllGeneralLedgerEntries() {

    //     String filename = "GeneralLedger2.dat";
    //     try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
    //         GeneralLedger generalLedger;
    //         while ((generalLedger = (GeneralLedger) ois.readObject()) != null) {
    //             generalLedgerList.add(generalLedger);
    //         }
    //     } catch (EOFException e) {
    //         e.printStackTrace();
    //     } catch (IOException | ClassNotFoundException e) {
    //         e.printStackTrace();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }

    //     return generalLedgerList;
    // }

}
