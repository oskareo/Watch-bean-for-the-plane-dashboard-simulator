/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WatchBean;
import java.util.Calendar;
import javax.swing.*;
import java.util.Calendar;
import java.util.List;
import javax.swing.event.EventListenerList;

/**
 *
 * @author USER
 */
public class WatchActions {
    
   
     private long  sendHour;
     private long sendMinute;
     private long sendSecond;
     private boolean started=false;
     List<IWatchView> wbview;
    // EventListenerList myEList;
     
    public WatchActions(List<IWatchView> wbv)
    {
    wbview=wbv;
    
    }
//    public void getHourInput()
//    {
//       
//    sendHour=c.get(Calendar.HOUR_OF_DAY);
//    }
//    public void getMinuteInput()
//    {
//       
//    sendMinute=c.get(Calendar.MINUTE);
//    }
//    public void getSecondInput()
//    {
//    sendSecond = c.get(Calendar.SECOND);
//    }
    
    public void updateTime()
    {
        //fix this for when the user enters the values they want
        //////
        fireWatchUpdate(getHour(), getMinute(), getSecond());
    }
    public void btnStartClicked()
    {
    wbview.get(0).theTimer().start();
        fireWatchStarted(getHour(), getMinute(), getSecond());
    }
    
     public void btnStopClicked()
    {
    //wbview.get(0).theTimer().stop();
        fireWatchStopped(getHour(), getMinute(), getSecond());
         wbview.get(0).theTimer().stop();
    }
     
      public void btnResumeClicked()
    {
    
    }
      
       public long getHour()
     {
           Calendar c = Calendar.getInstance();
        long hour=Long.parseLong(wbview.get(0).getHourInput());
          long result=0;
          long  sendHour=c.get(Calendar.HOUR_OF_DAY);
                 if(!("00".equals(wbview.get(0).getHourInput())))
                 {
                     if(hour<sendHour)
                     {
                     result= sendHour-hour;
                     sendHour= sendHour-result;
                     }
                     if(hour>sendHour)
                     {
                     result=hour-sendHour;
                     sendHour= sendHour+result;
                     }                    
                // sendHour=c.get(Calendar.HOUR_OF_DAY);
                 }
               //txtHourTimeInput.getText();
    
     return sendHour; 
     }
         
      public long getMinute()
     {
         Calendar c = Calendar.getInstance();
         
     long minute=Long.parseLong(wbview.get(0).getMinInput());
          long result=0;
          long  sendMinute=c.get(Calendar.MINUTE);;
                 if(!("00".equals(wbview.get(0).getMinInput())))
                 {
                     if(minute<sendMinute)
                     {
                     result= sendMinute-minute;
                     sendMinute= sendMinute-result;
                     }
                     if(minute>sendMinute)
                     {
                     result=minute-sendMinute;
                     sendMinute= sendMinute+result;
                     }                    
                // sendHour=c.get(Calendar.HOUR_OF_DAY);
                 }
               //txtHourTimeInput.getText();
    
     return sendMinute;
     }
      
      public long getSecond()
      {
          
           Calendar c = Calendar.getInstance();
      long second=Long.parseLong(wbview.get(0).getSecInput());
          long result=0;
          long  sendSecond=c.get(Calendar.SECOND);
                 if(!("00".equals(wbview.get(0).getSecInput())))
                 {
                     if(second<sendSecond)
                     {
                     result= sendSecond-second;
                     sendSecond= sendSecond-result;
                     }
                     if(second>sendSecond)
                     {
                     result=second-sendSecond;
                     sendSecond= sendSecond+result;
                     }                    
                // sendHour=c.get(Calendar.HOUR_OF_DAY);
                 }
               //txtHourTimeInput.getText();
    
     return sendSecond;
      }
      
      public boolean isStarted()
      {
      
         return started; 
      }
      
       public void fireWatchStopped(long lastHour, long lastMin, long lastSec) {
        WatchEvent swe = new WatchEvent(this, lastHour,lastMin, lastSec);
        WatchListener[] allMyListeners = (WatchListener[]) wbview.get(0).getEventlist().getListeners(WatchListener.class);
        for (int i = 0; i < allMyListeners.length; i++) {
            allMyListeners[i].StopTime(swe);
        }
    }

    public void fireWatchStarted(long hour, long min, long sec) {
        WatchEvent swe = new WatchEvent(this,hour,min,sec);
        WatchListener[] allMyListeners = (WatchListener[])wbview.get(0).getEventlist().getListeners(WatchListener.class);
        for (int i = 0; i < allMyListeners.length; i++) {
            allMyListeners[i].StartTime(swe);
        }
    }
    
    public void fireWatchUpdate(long hour, long min, long sec) {
        WatchEvent swe = new WatchEvent(this,hour,min,sec);
        WatchListener[] allMyListeners = (WatchListener[])wbview.get(0).getEventlist().getListeners(WatchListener.class);
        for (int i = 0; i < allMyListeners.length; i++) {
            allMyListeners[i].UpdateTime(swe);
        }
    }
}
