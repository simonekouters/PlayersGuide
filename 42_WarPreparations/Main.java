public class Main {
    public static void main(String[] args) {
		
        Sword sword1 = new Sword(Material.IRON, Gemstone.NONE, 75, 15);
        Sword sword2 = Sword.withMaterial(Material.BRONZE);
        Sword sword3 = Sword.withMaterial(Material.BINARIUM);

        System.out.println(sword1);
        System.out.println(sword2);
        System.out.println(sword3);
    }
}