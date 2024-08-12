import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Evento {
    private String nombre;
    private String descripcion;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Set<Participante> participantes;
    private Resultado resultado;

    public Evento(String nombre, String descripcion, LocalDateTime inicio, LocalDateTime fin) {
        if (inicio.isAfter(fin)) {
            throw new IllegalArgumentException("La fecha y hora de inicio no pueden ser después de la fecha y hora de fin.");
        }
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.participantes = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void agregarParticipante(Participante participante) {
        participantes.add(participante);
        participante.agregarEvento(this);
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void registrarResultado(Resultado resultado) {
        if (resultado == null) {
            throw new IllegalArgumentException("El resultado no puede ser nulo.");
        }
        this.resultado = resultado;
    }

    public Resultado getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Inicio: " + inicio + ", Fin: " + fin + ", Participantes: " + participantes.size();
    }
}

