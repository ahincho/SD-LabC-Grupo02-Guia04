package com.unsa.proposed;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public CalculatorServer() {
        try {
            Calculator c = new CalculatorImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/CalculatorService", c);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
    public static void main(String[] args) {
        new CalculatorServer();
        System.out.println("Calculator Server is ready.");
    }
}