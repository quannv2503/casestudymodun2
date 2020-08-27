package casestudymodun2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagePhoneBook {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        Menu menu = new Menu();
        do {
            try {
                System.out.println("\n  1.Continue PhoneBook | 2.Create New PhoneBook");
                System.out.print("You choose:");
                int choice = Integer.parseInt(scanner1.nextLine());
                if (choice == 1) {
                    ArrayList<PhoneBookProperties> obj = null;
                    try {
                        FileInputStream fis = new FileInputStream("file_danh_ba.txt");
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        obj = (ArrayList<PhoneBookProperties>) ois.readObject();
                        ois.close();
                        fis.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    PhoneBookFunctions.phoneList = obj;
                    menu.menu();
                } else if (choice == 2) {
                    menu.menu();
                } else {
                    System.out.println("Retype");
                }
            } catch (Exception e) {
                System.out.println("Retype");
            }
        } while (true);
    }
}
