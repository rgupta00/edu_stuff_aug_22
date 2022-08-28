package com.bankapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entity.Account;
//:) we just declare dao layer ....
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
