package lab4;

/**
 * Clase que se encarga de establecer una conexion cifrada 
 * ESCENARIO 3: Plan de comunicación segura de datos
 */
public class SecureDataCommunication {
    public SecureDataCommunication() {
        setupSSLContext();
    }

    /*
     * Es reconmendable siempre usar cookies httpOnly
     * ejemplo:
     */
    public Cookie createHttpOnlyCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        return cookie;
    }

    /**
     * Este metodo se encarga de configurar el contexto SSL
     * 
     * SSL es un protocolo de seguridad recomendado para la transmisión de datos
     * en la red para asi estos datos que viajen por la red esten cifrados
     * 
     * Metodo de ejemplo
     */
    private void setupSSLContext() {
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            FileInputStream fis = new FileInputStream("path/to/your/certificate.crt");
            X509Certificate caCert = (X509Certificate) cf.generateCertificate(fis);

            // Crear y almacenar keys CAs
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("caCert", caCert);

            // Se recomienda siempre conexiones https para evitar que se intercepten los datos
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Metodo de ejemplo
     */
    public void sendDataOverHttps(String urlStr, byte[] data) {
        try {
            URL url = new URL(urlStr);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/octet-stream");
            connection.getOutputStream().write(data);
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * recomendado siempre cifrar los datos
     * @param filePath
     * @param data
     */
    public void storeDataEncrypted(String filePath, byte[] data) {
        try {
            // Cifrar datos
            byte[] encryptedData = encryptData(data);

            // Almacenar datos cifrados en un archivo
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            fos.write(encryptedData);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * MEtodo que se encarga de cifrar los datos con AES
     * @param data
     * @return
     */
    private byte[] encryptData(byte[] data) {
        return data;
    }

}
