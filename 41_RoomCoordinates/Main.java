public class Main {
    public static void main(String[] args) {
        Coordinate coordinate1 = new Coordinate(1, 6);
        Coordinate coordinate2 = new Coordinate(2, 6);
        Coordinate coordinate3 = new Coordinate(2, 7);
        
        System.out.println(Coordinate.compareCoordinates(coordinate1, coordinate2)); //true
        
        System.out.println(Coordinate.compareCoordinates(coordinate1, coordinate3)); //false
    }
}