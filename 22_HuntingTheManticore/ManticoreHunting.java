import java.util.Scanner;

public class ManticoreHunting {
    private int distance;
    private int damage;
    
    private Scanner scanner;
    private int round;
    private int cityHealth;
    private int manticoreHealth;
    

    public ManticoreHunting() {
        this.scanner = new Scanner(System.in);
        this.round = 1;
        this.cityHealth = 15;
        this.manticoreHealth = 10;
    }
    
    
    public int getDistance() {
        return this.distance;
    }
    
    
    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    
    public void nextRound() {
        this.round++;
    }
    
    
    public void updateManticoreHealth() {
        this.manticoreHealth -= calculateDamage(this.round);
    }
    
    
    public void updateCityHealth() {
        this.cityHealth--;
    }
    
    
    public void displayStatus() {
        System.out.println("STATUS: Round: " + ANSI.CYAN + this.round + ANSI.RESET +  " City: " + ANSI.BLUE + cityHealth + "/15 " + ANSI.RESET +
                "Manticore: " + ANSI.MAGENTA + manticoreHealth + "/10" + ANSI.RESET +"\n" + "The cannon is expected to deal " + ANSI.RED +
                calculateDamage(this.round) + ANSI.RESET + " damage this round");
    }
    
    
    public boolean isDestroyed() {
        while (true) {
            if (manticoreHealth <= 0) {
                System.out.println(ANSI.GREEN + "The Manticore has been destroyed! The city of Consolas has been saved!" + ANSI.RESET);
                return true;
            } else if (cityHealth <= 0) {
                System.out.println(ANSI.RED + "The city of Consolas has been destroyed. You failed to save the city.");
                return true;
            } else {
                return false;
            }
        }
    }
    
    
    public int calculateDamage(int round) {
        if (round % 5 == 0 && round % 3 == 0) {
            this.damage = 10;
        } else if (round % 5 == 0) {
            this.damage = 3;
        } else if (round % 3 == 0) {
            this.damage = 3;
        } else {
            this.damage = 1;
        }
        return this.damage;
    }
}
