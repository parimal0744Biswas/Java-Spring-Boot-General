package com.parimal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parimal.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer>
{

}
