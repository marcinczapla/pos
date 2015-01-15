package com.marcinczapla.pos.app;

import com.marcinczapla.pos.devices.OutputDeviceFactory;
import com.marcinczapla.pos.devices.InputDeviceFactory;
import com.marcinczapla.pos.devices.interfaces.InputDevice;
import com.marcinczapla.pos.devices.interfaces.OutputDevice;
import com.marcinczapla.pos.model.products.Product;
import com.marcinczapla.pos.model.products.ProductRepository;
import com.marcinczapla.pos.model.products.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

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

    private List<Product> scannedProducts;

    public PosApp(InputDeviceFactory inputDeviceFactory, OutputDeviceFactory outputDeviceFactory, ProductRepository repository) {
        this.inputDeviceFactory = inputDeviceFactory;
        this.outputDeviceFactory = outputDeviceFactory;
        this.productRepository = repository;
        this.scannedProducts = new ArrayList<Product>();
    }

    public void initDevices() {
        this.scanner = inputDeviceFactory.cretateSimpleScanner();
        this.lcdDisplay = outputDeviceFactory.createLcdDisplay();
        this.printer = outputDeviceFactory.createPrinter();
    }

    public void doWork() {
        Product product = null;
        String barCode = scanner.readValue();
        if (!barCode.isEmpty()) {
            try {
                product = productRepository.loadByBarCode(barCode);
            } catch (ProductNotFoundException e) {
                e.printStackTrace();
            }
            if (product != null) {
                scannedProducts.add(product);
            }
        } else {
            lcdDisplay.printValue("Invalid Barcode");
        }
    }
}
