package com.example.teamsalary.repository;

import com.example.teamsalary.model.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TierRepository extends JpaRepository<Tier, Integer> {
    @Query(value = " SELECT bsalary FROM tier t WHERE t.id",nativeQuery = true)
    List<Object[]> findById(int id);


}
