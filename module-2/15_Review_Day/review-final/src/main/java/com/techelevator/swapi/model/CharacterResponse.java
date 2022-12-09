package com.techelevator.swapi.model;

public class CharacterResponse
{
    private int count;
    private String next;
    private String previous;
    private Character[] results;

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public String getNext()
    {
        return next;
    }

    public void setNext(String next)
    {
        this.next = next;
    }

    public String getPrevious()
    {
        return previous;
    }

    public void setPrevious(String previous)
    {
        this.previous = previous;
    }

    public Character[] getResults()
    {
        return results;
    }

    public void setResults(Character[] results)
    {
        this.results = results;
    }
}
