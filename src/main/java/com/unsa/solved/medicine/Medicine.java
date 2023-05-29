package com.unsa.solved.medicine;

import java.rmi.server.UnicastRemoteObject;

/**
 * Este es la claes Medicina para este proyecto solo
 * se puede comprar y consultar la lista de medicinas.
 **/
public class Medicine extends UnicastRemoteObject implements MedicineInterface {
    private String name;
    private float unitPrice;
    private int stock;
    public Medicine() throws Exception {
        super();
    }
    public Medicine(String name, float price, int stock) throws Exception {
        super();
        this.name = name;
        this.unitPrice = price;
        this.stock = stock;
    }
    @Override
    public Medicine getMedicine(int amount) throws Exception {
        if (this.stock <= 0) {
            throw new StockEx
        }
    }
}