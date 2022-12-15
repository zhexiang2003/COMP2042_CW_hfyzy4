package com.example.demo;

import java.io.*;
import java.util.ArrayList;

public class Account implements Comparable<Account> {

    private static long score = 0;
    private static String userName ;
    public static ArrayList<Account> accounts = new ArrayList<>();

    public Account(String userName, long score){
        this.userName=userName;
        this.score = score;
    }

    public Account() {

    }

    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    public void addToScore(long score) {
        this.score += score;
    }

    public Long getScore() {
        return score;
    }

    public String getUserName() {
        return userName;
    }

    static Account accountHaveBeenExist(String userName){
        for(Account account : accounts){
            if(account.getUserName().equals(userName)){
                return account;
            }
        }
        return null;

    }

    static void makeNewAccount(String userName, Long score){
        Account acc = new Account(userName, score);
        accounts.add(acc);
    }

    public void setScore(long score) {
        this.score = score;
    }

    static void writeFile (Account acc) throws IOException {
        String name = acc.getUserName();
        long score = acc.getScore();

        BufferedWriter writeUsername = new BufferedWriter(new FileWriter("C:\\Users\\zhexi\\OneDrive - University of Nottingham Malaysia\\University Projects\\COMP2042_CW_hfyzy4\\src\\main\\java\\com\\example\\demo\\accounts.txt",true));
        writeUsername.write(name);
        writeUsername.write(", ");
        writeUsername.write(String.valueOf(score));
        writeUsername.newLine();
        writeUsername.close();
    }


    public static void readFile() throws IOException {
        System.out.println("jjj");
        BufferedReader readUsername = new BufferedReader(new FileReader("C:\\Users\\zhexi\\OneDrive - University of Nottingham Malaysia\\University Projects\\COMP2042_CW_hfyzy4\\src\\main\\java\\com\\example\\demo\\accounts.txt"));
        String line;
        while ((line = readUsername.readLine()) != null) {
            //System.out.println(line);
            String[] lineSplit = line.split(", ");
            //System.out.println(lineSplit[0]+" "+Long.valueOf(lineSplit[1]));
            makeNewAccount(lineSplit[0],Long.valueOf(lineSplit[1]));
            //Account.makeNewAccount(userName,score);
            System.out.println(lineSplit[0]+" "+Long.valueOf(lineSplit[1]));
        }
//        Collections.sort(accounts);
        readUsername.close();
/*
        Collections.sort(accounts);
*/

    }


}
