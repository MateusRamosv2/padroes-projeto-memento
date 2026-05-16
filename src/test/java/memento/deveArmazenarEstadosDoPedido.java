package memento;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoSupermercadoTest {

    @Test
    void deveArmazenarEstadosDoPedido() {
        PedidoSupermercado pedido = new PedidoSupermercado();
        pedido.setEstado(EstadoPedidoRascunho.getInstance());
        pedido.setEstado(EstadoPedidoSeparacao.getInstance());
        pedido.setEstado(EstadoPedidoFaturado.getInstance());

        assertEquals(3, pedido.getEstados().size());
    }
}