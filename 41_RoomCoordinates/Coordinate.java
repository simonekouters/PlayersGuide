public record Coordinate(int row, int column) {
    public static boolean compareCoordinates(Coordinate coordinate, Coordinate coordinate1) {
        if (((coordinate.column + 1) == coordinate1.column || (coordinate.column - 1) == coordinate1.column) &&
        coordinate.row == coordinate1.row) {
            return true;
        }
        if (((coordinate.row + 1) == coordinate1.row || (coordinate.row - 1) == coordinate1.row) &&
                coordinate.column == coordinate1.column) {
            return true;
        }
        return false;
    }
}


