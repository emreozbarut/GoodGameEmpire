package com.goodgame.empire.service;

import com.goodgame.empire.model.response.RandomTroopResponse;

public interface TroopService
{
    RandomTroopResponse getRandomTroop(int troopSize);
}
