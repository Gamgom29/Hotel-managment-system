import java.lang.reflect.Array;
import java.util.ArrayList;

public class Singleroom {
    String name , contact , gender;
    ArrayList<Food> food = new ArrayList<>();
    Singleroom(){}
    Singleroom(String name , String contact , String gender){
        this.name = name ;
        this.contact = contact ;
        this.gender = gender ;
    }
}
