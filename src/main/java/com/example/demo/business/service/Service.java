package com.example.demo.business.service;

import com.example.demo.data.entity.*;
import com.example.demo.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

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
}
