package chess;

import static java.lang.StrictMath.abs;

/**
 * Created by Egor P on 01.03.2015.
 */
public class King extends Pawn {
    public boolean isRightMove(String from, String to) {
        if (super.isRightMove(from, to))
            return true;
        if (abs(from.charAt(0)-to.charAt(0))== 1 & abs(from.charAt(1)-to.charAt(1)) == 1)
            return true;
        if (abs(from.charAt(0)-to.charAt(0))==1 & from.charAt(1)==to.charAt(1))
            return true;
        return false;
    }
}
