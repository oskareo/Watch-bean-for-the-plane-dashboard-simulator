/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WatchBean;

import java.util.EventObject;
import java.util.List;

/**
 *
 * @author USER
 */
public class WatchEvent extends EventObject {
    private long hour;
    private long minutes;
    private long seconds;
    public WatchEvent(Object o) {
        super(o);
    }
    
     public WatchEvent(Object o, long h, long m, long s) {
        super(o);
        this.hour= h;
        this.minutes=m;
        this.seconds=s;
    
        
    }
     public long[] getTime()
     {
     long[] timeArray=new long[]{hour,minutes,seconds};
         return timeArray;
     }
}
