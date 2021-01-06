/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WatchBean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author USER
 */
public class WatchController implements ActionListener{
WatchActions mymodel;
WatchBeanView watchPanelControl;

WatchController(WatchActions wa,WatchBeanView wb )
{
mymodel=wa;
watchPanelControl=wb;
        
        
}
    //@Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==watchPanelControl.btnStart)
        {
        mymodel.btnStartClicked();
        }
        else if(ae.getSource()==watchPanelControl.btnStop)
        {
        mymodel.btnStopClicked();
        }
        else if(ae.getSource()==watchPanelControl.t)
        {
        mymodel.updateTime();
        }
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
