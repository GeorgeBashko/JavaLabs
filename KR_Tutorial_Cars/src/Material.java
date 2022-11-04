public enum Material {
    COTTON,LEATHER;

    @Override
    public String toString() {
        if(this == COTTON)
            return "cotton";
        return "leather";
    }
    public Material toType(String s)
    {
        Material m = switch (s) {
            case "cotton" -> COTTON;
            case "leather" -> LEATHER;
            default -> throw new IllegalArgumentException();
        };
        return m;
    }
}
