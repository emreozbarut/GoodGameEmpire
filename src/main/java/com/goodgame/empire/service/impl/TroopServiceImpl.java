package com.goodgame.empire.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.goodgame.empire.enums.SoldierType;
import com.goodgame.empire.model.Troop;
import com.goodgame.empire.model.response.RandomTroopResponse;
import com.goodgame.empire.service.TroopService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TroopServiceImpl implements TroopService
{
    private static final Random random = new Random();
    private static final int NUMBER_OF_DRAWS = SoldierType.values().length;
    private static final Map<Integer, SoldierType> randomSoldierCounts = new ConcurrentHashMap<>();
    private static final List<Troop> troops = new ArrayList<>();
    private static final int[] numbers = new int[NUMBER_OF_DRAWS];
    private static final int MINIMUM = 1;
    public static final int SCALE = 2;

    @Override
    public RandomTroopResponse getRandomTroop(int troopSize)
    {
        if (randomSoldierCounts.keySet().size() >= NUMBER_OF_DRAWS * (((troopSize - MINIMUM) * troopSize) / SCALE) - (troopSize - MINIMUM))
        {
            randomSoldierCounts.clear();
        }

        //Generate random size of troops
        randomNumberGenerator(troopSize);
        
        if (randomSoldierCounts.isEmpty())
        {
            putRandomNumbersToMap();
            return createRandomTroopResponse();
        }

        while (validateRandomNumbers())
        {
            randomNumberGenerator(troopSize);
        }

        putRandomNumbersToMap();
        return createRandomTroopResponse();
    }

    private RandomTroopResponse createRandomTroopResponse()
    {
        troops.clear();
        for (int i = 0; i < numbers.length; i++)
        {
            troops.add(Troop.builder()
                    .troopSize(numbers[i])
                    .soldier(Objects.requireNonNull(SoldierType.findBy(i)).getSoldier())
                    .build());
        }
        return RandomTroopResponse.builder().troops(troops).build();
    }

    private boolean validateRandomNumbers()
    {
        boolean isNotUnique = false;
        for (int i = 0; i < numbers.length; i++)
        {
            if (Objects.nonNull(randomSoldierCounts.get(numbers[i]))
                    && Objects.requireNonNull(SoldierType.findBy(i)).name().equals(randomSoldierCounts.get(numbers[i]).name()))
            {
                isNotUnique = true;
                log.info("Random number is retrieved before. Number: {}, SoldierType: {}", numbers[i], randomSoldierCounts.get(numbers[i]).name());
                break;
            }
        }
        return isNotUnique;
    }

    private void putRandomNumbersToMap()
    {
        for (int i = 0; i < numbers.length; i++)
        {
            randomSoldierCounts.put(numbers[i], SoldierType.findBy(i));
        }
    }

    private static void randomNumberGenerator(int finalSum)
    {
        int sum = 0;
        for (int i = 0; i < NUMBER_OF_DRAWS - MINIMUM; i++)
        {
            numbers[i] = random.nextInt((finalSum - sum) / SCALE) + MINIMUM;
            sum += numbers[i];
        }
        numbers[NUMBER_OF_DRAWS - MINIMUM] = finalSum - sum;
        log.info("Random numbers generated: {}", Arrays.toString(numbers));
    }
}
