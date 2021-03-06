package com.example.demo.data;
// measures the time it takes to fill the database for the four sets of parent/child entity classes
// and writes the timing result to the console and to a file

import com.example.demo.business.service.Service;
import com.example.demo.data.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ReadAndWriteData {
    private List<String> names = new ArrayList<>();
    private String filename = "/dataForEntities.txt";
    private Result newData = new Result();

    @Autowired
    private Service service;

    public Result timeScenarioOne() {
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
            InputStream inputStream = getClass().getResourceAsStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            names = new ArrayList<>();
            long timeStart = System.currentTimeMillis();
            University university = new University();
            String line = br.readLine();
            while (line != null) {
                String[] lineSplit = line.split(",");
                String universityName = lineSplit[0];
                if (!names.contains(universityName)) {
                    names.add(universityName);
                    university = new University(universityName);
                    service.saveUniversity(university);
                }
                Student student = new Student(lineSplit[1], university);
                service.saveStudent(student);
                line = br.readLine();
            }
            long timeEnd = System.currentTimeMillis();
            long timeSpent = timeEnd - timeStart;
            System.out.println("Bidirectional, with join. Saving universities/students took " + Long.toString(timeSpent) + " ms");
            newData.setBiJoin((int) timeSpent);
            service.deleteAllStudents();
            service.deleteAllUniversities();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runUniList() {
        try {
            InputStream inputStream = getClass().getResourceAsStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            names = new ArrayList<>();
            long timeStart = System.currentTimeMillis();
            Boss boss = new Boss();
            String line = br.readLine();
            while (line != null) {
                String[] lineSplit = line.split(",");
                String bossName = lineSplit[0];
                if (!names.contains(bossName)) {
                    names.add(bossName);
                    boss = new Boss(bossName);
                    service.saveBoss(boss);
                }
                Company company = new Company(lineSplit[1]);
                service.saveCompany(company);
                line = br.readLine();
            }
            long timeEnd = System.currentTimeMillis();
            long timeSpent = timeEnd - timeStart;
            System.out.println("Unidirectional, List on one-side. Saving boss/companies took " + Long.toString(timeSpent) + " ms");
            newData.setUniList((int) timeSpent);
            service.deleteAllCompanies();
            service.deleteAllBosses();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runBi() {
        try {
            InputStream inputStream = getClass().getResourceAsStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            names = new ArrayList<>();
            long timeStart = System.currentTimeMillis();
            Account account = new Account();
            String line = br.readLine();
            while (line != null) {
                String[] lineSplit = line.split(",");
                String accountName = lineSplit[0];
                if (!names.contains(accountName)) {
                    names.add(accountName);
                    account = new Account(accountName);
                    service.saveAccount(account);
                }
                Transaction transaction = new Transaction(lineSplit[1], account);
                service.saveTransaction(transaction);
                line = br.readLine();
            }
            long timeEnd = System.currentTimeMillis();
            long timeSpent = timeEnd - timeStart;
            System.out.println("Bidirectional, w/o join. Saving account/transactions took " + Long.toString(timeSpent) + " ms");
            newData.setBi((int) timeSpent);
            service.deleteAllTransactions();
            service.deleteAllAccounts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runUniObj() {
        try {
            InputStream inputStream = getClass().getResourceAsStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            names = new ArrayList<>();
            long timeStart = System.currentTimeMillis();
            Team team = new Team();
            String line = br.readLine();
            while (line != null) {
                String[] lineSplit = line.split(",");
                String teamName = lineSplit[0];
                if (!names.contains(teamName)) {
                    names.add(teamName);
                    team = new Team(teamName);
                    service.saveTeam(team);
                }
                Member member = new Member(lineSplit[1], team);
                service.saveMember(member);
                line = br.readLine();
            }
            long timeEnd = System.currentTimeMillis();
            long timeSpent = timeEnd - timeStart;
            System.out.println("Unidirectional, object on many-side. Saving team/members took " + Long.toString(timeSpent) + " ms");
            newData.setUniObj((int) timeSpent);
            service.deleteAllMembers();
            service.deleteAllTeams();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
