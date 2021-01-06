/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WatchBean;

//import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.EventListenerList;
//import uk.ac.gre.comp1549.DashboardAppMain.dashboard.IView;

/**
 *
 * @author USER
 */
public class WatchBeanView extends JPanel implements IWatchView{

    public static WatchBeanView watchBeanInstance= null;
    
    private int panelLength; // length/width of the bar
    private int panelHeight; // height of the bar
    
    private int panelPadding;
    
    private EventListenerList myListeners ;
    private long hour = 0, minute=0, second = 0;
    private boolean started=false;
     private JTextField txtHourTimeInput=new JTextField("00", 3);
     private JTextField txtMinutesTimeInput=new JTextField("00", 3);
     private JTextField txtSecondsTimeInput=new JTextField("00", 3);
     public JButton btnStart;
     public JButton btnStop;
     public JButton btnResume;
     private JLabel lblTitle;
    // private Calendar c= Calendar.getInstance();
     public Timer t;
    // private DrawWatchPanel panel= new DrawWatchPanel();
//      public WatchBeanView()
//      {
//      this(50, 30, 8);
//      }
     public WatchBeanView(int length, int height, int padding)
     {
         setLayout(new FlowLayout());
         //setPreferredSize(new Dimension(length + (2 * padding), height + (2 * padding)));
//         this.panelLength=length;
//     this.panelHeight=height;
//     this.panelPadding=padding;
       //  add(panel, BorderLayout.CENTER);
         //setLayout(new BorderLayout());
         
        // set the style of the border
        setBorder(new BevelBorder(BevelBorder.LOWERED));
myListeners= new EventListenerList();
        // position the label above the bar 
        lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        this.add(lblTitle, BorderLayout.NORTH);
      //  panel = new DrawWatchPanel();
       // add(panel, BorderLayout.CENTER);
        this.add(new JLabel("Hour:"));
        this.add(txtHourTimeInput);
        this.add(new JLabel("Minutes:"));
        this.add(txtMinutesTimeInput);
        this.add(new JLabel("Seconds:"));
        this.add(txtSecondsTimeInput);
        btnStart= new JButton();
        btnStop= new JButton();
        
         btnStart.setEnabled(true);
         btnStop.setEnabled(true);
        this.add((btnStart=new JButton("Start/Reset")),BorderLayout.SOUTH);
        this.add((btnStop=new JButton("Stop")),BorderLayout.SOUTH);
       // add((btnResume=new JButton("Resume")),BorderLayout.SOUTH);
              
     }
  
      public static synchronized WatchBeanView getInstance()
    {
        if(watchBeanInstance==null){
        
        watchBeanInstance = new WatchBeanView(200,150,8);
        }
    return watchBeanInstance;
    }
     
     public void addWatchListener(WatchListener wl)
     {
     myListeners.add(WatchListener.class, wl);
     }
     
     public void removeWatchListener(WatchListener wl)
     {
      myListeners.remove(WatchListener.class, wl);
     }
//     public long getHour()
//     {
//         
//         hour=Long.parseLong(txtHourTimeInput.getText());
//          long result=0;
//          long  sendHour=c.get(Calendar.HOUR_OF_DAY);;
//                 if(!("00".equals(txtHourTimeInput.getText())))
//                 {
//                     if(hour<sendHour)
//                     {
//                     result= sendHour-hour;
//                     sendHour= sendHour-result;
//                     }
//                     if(hour>sendHour)
//                     {
//                     result=hour-sendHour;
//                     sendHour= sendHour+result;
//                     }                    
//                // sendHour=c.get(Calendar.HOUR_OF_DAY);
//                 }
//               //txtHourTimeInput.getText();
//    
//     return sendHour; }
//         
//      public long getMinute()
//     {
//     minute=Long.parseLong(txtMinutesTimeInput.getText());
//          long result=0;
//          long  sendMinute=c.get(Calendar.MINUTE);;
//                 if(!("00".equals(txtMinutesTimeInput.getText())))
//                 {
//                     if(minute<sendMinute)
//                     {
//                     result= sendMinute-minute;
//                     sendMinute= sendMinute-result;
//                     }
//                     if(minute>sendMinute)
//                     {
//                     result=minute-sendMinute;
//                     sendMinute= sendMinute+result;
//                     }                    
//                // sendHour=c.get(Calendar.HOUR_OF_DAY);
//                 }
//               //txtHourTimeInput.getText();
//    
//     return sendMinute;
//     }
//      
//      public long getSecond()
//      {
//      minute=Long.parseLong(txtMinutesTimeInput.getText());
//          long result=0;
//          long  sendSecond=c.get(Calendar.SECOND);
//                 if(!("00".equals(txtSecondsTimeInput.getText())))
//                 {
//                     if(second<sendSecond)
//                     {
//                     result= sendSecond-second;
//                     sendSecond= sendSecond-result;
//                     }
//                     if(second>sendSecond)
//                     {
//                     result=second-sendSecond;
//                     sendSecond= sendSecond+result;
//                     }                    
//                // sendHour=c.get(Calendar.HOUR_OF_DAY);
//                 }
//               //txtHourTimeInput.getText();
//    
//     return sendSecond;
//      }
//      
//      public boolean isStarted()
//      {
//      
//         return started; 
//      }
     
//     public void setMinute()
//     {
//     
//     }
     
     
     //Call the action listeners to carry out an action
     public void ActivateWatchControls(WatchController wc)
     {
      t = new Timer(1000, (ActionListener) wc);
    // Timer t = new Timer(1000);
   // t.start();
     btnStart.addActionListener((ActionListener) wc);
     btnStop.addActionListener((ActionListener) wc);
    // btnResume.addActionListener((ActionListener) wc);
     
     }
public void setValue(String s)
{
lblTitle.setText(s);
}
public String getValue()
{
return lblTitle.getText();
}

//  @Override 
    public void UpdateClock(long time) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public String getHourInput() {
       
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return txtHourTimeInput.getText();
    }
public void setHourInput(String s)
{
txtHourTimeInput.setText(s);
}
    //@Override
    public String getMinInput() {
     return txtMinutesTimeInput.getText();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setMinInput(String s)
{
txtMinutesTimeInput.setText(s);
}

    //@Override
    public String getSecInput() {
     return txtSecondsTimeInput.getText();  // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public void setSecInput(String s)
{
txtSecondsTimeInput.setText(s);
}
   // @Override
    public EventListenerList getEventlist() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return myListeners;
    }

   // @Override
    public Timer theTimer() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return t;
    }
    
}
