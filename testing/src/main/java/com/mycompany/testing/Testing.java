/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.testing;

/**
 *
 * @author PC
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Testing {
    
    public static void write_roundCounter(String current_round)
    {
        try  
    {         
        File f= new File("round_counter.txt");  //file to be delete  
        if(f.delete())                      //returns Boolean value  
        {  
            System.out.println(f.getName() + " deleted");   //getting and printing the file name  
        }  
        else  
        {  
            System.out.println("failed");  
        }  
    }  
    catch(Exception e)  
    {  
        e.printStackTrace();  
    }  
        
    try {
            FileWriter writer = new FileWriter("round_counter.txt", true);
            writer.write(current_round);           
            writer.close();
        } 
    catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void write_score(String score)
    {
        try  
    {         
        File f= new File("current_score.txt");  //file to be delete  
        if(f.delete())                      //returns Boolean value  
        {  
            System.out.println(f.getName() + " deleted");   //getting and printing the file name  
        }  
        else  
        {  
            System.out.println("failed");  
        }  
    }  
    catch(Exception e)  
    {  
        e.printStackTrace();  
    }  
        
    try {
            FileWriter writer = new FileWriter("current_score.txt", true);
            writer.write(score);           
            writer.close();
        } 
    catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NewJFrame new1 = new NewJFrame();
        new1.setVisible(true);
        
        System.out.println("program running");
        write_roundCounter("5");
        write_score("0");
    }
}
