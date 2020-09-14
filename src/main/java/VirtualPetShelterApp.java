import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApp {
    Scanner input = new Scanner(System.in);
    Scanner reply = new Scanner(System.in);
    Scanner reply1 = new Scanner(System.in);

    VirtualPetShelter shelter = new VirtualPetShelter();
    String userName;
    int tickCounter = 0;
    int randomGuestGivingPet = (int) (Math.random() * 5) + 2;
    int randomGuestAdoptingPet = randomGuestGivingPet + 1;


    public static void exitGame() {
        System.out.println("Thanks for playing. See ya!");
        System.exit(0);
    }

    public static String capitalize(String name) {
        String firstLetter = name.substring(0, 1);
        String remainder = name.substring(1);

        String caps = firstLetter.toUpperCase();
        String remainderToLower = remainder.toLowerCase();
        String capitalizedName = caps + remainderToLower;

        return capitalizedName;
    }

    public static String possessiveVersion(String name) {
        String possessive = "";
        if (name.charAt(name.length() - 1) != 's') {
            return name + "'s";
        } else {
            return name + "'";
        }
    }

    public boolean yesOrNoVerify() {
        input = new Scanner(System.in);
        while (true) {
            String reply = (input.nextLine().toLowerCase());
            if (reply.equals("yes")) {
                return true;
            } else if (reply.toLowerCase().equals("no")) {
                return false;
            } else {
                System.out.println("I didn't quite catch that. 'yes' or 'no' please.");
            }
        }
    }

    public int validInteger(int range) {
        int response = 0;
        while (!input.hasNextInt()) {
            System.out.println("come on now...just a number.");
            input = new Scanner(System.in);
        }
        response = input.nextInt();

        while (response > range) {
            System.out.println("nice try. That's not an option I can deal with.");
            response = input.nextInt();
        }
        return response;
    }

    static void displayTime(int tickCounter) {
        String[] times = new String[]{"9:00", "10:00", "11:00", "noon", "1:00", "2:00", "3:00", "4:00", "5:00"};
        System.out.println("                                " + times[tickCounter]);
    }

    public void feedPet(String name) {
        //input = new Scanner(System.in);
        System.out.println("What would you like to feed " + name + "?\n" +
                "1. dry food\n" +
                "2. wet food\n" +
                "3. a treat\n" +
                "Be careful though. These pets tend to barf when they overeat.");
        int option = validInteger(3);
        if (option == 0) {
            exitGame();
        }
        System.out.println("How many servings would you like to give?");
        int servings = validInteger(10);

        if (option == 1) {
            shelter.feedDryFood(name, servings);
        } else if (option == 2) {
            shelter.feedWetFood(name, servings);
        } else if (option == 3) {
            shelter.feedTreat(name, servings);
        } else if (option == 0) {
            exitGame();
        }
    }

    public void mainMenuDisplay() {
        System.out.println();
        System.out.println("Hit 1 to feed all the pets.\n" +
                "    2 to give them all water. \n" +
                "    3 to work with a specific pet.\n" +
                "    0 will exit the game.");
    }

    public void specificPetOptionsMenu(String name) {
        System.out.println();
        System.out.println("You can hit... \n" +
                "      1 to feed\n" +
                "      2 to fill " + possessiveVersion(name) + " water bowl.\n" +
                "      3 to pet " + name + ".\n" +
                "      4 to play with a toy\n" +
                "      0 to exit");
    }

    public void go() {

        //adding initial pets in the shelter

        VirtualPet sandy = new VirtualPet("Sandy", 11, "loves to gnaw hair");
        VirtualPet zed = new VirtualPet("Zed", 1, "is a siamese athlete");
        VirtualPet zara = new VirtualPet("Zara", 4, "is Zed's girlfriend");
        VirtualPet pinot = new VirtualPet("Pinot", 25, "he's one old cat");
        VirtualPet juniper = new VirtualPet("Juniper", 8, "sits around", 40, 13, 11, 26, 17);
        VirtualPet scooter = new VirtualPet("Scooter", 1, "is quite playful", 30, 20, 5, 0, 20);
        shelter.add(sandy);
        shelter.add(zed);
        shelter.add(zara);
        shelter.add(pinot);
        shelter.add(juniper);
        shelter.add(scooter);

        System.out.println();
        System.out.println("Welcome! I'm glad you're here. We have some unfortunate cases and they need your help.\n" +
                "To begin, I'll need your name please.");

        String name = input.nextLine();
        userName = capitalize(name);

        System.out.println("Thank you for joining us, " + userName + ". I will need for you to manage things here.\n" +
                "Our animals are sometimes anxious, maybe feel bored and need to be stimulated, and of course, like the rest of us,\n" +
                "they get hungry, thirsty, and need to sleep. Sometimes, you might have someone come in either looking to adopt, \n" +
                "or looking to drop off an animal. Are you ready? If so, I'll introduce you to the animals. type 'yes' or 'no'.");

        if (yesOrNoVerify()) {
            System.out.println();
        } else {
            exitGame();
        }

        shelter.displayPets("nameAndDescript");
        System.out.println();
        System.out.println("Above all things, don't let any pet's general assessment get too high. You might need to check out a pet and see\n" +
                "what you can do specifically if that number gets too high. I'll return this evening at 5:00, at which point we'll see how you did.\n" +
                "Ready? 'yes' or 'no'");

        if (yesOrNoVerify()) {
            System.out.println("Great. Let's get started...");
            System.out.println();
        } else {
            exitGame();
        }

        //main loop here

        while (tickCounter <= 8) {

            int choice = 0;
            shelter.displayPets("full");
            System.out.println("random guest is ...." + randomGuestGivingPet);
            displayTime(tickCounter);
            mainMenuDisplay();
            choice = validInteger(3);
            if (choice == 0) {
                exitGame();
            }
            if (choice == 1) {
                System.out.println("How many servings for each pet?");
                choice = validInteger(10);
                shelter.feedAll(choice);
            } else if (choice == 2) {
                System.out.println("How many cups of water in each bowl?");
                choice = validInteger(3);
                shelter.waterAll(choice);
            } else if (choice == 3) {
                System.out.println("Which pet needs your help? Please enter a name.");
                String chosen = reply.nextLine();
                String chosenPet = capitalize(chosen);

                while (!shelter.confirmName(chosenPet)) {
                    System.out.println("please check your spelling.");
                    chosen = input.nextLine();
                    chosenPet = capitalize(chosen);
                }

                System.out.println("NAME       Assessment    Hunger   Thirst   Anxiety   Fatigue   Need to hunt");
                System.out.println(shelter.pets.get(chosenPet).petToString());
                System.out.println();
                System.out.println("What would you like to do with " + chosenPet + "?");

                specificPetOptionsMenu(chosenPet);
                choice = validInteger(4);

                if (choice == 0) {
                    exitGame();
                } else if (choice == 1) {
                    feedPet(chosenPet);
                } else if (choice == 2) {
                    shelter.waterSpecificPet(chosenPet);
                } else if (choice == 3) {
                    shelter.strokePet(chosenPet);
                } else if (choice == 4) {
                    shelter.playWith(chosenPet);
                }
            }

            if (randomGuestGivingPet == tickCounter){
                System.out.println("You have a visitor! It looks Somebody has a pet to give you. I'll need your help to enter\n"+
                " a few details about your new guest please. Let's start with a good name....?");
                String preName = reply.nextLine();
                String newName = capitalize(preName);

                while (shelter.pets.containsKey(newName)){
                    System.out.println("sorry! We've got one of those. Try a different name.");
                    preName = reply.nextLine();
                    newName = capitalize(preName);
                }

                System.out.println("Perfect- and now that you've met, give me a description of your new pet.");
                String newDescription = reply1.nextLine();
                System.out.println("Finally, can I have a guess as to your new pet's age?");
                choice = validInteger(25);

                VirtualPet newPet = new VirtualPet(newName, choice, newDescription);
                shelter.add(newPet);
            }

            if (randomGuestAdoptingPet == tickCounter){
                System.out.println("Sorry to keep you busy! You have another visitor. This time your visitor wants to adopt a pet.\n" +
                        "We will first display everyone here, and then I'll need your guest to enter the name of his or her choice.");
                shelter.displayPets("nameAndDescript");
                String preName = reply1.nextLine();
                String capitalizedName = capitalize(preName);
                while (!shelter.confirmName(capitalizedName)){
                    System.out.println("Try again. Check your spelling.");
                    preName = reply1.nextLine();
                    capitalizedName = capitalize(preName);
                }
                System.out.println("Thank your visitor. Say good bye to " + capitalizedName + ".");
                shelter.adopt(capitalizedName);
            }

            tickCounter++;
            shelter.tick();

        } // end of main loop



    }


    public static void main(String[] args) {
        VirtualPetShelterApp app = new VirtualPetShelterApp();
        app.go();

    }
}
