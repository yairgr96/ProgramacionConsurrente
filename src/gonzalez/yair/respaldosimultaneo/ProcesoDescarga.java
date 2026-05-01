package gonzalez.yair.respaldosimultaneo;
// implements Runnable: Indica a Java que esta clase es un proceso apto
// para ejecutarse en segundo plano dentro de un Thread (Hilo).
public class ProcesoDescarga implements Runnable {

    private String nombreCamara;

    public ProcesoDescarga(String nombreCamara) {
        this.nombreCamara = nombreCamara;
    }

    /*Metodo obligatorio por la interfaz Runnable.
    Todo el codigo escrito dentro de run() es el trabajo que el hilo ejecutara*/

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            System.out.println("Descargando paquete " + (i+1) + " de la " + nombreCamara);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }
    }
}
