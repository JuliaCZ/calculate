package com.example.julia.calculate2;

import java.util.ArrayList;

/**
 * Created by julia on 08.08.2016.
 */
public class ListCollection<T, T1> {
    private ArrayList<Integer> first = new ArrayList<Integer>();
    private ArrayList<Integer> second = new ArrayList<Integer>();
    public ListCollection(){}
    public void Add(int first, int second)
    {
        this.first.add(first);
        this.second.add(second);
    }
    public void Print()
    {
        for(int i = 0; i < first.size(); i++)
        {
            System.out.println(" ( " + first.get(i) + " , " + second.get(i) + " ) ");
        }
    }
    public int getFirst(int i) {
        return first.get(i);
    }
    public void setFirst(int index, int number) {
        this.first.set(index, number);
    }
    public int getSecond(int i) {
        return second.get(i);
    }
    public void setSecond(int index, int number) {
        this.second.set(index, number);
    }
    public int Size()
    {
        return first.size();
    }
    public int SizeAll()
    {
        return first.size() + second.size();
    }
    public ListCollection get(int index)
    {
        ListCollection tmp = new ListCollection();
        tmp.Add(this.getFirst(index), this.getSecond(index));
        return tmp;
    }
    public void Delete(int index)
    {
        this.first.remove(index);
        this.second.remove(index);
    }
    public void DeleteAll()
    {
        this.first.removeAll(first);
        this.second.removeAll(second);
    }
    public int LengthPairs()
    {
        int length = 0;
        length = first.get(0) - second.get(0);
        length += first.get(1) - second.get(1);
        length = Math.abs(length);
        return length;
    }
}
