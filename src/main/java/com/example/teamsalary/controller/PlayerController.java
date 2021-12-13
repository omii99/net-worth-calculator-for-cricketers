package com.example.teamsalary.controller;

import com.example.teamsalary.exception.ResourceNotFoundException;
import com.example.teamsalary.model.Player;
import com.example.teamsalary.repository.PlayerRepository;
import com.example.teamsalary.response.SuccessResponse;
import com.example.teamsalary.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("player")
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerService playerService;

    //list of the Players
    @GetMapping("/all")
    @Transactional(readOnly = true)
  //  @PreAuthorize("hasAuthority('PLAYER_READ')")
    public ResponseEntity<List> ListAllPlayers(){

        playerService.listAllPlayer();
        List<Player>players= playerService.listAllPlayer();
        return new ResponseEntity(new SuccessResponse(200,players,"Success"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @Transactional
   // @PreAuthorize("hasAuthority('PLAYER_UPDATE')")
    public ResponseEntity<?> update(@RequestBody Player playerDetails, @PathVariable Integer id)
            throws ResourceNotFoundException {

        Player player =
                playerRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("player not found on :: " + id));

//        if (playerDetails.getPos() == 0) {
//            player.setPos(player.getPos());
//
//        } else {
//            player.setPos(playerDetails.getPos());
//            player.setAdditional(playerRepository.updatePOS(id));
//
//        }

        if (playerDetails.getPom() == 1 && playerDetails.getPos()==0) {
            player.setPom(playerDetails.getPom());
            playerDetails.setAdditional(playerRepository.updatePOM(id));
            //System.out.println(playerRepository.updatePOM(id));
            playerRepository.save(player);

        }
        else if(playerDetails.getPom() == 0 && playerDetails.getPos()==1){

            player.setPos(playerDetails.getPos());
            playerDetails.setAdditional(playerRepository.updatePOS(id));
            playerRepository.save(player);
        }
        else if(playerDetails.getPom()==1 && playerDetails.getPos()==1){
            if(playerRepository.findCategory(player.getTierId()) == 1){
                if(playerDetails.getAdditional() <= 150000  ) {
                    player.setPom(playerDetails.getPom());
                    player.setPos(playerDetails.getPos());
                    playerDetails.setAdditional(playerRepository.updateSuperAdditional(id));
                    playerRepository.save(player);

                }
                else
                {
                    player.setPom(playerDetails.getPom());
                    player.setPos(playerDetails.getPos());
                    playerDetails.setAdditional(150000);
                    playerRepository.save(player);
                }
            }
            if(playerRepository.findCategory(player.getTierId()) == 2){
                if(playerDetails.getAdditional() <= 97500  ) {
                    player.setPom(playerDetails.getPom());
                    player.setPos(playerDetails.getPos());
                    playerDetails.setAdditional(playerRepository.updateSuperAdditional(id));
                    playerRepository.save(player);
                }
                else
                {
                    playerDetails.setAdditional(97500);
                    player.setPom(playerDetails.getPom());
                    player.setPos(playerDetails.getPos());
                    playerRepository.save(player);
                }
            }
            if(playerRepository.findCategory(player.getTierId()) == 3){
                if(playerDetails.getAdditional() <= 75000  ) {
                    player.setPom(playerDetails.getPom());
                    player.setPos(playerDetails.getPos());
                    playerDetails.setAdditional(playerRepository.updateSuperAdditional(id));
                    playerRepository.save(player);
                }
                else
                {
                    playerDetails.setAdditional(75000);
                    player.setPom(playerDetails.getPom());
                    player.setPos(playerDetails.getPos());
                    playerRepository.save(player);
                }
            }
            if(playerRepository.findCategory(player.getTierId()) == 4){
                if(playerDetails.getAdditional() <= 52500  ) {
                    player.setPom(playerDetails.getPom());
                    player.setPos(playerDetails.getPos());
                    playerDetails.setAdditional(playerRepository.updateSuperAdditional(id));
                    playerRepository.save(player);
                }
                else
                {
                    playerDetails.setAdditional(52500);
                    player.setPom(playerDetails.getPom());
                    player.setPos(playerDetails.getPos());
                    playerRepository.save(player);
                }
            }
        }
        else {
            player.setPos(playerDetails.getPos());
            player.setPom(playerDetails.getPom());
        }


//        if (playerDetails.getPos() == 1) {
//
//
//            player.setPos(playerDetails.getPos());
//            player.setPosfee(playerRepository.updatePOS(id));
//            playerRepository.save(player);
//           // System.out.println(playerRepository.updatePOM(id));
//
//        }
//
//        if (playerDetails.getPom() == 1 && playerDetails.getPos()==1){
//                    if(playerDetails.getTierId() ==1){
//                        playerDetails.setPomfee(player.getPospomfee());
//                    }
//                }

        if (playerDetails.getWinstatus() == 1) {
            player.setWinstatus(playerDetails.getWinstatus());
            int x = (int) ((3000000 * 0.7)/15);
            player.setTropyprice(x);
        }
        else if(playerDetails.getWinstatus() == 2) {
            player.setWinstatus(playerDetails.getWinstatus());
            int x = (int) ((2400000 * 0.5)/15);
            player.setTropyprice(x);
        }
        else{
            player.setWinstatus(player.getWinstatus());
            player.setTropyprice(player.getTropyprice());

        }




        if (playerDetails.getName() == null) {
            player.setName(player.getName());
        } else {
            player.setName(playerDetails.getName());

        }


        if (playerDetails.getDescription() == null) {
            player.setDescription(player.getDescription());
        } else {
            player.setDescription(playerDetails.getDescription());

        }



        if (playerDetails.getTierId() ==0 ) {
            player.setTierId(player.getTierId());
        } else {
            player.setTierId(playerDetails.getTierId());

            playerRepository.save(player);

            }






        playerDetails.setTotal(playerRepository.updateFee(id));
      //  customer.setUpdated_at(customerDetail.getUpdated_at());
        final Player updatedPlayer = playerRepository.save(player);

        return new ResponseEntity(new SuccessResponse(200, null, "Success"), HttpStatus.OK);
    }

    @Transactional
 //   @PreAuthorize("hasAuthority('PLAYER_CREATE')")
    @PostMapping("/create")
    public ResponseEntity<String> add(@RequestBody Player player) {
        player.setTotal(10000);
        playerService.savePlayer(player);
        return new ResponseEntity(new SuccessResponse(200, null, "Success"), HttpStatus.OK);
    }

    //find by Id
    @GetMapping("/list/{id}")
    public ResponseEntity<Player> get (@PathVariable Integer id){
        try {
            Player player = playerService.getPlayer(id);

            return new ResponseEntity(new SuccessResponse(200, player, "Success"), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }

    }
}
