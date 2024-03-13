package com.vfedotov.rest_api_json_proxy.config;

import com.vfedotov.dao_layer.dao.AccountRepository;
import com.vfedotov.dao_layer.entity.Account;
import com.vfedotov.dao_layer.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByLogin(login);
        if (account == null)
            throw new UsernameNotFoundException("Account does not exist!");
        if (account.getStatus() == Status.BANNED)
            throw new IllegalStateException("Account is banned!");
        return SecurityAccount.fromAccount(account);
    }
}
