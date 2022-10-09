package com.goodgame.empire.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodgame.empire.service.impl.TroopServiceImpl;
import com.goodgame.empire.model.response.RandomTroopResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/troop")
public class TroopController
{
    private final TroopServiceImpl troopService;

    @GetMapping("/random/{size}")
    public ResponseEntity<RandomTroopResponse> getRandomTroop(@PathVariable("size") Integer size)
    {
        return ResponseEntity.ok(troopService.getRandomTroop(size));
    }
}
