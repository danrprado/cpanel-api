package com.ro.panel.controllers;

import com.ro.panel.models.MasterAccount;
import com.ro.panel.repositories.MasterAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Optional;


@RestController
@Validated
public class MasterAccountController {


    private final MasterAccountRepository masterAccountRepository;

    @Autowired
    public MasterAccountController(MasterAccountRepository masterAccountRepository) {
        this.masterAccountRepository = masterAccountRepository;
    }

    @GetMapping("/user-panel/master-account/{id}")
    @Validated
    public ResponseEntity<?> getMasterAccounts(@PathVariable @Min(1) Integer id){
        Optional<MasterAccount> masterAccount = masterAccountRepository.findById(id);
        return ResponseEntity.ok(masterAccount.orElse(new MasterAccount()));
    }
}
