/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIew;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nazil
 */
public class ProgressBar {
    
    public static void main(String[] args) throws InterruptedException {
        GUI_ProgressBar pf= new GUI_ProgressBar();
        GUI_Login lf = new GUI_Login();
        pf.setVisible(true);
        
        for(int i= 1; i<=100; ++i){
            try{
                Thread.sleep(80);
                pf.ProgressBar1.setValue(i);
                
                if(i%2==0){
                    pf.PleaseWait1.setText("Please Wait...");
                }else{
                    pf.PleaseWait1.setText("Please Wait...");
                }
                
                if(i==100){
                    pf.setVisible(false);
                    lf.setVisible(true);
                }
            }catch (InterruptedException ex){
                Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
