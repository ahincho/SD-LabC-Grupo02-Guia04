package com.unsa.solved.medicine;

import java.util.HashMap;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            StockInterface pharm = (StockInterface) Naming.lookup("rmi://localhost:1099/pharmacy");
            System.out.println("Ingresa la opcion.\n1.Listar productos.\n2. Comprar productos.");
            int selection = sc.nextInt();
            // Enumerator
            if( selection == 1 ) {
                HashMap<String, MedicineInterface> aux;
                try {
                    aux = (HashMap<String,MedicineInterface>) pharm.getStockProducts();
                    for(String key : aux.keySet()) {
                        MedicineInterface e = (MedicineInterface) aux.get(key);
                        System.out.println(e.print());
                        System.out.println("*--------------*");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if( selection == 2 ) {
                try {
                    System.out.println("Ingrese nombre de la medicina");
                    String medicine = sc.next();
                    System.out.println("Ingrese cantidad a comprar");
                    int amount = sc.nextInt();
                    MedicineInterface aux = pharm.buyMedicine(medicine, amount);
                    System.out.println("Usted acaba de comprar");
                    System.out.println(aux.print());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Seleccione una opcion valida");
            }
            sc.close();
        } catch (MalformedURLException murle) {
            System.out.println();
            System.out.println("MalformedURLException");
            System.out.println(murle);
        } catch (RemoteException re) {
            System.out.println();
            System.out.println("RemoteException");
            System.out.println(re);
        } catch (NotBoundException nbe) {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(nbe);
        } catch (ArithmeticException ae) {
            System.out.println();
            System.out.println("ArithmeticException");
            System.out.println(ae);
        }
    }
}