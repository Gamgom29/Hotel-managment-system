import java.util.Scanner;

public class HotelSystem {
    public static void main(String[] args){
        System.out.println("\n---------------------------------------------");
        System.out.printf("       Welcome to %s hotel\n ",Hotel.hotel_name);
        System.out.println("---------------------------------------------");
        System.out.println("\n--Please log in to the system--");

        try {
            String Username= "robaa";
            String Password= "123";

            Scanner input = new Scanner(System.in);
            System.out.println("\nEnter Username : ");
            String username = input.next();

            System.out.println("\nEnter Password : ");
            String password = input.next();

            if (username.equals(Username) && password.equals(Password)) {

                System.out.println("\n--Access Granted! Welcome!--");
            }

            else if (username.equals(Username)) {
                System.out.println("\nInInvalid Password! You cannot log in to the system. Please try again.");
               return;
            } else if (password.equals(Password)) {
                System.out.println("\nInvalid Username! You cannot log in to the system. Please try again.");
                return;
            } else {
                System.out.println("\nInvalid Username & Password! You cannot log in to the system. Please try again.");
                return;
            }
            Scanner in=new Scanner(System.in);
            int in1,in2;
            char question;
            x:
            do {
                System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Display reservation details\n7.Exit\n");
                in1 = in.nextInt();
                switch(in1){
                    case 1: System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                        in2 = in.nextInt();
                        Hotel.features(in2);
                        break;
                    case 2:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        in2 = in.nextInt();
                        Hotel.availability(in2);
                        break;
                    case 3:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        in2 = in.nextInt();
                        Hotel.bookroom(in2);
                        break;
                    case 4:
                        System.out.print("\nRoom Number- ");
                        in2 = in.nextInt();
                        if(in2>60)
                            System.out.println("Room doesn't exist");
                        else if(in2>40)
                            Hotel.order(in2-41,4);
                        else if(in2>30)
                            Hotel.order(in2-31,3);
                        else if(in2>10)
                            Hotel.order(in2-11,2);
                        else if(in2>0)
                            Hotel.order(in2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 5:
                        System.out.print("\nRoom Number- ");
                        in2 = in.nextInt();
                        if(in2>60)
                            System.out.println("Room doesn't exist");
                        else if(in2>40)
                            Hotel.deallocate(in2-41,4);
                        else if(in2>30)
                            Hotel.deallocate(in2-31,3);
                        else if(in2>10)
                            Hotel.deallocate(in2-11,2);
                        else if(in2>0)
                            Hotel.deallocate(in2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:
                        System.out.print("\n=====================\nReservation details- \n======================\n\nEnter room number: ");
                        in2 = in.nextInt();
                        if(in2>60)
                            System.out.println("Reservation doesn't exist");
                        else if(in2>40)
                            Hotel.display(in2-41,4);
                        else if(in2>30)
                            Hotel.display(in2-31,3);
                        else if(in2>10)
                            Hotel.display(in2-11,2);
                        else if(in2>0)
                            Hotel.display(in2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 7:break x;
                }
                    System.out.println("\nContinue : (y/n) ");
                    question=in.next().charAt(0);
                    if(!(question=='y'||question=='Y'||question=='n'||question=='N')){
                        System.out.println("Invalid Option");
                        System.out.println("\nContinue : (y/n)");
                        question=in.next().charAt(0);
                    }

            }while(question=='y'||question=='Y');

        }
        catch(Exception e)
        {
            System.out.println("*******NOT VALID INPUT*******");
        }
    }
}
