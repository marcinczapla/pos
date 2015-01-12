package com.marcinczapla.pos.scanner;

/**
 * Created by Marcin on 2015-01-12.
 */
public class ScannerFactory {
    public Scanner cretateSimpleScanner(){
        return new SimpleScannerImpl();
    }
}
