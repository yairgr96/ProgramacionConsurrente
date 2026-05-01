package gonzalez.yair.torneomultihilo;

public class Equipo {

    private String nombre;
    private int puntos;
    private int golesFavor;
    private int golesContra;

    public Equipo(String nombre) {
        this.nombre = nombre;

        puntos = 0;
        golesFavor = 0;
        golesContra = 0;
    }

    public void registrarResultado(int golesAnotados, int golesRecibidos){
        this.golesFavor += golesAnotados;
        this.golesContra += golesRecibidos;

        if (golesAnotados > golesRecibidos){
            puntos += 3;
        } else if (golesAnotados == golesRecibidos) {

            puntos += 1;
        }else {

            puntos += 0;
        }
    }

    public void mostrarEstadisticas(){
        int diferenciaGoles = this.golesFavor - this.golesContra;

        System.out.println(this.nombre + "\t| Pts: " + this.puntos +
                "\t| GF: " + this.golesFavor +
                "\t| GC: " + this.golesContra +
                "\t| DIF: " + diferenciaGoles);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
