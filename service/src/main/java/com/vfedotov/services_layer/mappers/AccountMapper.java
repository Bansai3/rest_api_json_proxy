package com.vfedotov.services_layer.mappers;

import com.vfedotov.dao_layer.entity.Account;
import com.vfedotov.services_layer.response_dto.AccountDto;
import com.vfedotov.services_layer.request_dto.accounts.AddAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto AccountToAccountDto(Account account);
    @Mapping(target = "id", expression = "java(0)")
    Account AddAccountDtoToAccount(AddAccountDto accountDto);
}
