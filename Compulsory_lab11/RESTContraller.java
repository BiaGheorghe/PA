package com.example.demo1.resource;

import com.example.demo1.model.Player;
import com.example.demo1.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value="/rest/players")
public class RESTContraller {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value="/all")
    public List<Player> getAll(){
        System.out.println(usersRepository.findAll());
        return usersRepository.findAll();
    }

    @PostMapping(value="/add")
    public Player addPlayer(@RequestBody final Player users){
        return usersRepository.save(users);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") int id){
        for(Player player:usersRepository.findAllById(Collections.singleton(id))) {
            System.out.println(player);
            usersRepository.delete(player);

        }

    }

    @PutMapping(path="{id}")
    public Player updatePlayer(@RequestBody Player newPlayer, @PathVariable int id) {

        return usersRepository.findById(id)
                .map(player -> {
                    player.setName(newPlayer.getName());
                    player.setCountry(newPlayer.getCountry());
                    return usersRepository.save(player);
                })
                .orElseGet(() -> {
                    newPlayer.setId(id);
                    return usersRepository.save(newPlayer);
                });
    }

    @GetMapping(path = "{id}")
    public List<Player> selectPlayerById(@PathVariable int id) {
        return usersRepository.findAllById(Collections.singleton(id));

    }
}
