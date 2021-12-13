package com.example.teamsalary.repository;

import com.example.teamsalary.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

//    @Query(value = " SELECT bsalary FROM tier t WHERE t.id",nativeQuery = true)
//    List<Object[]> findById(int id);

//    @Modifying
//    @Query("update player p set p.totalfee = t where u.lastLoginDate < :date")
//    void updatetotalfee(@Param("date") LocalDate date);

    @Transactional
    @Modifying
    @Query(value="UPDATE player INNER JOIN tier ON player.tier_id = tier.id SET player.totalfee =((tier.bsalary) + (player.additional) + (player.tropy_price)) WHERE player.id=?1",nativeQuery = true)
    int updateFee(int id);


   // @Query(value = "update player p set p.additional = (p.totalfee * 0.1) where  p.id=?1 ",nativeQuery = true)
   @Transactional
   @Modifying
@Query(value = "UPDATE player p  INNER JOIN tier t ON p.tier_id=t.id SET p.additional=((t.bsalary) * (0.1)) WHERE p.id=?1  ",nativeQuery = true)
    int updatePOM(int id);

@Transactional
    @Modifying
    @Query(value = "UPDATE player p  INNER JOIN tier t ON p.tier_id=t.id SET p.additional=((t.bsalary) * (0.25)) WHERE p.id=?1 ",nativeQuery = true)
    int updatePOS(int num);

    @Query(value = " SELECT category_id FROM tier t WHERE t.id=?1",nativeQuery = true)
    int findCategory(int id);

    @Transactional
    @Modifying
    @Query(value = " UPDATE player p  INNER JOIN tier t ON p.tier_id=t.id SET p.additional=(((t.bsalary) * (0.25)) + ((t.bsalary) * (0.1)) + (t.bsalary))  WHERE p.id=?1",nativeQuery = true)
    int updateSuperAdditional(int id);

}
