import java.util.Scanner;

public class Main {
    
    public Main(){
    }

    public void promptEnter(Scanner scanner){
        scanner.nextLine();
    }

    public void promptFirstEnter(Scanner scanner){
        System.out.println("Press ENTER to Continue...");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        Main main = new Main();
        //main.promptEnter();
    }
}
