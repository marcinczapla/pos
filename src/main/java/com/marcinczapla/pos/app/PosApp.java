package com.marcinczapla.pos.app;

import com.marcinczapla.pos.devices.OutputDeviceFactory;
import com.marcinczapla.pos.devices.InputDeviceFactory;
import com.marcinczapla.pos.devices.interfaces.InputDevice;
import com.marcinczapla.pos.devices.interfaces.OutputDevice;
import com.marcinczapla.pos.model.products.ProductRepository;

/**
 * Created by Marcin on 2015-01-14.
 */
public class PosApp {
    private InputDeviceFactory inputDeviceFactory;
    private OutputDeviceFactory outputDeviceFactory;

    private ProductRepository productRepository;

    private InputDevice scanner;
    private OutputDevice lcdDisplay;
    private OutputDevice printer;

    public PosApp(InputDeviceFactory inputDeviceFactory, OutputDeviceFactory outputDeviceFactory, ProductRepository repository) {
        this.inputDeviceFactory = inputDeviceFactory;
        this.outputDeviceFactory = outputDeviceFactory;
        this.productRepository = repository;
    }

    public void initDevices(){
        this.scanner = inputDeviceFactory.cretateSimpleScanner();
        this.lcdDisplay = outputDeviceFactory.createLcdDisplay();
        this.printer = outputDeviceFactory.createPrinter();
    }

    public void doWork(){

    }
}
