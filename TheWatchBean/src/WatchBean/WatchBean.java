/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WatchBean;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class WatchBean extends JPanel {
    
    public static WatchBean wbInstance=null;
  public  WatchBeanView wbv;//= WatchBeanView.getInstance();
    
   public List<IWatchView> theView ;//= new ArrayList<>();
   public WatchActions wa;
   
  public WatchController wc;
    public WatchBean()
    {
    wbv= WatchBeanView.getInstance();
    theView = new ArrayList<>();
    theView.add(wbv);
    wa= new WatchActions(theView);
    wc= new WatchController(wa, wbv);
    wbv.ActivateWatchControls(wc);
   add(wbv);
    }
    
    public static synchronized WatchBean getInstance()
    {
        if(wbInstance==null)
        {
        wbInstance= new WatchBean();
        }
    
    
   return wbInstance; }
}
