package com.marcinczapla.pos.app;

import com.marcinczapla.pos.devices.OutputDeviceFactory;
import com.marcinczapla.pos.devices.InputDeviceFactory;
import com.marcinczapla.pos.devices.interfaces.InputDevice;
import com.marcinczapla.pos.devices.interfaces.OutputDevice;
import com.marcinczapla.pos.model.products.Product;
import com.marcinczapla.pos.model.products.ProductRepository;
import com.marcinczapla.pos.model.products.exceptions.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-01-14.
 */
public class PosApp {
    private static final String INVALID_BARCODE_MESSAGE = "Invalid Barcode";
    private static final String PRODUCT_NOT_FOUND_MESSAGE = "Product not found";

    private final InputDeviceFactory inputDeviceFactory;
    private final OutputDeviceFactory outputDeviceFactory;

    private final ProductRepository productRepository;

    private InputDevice scanner;
    private OutputDevice lcdDisplay;
    private OutputDevice printer;

    private final List<Product> scannedProducts;

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
        String barCode = scanner.readValue();
        if (!barCode.isEmpty()) {
            processBarcode(barCode);
        } else {
            lcdDisplay.printValue(INVALID_BARCODE_MESSAGE);
        }
    }

    private void processBarcode(String barCode) {
        if (!"exit".equals(barCode)) {
            Product product = findProductByBarcode(barCode);
            if (product!=null) {
                scannedProducts.add(product);
                lcdDisplay.printValue(product.getName() + " " + product.getPrice());
            }
        } else {
            printTotals();
        }
    }

    private Product findProductByBarcode(String barCode) {
        Product product = null;
        try {
            product = productRepository.loadByBarCode(barCode);
        } catch (ProductNotFoundException e) {
            lcdDisplay.printValue(PRODUCT_NOT_FOUND_MESSAGE);
        }
        return product;
    }

    private void printTotals() {
        BigDecimal total = BigDecimal.ZERO;
        for (Product p : scannedProducts) {
            total = total.add(p.getPrice());
            printer.printValue(p.getName() + " " + p.getPrice());
        }
        printer.printValue(total.toString());
        lcdDisplay.printValue(total.toString());
    }
}
