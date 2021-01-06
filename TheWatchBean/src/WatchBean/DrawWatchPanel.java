/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WatchBean;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class DrawWatchPanel extends JPanel{
     private int panelLength; // length/width of the bar
    private int panelHeight; // height of the bar
    
    private int panelPadding;
    
     public DrawWatchPanel() {
        this(50, 30, 8);
    }
     
     public DrawWatchPanel(int length, int height, int padding)
     {
         setPreferredSize(new Dimension(length + (2 * padding), height + (2 * padding)));
     this.panelLength=length;
     this.panelHeight=height;
     this.panelPadding=padding;
     }
}
