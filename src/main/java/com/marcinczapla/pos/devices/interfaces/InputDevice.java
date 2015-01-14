package com.marcinczapla.pos.devices.interfaces;

import com.marcinczapla.pos.interfaces.Subject;

/**
 * Created by Marcin on 2015-01-11.
 */
public interface InputDevice extends Subject{
    public String readValue();
}
