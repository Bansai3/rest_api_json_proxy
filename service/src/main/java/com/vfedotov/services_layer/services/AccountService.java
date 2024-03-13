package com.vfedotov.services_layer.services;

import com.vfedotov.dao_layer.dao.AccountRepository;
import com.vfedotov.dao_layer.entity.Account;
import com.vfedotov.services_layer.mappers.AccountMapper;
import com.vfedotov.services_layer.request_dto.accounts.AddAccountDto;
import com.vfedotov.services_layer.request_dto.accounts.DeleteAccountDto;
import com.vfedotov.services_layer.response_dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    public List<AccountDto> getAccounts(){
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(ac -> accountMapper.AccountToAccountDto(ac)).collect(Collectors.toList());
    }
    public void addAccount(AddAccountDto addAccountDto) {
        Account ac = accountMapper.AddAccountDtoToAccount(addAccountDto);
        accountRepository.save(ac);
    }
    public void deleteAccount(DeleteAccountDto deleteAccountDto) {
        Account ac = accountRepository.finAccountById(deleteAccountDto.getId());
        accountRepository.delete(ac);
    }

}
