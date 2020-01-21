package com.example.demo.data;
// measures the time it takes to fill the database for the four sets of parent/child entity classes
// and writes the timing result to the console and to a file

import com.example.demo.business.service.Service;
import com.example.demo.data.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class ReadAndWriteData {
    private List<String> names = new ArrayList<>();
    private File file = new File("src/main/resources/dataForEntities.txt");
    private String[] newData = new String[4];

    @Autowired
    private Service service;

    public String[] timeScenarioOne() {
        List<Integer> order = new ArrayList<Integer>(List.of(0,1,2,3));
        Collections.shuffle(order);
        for (int i = 0; i < 4; i++) {
            if (order.get(i) == 0) {
                runBiJoin();
            } else if (order.get(i) == 1) {
                runUniList();
            } else if (order.get(i) == 2) {
                runBi();
            } else {
                runUniObj();
            }
        }
        return newData;
    }

    private void runBiJoin() {
        try {
            Scanner scanner = new Scanner(file);
            names = new ArrayList<>();
            long timeStart = System.currentTimeMillis();
            University university = new University();
            //for (int i = 0; i < 100; i++) {
            while (scanner.hasNextLine()) {
                String[] lineSplit = scanner.nextLine().split(",");
                String universityName = lineSplit[0];
                if (!names.contains(universityName)) {
                    names.add(universityName);
                    university = new University(universityName);
                    service.saveUniversity(university);
                } else {

                }
                Student student = new Student(lineSplit[1], university);
                service.saveStudent(student);
            }
            long timeEnd = System.currentTimeMillis();
            long timeSpent = timeEnd - timeStart;
            System.out.println("Bidirectional, with join. Saving universities/students took " + Long.toString(timeSpent) + " ms");
            scanner.close();
            newData[0] = Long.toString((timeSpent));
            service.deleteAllStudents();
            service.deleteAllUniversities();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void runUniList() {
        try {
            Scanner scanner = new Scanner(file);
            names = new ArrayList<>();
            long timeStart = System.currentTimeMillis();
            Boss boss = new Boss();
            //for (int i = 0; i < 100; i++) {
            while (scanner.hasNextLine()) {
                String[] lineSplit = scanner.nextLine().split(",");
                String bossName = lineSplit[0];
                if (!names.contains(bossName)) {
                    names.add(bossName);
                    boss = new Boss(bossName);
                    service.saveBoss(boss);
                } else {

                }
                Company company = new Company(lineSplit[1]);
                service.saveCompany(company);
            }
            long timeEnd = System.currentTimeMillis();
            long timeSpent = timeEnd - timeStart;
            System.out.println("Unidirectional, List on one-side. Saving boss/companies took " + Long.toString(timeSpent) + " ms");
            newData[1] = Long.toString((timeSpent));
            service.deleteAllCompanies();
            service.deleteAllBosses();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void runBi() {
        try {
            Scanner scanner = new Scanner(file);
            names = new ArrayList<>();
            long timeStart = System.currentTimeMillis();
            Account account = new Account();
            //for (int i = 0; i < 100; i++) {
            while (scanner.hasNextLine()) {
                String[] lineSplit = scanner.nextLine().split(",");
                String accountName = lineSplit[0];
                if (!names.contains(accountName)) {
                    names.add(accountName);
                    account = new Account(accountName);
                    service.saveAccount(account);
                } else {

                }
                Transaction transaction = new Transaction(lineSplit[1], account);
                service.saveTransaction(transaction);
            }
            long timeEnd = System.currentTimeMillis();
            long timeSpent = timeEnd - timeStart;
            System.out.println("Bidirectional, w/o join. Saving account/transactions took " + Long.toString(timeSpent) + " ms");
            newData[2] = Long.toString((timeSpent));
            service.deleteAllTransactions();
            service.deleteAllAccounts();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void runUniObj() {
        try {
            Scanner scanner = new Scanner(file);
            names = new ArrayList<>();
            long timeStart = System.currentTimeMillis();
            Team team = new Team();
            //for (int i = 0; i < 100; i++) {
            while (scanner.hasNextLine()) {
                String[] lineSplit = scanner.nextLine().split(",");
                String teamName = lineSplit[0];
                if (!names.contains(teamName)) {
                    names.add(teamName);
                    team = new Team(teamName);
                    service.saveTeam(team);
                } else {

                }
                Member member = new Member(lineSplit[1], team);
                service.saveMember(member);
            }
            long timeEnd = System.currentTimeMillis();
            long timeSpent = timeEnd - timeStart;
            System.out.println("Unidirectional, object on many-side. Saving team/members took " + Long.toString(timeSpent) + " ms");
            newData[3] = Long.toString((timeSpent));
            service.deleteAllMembers();
            service.deleteAllTeams();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
