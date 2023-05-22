public class Holder {
     private static Doubleroom arr1[] = new Doubleroom[10]; //VIP
     private static Doubleroom arr2[]= new Doubleroom[20]; //ECO
     private static Singleroom arr3[]= new Singleroom[10]; //VIP
     private static Singleroom arr4[]= new Singleroom[20]; //ECO

    public static Doubleroom[] getArr1() {
        return arr1;
    }

    public static Doubleroom[] getArr2() {
        return arr2;
    }

    public static Singleroom[] getArr3() {
        return arr3;
    }

    public static Singleroom[] getArr4() {
        return arr4;
    }

    public static void singleRoomAvailability(Singleroom arr[]){
        int count = 0;
        for(int i=0;i< arr.length;i++)
        {
            if(arr[i]==null)
                count++;
        }
        System.out.printf("Number of Rooms is : %d \n" , count);
    }
    public static void doubleRoomAvailability(Doubleroom arr[]){
        int count = 0;
        for(int i=0;i< arr.length;i++)
        {
            if(arr[i]==null)
                count++;
        }
        System.out.printf("Number of Rooms is : %d \n" , count);
    }
}