package casestudymodun2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    PhoneBookFunctions phoneBookFunctions = new PhoneBookFunctions();
    Scanner scanner = new Scanner(System.in);
    private String enterName;
    private String enterPhoneNumber;
    private String nowPhoneNumber;

    public void menu() {
        do {
            try {
                System.out.println("                                                Please select menu:");
                System.out.println("<------------------------------------------------------------------------------------------------------------------------->");
                System.out.println("| 1:Insert Phone        |        2:Remove Phone           |          3:Update Phone         |          4:Search Phone    |");
                System.out.println("| 5:Sort                |        6:Shows                  |          7:Save                 |          8:Exit            |");
                System.out.println("<------------------------------------------------------------------------------------------------------------------------->");

                System.out.print("You choose:");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        boolean validName=false;
                        do {
                            System.out.print("Enter name:");
                            enterName = scanner.nextLine();
                            String regexName = "^[a-zA-Z\\sàáạã_-]{3,25}$";
                            Pattern pattern = Pattern.compile(regexName);
                            Matcher matcher = pattern.matcher(enterName);
                            if (matcher.find()) {
                                validName = true;
                                break;
                            } else {
                                System.out.println("Invalid name!");
                            }
                        } while (!validName);
                        boolean validNumber=false;
                        do {
                            System.out.print("\nEnter phone number:");
                            enterPhoneNumber = scanner.nextLine();
                            String regexPhoneNumber = "^\\+?(?:0|84)(?:\\d){9}$";

                            Pattern pattern = Pattern.compile(regexPhoneNumber);
                            Matcher matcher = pattern.matcher(enterPhoneNumber);
                            if (matcher.find()) {
                                validNumber=true;
                                break;
                            } else {
                                System.out.println("Invalid phone number!");
                            }
                        } while (!validNumber);
                        phoneBookFunctions.insertPhone(enterName, enterPhoneNumber);
                        break;
                    case 2:
                        System.out.print("Enter the name of the person you want to remove:");
                        String deleteName = scanner.nextLine();
                        phoneBookFunctions.removePhone(deleteName);
                        break;
                    case 3:
                        System.out.print("Whose phone number do you want to fix:");
                        String name1 = scanner.nextLine();
                        boolean validNumberNew=false;
                        do {
                            System.out.print("\nNew phone number:");
                            nowPhoneNumber = scanner.nextLine();
                            String regexPhoneNumberNew = "^\\+?(?:0|84)(?:\\d){9}$";

                            Pattern pattern = Pattern.compile(regexPhoneNumberNew);
                            Matcher matcher = pattern.matcher(nowPhoneNumber);
                            if (matcher.find()) {
                                validNumberNew=true;
                                break;
                            } else {
                                System.out.println("Invalid phone number!");
                            }
                        } while (!validNumberNew);
                        phoneBookFunctions.updatePhone(name1, nowPhoneNumber);
                        break;
                    case 4:
                        System.out.print("Enter the name of the person you want to find:");
                        String name2 = scanner.nextLine();
                        phoneBookFunctions.searchPhone(name2);
                        break;
                    case 5:
                        phoneBookFunctions.sort();
                        break;
                    case 6:
                        System.out.println(phoneBookFunctions.shows());
                        break;
                    case 7:
                        phoneBookFunctions.save();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Retype!");
                }
            } catch (Exception e) {
                System.out.println("Retype!");
            }
        } while (true);
    }
}