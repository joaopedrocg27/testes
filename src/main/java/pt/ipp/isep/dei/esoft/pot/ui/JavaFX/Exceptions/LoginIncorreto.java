package pt.ipp.isep.dei.esoft.pot.ui.JavaFX.Exceptions;

public class LoginIncorreto extends Exception {

    public LoginIncorreto(String s, Throwable throwable) {
        super(s, throwable);
    }

    public LoginIncorreto(String s) {
        super(s);
    }

    public LoginIncorreto() {
    }
}
