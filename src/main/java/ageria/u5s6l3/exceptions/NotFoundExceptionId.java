package ageria.u5s6l3.exceptions;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotFoundExceptionId extends RuntimeException{
    public NotFoundExceptionId(UUID id){
        super("L'oggetto con id: " + id + " non e' stato trovato");
    }


}
