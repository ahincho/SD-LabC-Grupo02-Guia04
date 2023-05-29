package com.unsa.solved.medicine;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerSide {
    public static void main(String[] args) {
        try {
            Stock pharmacy = new Stock();
            pharmacy.addMedicine("Paracetamol", 3.2f, 10);
            pharmacy.addMedicine("Mejoral", 2.0f, 20);
            pharmacy.addMedicine("Amoxilina", 1.0f, 30);
            pharmacy.addMedicine("Aspirina", 5.0f, 40);
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/pharmacy", pharmacy);
            System.out.println("Pharmacy Server Is Ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}