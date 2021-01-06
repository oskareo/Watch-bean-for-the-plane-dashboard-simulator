/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WatchBean;

import javax.swing.Timer;
import javax.swing.event.EventListenerList;
import javax.swing.*;

/**
 *
 * @author USER
 */
public interface IWatchView {
    void UpdateClock(long time);
    public String getHourInput();
    public String getMinInput();
   public  String getSecInput();
   public EventListenerList getEventlist();
   public Timer theTimer();
}
