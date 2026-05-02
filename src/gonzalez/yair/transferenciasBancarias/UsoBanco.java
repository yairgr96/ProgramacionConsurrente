package gonzalez.yair.transferenciasBancarias;

public class UsoBanco {
    public static void main(String[] args) {

        Banco b = new Banco();

        for (int i = 0; i < 100; i++) {

            EjecutandoTransferencia trasferencias = new EjecutandoTransferencia(b, i, 200);
            Thread hilo = new Thread(trasferencias);
            hilo.start();
        }



    }
}
