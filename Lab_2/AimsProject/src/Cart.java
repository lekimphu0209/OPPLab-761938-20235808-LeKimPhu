public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemsOdered[] =
            new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyQrdered = 0;
    //add DVD
    public void addDVD(DigitalVideoDisc disc){
        if(qtyQrdered < MAX_NUMBER_ORDERED){
            itemsOdered[qtyQrdered] = disc;
            qtyQrdered++;
            System.out.println("The disc has been added");
        }else{
            System.out.println("The cart is almost full");
        }
    }
    //remove DVD
    public void removeDVD(DigitalVideoDisc disc){
        boolean found = false;
        for(int i = 0 ; i < qtyQrdered; i++){
            if(itemsOdered[i] == disc){
                found = true;

                for(int j = i; j < qtyQrdered - 1 ; j++){
                    itemsOdered[j] = itemsOdered[j+1];
                }
                itemsOdered[qtyQrdered-1] = null;
                qtyQrdered--;
                System.out.println("The disc has been removed ");
                break;
            }
        }
        if(!found){
            System.out.println("The disc was not found");
        }
    }

    //Total
    public float totalCost(){
        float sum = 0;
        for(int i= 0 ; i < qtyQrdered; i++){
            sum += itemsOdered[i].getCost();
        }
        return sum;
    }
}
