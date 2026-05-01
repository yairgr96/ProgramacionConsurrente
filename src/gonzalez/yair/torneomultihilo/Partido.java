package gonzalez.yair.torneomultihilo;

public class Partido implements Runnable{

    private Equipo local;
    private Equipo visitante;

    public Partido(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
    }

    @Override
    public void run() {

        int golesLocal = (int)(Math.random()*5);
        int golesVisitante = (int)(Math.random()*5);

        local.registrarResultado(golesLocal, golesVisitante);
        visitante.registrarResultado(golesVisitante, golesLocal);
        System.out.println("Termino! " + local + " " + golesLocal + " - " + visitante +" " + golesVisitante );
    }
}
