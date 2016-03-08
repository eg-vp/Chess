package chess;

/**
 * Created by Egor P on 01.03.2015.
 */
public class Castle extends Pawn {
    public boolean isRightMove(String from, String to) {
        if (super.isRightMove(from, to))
            return true;
        if (from.charAt(0)!=to.charAt(0) & from.charAt(1)!=to.charAt(1))
            return false;
        if (from.charAt(0)==to.charAt(0) & from.charAt(1)!=to.charAt(1))
            return true;
        if (from.charAt(0)!=to.charAt(0) & from.charAt(1)==to.charAt(1))
            return true;
        return false;
    }
}
