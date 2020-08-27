package casestudymodun2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class PhoneBookFunctions extends Phone {
    static ArrayList<PhoneBookProperties> phoneList = new ArrayList();

    @Override
    void insertPhone(String name, String phone) {
        phoneList.add(new PhoneBookProperties(name, phone));
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
        boolean isSearch = false;
        for (PhoneBookProperties a : phoneList) {
            if (a.getName().equals(name)) {
                System.out.println("Phone number:" + a.getPhone());
                isSearch = true;
                break;
            }
        }
        if (!isSearch) {
            System.out.println("This person is not in the contact list.");
        }
    }

    @Override
    void sort() {
        Collections.sort(phoneList);
        System.out.println("Sorting done");
    }

    @Override
    String shows() {
        System.out.println("<-----------------------------Phone Book---------------------------->");
        String b = " ";
        for (int i = 0; i < phoneList.size(); i++) {
            b += "\t " + (i + 1) + "  | " + phoneList.get(i).getName() + " : " +
                    phoneList.get(i).getPhone() + "\n";
        }
        return b;
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
