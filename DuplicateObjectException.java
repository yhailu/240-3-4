package abstractclass;

/**
 * Created by yesuserahailu on 11/9/15.
 */
public class DuplicateObjectException extends Exception{
    public DuplicateObjectException(String error){
        super("\n" + error);
    }
}
