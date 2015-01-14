package com.marcinczapla.pos.app;

import com.marcinczapla.pos.devices.OutputDeviceFactory;
import com.marcinczapla.pos.devices.ScannerFactory;
import com.marcinczapla.pos.devices.interfaces.InputDevice;
import com.marcinczapla.pos.devices.interfaces.OutputDevice;
import com.marcinczapla.pos.model.products.ProductRepository;

/**
 * Created by Marcin on 2015-01-14.
 */
public class PosApp {
    private ScannerFactory scannerFactory;
    private OutputDeviceFactory outputDeviceFactory;

    private ProductRepository productRepository;

    private InputDevice scanner;
    private OutputDevice lcdDisplay;
    private OutputDevice printer;

    public PosApp(ScannerFactory scannerFactory, OutputDeviceFactory outputDeviceFactory, ProductRepository repository) {
        this.scannerFactory = scannerFactory;
        this.outputDeviceFactory = outputDeviceFactory;
        this.productRepository = repository;
    }

    public void initDevices(){
        this.scanner = scannerFactory.cretateSimpleScanner();
        this.lcdDisplay = outputDeviceFactory.createLcdDisplay();
        this.printer = outputDeviceFactory.createPrinter();
    }
}
