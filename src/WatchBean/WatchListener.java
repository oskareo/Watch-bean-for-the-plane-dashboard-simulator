/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WatchBean;

import java.util.EventListener;

/**
 *
 * @author USER
 */
public interface WatchListener extends EventListener {
    
    public void StartTime(WatchEvent swe);
    public void StopTime(WatchEvent swe);
    public void UpdateTime(WatchEvent swe);
     // void ResumeTime(WatchEvent swe);
     
    
}
