package com.sios.dg.neo.kokaki.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sios.dg.neo.kokaki.demo.domain.Player;
import com.sios.dg.neo.kokaki.demo.repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findOne(Long id) {
        return playerRepository.findById(id);
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void delete(Player player) {
        playerRepository.delete(player);
    }
}