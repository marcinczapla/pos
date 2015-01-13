package com.marcinczapla.pos.devices;

import com.marcinczapla.pos.interfaces.devices.InputDevice;

/**
 * Created by Marcin on 2015-01-12.
 */
public class ScannerFactory {
    public InputDevice cretateSimpleScanner(){
        return new SimpleInputDeviceImpl();
    }
}
