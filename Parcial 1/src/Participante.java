import java.util.HashSet;
import java.util.Set;

public class Participante extends Persona {
    private Set<Evento> eventos;

    public Participante(String nombre, String id) {
        super(nombre, id);
        this.eventos = new HashSet<>();
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    @Override
    public String toString() {
        return super.toString() + ", Eventos: " + eventos.size();
    }
}
