package com.goodgame.empire.factory;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import com.goodgame.empire.model.Soldier;
import com.goodgame.empire.enums.SoldierType;

public final class SoldierFactory
{
    private SoldierFactory()
    {
    }

    static Map<SoldierType, Soldier> soldierTypes = new ConcurrentHashMap<>();

    public static Soldier getSoldier(SoldierType soldierType)
    {
        Soldier soldier = soldierTypes.get(soldierType);
        if (Objects.isNull(soldier))
        {
            soldier = soldierType.createSoldier();
            soldierTypes.put(soldierType, soldier);
        }
        return soldier;
    }
}
