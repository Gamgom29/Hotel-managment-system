public class Holder {
    Doubleroom arr1[]; //Luxury
    Doubleroom arr2[]; //Deluxe
    Singleroom arr3[]; //Luxury
    Singleroom arr4[]; //Deluxe

    public Holder() {
        arr1 = new Doubleroom[10];
        arr4 = new Singleroom[20];
        arr3 = new Singleroom[10];
        arr2 = new Doubleroom[20];
    }
}