package com.techelevator.models.cards;

public abstract class Card implements Valuable
{	
	// private variables
	private final int value;
	private boolean isFaceUp;
	
	// constructors
	protected Card(int value)
	{
		this.value = value;
	}

	//getters
	@Override
	public int getValue()
	{
		return value;
	}

	public void toggleValue() { /* no default implementation for cards with single value */ }

	@Override
	public int getHighestValue()
	{
		return getValue();
	}

	@Override
	public int getLowestValue()
	{
		return getValue();
	}

	@Override
	public boolean hasMultipleValues()
	{
		// by default cards only have 1 value
		return false;
	}

	@Override
	public int[] getPossibleValues()
	{
		return new int[] {getValue()};
	}

	public boolean isFaceUp()
	{
		return isFaceUp;
	}

	public void flip()
	{
		isFaceUp = !isFaceUp;
	}
	
	@Override
	public String toString()
	{
		if(!isFaceUp)
		{
			return "??";
		}
		else 
		{
			return this.getValue() + "";
		}
	}


}
