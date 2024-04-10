package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Bank1;
@Repository
public interface BankRepo extends JpaRepository<Bank1, String> {

}
