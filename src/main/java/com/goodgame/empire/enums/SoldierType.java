package com.goodgame.empire.enums;

import com.goodgame.empire.factory.SoldierFactory;
import com.goodgame.empire.model.Archer;
import com.goodgame.empire.model.Healing;
import com.goodgame.empire.model.Soldier;
import com.goodgame.empire.model.Spearman;
import com.goodgame.empire.model.Swordsman;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum SoldierType
{
    SPEARMAN(26, 26, 8, 14, 0, 30, 0, 6)
            {
                @Override
                public Soldier createSoldier()
                {
                    log.info("Spearman created.");
                    return Spearman.builder()
                            .meleeAttackPower(getMeleeAttackPower())
                            .meleeDefensePower(getMeleeDefensePower())
                            .rangedDefensePower(getRangedDefensePower())
                            .lootingCapacity(getLootingCapacity())
                            .recruitmentTPU(getRecruitmentTPU())
                            .recruitmentCost(getRecruitmentCost())
                            .healing(Healing.builder().healingTPU(getHealingTPU()).healingCost(getHealingCost()).build())
                            .build();
                }
            },
    SWORDSMAN(61, 5, 3, 12, 0, 85, 0, 43)
            {
                @Override
                public Soldier createSoldier()
                {
                    log.info("Swordsman created.");
                    return Swordsman.builder()
                            .meleeAttackPower(getMeleeAttackPower())
                            .meleeDefensePower(getMeleeDefensePower())
                            .rangedDefensePower(getRangedDefensePower())
                            .lootingCapacity(getLootingCapacity())
                            .recruitmentTPU(getRecruitmentTPU())
                            .recruitmentCost(getRecruitmentCost())
                            .healing(Healing.builder().healingTPU(getHealingTPU()).healingCost(getHealingCost()).build())
                            .build();
                }
            },
    ARCHER(10, 53, 55, 9, 0, 70, 0, 35)
            {
                @Override
                public Soldier createSoldier()
                {
                    log.info("Archer created.");
                    return Archer.builder()
                            .meleeAttackPower(getMeleeAttackPower())
                            .meleeDefensePower(getMeleeDefensePower())
                            .rangedDefensePower(getRangedDefensePower())
                            .lootingCapacity(getLootingCapacity())
                            .recruitmentTPU(getRecruitmentTPU())
                            .recruitmentCost(getRecruitmentCost())
                            .healing(Healing.builder().healingTPU(getHealingTPU()).healingCost(getHealingCost()).build())
                            .build();
                }
            };

    private final int meleeAttackPower;
    private final int meleeDefensePower;
    private final int rangedDefensePower;
    private final int lootingCapacity;
    private final int recruitmentTPU;
    private final int recruitmentCost;
    private final int healingTPU;
    private final int healingCost;

    public static SoldierType findBy(int ordinal)
    {
        for (SoldierType soldierType : SoldierType.values())
        {
            if (soldierType.ordinal() == ordinal)
            {
                return soldierType;
            }
        }
        log.error("SoldierType not found. Ordinal: {}", ordinal);
        return null;
    }

    public abstract Soldier createSoldier();

    public Soldier getSoldier()
    {
        return SoldierFactory.getSoldier(this);
    }

    SoldierType(int meleeAttackPower, int meleeDefensePower, int rangedDefensePower, int lootingCapacity,
                int recruitmentTPU, int recruitmentCost, int healingTPU, int healingCost)
    {
        this.meleeAttackPower = meleeAttackPower;
        this.meleeDefensePower = meleeDefensePower;
        this.rangedDefensePower = rangedDefensePower;
        this.lootingCapacity = lootingCapacity;
        this.recruitmentTPU = recruitmentTPU;
        this.recruitmentCost = recruitmentCost;
        this.healingTPU = healingTPU;
        this.healingCost = healingCost;
    }
}
