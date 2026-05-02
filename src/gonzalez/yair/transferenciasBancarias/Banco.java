package gonzalez.yair.transferenciasBancarias;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {

    private final double cuentas [];
    private Lock bloqueaBanco = new ReentrantLock();
    private Condition saldoSuficiente;

    public Banco(){
        cuentas = new double[100];

        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 200;
        }

        saldoSuficiente = bloqueaBanco.newCondition();
    }

    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidadTransferencia) throws InterruptedException {

        bloqueaBanco.lock();
        try {
            //if (cuentas[cuentaOrigen] < cantidadTransferencia) return; // evitar la transferencia

            while(cuentas[cuentaOrigen] < cantidadTransferencia)saldoSuficiente.await();

            //Informa que hilo esta haciendo la transferencia
            System.out.println(Thread.currentThread());

            cuentas[cuentaOrigen] -= cantidadTransferencia;
            cuentas[cuentaDestino] += cantidadTransferencia;

            System.out.println("Transfrencia exitosa: $" + cantidadTransferencia + " de la cuenta " + cuentaOrigen + " a la cuenta " + cuentaDestino);
            //System.out.printf("%10.2f de %d para la cuenta %d", cantidadTransferencia, cuentaOrigen, cuentaDestino );
            System.out.printf("Saldo total: %10.2f%n", getSaldoTotal());

            saldoSuficiente.signalAll();
        }finally {
            bloqueaBanco.unlock();
        }
    }

    private double getSaldoTotal() {

        double sumaSaldoBanco = 0;
        for (int i = 0; i < cuentas.length; i++) {
            sumaSaldoBanco += cuentas[i];
        }
        return sumaSaldoBanco;
    }


}

class EjecutandoTransferencia implements Runnable{

    private Banco banco;
    private int cuentaDeOrigen;
    private double cantidadMaxima;

    public EjecutandoTransferencia(Banco banco, int cuentaDeOrigen, double cantidadMaxima) {
        this.banco = banco;
        this.cuentaDeOrigen = cuentaDeOrigen;
        this.cantidadMaxima = cantidadMaxima;
    }

    @Override
    public void run() {

        while (true){

            int cuentaDeDestino = (int) (Math.random()*100);
            double cantidadATransferir = cantidadMaxima*Math.random();
            try {
                banco.transferencia(cuentaDeOrigen, cuentaDeDestino, cantidadATransferir);


                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
