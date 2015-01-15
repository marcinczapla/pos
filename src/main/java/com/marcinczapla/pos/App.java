package com.marcinczapla.pos;

import com.marcinczapla.pos.app.PosApp;
import com.marcinczapla.pos.devices.OutputDeviceFactory;
import com.marcinczapla.pos.devices.InputDeviceFactory;
import com.marcinczapla.pos.model.products.ProductRepositorySimpleImpl;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( " " );
        PosApp posApp = new PosApp(new InputDeviceFactory(),new OutputDeviceFactory(), new ProductRepositorySimpleImpl());
        posApp.initDevices();
        posApp.doWork();
    }
}
