public enum Behaviour {
    GOOD,BAD;

    @Override
    public String toString() {
        if(this == GOOD)
            return "Good";
        else return "Bad";
    }
    public String toType(Behaviour b)
    {
        switch (b)
        {
            case BAD:return "Bas";
            case GOOD:return "Good";
            default:throw new IllegalArgumentException();
        }
    }
}
