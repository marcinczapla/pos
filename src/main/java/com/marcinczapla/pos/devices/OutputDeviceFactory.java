package com.marcinczapla.pos.devices;

import com.marcinczapla.pos.devices.interfaces.OutputDevice;

/**
 * Created by Marcin Czapla on 2015-01-13.
 */
public class OutputDeviceFactory {
    public OutputDevice createPrinter(){
        return new Printer();
    }

    public OutputDevice createLcdDisplay(){
        return new LcdDisplay();
    }
}
