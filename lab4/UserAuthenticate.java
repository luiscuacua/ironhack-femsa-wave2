package lab4;

/**
 * Clase que se encarga de autenticar a un usuario
 * ESCENARIO 1: Autenticación de usuario
 */
public class UserAuthentication {

    public UserAuthentication(){

    }

    /*
     * Otra forma correcta es siempre pasar los parametros sencibles en hash 
     * ejemplo:
     * authenticate(sha256(user), sha256(password))
     * user: 21232f297a57a5a743894a0e4a801fc3
     * password: 5f4dcc3b5aa765d61d8327deb882cf99
     */
    public boolean authenticate(String userEncript , String passwordEncript) {


        if(decrypt(usuario.equals(getUserBd())) && decrypt(password.equals(getPasswordBd()))) {
            return true;
        }
        return false;
    }

    //suponiendo que este metodo hace una consulta a la base de datos
    private User getUserBd( String user, String password) {

        /* 
         * es recomendable usar un framework de persistencia ya que este
         * ayuda a evitar el sqlInjection y otros problemas de seguridad
         */
        
        /**
         * Cuando se crea ub query con un string concatenado, se puede inyectar codigo sql
         * ejemplo: Select * from users where user = 'admin' or 1=1' and password = 'password'
         */

        /**
         * Forma correcta de hacerlo
         * String query = "Select * from users where user = ? and password = ?";
         */

        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE user = ? and password = ?");
        pstmt.setString(1, user);
        pstmt.setString(1, password);
        ResultSet results = pstmt.executeQuery();

        return new User(results.getUser(), results.getPass());
    }
}
