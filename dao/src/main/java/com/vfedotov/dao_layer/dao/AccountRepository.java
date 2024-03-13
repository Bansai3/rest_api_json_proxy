package com.vfedotov.dao_layer.dao;

import com.vfedotov.dao_layer.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    Account finAccountById(Long id);
    Account findAccountByLogin(String login);
}
