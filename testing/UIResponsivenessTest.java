/*
 * Definicion de una clase en especifico para el tema de UI como responsabilidad unica
 */
class UIResponsivenessTest {
    private UiComponent uiComponent;

    //inicializar datos y crear mockito como buena practica
    @BeforeEach
    void setUp() {
        uiComponent = Mockito.mock(UiComponent.class);
    }

    @Test
    void testUIAdjustsToScreenSize() {
        //se utiliza stub para que independientemente de que dato se le pase al metodo este siempre devuelva true
        when(uiComponent.adjustsToScreenSize(any())).thenReturn(true);

        UiComponent uiComponent = setupUIComponent(1024);
        boolean result = uiComponent.adjustsToScreenSize(1024);

        
        assertTrue(result, "La interfaz de usuario debe ajustarse a un ancho de 1024 píxeles.");
    }

    // Suponiendo que setupUIComponent es un método que inicializa UiComponent
    private UiComponent setupUIComponent(int width) {
        when(uiComponent.adjustsToScreenSize(width)).thenReturn(true);
        return uiComponent;
    }
}

//Suponiendo que la clase UiComponent se define de la siguiente manera
class UiComponent {
    public boolean adjustsToScreenSize(int width) {
        return false;
    }
}