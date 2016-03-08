package chess;

import static java.lang.StrictMath.abs;

/**
 * Created by Egor P on 01.03.2015.
 */
public class Hoss extends ChessFigure {
    public boolean isRightMove(String from, String to) {
        if (from.equals(to))
            return false;
        if (abs(from.charAt(0)-to.charAt(0))==2 & abs(from.charAt(1)-to.charAt(1))==1)
            return true;
        if (abs(from.charAt(1)-to.charAt(1))==2 & abs(from.charAt(0)-to.charAt(0))==1)
            return true;
        return false;
    }
}
