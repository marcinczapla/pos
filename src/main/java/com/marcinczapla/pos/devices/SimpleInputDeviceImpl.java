package com.marcinczapla.pos.devices;

import com.marcinczapla.pos.devices.interfaces.InputDevice;

/**
 * Created by Marcin on 2015-01-12.
 */
class SimpleInputDeviceImpl implements InputDevice {

    @Override
    public String readValue() {
        String barcodeValue = "111111111111";
        return barcodeValue;
    }
}
