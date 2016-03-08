package chess;

import static java.lang.StrictMath.abs;

/**
 * Created by Egor P on 01.03.2015.
 */
public class Pawn extends ChessFigure {
    public boolean isRightMove(String from, String to)
    {
        if (from.equals(to))
            return false;
        if (from.charAt(0) != to.charAt(0))
            return false;
        if (abs(to.charAt(1)-from.charAt(1))==1)
            return true;
        return false;
    }
}
