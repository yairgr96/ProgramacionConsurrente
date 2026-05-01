package gonzalez.yair.respaldosimultaneo;

import org.w3c.dom.ls.LSOutput;

public class ModuloC5 {

    public static void main(String[] args) {

        // 1. CREACIÓN DE LAS TAREAS (Los "Manuales de Instrucciones")
        // Instanciamos objetos de nuestra clase que implementa Runnable.
        // Aún no hacen nada por sí solos, solo contienen la información de qué cámara se va a respaldar.
        ProcesoDescarga camaraNorte = new ProcesoDescarga("Camara Norte");
        ProcesoDescarga camaraSur = new ProcesoDescarga("Camara Sur");
        ProcesoDescarga camaraOriente = new ProcesoDescarga("Camara Oriente");

        // 2. CREACIÓN DE LOS HILOS (Contratando a los "Trabajadores")
        // La clase nativa Thread representa un hilo de ejecución independiente en el procesador.
        // Le entregamos a cada Thread su tarea (manual) correspondiente en el constructor.
        Thread hilo1 = new Thread(camaraNorte);
        Thread hilo2 = new Thread(camaraSur);
        Thread hilo3 = new Thread(camaraOriente);

        // 3. ARRANQUE CONCURRENTE (La orden del Gerente: "¡A trabajar todos al mismo tiempo!")
        // Usamos .start() (y NO .run()) para que los tres hilos comiencen a ejecutarse simultáneamente
        // en segundo plano. A partir de aquí, compiten por el tiempo del procesador.
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }

}
