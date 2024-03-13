package com.vfedotov.controllers;

import com.vfedotov.services_layer.request_dto.accounts.AddAccountDto;
import com.vfedotov.services_layer.response_dto.AccountDto;
import com.vfedotov.services_layer.services.AccountService;
import jakarta.validation.Valid;
import com.vfedotov.services_layer.request_dto.accounts.DeleteAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService as;

    @GetMapping("/accounts")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<AccountDto> getAccounts() {
        return as.getAccounts();
    }

    @PostMapping("/add_account")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void AddAccount(@RequestBody @Valid AddAccountDto addDto) {
        as.addAccount(addDto);
    }


    @DeleteMapping("/delete_account")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void DeleteAccount(@RequestBody @Valid DeleteAccountDto deleteAccountDto) {
        as.deleteAccount(deleteAccountDto);
    }
}
