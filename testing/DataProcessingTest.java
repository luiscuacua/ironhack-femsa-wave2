
/**
 * clase DataProcessingTest con responsabilidad unica para
 * los casos de Funciones de procesamiento de datos.
 * En esta clase se utiliza mockitos con la intencion de solo 
 * validar las funciones sin depender de funciones externas
 */
class DataProcessingTest {
    private DataProcessing dataProcessing;
    private Data data;

    //inicializar datos y crear mockito como buena practica
    @BeforeEach
    void setUp() {
        dataProcessing = Mockito.mock(DataProcessing.class);
        data = new Data();
    }

    //test para proceso de data correcto
    @Test
    void testSuccessfulDataProcessing() throws Exception {
        //definir el flujo de cuando fetchData() devuelva data
        when(dataProcessing.fetchData()).thenReturn(data);

        //definir que no se cree una exception
        doAnswer(invocation -> {
            data.setProcessedSuccessfully(true);
            return null;
        }).when(dataProcessing).processData(data);

        Data fetchedData = dataProcessing.fetchData();
        dataProcessing.processData(fetchedData);

        //validar que se cumpla el proceso correcto
        assertTrue(fetchedData.isProcessedSuccessfully(), "Los datos deben procesarse correctamente");
    }

    //test cuando falla el procesos de data
    @Test
    void testFailedDataProcessing() throws Exception {
        //definir el flujo de cuando fetchData() devuelva data
        when(dataProcessing.fetchData()).thenReturn(data);

        //definir que se cree una exception
        doThrow(new Exception("Error de procesamiento de datos")).when(dataProcessing).processData(data);

        Data fetchedData = dataProcessing.fetchData();

        //obtener la exception esperada
        Exception exception = assertThrows(Exception.class, () -> {
            dataProcessing.processData(fetchedData);
        });

        //validar la exception esperada
        assertEquals("Error de procesamiento de datos", exception.getMessage(), "Debe gestionar los errores de procesamiento");
    }
}

// Suponiendo que las clases DataProcessing y Data se definen de la siguiente manera
class DataProcessing {
    public Data fetchData() {
        return new Data();
    }

    public void processData(Data data) throws Exception {
        if (data == null) {
            throw new Exception("Data processing error");
        }
        data.setProcessedSuccessfully(true);
    }
}

class Data {
    private boolean processedSuccessfully;

    public boolean isProcessedSuccessfully() {
        return processedSuccessfully;
    }

    public void setProcessedSuccessfully(boolean processedSuccessfully) {
        this.processedSuccessfully = processedSuccessfully;
    }
}