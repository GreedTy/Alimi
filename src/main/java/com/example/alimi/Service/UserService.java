package com.example.alimi.Service;

import com.example.alimi.Domain.Account;
import com.example.alimi.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Account registUser(Account account) {
        account.encodePassword(passwordEncoder);
        this.accountRepository.save(account);
        return account;
    }

    public List<Account> selectAllUser() {
        return accountRepository.findAll();
    }

    public Account findUserName(String userId) {
        Account account = accountRepository.findByUsername(userId);
        return account;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        System.out.println(account.getUsername());
        System.out.println(account.getPassword());
        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }
}
