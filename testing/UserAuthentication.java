package testing;

public class UserAuthentication {

    public UserAuthentication(){

    }
    public boolean authenticate(String usuario, String password) {
        //validar usuario en BD o api
        if(usuario.equals(getUserBd()) && password.equals(getPasswordBd())) {
            return true;
        }

        return false;
 
    }

    private Object getPasswordBd() {
        return "usuario";
    }

    private Object getUserBd() {
        return "password";
    }
}
