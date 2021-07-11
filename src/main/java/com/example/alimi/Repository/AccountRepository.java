package com.example.alimi.Repository;

import com.example.alimi.Domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUsername(String username);
}
