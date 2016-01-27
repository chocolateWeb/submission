
package Exceptions;
import javax.ejb.ApplicationException;

/**
 *
 * @author Hariharan
 */
@ApplicationException(rollback = true)
public class PlayerException extends Exception {
    
    public PlayerException(){
        
        super();
    }

    public PlayerException(String message) {
        super(message);
    }
    
    
}
