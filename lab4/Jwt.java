package lab4;

/**
 * Clase que se encarga del token jwt
 * ESCENARIO 2: Esquema de autenticación JWT
 */
public class Jwt {
    
    public Jwt(){
        
    }

    public String generateJwtToken(User user) {


        if(UserAuthentication.authenticate(user.getUser(), user.getPassword()) ){
            long currentTimeMillis = System.currentTimeMillis();
            Date now = new Date(currentTimeMillis);

            
            /**
             * se recomienda siempre usar un tiempo de expiración en el token
             * ya que si no el token por default siempre será valido
             */

            Date expiryDate = new Date(currentTimeMillis + 3600000);

            //no se recomienda usar datos sensibles en el token, como contraseñas
            return Jwts.builder()
                    .setSubject(user.getUser())
                    .setIssuedAt(now)
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY) //se recomienda usar un secretKey e indicar el algoritmo de encriptación
                    .compact();
        }

        return throw new Exception("User not authenticated");
    }

}
