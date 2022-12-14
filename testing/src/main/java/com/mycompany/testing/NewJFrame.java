/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.testing;

import java.awt.Color;
import java.io.File;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;



/**
 *
 * @author PC
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */   
    private String roundString ="";
    private int round = 0;
    private String scoreString = "";
    private int day, month,year; //used for clock
    private int hour, minute, second; //used for clock
    private String daystr,timestr; //usedf for jlabel and clock
    private int score =0;
    private int[] newButtons = new int[5];
    private int buttonCounter = 5;
    private String answer ="";
    private String button1 = "";
    private String button2 = "";
    private String button3 = "";
    private String button4 = "";
    private String button5 = "";
    private String button6 = "";
    private String button7 = "";
    private String button8 = "";
    private String button9 = "";
    private String button10 = "";
    private String button11 = "";
    private String button12 = "";
    private String button13 = "";
    private String button14 = "";
    private String button15 = "";
    private String button16 = "";
  
     
    public NewJFrame() {
        initComponents();      
        this.setBounds(0, 0, 610, 435); //setting the bound
        this.setLocationRelativeTo(null); //setting the screen to center
        textLabel();
        newButtons = randomButton();                  
        colorController(newButtons);     
        currentTime(); //calling clokc function
        read("current_score.txt");
        System.out.println(score);
        read_roundCounter("round_counter.txt");
        System.out.println(round);
        
        if(round ==0)
        {
            this.setVisible(false);
            this.dispose();
            new Score().setVisible(true);            
        }
        
    }
    
    public void read(String filename)
    {
       try {
            FileReader reader = new FileReader(filename);
            int character;
 
            while ((character = reader.read()) != -1) {                   
                scoreString += (char)character;
            }
            score = Integer.parseInt(scoreString);
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void read_roundCounter(String filename)
    {
       try {
            FileReader reader = new FileReader(filename);
            int character;
 
            while ((character = reader.read()) != -1) {                   
                roundString += (char)character;
            }
            round = Integer.parseInt(roundString);
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    // method: write
    // purpose: this method is to write to the score information to file named "current_socre.txt
    public void write_roundCounter(String current_round)
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
    
    
    // method: write
    // purpose: this method is to write to the score information to file named "current_socre.txt
    public void write(String current_score)
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
            writer.write(current_score);           
            writer.close();
        } 
    catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    
    // method: currentTime
    // purpose: this method uses the Calendar and SimplDataFormat class to present correct local time on the screen
    public void currentTime(){
        
        Thread clock = new Thread(){
                public void run(){
                    while(true)
                {
                    try{
                        Calendar c = Calendar.getInstance();
                        minute = c.get(Calendar.MINUTE);
                        second = c.get(Calendar.SECOND);
                        hour = c.get(Calendar.HOUR);
                        if(hour>12)
                        {
                            hour = hour - 12;
                        }
                        day = c.get(Calendar.DAY_OF_MONTH);
                        month = c.get(Calendar.MONTH);
                        year = c.get(Calendar.YEAR);
                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                        Date dat = c.getTime();
                        timestr = sdf.format(dat);
                        daystr = sd.format(dat);
                        jLabel3.setText(timestr);
                        jLabel2.setText(daystr);
                        
                    }catch(Exception e){
                        
                    }
                }
                        }
           };
            clock.start();
    }
    
    
    
  
   
    //method to control jlabel text
    public void textLabel()
    {
        String[] color_list = {"Green", "Yellow", "Red","Blue", "Purple"};
        Random rand = new Random(); //random function is used to choose one of five words      
        int random1 = rand.nextInt(5);
        int random2 = rand.nextInt(5);
        if(random1 ==0)           
        {
            jLabel1.setText(color_list[0]);
            answer = color_list[0];
            if(random2 ==0)
            {               
                jLabel1.setForeground(Color.red);
            }
            else  if(random2 ==1)
            {
                jLabel1.setForeground(Color.blue);
            }
            else if(random2 ==2)
            {
                jLabel1.setForeground(Color.yellow);
            }
             else if(random2 ==3)
            {
                jLabel1.setForeground(Color.green);
            }
             else if(random2 ==4)
            {
                jLabel1.setForeground(Color.magenta);
            }
        }
        else if(random1 ==1)           
        {
            jLabel1.setText(color_list[1]);
            answer = color_list[1];
               if(random2 ==0)
            {               
                jLabel1.setForeground(Color.red);
            }
            else  if(random2 ==1)
            {
                jLabel1.setForeground(Color.blue);
            }
            else if(random2 ==2)
            {
                jLabel1.setForeground(Color.yellow);
            }
             else if(random2 ==3)
            {
                jLabel1.setForeground(Color.green);
            }
             else if(random2 ==4)
            {
                jLabel1.setForeground(Color.magenta);
            }
        }
         else if(random1 ==2)           
        {
            jLabel1.setText(color_list[2]);
            answer = color_list[2];
              if(random2 ==0)
            {               
                jLabel1.setForeground(Color.red);
            }
            else  if(random2 ==1)
            {
                jLabel1.setForeground(Color.blue);
            }
            else if(random2 ==2)
            {
                jLabel1.setForeground(Color.yellow);
            }
             else if(random2 ==3)
            {
                jLabel1.setForeground(Color.green);
            }
             else if(random2 ==4)
            {
                jLabel1.setForeground(Color.magenta);
            }
        }
         else if(random1 ==3)           
        {
            jLabel1.setText(color_list[3]);
            answer = color_list[3];
               if(random2 ==0)
            {               
                jLabel1.setForeground(Color.red);
            }
            else  if(random2 ==1)
            {
                jLabel1.setForeground(Color.blue);
            }
            else if(random2 ==2)
            {
                jLabel1.setForeground(Color.yellow);
            }
             else if(random2 ==3)
            {
                jLabel1.setForeground(Color.green);
            }
             else if(random2 ==4)
            {
                jLabel1.setForeground(Color.magenta);
            }
        }
         else if(random1 ==4)           
        {
            jLabel1.setText(color_list[4]);
            answer = color_list[4];
               if(random2 ==0)
            {               
                jLabel1.setForeground(Color.red);
            }
            else  if(random2 ==1)
            {
                jLabel1.setForeground(Color.blue);
            }
            else if(random2 ==2)
            {
                jLabel1.setForeground(Color.yellow);
            }
             else if(random2 ==3)
            {
                jLabel1.setForeground(Color.green);
            }
             else if(random2 ==4)
            {
                jLabel1.setForeground(Color.magenta);
            }
        }
    }
    
    //method to show 5 random buttons by changing setVisible() to true
    //method to set random color to 5 random buttons
    public void colorController(int[] newButtons)
    {
        //red -0
        //blue -1
        //purple-2 - magenta
        //green -3
        //yellow -4
         for (int i = 0; i < newButtons.length; i++)
         {            
             if(newButtons[i]==0)
             {
                 jButton1.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton1.setBackground(Color.yellow);
                         button1 = "Yellow";
                         break;
                     case 3:
                         jButton1.setBackground(Color.green);
                         button1 = "Green";
                         break;
                     case 2:
                         jButton1.setBackground(Color.magenta);
                         button1 = "Purple";
                         break;
                     case 1:
                         jButton1.setBackground(Color.blue);
                         button1 = "Blue";
                         break;
                     case 0:
                         jButton1.setBackground(Color.red);
                         button1 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==1)
             {
                 jButton2.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton2.setBackground(Color.yellow);  
                         button2 = "Yellow";
                         break;
                     case 3:
                         jButton2.setBackground(Color.green);
                         button2 = "Green";
                         break;
                     case 2:
                         jButton2.setBackground(Color.magenta);
                         button2 = "Purple";
                         break;
                     case 1:
                         jButton2.setBackground(Color.blue);
                         button2 = "Blue";
                         break;
                     case 0:
                         jButton2.setBackground(Color.red);
                         button2 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==2)
             {
                 jButton3.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton3.setBackground(Color.yellow);   
                         button3 = "Yellow";
                         break;
                     case 3:
                         jButton3.setBackground(Color.green);
                         button3 = "Green";
                         break;
                     case 2:
                         jButton3.setBackground(Color.magenta);
                         button3 = "Purple";
                         break;
                     case 1:
                         jButton3.setBackground(Color.blue);
                         button3 = "Blue";
                         break;
                     case 0:
                         jButton3.setBackground(Color.red);
                         button3 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==3)
             {
                 jButton4.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton4.setBackground(Color.yellow);     
                         button4 = "Yellow";
                         break;
                     case 3:
                         jButton4.setBackground(Color.green);
                         button4 = "Green";
                         break;
                     case 2:
                         jButton4.setBackground(Color.magenta);
                         button4 = "Purple";
                         break;
                     case 1:
                         jButton4.setBackground(Color.blue);
                         button4 = "Blue";
                         break;
                     case 0:
                         jButton4.setBackground(Color.red);
                         button4 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==4)
             {
                 jButton5.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton5.setBackground(Color.yellow);  
                         button5 = "Yellow";
                         break;
                     case 3:
                         jButton5.setBackground(Color.green);
                         button5 = "Green";
                         break;
                     case 2:
                         jButton5.setBackground(Color.magenta);
                         button5 = "Purple";
                         break;
                     case 1:
                         jButton5.setBackground(Color.blue);
                         button5 = "Blue";
                         break;
                     case 0:
                         jButton5.setBackground(Color.red);
                         button5 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==5)
             {
                 jButton6.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton6.setBackground(Color.yellow);         
                         button6 = "Yellow";
                         break;
                     case 3:
                         jButton6.setBackground(Color.green);
                         button6 = "Green";
                         break;
                     case 2:
                         jButton6.setBackground(Color.magenta);
                         button6 = "Purple";
                         break;
                     case 1:
                         jButton6.setBackground(Color.blue);
                         button6 = "Blue";
                         break;
                     case 0:
                         jButton6.setBackground(Color.red);
                         button6 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==6)
             {
                 jButton7.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton7.setBackground(Color.yellow);    
                         button7 = "Yellow";
                         break;
                     case 3:
                         jButton7.setBackground(Color.green);
                         button7 = "Green";
                         break;
                     case 2:
                         jButton7.setBackground(Color.magenta);
                         button7 = "Purple";
                         break;
                     case 1:
                         jButton7.setBackground(Color.blue);
                         button7 = "Blue";
                         break;
                     case 0:
                         jButton7.setBackground(Color.red);
                         button7 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==7)
             {
                 jButton8.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton8.setBackground(Color.yellow);     
                         button8 = "Yellow";
                         break;
                     case 3:
                         jButton8.setBackground(Color.green);
                         button8 = "Green";
                         break;
                     case 2:
                         jButton8.setBackground(Color.magenta);
                         button8 = "Purple";
                         break;
                     case 1:
                         jButton8.setBackground(Color.blue);
                         button8 = "Blue";
                         break;
                     case 0:
                         jButton8.setBackground(Color.red);
                         button8 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==8)
             {
                 jButton9.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton9.setBackground(Color.yellow); 
                         button9 = "Yellow";
                         break;
                     case 3:
                         jButton9.setBackground(Color.green);
                         button9 = "Green";
                         break;
                     case 2:
                         jButton9.setBackground(Color.magenta);
                         button9 = "Purple";
                         break;
                     case 1:
                         jButton9.setBackground(Color.blue);
                         button9 = "Blue";
                         break;
                     case 0:
                         jButton9.setBackground(Color.red);
                         button9 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==9)
             {
                 jButton10.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton10.setBackground(Color.yellow);     
                         button10 = "Yellow";
                         break;
                     case 3:
                         jButton10.setBackground(Color.green);
                         button10 = "Green";
                         break;
                     case 2:
                         jButton10.setBackground(Color.magenta);
                         button10 = "Purple";
                         break;
                     case 1:
                         jButton10.setBackground(Color.blue);
                         button10 = "Blue";
                         break;
                     case 0:
                         jButton10.setBackground(Color.red);
                         button10 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==10)
             {
                 jButton11.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton11.setBackground(Color.yellow);  
                         button11 = "Yellow";
                         break;
                     case 3:
                         jButton11.setBackground(Color.green);
                         button11 = "Green";
                         break;
                     case 2:
                         jButton11.setBackground(Color.magenta);
                         button11 = "Purple";
                         break;
                     case 1:
                         jButton11.setBackground(Color.blue);
                         button11 = "Blue";
                         break;
                     case 0:
                         jButton11.setBackground(Color.red);
                         button11 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==11)
             {
                 jButton12.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton12.setBackground(Color.yellow); 
                         button12 = "Yellow";
                         break;
                     case 3:
                         jButton12.setBackground(Color.green);
                         button12 = "Green";
                         break;
                     case 2:
                         jButton12.setBackground(Color.magenta);
                         button12 = "Purple";
                         break;
                     case 1:
                         jButton12.setBackground(Color.blue);
                         button12 = "Blue";
                         break;
                     case 0:
                         jButton12.setBackground(Color.red);
                         button12 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==12)
             {
                 jButton13.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton13.setBackground(Color.yellow);      
                         button13 = "Yellow";
                         break;
                     case 3:
                         jButton13.setBackground(Color.green);
                         button13 = "Green";
                         break;
                     case 2:
                         jButton13.setBackground(Color.magenta);
                         button13 = "Purple";
                         break;
                     case 1:
                         jButton13.setBackground(Color.blue);
                         button13 = "Blue";
                         break;
                     case 0:
                         jButton13.setBackground(Color.red);
                         button13 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==13)
             {
                 jButton14.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton14.setBackground(Color.yellow);   
                         button14 = "Yellow";
                         break;
                     case 3:
                         jButton14.setBackground(Color.green);
                         button14 = "Green";
                         break;
                     case 2:
                         jButton14.setBackground(Color.magenta);
                         button14 = "Purple";
                         break;
                     case 1:
                         jButton14.setBackground(Color.blue);
                         button14 = "Blue";
                         break;
                     case 0:
                         jButton14.setBackground(Color.red);
                         button14 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             else if(newButtons[i]==14)
             {
                 jButton15.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton15.setBackground(Color.yellow);   
                         button15 = "Yellow";
                         break;
                     case 3:
                         jButton15.setBackground(Color.green);
                         button15 = "Green";
                         break;
                     case 2:
                         jButton15.setBackground(Color.magenta);
                         button15 = "Purple";
                         break;
                     case 1:
                         jButton15.setBackground(Color.blue);
                         button15 = "Blue";
                         break;
                     case 0:
                         jButton15.setBackground(Color.red);
                         button15 = "Red";
                         break;
                     default:
                         break;
                 }
                 
             }
             else if(newButtons[i]==15)
             {
                 jButton16.setVisible(true);
                 buttonCounter--;
                 switch (buttonCounter) {
                     case 4:
                         jButton16.setBackground(Color.yellow); 
                         button16 = "Yellow";
                         break;
                     case 3:
                         jButton16.setBackground(Color.green);
                         button16 = "Green";
                         break;
                     case 2:
                         jButton16.setBackground(Color.magenta);
                         button16 = "Purple";
                         break;
                     case 1:
                         jButton16.setBackground(Color.blue);
                         button16 = "Blue";
                         break;
                     case 0:
                         jButton16.setBackground(Color.red);
                         button16 = "Red";
                         break;
                     default:
                         break;
                 }
             }
             
             
         }
    }
    
      
           
    //method to chosee 5 random buttons out of 16 buttons available
    public int[] randomButton()
    {
        int [] buttons = new int[16];
        int [] newButtons = new int[5];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = i;      
        }
        
        Random rand = new Random();
        
       for (int i = 0; i < buttons.length; i++) {
			int randomIndexToSwap = rand.nextInt(buttons.length);
			int temp = buttons[randomIndexToSwap];
			buttons[randomIndexToSwap] = buttons[i];
			buttons[i] = temp;
		}
       
       for (int i = 0; i < newButtons.length; i++) {
            newButtons[i] = buttons[i];      
        }        
       
       return newButtons;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13);
        jButton13.setBounds(10, 320, 130, 60);
        jButton13.setVisible(false);

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(10, 160, 130, 60);
        jButton5.setVisible(false);

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(10, 240, 130, 60);
        jButton9.setVisible(false);

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(160, 160, 130, 60);
        jButton6.setVisible(false);

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(310, 160, 130, 60);
        jButton7.setVisible(false);

        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 80, 130, 60);
        jButton1.setVisible(false);

        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14);
        jButton14.setBounds(160, 320, 130, 60);
        jButton14.setVisible(false);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(160, 80, 130, 60);
        jButton2.setVisible(false);

        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12);
        jButton12.setBounds(460, 240, 130, 60);
        jButton12.setVisible(false);

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(310, 80, 130, 60);
        jButton3.setVisible(false);

        jButton10.setToolTipText("");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(160, 240, 130, 60);
        jButton10.setVisible(false);

        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(310, 240, 130, 60);
        jButton11.setVisible(false);

        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15);
        jButton15.setBounds(310, 320, 130, 60);
        jButton15.setVisible(false);

        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16);
        jButton16.setBounds(460, 320, 130, 60);
        jButton16.setVisible(false);

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(460, 160, 130, 60);
        jButton8.setVisible(false);

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(460, 80, 130, 60);
        jButton4.setVisible(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("?????? ??????", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(230, 20, 120, 40);

        jLabel2.setFont(new java.awt.Font("??????", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(340, 20, 110, 30);

        jLabel3.setFont(new java.awt.Font("??????", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(460, 20, 140, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);       
        write_roundCounter(roundString);
        if(answer.equals(button1))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);          
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button2))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button3))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button4))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button5))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button6))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button7))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button8))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button9))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button10))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button11))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button12))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button13))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button14))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button15))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        round--;
        roundString = Integer.toString(round);
        write_roundCounter(roundString);
        if(answer.equals(button16))
        {
           new Win().setVisible(true);
           this.setVisible(false);
           score += 100;
           scoreString = Integer.toString(score);
           write(scoreString);
        }
        else
        {
           new lose().setVisible(true);
           this.setVisible(false);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setBackground(Color.lightGray);
        
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        if(button1 == "Red")
        {
            jButton1.setBackground(Color.red);
        }
        else if(button1 == "Yellow")
        {
            jButton1.setBackground(Color.yellow);
        }
        else if(button1 == "Purple")
        {
            jButton1.setBackground(Color.magenta);
        }
        else if(button1 == "Green")
        {
            jButton1.setBackground(Color.green);
        }
        if(button1 == "Blue")
        {
            jButton1.setBackground(Color.blue);
        }      
    }//GEN-LAST:event_jButton1MouseExited

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
