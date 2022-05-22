package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Products {
    Item itemMouse = new Item("Mouse",10.99,0.2,"RO");
    Item itemKeyboard = new Item("Keyboard",40.99,0.7,"UK");
    Item itemMonitor = new Item("Monitor",164.99,1.9,"US");
    Item itemWebcam = new Item("Webcam",84.99,0.2,"RO");
    Item itemHeadphones = new Item("Headphones",59.99,0.6,"US");
    Item itemLamp = new Item("Desk Lamp",89.99,1.3,"UK");
    ArrayList<Item> items = new ArrayList<Item>();
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> list = new ArrayList<String>();
    int mouseCounter =0;
    int keyboardCounter = 0;
    int monitorCounter = 0;
    int webcamCounter = 0;
    int headphonesCounter = 0;
    int lampCounter = 0;

    protected void showItems() {
        items.add(itemMouse);
        items.add(itemKeyboard);
        items.add(itemMonitor);
        items.add(itemWebcam);
        items.add(itemHeadphones);
        items.add(itemLamp);
        System.out.println("Please select from the items listed below");
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }

    protected void selectItems() {
        System.out.println("Enter : ");
        String userInput =scanner.nextLine();

        do {
            if(userInput.equals("Mouse"))
                    mouseCounter++;
                if(userInput.equals("Keyboard"))
                    keyboardCounter++;
                if(userInput.equals("Monitor"))
                    monitorCounter++;
                if(userInput.equals("Webcam"))
                    webcamCounter++;
                if(userInput.equals("Headphones"))
                    headphonesCounter++;
                if(userInput.equals("Desk Lamp"))
                    lampCounter++;
            System.out.println("Current contents are:");
            if(mouseCounter!=0)
                System.out.println("Mouse x"+mouseCounter);
            if(keyboardCounter!=0)
                System.out.println("Keyboard x"+keyboardCounter);
            if(monitorCounter!=0)
                System.out.println("Monitor x"+monitorCounter);
            if(webcamCounter!=0)
                System.out.println("Webcam x"+webcamCounter);
            if(headphonesCounter!=0)
                System.out.println("Headphones x"+headphonesCounter);
            if(lampCounter!=0)
                System.out.println("Desk Lamp x"+lampCounter);
            System.out.println("Add more? (y/n)");
            if (scanner.next().startsWith("y")) {
                System.out.println("Enter : ");
                scanner.nextLine();
                userInput =scanner.nextLine();
            } else {
                System.out.println("Subtotal: "+checkout());
                System.out.println("Shipping: "+Math.round(shipping()));
                System.out.println("VAT: $"+vatCalc());
                System.out.println("Discounts: ");
                if(discountKeyboard()!=0)
                    System.out.println("10% off keyboards: -$"+discountKeyboard());
                if (shipping()!=shppingDiscount())
                             System.out.println("$10 off shipping: -10$");

                System.out.println("Total: $"+Math.round(100*(checkout()+shppingDiscount()-discountKeyboard()+vatCalc()))/100);
                break;
            }


        } while (true);
    }
    protected double discountKeyboard(){
        if(keyboardCounter!=0)
            return itemKeyboard.getPrice()*keyboardCounter*0.1;
        else
            return 0;
    }
    protected double vatCalc(){
        return checkout()*0.19;
    }
   protected double checkout(){
            double total = 0;
       if(mouseCounter!=0)
           total = total+itemMouse.getPrice()*mouseCounter;
       if(keyboardCounter!=0)
           total = total+itemKeyboard.getPrice()*keyboardCounter;
       if(monitorCounter!=0)
           total = total+itemMonitor.getPrice()*monitorCounter;
       if(webcamCounter!=0)
           total=total+itemWebcam.getPrice()*webcamCounter;
       if(headphonesCounter!=0)
           total=total+itemHeadphones.getPrice()*headphonesCounter;
       if(lampCounter!=0)
           total=total+itemLamp.getPrice()*lampCounter;
       return total;
    }

    protected double shipping(){
        ShippingRate shippingRateRO = new ShippingRate(1,"RO");
        ShippingRate shippingRateUK = new ShippingRate(2,"UK");
        ShippingRate shippingRateUS = new ShippingRate(3,"US");
        double totalShipping = 0;
        if(mouseCounter!=0)
            totalShipping = totalShipping+itemMouse.getWeight()*mouseCounter*shippingRateRO.getRate()*10;
        if(keyboardCounter!=0)
            totalShipping = totalShipping+itemKeyboard.getWeight()*keyboardCounter*shippingRateUK.getRate()*10;
        if(monitorCounter!=0)
            totalShipping = totalShipping+itemMonitor.getWeight()*monitorCounter*shippingRateUS.getRate()*10;
        if(webcamCounter!=0)
            totalShipping=totalShipping+itemWebcam.getPrice()*webcamCounter*shippingRateRO.getRate()*10;
        if(headphonesCounter!=0)
            totalShipping=totalShipping+itemHeadphones.getPrice()*headphonesCounter*shippingRateUS.getRate()*10;
        if(lampCounter!=0)
            totalShipping=totalShipping+itemLamp.getPrice()*lampCounter*shippingRateUK.getRate()*10;
        return totalShipping;
    }
    protected double shppingDiscount(){
        double totalShipping = shipping();
        if((lampCounter+headphonesCounter+webcamCounter+mouseCounter+monitorCounter+keyboardCounter)>=2)
            return totalShipping-10;
        else
            return totalShipping;
    }

}
