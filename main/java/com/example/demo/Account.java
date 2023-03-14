package com.example.demo;

import java.io.*;
import java.util.ArrayList;

/**
 * The Account class is responsible for managing the username and the score in the game.
 *
 * <p>
 *     The Account class is allowed to create a new username, reads account from a file, write accounts into the file,
 *     and compare the scores.
 * </p>
 * */

public class Account implements Comparable<Account> {

    private static long score = 0;
    private static String userName ;

    /** The array list of the account. */
    public static ArrayList<Account> accounts = new ArrayList<>();

    /** A new Account created with username and score.*/
    public Account(String userName, long score){
        this.userName=userName;
        this.score = score;
    }

    public Account() {

    }

    /** This function compares the score of the current account and the next account. */
    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    /** Add the score to the username's score. */
    public void addToScore(long score) {
        this.score += score;
    }

    public Long getScore() {
        return score;
    }

    public String getUserName() {
        return userName;
    }

    /** Return account if the account exists in the list, if not return null. */
    static Account accountHaveBeenExist(String userName){
        for(Account account : accounts){
            if(account.getUserName().equals(userName)){
                return account;
            }
        }
        return null;

    }

    /** Create new account with the new username and score. Then add it into the array list. */
    static void makeNewAccount(String userName, Long score){
        Account acc = new Account(userName, score);
        accounts.add(acc);
    }

    public void setScore(long score) {
        this.score = score;
    }


    /** Write the account list into the file. */
    static void writeFile (Account acc) throws IOException {
        String name = acc.getUserName();
        long score = acc.getScore();

        BufferedWriter writeUsername = new BufferedWriter(new FileWriter("main/java/com/example/demo/accounts.txt",true));
        writeUsername.write(name);
        writeUsername.write(", ");
        writeUsername.write(String.valueOf(score));
        writeUsername.newLine();
        writeUsername.close();
    }

    /** Read the account list from the file. */
    public static void readFile() throws IOException {

        BufferedReader readUsername = new BufferedReader(new FileReader("main/java/com/example/demo/accounts.txt"));
        String line;
        while ((line = readUsername.readLine()) != null) {

            String[] lineSplit = line.split(", ");

            makeNewAccount(lineSplit[0],Long.valueOf(lineSplit[1]));
        }

        readUsername.close();

    }


}
