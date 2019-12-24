package com.example.demo.business.service;

import com.example.demo.data.entity.*;
import com.example.demo.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BossRepository bossRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberRepository memberRepository;

    public void saveUniversity(University university) {
        universityRepository.save(university);
    }
    public void deleteAllUniversities() { universityRepository.deleteAll(); }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
    public void deleteAllStudents() { studentRepository.deleteAll(); }

    public void saveBoss(Boss boss) {
        bossRepository.save(boss);
    }
    public void deleteAllBosses() { bossRepository.deleteAll(); }

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }
    public void deleteAllCompanies() { companyRepository.deleteAll(); }

    public void saveAccount(Account account) { accountRepository.save(account); }
    public void deleteAllAccounts() { accountRepository.deleteAll(); }

    public void saveTransaction(Transaction transaction) { transactionRepository.save(transaction); }
    public void deleteAllTransactions() { transactionRepository.deleteAll(); }

    public void saveTeam(Team team) { teamRepository.save(team); }
    public void deleteAllTeams() { teamRepository.deleteAll(); }

    public void saveMember(Member member) { memberRepository.save(member); }
    public void deleteAllMembers() { memberRepository.deleteAll(); }

    public DisplayResultClass readResultsFromFile() {
        File file = new File("src/main/resources/results.csv");
        DisplayResultClass results = new DisplayResultClass();
        results.setTitles(new String[]{"BiJoin","UniList","Bi","UniObj"});
        String[] nextResult;
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine(); // skip titles
            String[] lineSplit;
            while (scanner.hasNextLine()) {
                nextResult = new String[4];
                lineSplit = scanner.nextLine().split(",");
                for (int i = 0; i < 4; i++) {
                    nextResult[i] = lineSplit[i];
                }
                results.setResult(nextResult);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }

    public void writeDataToResultsFile(DisplayResultClass results, String[] newData) {
        results.setResult(newData);
        File file = new File("src/main/resources/results.csv");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            for (int i = 0; i < 4; i++) {
                fileWriter.write(newData[i] + ",");
            }
            fileWriter.write("\n");
            fileWriter.close();
        }
        catch(IOException error) {
            System.out.println(error.getMessage());
        }
    }
}
