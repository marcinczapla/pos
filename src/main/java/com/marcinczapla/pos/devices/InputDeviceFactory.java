package com.marcinczapla.pos.devices;

import com.marcinczapla.pos.devices.interfaces.InputDevice;

/**
 * Created by Marcin on 2015-01-12.
 */
public class InputDeviceFactory {
    public InputDevice cretateSimpleScanner(){
        return new SimpleInputDeviceImpl();
    }
}
