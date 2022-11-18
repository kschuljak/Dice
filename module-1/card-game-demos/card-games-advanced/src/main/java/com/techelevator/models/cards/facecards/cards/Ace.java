package com.techelevator.models.cards.facecards.cards;

import com.techelevator.models.cards.facecards.FaceCard;

import java.util.LinkedList;
import java.util.Queue;

public class Ace extends FaceCard
{
    // use queue to cycle through possible values
    private Queue<Integer> values = new LinkedList<>();

    public Ace(String suit)
    {
        super(suit, 11, "A");

        values.offer(11);
        values.offer(1);
    }

    public int defaultValue()
    {
        return super.getValue();
    }

    @Override
    public int getValue()
    {
        return values.peek();
    }

    @Override
    public int getHighestValue()
    {
        return values.stream()
                     .max(Integer::compare)
                     .get();
    }

    @Override
    public int getLowestValue()
    {
        return values.stream()
                     .min(Integer::compare)
                     .get();
    }

    @Override
    public boolean hasMultipleValues()
    {
        return true;
    }

    @Override
    public int[] getPossibleValues()
    {
        int[] values = new int[this.values.size()];
        int i = 0;

        for (int value : this.values)
        {
            values[i] = value;
            i++;
        }

        return values;
    }

    @Override
    public void toggleValue()
    {
        // cycle to next value
        Integer value = values.remove();
        values.offer(value);
    }
}
