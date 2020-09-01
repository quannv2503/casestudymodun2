package casestudymodun2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookFunctions extends Phone {
    static ArrayList<PhoneBookProperties> phoneList = new ArrayList();

    @Override
    void insertPhone(String name, String phone) {
        boolean isInsert = false;
        for (PhoneBookProperties a : phoneList) {
            if (a.getPhone().equals(phone)) {
                System.out.println("Phone number already in the contact list!");
                isInsert = true;
                break;
            }
        }
        if (!isInsert) {
            phoneList.add(new PhoneBookProperties(name, phone));
            System.out.println("Added");
        }
    }

    @Override
    void removePhone(String name) {
        boolean isDelete = false;
        for (PhoneBookProperties a : phoneList) {
            if (a.getName().equals(name)) {
                phoneList.remove(a);
                System.out.println("Deleted");
                isDelete = true;
                break;
            }
        }
        if (!isDelete) {
            System.out.println("Can not find the name of the person you entered.");
        }
    }

    @Override
    void updatePhone(String name, String newphone) {
        boolean isUpdate = false;
        int index = -1;
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getName().equals(name)) {
                isUpdate = true;
                index = i;
                break;
            }
        }

        if (!isUpdate) {
            System.out.println("Can not find the name of the person you entered.");
        } else {
            phoneList.set(index, new PhoneBookProperties(name, newphone));
            System.out.println("Changed.");
        }

    }

    @Override
    void searchPhone(String name) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listName = new ArrayList<>();
        Pattern pattern = Pattern.compile(name);
        Matcher matcher;
        for (int i = 0; i < phoneList.size(); i++) {
            matcher = pattern.matcher(phoneList.get(i).getName());
            if (matcher.find()) {
                listName.add(phoneList.get(i).getName());
            }
        }
        if (listName.isEmpty()) {
            System.out.println("Not found!");
        } else if (listName.size() == 1) {
            for (int i = 0; i < phoneList.size(); i++) {
                if (phoneList.get(i).getName().equals(listName.get(0))) {
                    System.out.println("Phone number of the person you want to find:" + phoneList.get(i).getPhone());
                    break;
                }
            }
        } else {
            System.out.println("Search found:");
            for (int i = 0; i < listName.size(); i++) {
                System.out.println((i + 1) + ":" + listName.get(i));
            }
            System.out.print("You are looking for friends in the directory:");
            int find = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < phoneList.size(); i++) {
                if (phoneList.get(i).getName().equals(listName.get(find - 1))) {
                    System.out.println("Phone number of the person you want to find:" + phoneList.get(i).getPhone());
                    break;
                }
            }
        }
    }

    @Override
    void sort() {
        Collections.sort(phoneList);
        System.out.println("Sorting done");
    }

    @Override
    void shows() {
        System.out.println("<-----------------------------Phone Book---------------------------->");
        System.out.printf("\t%10s %15s %30s \n\n", "STT", "Full name", "Phone number");
        String b = " ";
        for (int i = 0; i < phoneList.size(); i++) {
            System.out.printf("\t %8d %6s %-27s %1s \n", (i + 1), " ", phoneList.get(i).getName(), phoneList.get(i).getPhone());
        }

    }

    @Override
    void save() {
        try {
            FileOutputStream fos = new FileOutputStream("file_danh_ba.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(phoneList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Saved.");
    }
}
