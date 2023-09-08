import java.util.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) { //main method
        HashMap<String, Integer> snacks = new HashMap<>(); // hashmaps to store food name and price
        HashMap<String, Integer> mainCourse = new HashMap<>();
        HashMap<String, Integer> dessert = new HashMap<>();
        List<String> itemsToAdd = new ArrayList<>(); // a list to store only the name of food you want
        List<Integer> itemsValue = new ArrayList<>(); // a list to store the prices of the food you want
        OrderManager orderManager = new OrderManager(itemsToAdd, itemsValue);// instance of OrderManager class necessary to add item into cart and prices and to incorporate the lists we created

        Scanner scan = new Scanner(System.in); // scanner to take user inputs
        snacks.put("Samosa", 20);
        snacks.put("Pakora", 100); //code to put in item in respective HashMaps
        snacks.put("Patties", 30);
        snacks.put("Dhokla", 250);
        snacks.put("Kachori", 40);

        mainCourse.put("ShahiPanner", 500);
        mainCourse.put("DalMakhni", 450);
        mainCourse.put("MalaiKofta", 600);
        mainCourse.put("MixVeg", 350);
        mainCourse.put("SoyaChaap", 400);

        dessert.put("GulabJamun", 30);
        dessert.put("Jalebi", 150);
        dessert.put("MoongDalHalwa", 150);

        System.out.println("Hey !! welcome to our restaurant would you like to place an order? \n\n if yes press 1 if you don't want to place an order right now press 2.");

        while(true){ // while the if statement is true code will repeat
            int wannaPlaceOrder = scan.nextInt(); // important since when this scanner is reached rest of the loop is blocked hence the whole code is stopped until input is made

            if(wannaPlaceOrder == 1){ //if wanna place order
                System.out.println(" \n Snacks currently available are : \n");
                break;
            }
            if(wannaPlaceOrder == 2){ //if wannaa troll the restaurant
                System.out.println("Thanks for visiting us we would love to serve you some other time.");
                System.exit(0); // exits program immediately 0 over here is exit code how many errors will show up prolly there to help other programmers understand what errors are happening in this code
            }
            else { //if you are dumb
                System.out.println("Invalid Option!!! Please try again");
            }

        }



        for (String s : snacks.keySet()) { // key set basically return a set of all keys in the map and set has only unique values so every key is unique
            System.out.println(s + " : " + snacks.get(s));
        }
        System.out.println("\n Input the name of item you want in your cart. If you don't want anything from this list just press enter or type next to skip. \n");

        String chosenSnack; // had to declare these before since cant declare in loop sadly
        int snackPrice = 0;// had to declare this cause cant in loop
        while (true) {
            chosenSnack = scan.next().trim(); // .trim removes whitespaces .toLowerCase so that case doesnt matter when typing next

            if (chosenSnack.isEmpty()) { //this means if user just presses enter
                break; // this skips this whole shit
            } else if (chosenSnack.equalsIgnoreCase("next")) { // if user types next
                break;
            } else if (snacks.containsKey(chosenSnack)) { //if user inputs a valid option in the food HashMap

                snackPrice = snacks.get(chosenSnack);
                itemsToAdd.add(chosenSnack);
                itemsValue.add(snackPrice);
                System.out.println("Item added to cart named " + chosenSnack + " worth rs: " + snackPrice);
            } else {
                System.out.println("Item not found. Please try again or type -next- to skip"); //if user doesn't input correct thing
            }
        }

        //System.out.println(orderManager.getItemsInCart()); if I want to get to know what is in cart
        //System.out.println(orderManager.getCartValue()); if I want to know cart value


        System.out.println(" \n Items on the main course are : \n");

        for (String s : mainCourse.keySet()) { // this prints all items in main course HashMap
            System.out.println(s + " : " + mainCourse.get(s));
        }
        String chosenMainCourse;
        int mainCoursePrice = 0;

        while (true) {
            chosenMainCourse = scan.next().trim();

            if (chosenMainCourse.isEmpty()) {
                break;
            } else if (chosenMainCourse.equalsIgnoreCase("next")) {
                break;
            } else if (mainCourse.containsKey(chosenMainCourse)) { // if it contains items from the main course this will execute
                mainCoursePrice = mainCourse.get(chosenMainCourse);
                itemsToAdd.add(chosenMainCourse);
                itemsValue.add(mainCoursePrice);
                System.out.println("Item added to cart named " + chosenMainCourse + " worth rs " + mainCoursePrice);
            } else {
                System.out.println("Item not found. Please try again or type -next- to skip");
            }
        }

        System.out.println(" \n Dessert options are : \n");

        for (String s : dessert.keySet()) { //prints items in desert
            System.out.println(s + " : " + dessert.get(s));
        }
        String chosenDessert; // declared this outside cause I cant inside + impt. if wanna print chosenDessert later which although wont be needed just mentioned for other usecasses
        int dessertPrice = 0;

        while (true) {
            chosenDessert = scan.next().trim();

            if (chosenDessert.isEmpty()) {
                break;
            }
            if (chosenDessert.equalsIgnoreCase("next")) { //equalsIgnoreCase basically ignores capital or small letter so in this case if I type in next or NeXT it doesn't matter
                break;
            }
            if (dessert.containsKey(chosenDessert)) {
                dessertPrice = dessert.get(chosenDessert);
                itemsToAdd.add(chosenDessert);
                itemsValue.add(dessertPrice);
                System.out.println("Item added to cart named " + chosenDessert + " worth rs " + dessertPrice);
            } else {
                System.out.println("Item not found. Please try again or type -next- to skip");
            }
        }
        /*int total = 0; // created this total outside so this total variable can exist inside and outside the loop so we can print it outside after loop is finished
        for (int i : itemsValue) {
            total += i; // all items in itemsValue will sum up in total
        }*/
        //this approach of getting total war replaced by me after I implemented the total in OrderManager whenever getCarValue() is generated total is also generated and using getCartTotal prints it

        Random rad = new Random(); //this creates a random number when we use rad like on 150th line

        orderManager.getItemsInCart(); //using method in OrderManager
        orderManager.getCartValue(); //using method in OrderManager
        System.out.println("Your total bill sums up to : " + orderManager.getCartTotal() );
        System.out.println("\n\nPress 1 to confirm your order or press 2 to cancel your order.");

        // int order = scan.nextInt(); if we put this outside it will become an infinite loop :(

        while (true){
            int order = scan.nextInt(); //used inside since order will block rest of the code until a input is provided hence every time loop restarts a new input is needed and eventually we get a input which breaks the loop

        if (order == 1){ // choosing 1 will place order technically(shrugs...) and end loop
            System.out.println("Your order has been successfully placed!!");
            int orderNumber = rad.nextInt(500);
            System.out.println("Your order number is " + orderNumber);
            break;
        }
        if (order == 2){ // choosing 2 will cancel order and break / end loop
            System.out.println("Your order has been cancelled. Thanks for visiting us.");
            break;
        } else {
            System.out.println("Invalid Option!!!"); // repeats loop since you suck at choosing
        }
        }


    }
}