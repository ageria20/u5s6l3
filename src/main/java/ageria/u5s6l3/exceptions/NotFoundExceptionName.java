package ageria.u5s6l3.exceptions;

public class NotFoundExceptionName extends RuntimeException {
    public NotFoundExceptionName(String name) {
        super("L'utente' " + name + " non è stato trovato");
    }
}