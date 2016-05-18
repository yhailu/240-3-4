package abstractclass;

/**
 * Created by yesuserahailu on 11/9/15.
 */
public class CannotRetrieveException extends Exception {
    public CannotRetrieveException(String error){
        super("\n" + error);
    }
}
