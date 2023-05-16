public class Food {
    int itemno ;
    int quantitiy;
    float price ;

    public Food(int itemno, int quantitiy ) {
        this.itemno = itemno;
        this.quantitiy = quantitiy;
        if(itemno == 1)
            price=quantitiy*3;
        else if(itemno == 2)
            price=quantitiy*10;
        else if(itemno==3)
            price= quantitiy*6;
        else if(itemno == 4)
            price=quantitiy*2;
    }
}
