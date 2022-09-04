package com.bankapp.repo;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entity.TransactionHistory;

@Repository
public interface TransactionHistoryRepo extends JpaRepository<TransactionHistory, Integer> {

}
