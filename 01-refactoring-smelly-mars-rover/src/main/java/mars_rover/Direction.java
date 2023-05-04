package mars_rover;

public enum Direction {
    N, S, W, E;

    public static Direction create(final String directionEncoding) {
        if(directionEncoding.equals("S"))
            return S;
        else if(directionEncoding.equals("W"))
            return W;
        else if(directionEncoding.equals("E"))
            return E;
        return N;
    }
}
