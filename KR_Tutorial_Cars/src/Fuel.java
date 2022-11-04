public enum Fuel {
    DIZEL,BENZIN;

    @Override
    public String toString() {
        if(this == DIZEL)
            return "dizel";
        return "benzin";
    }
    public Fuel toType(String s)
    {
        Fuel f = switch (s) {
            case "benzin" -> BENZIN;
            case "dizel" -> DIZEL;
            default -> throw new IllegalArgumentException();
        };
        return f;
    }
}
