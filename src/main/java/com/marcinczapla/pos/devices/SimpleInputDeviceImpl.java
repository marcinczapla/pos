package com.marcinczapla.pos.devices;

import com.marcinczapla.pos.devices.interfaces.InputDevice;
import com.marcinczapla.pos.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-01-12.
 */
class SimpleInputDeviceImpl implements InputDevice {

    private String barcodeValue;
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers ){
            o.triggerChange(barcodeValue);
        }
    }

    @Override
    public String readValue() {
        this.barcodeValue="111111111111";
        this.notifyObservers();
        return this.barcodeValue;
    }
}
