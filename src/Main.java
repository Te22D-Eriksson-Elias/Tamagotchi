import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Döp din tamagotchi!");
        Scanner myScanner = new Scanner(System.in);
        String name = myScanner.nextLine();
        Tamgocthi Tamagotchi = new Tamgocthi(name, 10, 10);
        System.out.println("Din tamagotchi heter: " + Tamagotchi.name);
        
        Tamagotchi.loop();
    }
}