/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIpart;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import CodingPart.Decompress;
import CodingPart.compress;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Rakesh
 */
public class design extends JFrame implements ActionListener {
//    declare buttons which you want to add in GUI
    JButton compressButton;
    JButton decompressButton;
    
    design(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600,300);
        this.getContentPane().setBackground(Color.DARK_GRAY);

        compressButton = new JButton("Select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(35,100,200,30);
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(350,100,200,30);
        
//  add these buttons to GUI
this.add(compressButton);
this.add(decompressButton);
    }
    
    @Override
   public void actionPerformed(ActionEvent e){
       
       if(e.getSource()==compressButton){
           JFileChooser fileChooser = new JFileChooser();
           int response = fileChooser.showSaveDialog(null);
           if(response == JFileChooser.APPROVE_OPTION){
               File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
               try{
                   compress.compressFunction(file);
               }
               catch(Exception excp){
                   JOptionPane.showMessageDialog(null,excp.toString());
               }
           }
       }
        if(e.getSource()==decompressButton){
           JFileChooser fileChooser = new JFileChooser();
           int response = fileChooser.showSaveDialog(null);
           if(response == JFileChooser.APPROVE_OPTION){
               File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
               try{
                   Decompress.DecompressFile(file);
               }
               catch(Exception excp){
                   JOptionPane.showMessageDialog(null,excp.toString());
               }
           }
       }
       
   }
    
    public static void main(String[] args){
        design view = new design();
        view.setVisible(true);
        
    }
}
