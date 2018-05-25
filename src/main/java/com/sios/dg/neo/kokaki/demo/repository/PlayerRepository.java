package com.sios.dg.neo.kokaki.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sios.dg.neo.kokaki.demo.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}