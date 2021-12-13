package com.example.teamsalary.service;

import com.example.teamsalary.model.Player;
import com.example.teamsalary.model.Tier;
import com.example.teamsalary.repository.PlayerRepository;
import com.example.teamsalary.repository.TierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TierRepository tierRepository;

    public void savePlayer(Player player) {
//       bsalaryfee = bsalaryfee(player.getTier());
//        player.setTotal(bsalaryfee);
        player.setDescription(player.getDescription());
        player.setTierId(player.getTierId());
       // player.setTotal(playerRepository.updateFee(player.getTierId()));
       // player.setTotal(playerRepository.updateFee(player.getId()));
        player.setName(player.getName());
        playerRepository.save(player);
    }

//    public void bsalaryfee(Tier tier){
//       tierRepository.findById(tier.getId());
//
//    }


    public List<Player> listAllPlayer() {

        return playerRepository.findAll();
    }

    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);

    }

    public Player getPlayer(Integer id) {

        return playerRepository.findById(id).get();
    }
}
