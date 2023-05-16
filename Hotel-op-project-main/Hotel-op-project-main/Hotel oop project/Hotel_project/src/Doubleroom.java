public class Doubleroom extends  Singleroom {
    String name2 , contact2 , gender2;
    Doubleroom(){}
    Doubleroom(String name,String contact,String gender,String name2,String contact2,String gender2){
        super(name , contact ,gender);
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
    }
}
