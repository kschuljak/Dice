package Backpack.Shop;

import Backpack.Coinpurse.Coinpurse;
import Backpack.Gear.Weapons.Weapons;

import java.time.Year;
import java.util.Scanner;

public class ArmoryApplication {

    public void run(){

        Scanner input = new Scanner(System.in);
        Armory armory = new Armory();
        Coinpurse coinpurse = new Coinpurse(26, 12, 8, 2);

        printHeader();

        while(true) {

            printDoNext();

            int choice = Integer.parseInt(input.nextLine().strip());
            System.out.println();

            try {
                if (choice == 1)
                {
                    printBuyWeaponSelectionIntro();
                    int weaponCategory = Integer.parseInt(input.nextLine().strip());

                    System.out.println();

                    if (weaponCategory == 1) armory.printSimpleMeleeWeapons();
                    else if (weaponCategory == 2) armory.printSimpleRangedWeapons();
                    else if (weaponCategory == 3) armory.printMartialMeleeWeapons();
                    else if (weaponCategory == 4) armory.printMartialRangedWeapons();
                    else if (weaponCategory == 5) armory.printGear();
                    else System.out.println("You have not made a valid choice.");
                    System.out.println();
                    System.out.print("Select an option: ");

                    int weaponPurchase = Integer.parseInt(input.nextLine().strip());

                    int cost = printSelect(weaponCategory, weaponPurchase, armory, coinpurse);
                    System.out.println();
                    String confirmChoice = input.nextLine().strip();

                    System.out.println();

                    if (confirmChoice.equals("Y")) {

                        boolean successful = coinpurse.spendMoney(cost);
                        if (successful) {
                            armory.addToShopFunds(cost);
                            System.out.println("Transaction complete!");
                            System.out.println("-------------------------------------");
                        } else {
                            System.out.println();
                            System.out.println("Transaction failed.");
                            System.out.println("-------------------------------------");
                        }
                    } else if (confirmChoice.equals("N")) {
                        System.out.println("You have canceled the transaction.");
                    } else System.out.print("You have not made a valid choice.");


                }
                else if (choice == 2)
                {
                    printSellWeaponSelectionIntro();
                }
                else if (choice == 3) break;

                else throw new RuntimeException("You have not made a valid choice.");

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Please try again.");
            }

        }

    }

    private void printHeader() {
        System.out.println();
        System.out.println("*************************************");
        System.out.println("******  WELCOME TO THE ARMORY  ******");
        System.out.println("*************************************");
        System.out.println();
    }

    private void printDoNext() {
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("What would you like to do next? ");
        System.out.println();
        System.out.println("1) Buy");
        System.out.println("2) Sell");
        System.out.println("3) Exit ");
        System.out.println();
        System.out.print("Select an option: ");
    }

    private void printBuyWeaponSelectionIntro() {
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("What would you like to buy?");
        System.out.println();
        System.out.println("1) Simple Melee Weapon");
        System.out.println("2) Simple Ranged Weapon");
        System.out.println("3) Martial Melee Weapon ");
        System.out.println("4) Martial Ranged Weapon");
        System.out.println("5) See All");
        System.out.println();
        System.out.print("Select an option: ");
    }

    private void printConfirmSelection(Weapons item){
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("One " + item.getName() + " is " + item.getCost() + ".");
        System.out.print("Would you like to purchase this item? (Y/N): ");
    }

    private int printSelect(int weaponCategory, int weaponChoice, Armory armory, Coinpurse coinpurse) {
        String[] category;
        if (weaponCategory == 1) category = armory.getGearInShopSimpleMeleeWeapons();
        else if (weaponCategory == 2) category = armory.getGearInShopSimpleRangedWeapons();
        else if (weaponCategory == 3) category = armory.getGearInShopMartialMeleeWeapons();
        else if (weaponCategory == 4) category = armory.getGearInShopMartialRangedWeapons();
        else if (weaponCategory == 5) category = armory.getGearInShop();
        else return 0;
        Weapons item = armory.getSelection(weaponChoice, category);
        printConfirmSelection(item);
        String cost = item.getCost();
        String[] split = cost.split(" ");
        int costInCopper = coinpurse.getItemCostInCopper(split[0], split[1]);
        return costInCopper;
    }

    private void printSellWeaponSelectionIntro() {
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("What would you like to sell?");
        System.out.println();
    }

}
