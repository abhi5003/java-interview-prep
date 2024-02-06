package com.spring.example.LLD.DesignPatterns.SOLID.SRP;

public class Marker {

    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}


class  Invoice{
    Marker marker;
    int quantity;
    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }
    public int calculateTotal(){
        int price=((marker.price) * this.quantity);
        return price;
    }


}


// Followed SRP

class InvoiceDAO{

    Invoice invoice;

    public InvoiceDAO(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveDB(){
        // Save to DB
    }

    public void saveToFile(){
        // save to file
    }
}

class InvoicePrinter{
    Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice(){
        // Print the invoice
    }

}



