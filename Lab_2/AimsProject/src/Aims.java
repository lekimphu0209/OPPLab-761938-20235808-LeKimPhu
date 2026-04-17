public class Aims {
    public static void  main(String[] args){
        Cart anOrder = new Cart();
        //create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "ROger Allers", 87 , 19.95f);
        anOrder.addDVD(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King",
                "Science Fiction", "George Lucas", 87 , 24.95f);
        anOrder.addDVD(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation",18.99f);
        anOrder.addDVD(dvd3);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    }
}
