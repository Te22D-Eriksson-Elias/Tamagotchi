import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tamgocthi {
    private int hunger;
    private int boredom;
    private ArrayList<String> Words = new ArrayList<>();
    private Boolean isAlive = true;
    private Random Generator = new Random();
    String name;

    public Tamgocthi(String incomingName, int incomingHunger, int incomingBoredom) {
        name = incomingName;
        hunger = incomingHunger;
        boredom = incomingBoredom;
    }

    public void tick() {
        hunger++;
        boredom++;
        if (boredom > 10 || hunger > 10) {
            isAlive = false;
            System.out.println(name + " is not alive");
        }
    }

    public  void feed(){
        hunger = hunger - Generator.nextInt(10);
    }

    public  void speak(){
        int index = Generator.nextInt(Words.size());
        System.out.println(name + " says " + Words.get(index));
        reduceBoredom();
    }

    public  void teach(String word){
        Words.add(word);
        System.out.println(name + " learned " + word);
    }

    public  void printStats(){
        System.out.println("Hunger: " + hunger);
        System.out.println("Boredom: " + boredom);
    }

    public Boolean getAlive(){
        return isAlive;
    }

    private  void reduceBoredom(){
        boredom = boredom - Generator.nextInt(10);
    }


     void loop(){
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        while (getAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Tick.startTick();

            menu(name);
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("Skriv ut vad du önskar att lära " + name + ":");
                    teach(scan.nextLine());
                    tick();
                    break;
                case "2":
                    System.out.println("Säg något till " + name);
                    scan.nextLine();
                    speak();
                    tick();
                    break;
                case "3":
                    feed();
                    tick();
                    break;
                case "4":
                    printStats();
                    tick();
                    break;
                    case "5":
                        return;
                default:
                    tick();
                    break;
            }
        }
    }

     void menu(String name){
        System.out.println("1.Lär " + name + " ett nytt ord!");
        System.out.println("2.Beordra " + name + " att säga något");
        System.out.println("3.Mata " + name + " så han inte svälter");
        System.out.println("4.Visa alla stats för " + name);
        System.out.println("5. Avsluta spelet");
        System.out.println("Gör inget och titta på " + name);
    }
}
