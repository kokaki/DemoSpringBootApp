package com.sios.dg.neo.kokaki.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sios.dg.neo.kokaki.demo.domain.Player;
import com.sios.dg.neo.kokaki.demo.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String index(Model model) {
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players);
        return "players/index";
    }

    @GetMapping("new")
    public String newPlayer(Model model) {
        return "players/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Player> player = playerService.findOne(id);
        model.addAttribute("player", player);
        return "players/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Optional<Player> player = playerService.findOne(id);
        model.addAttribute("player", player);
        return "players/show";
    }

    @PostMapping
    public String create(@ModelAttribute Player player) {
        playerService.save(player);
        return "redirect:/players";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Player player) {
        player.setId(id);
        playerService.save(player);
        return "redirect:/players";
    }

    @DeleteMapping("{id}")
    public String destroy(@ModelAttribute Player player) {
        playerService.delete(player);
        return "redirect:/players";
    }
}