package com.yunusKaya.creditManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yunusKaya.creditManagement.model.Credit;
public interface CreditRepository extends JpaRepository<Credit, Long> {

}
