package com.SpringCP.SpringCP.repository;

import com.SpringCP.SpringCP.model.PrivateKeyCoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends JpaRepository<PrivateKeyCoin,Long> {
    List<PrivateKeyCoin> findByHashTableId(String hashTableId);
}
