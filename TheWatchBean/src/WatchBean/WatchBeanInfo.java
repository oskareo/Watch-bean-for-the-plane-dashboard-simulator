/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WatchBean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 *
 * @author USER
 */
public class WatchBeanInfo extends SimpleBeanInfo {
    
     Class beanClass = WatchBeanView.class;
    
     
     public WatchBeanInfo(){}
     
     @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor _hours = new PropertyDescriptor("hours", beanClass, "getHourInput", "setHourInput");
            PropertyDescriptor _minutes = new PropertyDescriptor("minutes", beanClass, "getMinInput", "setMinInput");
            PropertyDescriptor _seconds = new PropertyDescriptor("seconds", beanClass, "getSecInput", "setSecInput");
            PropertyDescriptor _value = new PropertyDescriptor("value", beanClass,"getValue","setValue");
            PropertyDescriptor[] pds = new PropertyDescriptor[]{
                _hours,
                _minutes,
                _seconds,
            _value};
            return pds;

        } catch (IntrospectionException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
