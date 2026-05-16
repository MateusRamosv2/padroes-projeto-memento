package memento;

import java.util.ArrayList;
import java.util.List;

public class PedidoSupermercado {

    private EstadoPedidoSupermercado estado;
    private List<EstadoPedidoSupermercado> memento = new ArrayList<EstadoPedidoSupermercado>();

    public EstadoPedidoSupermercado getEstado() {
        return this.estado;
    }

    public void setEstado(EstadoPedidoSupermercado estado) {
        this.estado = estado;
        this.memento.add(this.estado);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice de restauração inválido");
        }
        this.estado = this.memento.get(indice);
    }

    public List<EstadoPedidoSupermercado> getEstados() {
        return this.memento;
    }
}