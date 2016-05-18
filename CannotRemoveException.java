package abstractclass;

/**
 * Created by yesuserahailu on 11/9/15.
 */
public class CannotRemoveException extends Exception {
    public CannotRemoveException(String error){
        super("\n" + error);
    }
}
