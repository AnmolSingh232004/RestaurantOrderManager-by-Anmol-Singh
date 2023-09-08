import java.util.List;

public class OrderManager {
    List<String> itemsInCart;
    List<Integer> cartValue;

    public OrderManager(List<String> itemsInCart, List<Integer> cartValue) { //enables us to create itemsInCart and cartValue list
        this.itemsInCart = itemsInCart;
        this.cartValue = cartValue;
    }

    int total;

    public void getItemsInCart() { // enables us to print out the items in our cart
        System.out.println("Total items in your cart are : " + itemsInCart);
    }

    public void getCartValue() { // enables us to print out the items in our cart
        System.out.println("Price of corresponding items are : " + cartValue);
        for (int i : cartValue) {
            total += i;
        }
    }

    public int getCartTotal() {
        return total;

    }
}



