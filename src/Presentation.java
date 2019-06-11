import java.util.Scanner;

public class Presentation {
    public static void main(String[] args) {
        choosePlayer();
        System.out.println("Use w/s/a/d to move");
        System.out.println("Use e for special ability or q to pass.");
        //TODO Initial game

    }


            public static void choosePlayer () {
            Scanner reader = new Scanner(System.in);
            System.out.println("Welcome to Dungeon and Dragons");
            System.out.println("Please select a player:");
            System.out.println("1. Jon Snow" + "  " + "Health: 300" + "  " + "Attack damage: 30" + "  " + "Defense: 4" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "Ability cooldown: 6" + "Remaining: 0");
            System.out.println("2. The Hound" + "  " + "Health: 400" + "  " + "Attack damage: 20" + "  " + "Defense: 6" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "Ability cooldown: 4" + "Remaining: 0");
            System.out.println("3. Melisandre" + "  " + "Health: 160" + "  " + "Attack damage: 10" + "  " + "Defense: 1" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "SpellPower: 15" + "Mana: 75/300");
            System.out.println("4. Thoros of Myr" + "  " + "Health: 250" + "  " + "Attack damage: 25" + "  " + "Defense: 3" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "SpellPower: 20" + "Mana: 37/300");
            System.out.println("5. Arya Stark" + "  " + "Health: 150" + "  " + "Attack damage: 40" + "  " + "Defense: 2" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "Energy: 100/100");
            System.out.println("6. Bronn" + "  " + "Health: 250" + "  " + "Attack damage: 35" + "  " + "Defense: 3" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "Energy: 100/100");
            int i = reader.nextInt();
            if (i == 1) {
                Controller.choosePlayer(1);
                System.out.println("You have selected" + "Jon Snow" + "  " + "Health: 300" + "  " + "Attack damage: 30" + "  " + "Defense: 4" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "Ability cooldown: 6" + "Remaining: 0");
            }
             if (i == 2) {
                 Controller.choosePlayer(2);
                System.out.println("You have selected" + "The Hound" + "  " + "Health: 400" + "  " + "Attack damage: 20" + "  " + "Defense: 6" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "Ability cooldown: 4" + "Remaining: 0");
            }
             if (i == 3) {
                 Controller.choosePlayer(3);
                System.out.println("You have selected" + "Melisandre" + "  " + "Health: 160" + "  " + "Attack damage: 10" + "  " + "Defense: 1" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "SpellPower: 15" + "Mana: 75/300");
            }
             if (i == 4) {
                 Controller.choosePlayer(4);
                System.out.println("You have selected" + "Thoros of Myr" + "  " + "Health: 250" + "  " + "Attack damage: 25" + "  " + "Defense: 3" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "SpellPower: 20" + "Mana: 37/300");
            }
             if (i == 5) {
                 Controller.choosePlayer(5);
                System.out.println("You have selected" + "Arya Stark" + "  " + "Health: 150" + "  " + "Attack damage: 40" + "  " + "Defense: 2" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "Energy: 100/100");
            }
             if (i == 6) {
                 Controller.choosePlayer(6);
                System.out.println("You have selected" + "Bronn" + "  " + "Health: 250" + "  " + "Attack damage: 35" + "  " + "Defense: 3" + "\n" + "Level: 1" + "  " + "Experience: 0/50" + "  " + "Energy: 100/100");
            }
            else {
                System.out.println("Plaese choose a number between 1 - 6");
                choosePlayer();
            }
        }
    }


