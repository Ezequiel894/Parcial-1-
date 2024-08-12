import java.util.Map;

public class Resultado {
    private Map<Participante, Integer> posiciones;

    public Resultado(Map<Participante, Integer> posiciones) {
        this.posiciones = posiciones;
    }

    public Map<Participante, Integer> getPosiciones() {
        return posiciones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Resultados:\n");
        for (Map.Entry<Participante, Integer> entry : posiciones.entrySet()) {
            sb.append("Participante: ").append(entry.getKey().getNombre()).append(", Posición: ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
