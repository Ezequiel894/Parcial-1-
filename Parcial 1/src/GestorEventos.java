import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GestorEventos {
    private Map<String, Evento> eventos;
    private Map<String, Participante> participantes;

    public GestorEventos() {
        eventos = new HashMap<>();
        participantes = new HashMap<>();
    }

    public void registrarEvento(String nombre, String descripcion, LocalDateTime inicio, LocalDateTime fin) {
        if (eventos.containsKey(nombre)) {
            throw new IllegalArgumentException("El evento ya existe.");
        }
        Evento evento = new Evento(nombre, descripcion, inicio, fin);
        eventos.put(nombre, evento);
    }

    public void registrarParticipante(String nombre, String id) {
        if (participantes.containsKey(id)) {
            throw new IllegalArgumentException("El participante ya existe.");
        }
        Participante participante = new Participante(nombre, id);
        participantes.put(id, participante);
    }

    public void asignarParticipanteAEvento(String idParticipante, String nombreEvento) {
        Participante participante = participantes.get(idParticipante);
        Evento evento = eventos.get(nombreEvento);

        if (participante == null) {
            throw new Excepcion("Participante no encontrado.");
        }
        if (evento == null) {
            throw new EventoNoEncontradoException("Evento no encontrado.");
        }

        evento.agregarParticipante(participante);
    }

    public void registrarResultados(String nombreEvento, Map<Participante, Integer> posiciones) {
        Evento evento = eventos.get(nombreEvento);
        if (evento == null) {
            throw new EventoNoEncontradoException("Evento no encontrado.");
        }
        Resultado resultado = new Resultado(posiciones);
        evento.registrarResultado(resultado);
    }

    public Evento consultarEvento(String nombreEvento) {
        Evento evento = eventos.get(nombreEvento);
        if (evento == null) {
            throw new EventoNoEncontradoException("Evento no encontrado.");
        }
        return evento;
    }

    public Participante consultarParticipante(String idParticipante) {
        Participante participante = participantes.get(idParticipante);
        if (participante == null) {
            throw new Excepcion("Participante no encontrado.");
        }
        return participante;
    }

    public void listarEventos() {
        for (Evento evento : eventos.values()) {
            System.out.println(evento);
        }
    }
}
