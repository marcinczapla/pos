package com.marcinczapla.pos.interfaces.devices;

import com.marcinczapla.pos.interfaces.Subject;

/**
 * Created by Marcin on 2015-01-11.
 */
public interface InputDevice extends Subject{
    public String readValue();
}
