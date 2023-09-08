import java.util.HashMap;
import java.util.Map;

public class ItemWithPrices {
    HashMap<String, Integer> snacks ; //I could just create a HashMap type map in main later on like Map<String, Integer> newHashMap = new HashMap<>();
    HashMap<String, Integer> mainCourse;
    HashMap<String, Integer> dessert;

    public ItemWithPrices(HashMap<String, Integer> snacks, HashMap<String, Integer> mainCourse, HashMap<String, Integer> dessert){
        this.snacks = snacks;
        this.mainCourse = mainCourse;
        this.dessert = dessert;

    }
    public Map<String, Integer> getSnacks(){
        return snacks;
    }
    public Map<String, Integer> getMainCourse(){
        return mainCourse;
    }
    public Map<String, Integer> getDessert(){
        return dessert;
    }
}
