
/*
 * Definicion de una clase en especifico para el tema de autenticacion
 * como responsabilidad unica y validar los diferentes casos de esta funcionalidad
 */
class UserAuthenticationTest {

    private UserAuthentication userAuthentication;

    /*
     * Metodo para inicializar lis datos que se utilizaran en los test
     */
    @BeforeEach
    void setUp() {
        userAuthentication = new UserAuthentication();
    }

    //crear un solo test para valdiar una autenticacion correcta
    @Test
    void testSuccessfulAuthentication() {
        boolean result = userAuthentication.authenticate("validUser", "validPassword");
        assertTrue(result, "La autenticación debe tener éxito para credenciales válidas");
    }

    //crear un solo test para el caso de usuario incorrecto
    @Test
    void testFailedAuthentication() {
        boolean result = userAuthentication.authenticate("invalidUser", "invalidPassword");
        assertFalse(result, "La autenticación debería fallar si las credenciales no son válidas");
    }

    //un test para validar el usuario vacio
    @Test
    void testEmptyUsername() {
        boolean result = userAuthentication.authenticate("", "somePassword");
        assertFalse(result, "La autenticación debería fallar si el nombre de usuario está vacío");
    }

    //un test para validar el pass vacio
    @Test
    void testEmptyPassword() {
        boolean result = userAuthentication.authenticate("someUser", "");
        assertFalse(result, "La autenticación debería fallar si el pass está vacío");
    }

    //un test para validar el usuario nulo
    @Test
    void testNullUsername() {
        boolean result = userAuthentication.authenticate(null, "somePassword");
        assertFalse(result, "La autenticación debería fallar si el usuario es nulo");
    }

    //un test para validar el pass nulo
    @Test
    void testNullPassword() {
        boolean result = userAuthentication.authenticate("someUser", null);
        assertFalse(result, "La autenticación debería fallar si el pass es nulo");
    }
}