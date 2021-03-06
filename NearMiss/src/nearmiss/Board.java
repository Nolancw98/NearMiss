/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nearmiss;

import java.util.ArrayList;

/**
 *
 * @author: Nolan
 * @assignment: 
 */
public class Board {
    private Object[][] entries;
    public Board()
    {
        entries = new Object[6][4];
    }
    
    public void initBoard()
    {
        entries[0][0] = 5;
        entries[0][1] = "_";
                
        entries[1][0] = 10;
        entries[1][1] = "_";
        
        entries[2][0] = 20;
        entries[2][1] = "_";
        entries[2][2] = "_";
        
        entries[3][0] = 50;
        entries[3][1] = "_";
        entries[3][2] = "_";
        
        entries[4][0] = 100;
        entries[4][1] = "_";
        entries[4][2] = "_";
        
        entries[5][0] = 100;
        entries[5][1] = "_";
        entries[5][2] = "_";
        entries[5][3] = "_";
      
    }
    
    public void placeNumber(int number, int r, int c)
    {
        if(c != 0 && entries[r][c].equals("_"))
        {
            entries[r][c] = number;
        }
    }
    
    public Object[][] getEntries()
    {
        return entries;
    }
    
    public boolean boardFilled()
    {
        String temp = "";
        for(Object[] r : entries)
        {
            for(Object c : r)
            {
                temp += c;
            }
        }
        if(temp.contains("_"))
            return false;
        return true;
    }
    public boolean spaceFilled(int r, int c)
    {
        try
        {
            if(entries[r][c].toString().equals("_"))
                return false;
            return true;
        }
        catch(Exception e)
        {
            return true;
        }
    }
    public int computeScore()
    {
        int score = 0;
        if(boardFilled())
        {
            score += Math.abs(5 - Integer.valueOf(entries[0][1].toString()));
            score += Math.abs(10 - Integer.valueOf(entries[1][1].toString()));
            score += Math.abs(20 - Integer.valueOf(entries[2][1].toString() + entries[2][2].toString()));
            score += Math.abs(50 - Integer.valueOf(entries[3][1].toString() + entries[3][2].toString()));
            score += Math.abs(100 - Integer.valueOf(entries[4][1].toString() + entries[4][2].toString()));
            score += Math.abs(100 - Integer.valueOf(entries[5][1].toString() + entries[5][2].toString() + entries[5][3].toString()));
        }
        return score;
    }
}
