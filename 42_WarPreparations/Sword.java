public record Sword(Material material, Gemstone gemstone, int length, int crossguardWidth) {
    public static Sword withMaterial(Material material) {
        Gemstone BASIC_GEMSTONE = Gemstone.NONE;
        int BASIC_LENGTH = 75;
        int BASIC_CROSSGUARDWITH = 15;
        
        return new Sword(material, BASIC_GEMSTONE, BASIC_LENGTH, BASIC_CROSSGUARDWITH);
    }
    
    
    @Override
    public String toString() {
    StringBuilder bldr = new StringBuilder();
        if (this.gemstone.equals(Gemstone.NONE)) {
            bldr.append("plain ");
            bldr.append(material.name().toLowerCase());
            bldr.append(" sword of ");
            bldr.append(length);
            bldr.append(" centimeters long, and crossguard width of ");
            bldr.append(crossguardWidth);
            bldr.append(" cm");
        } else {
            bldr.append(material.name().toLowerCase());
            bldr.append(" sword of ");
            bldr.append(length);
            bldr.append(" centimeters long, a crossguard width of ");
            bldr.append(crossguardWidth);
            bldr.append(" cm, ");
            bldr.append("and an embedded ");
            bldr.append(gemstone.name().toLowerCase());
        }
        return bldr.toString();
    }
}
