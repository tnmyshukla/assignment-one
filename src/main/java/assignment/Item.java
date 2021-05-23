package main.java.assignment;


public class Item {
    public String name;
    int price;
    int quantity;
    String type;
    Double salesTax;
    Double finalPrice;
    public Item(String name, String type, int price, int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.type=type;
        setFinalPrice();
    }

    public void setFinalPrice() {
        switch(this.type){
            case "raw":
                this.salesTax=12.5*this.price*0.01;
                break;
            case "manufactured":
                this.salesTax=12.5*this.price*0.01;
                this.salesTax+=0.02*(this.price+this.salesTax);
                break;
            case "imported":
                Double importDuty=0.1*this.price;
                Double surcharge;
                if(this.price+importDuty<=100) {
                    surcharge=5.0;
                } else if(this.price+importDuty<=200) {
                    surcharge=10.0;
                }else{
                    surcharge=0.05*(this.price+importDuty);
                }
                this.salesTax=importDuty+surcharge;
                break;
        }
        this.finalPrice=(this.salesTax+this.price)*this.quantity;
    }
    void displayItemDetails(){
        System.out.println("Item Name: "+this.name);
        System.out.println("Item Price: "+this.price);
        System.out.println("Item Quantity: "+this.quantity);
        System.out.println("Sales Tax: "+this.salesTax);
        System.out.println("Final Price: "+this.finalPrice);
    }
}
