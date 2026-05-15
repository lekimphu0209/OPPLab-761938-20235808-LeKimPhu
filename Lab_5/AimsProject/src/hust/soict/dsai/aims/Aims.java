package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Store store = new Store();
        Cart cart = new Cart();

        // Sample data
        store.addMedia(new DigitalVideoDisc(1, "Lion King", "Animation", 19.95f, "Disney", 90));
        store.addMedia(new Book(2, "Clean Code", "Education", 45.0f));

        CompactDisc cd = new CompactDisc(3, "Best Hits", "Music", 25.0f, "Unknown", 0, "Artist");
        cd.addTrack(new Track("Song1", 200));
        cd.addTrack(new Track("Song2", 180));
        store.addMedia(cd);

        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore(store, cart);
                    break;
                case 2:
                    updateStore(store);
                    break;
                case 3:
                    seeCart(cart);
                    break;
                case 0:
                    System.out.println("Exit program!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    // ================= MAIN MENU =================

    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Choose: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. See media details");
        System.out.println("2. Add media to cart");
        System.out.println("3. Play media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Choose: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Choose: ");
    }

    public static void cartMenu() {
        System.out.println("\nCart Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media");
        System.out.println("2. Sort media");
        System.out.println("3. Remove media");
        System.out.println("4. Play media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Choose: ");
    }

    // ================= VIEW STORE =================

    public static void viewStore(Store store, Cart cart) {
        int choice;

        do {
            store.print();
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: // details
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    Media m = store.findByTitle(title);

                    if (m != null) {
                        System.out.println(m);

                        int sub;
                        do {
                            mediaDetailsMenu();
                            sub = scanner.nextInt();
                            scanner.nextLine();

                            if (sub == 1) {
                                cart.addMedia(m);
                            } else if (sub == 2 && m instanceof Playable) {
                                ((Playable) m).play();
                            }

                        } while (sub != 0);

                    } else {
                        System.out.println("Media not found!");
                    }
                    break;

                case 2: // add to cart
                    System.out.print("Enter title: ");
                    String t = scanner.nextLine();
                    Media media = store.findByTitle(t);

                    if (media != null) {
                        cart.addMedia(media);
                    } else {
                        System.out.println("Not found!");
                    }
                    break;

                case 3: // play
                    System.out.print("Enter title: ");
                    String t2 = scanner.nextLine();
                    Media m2 = store.findByTitle(t2);

                    if (m2 instanceof Playable) {
                        ((Playable) m2).play();
                    } else {
                        System.out.println("Cannot play!");
                    }
                    break;

                case 4:
                    seeCart(cart);
                    break;
            }

        } while (choice != 0);
    }

    // ================= UPDATE STORE =================

    public static void updateStore(Store store) {
        System.out.println("\n1. Add DVD");
        System.out.println("2. Remove by title");
        System.out.print("Choose: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Title: ");
            String title = scanner.nextLine();

            store.addMedia(new DigitalVideoDisc(
                    100, title, "Unknown", 10.0f, "Unknown", 60
            ));

            System.out.println("Added!");

        } else if (choice == 2) {
            System.out.print("Title: ");
            String title = scanner.nextLine();

            Media m = store.findByTitle(title);

            if (m != null) {
                store.removeMedia(m);
                System.out.println("Removed!");
            } else {
                System.out.println("Not found!");
            }
        }
    }

    // ================= CART =================

    public static void seeCart(Cart cart) {
        int choice;

        do {
            cart.print();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: // filter
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    cart.searchByTitle(title);
                    break;

                case 2: // sort
                    cart.sortByTitle();
                    System.out.println("Sorted!");
                    break;

                case 3: // remove
                    System.out.print("Enter title: ");
                    String t = scanner.nextLine();
                    cart.removeByTitle(t);
                    break;

                case 4: // play
                    System.out.print("Enter title: ");
                    String t2 = scanner.nextLine();
                    cart.playByTitle(t2);
                    break;

                case 5: // place order
                    System.out.println("Order created!");
                    cart.clear();
                    break;
            }

        } while (choice != 0);
    }
}