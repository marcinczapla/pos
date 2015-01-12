package com.marcinczapla.pos.scanner;

import com.marcinczapla.pos.interfaces.Subject;

/**
 * Created by Marcin on 2015-01-11.
 */
public interface Scanner extends Subject{
    public String scanBarcode();
}
