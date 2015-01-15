package com.marcinczapla.pos.devices;

import com.marcinczapla.pos.devices.interfaces.OutputDevice;

/**
 * Created by Marcin Czapla on 2015-01-13.
 */
class Printer implements OutputDevice {

    @Override
    public void printValue(String value) {
        System.out.println(value);
    }

}
