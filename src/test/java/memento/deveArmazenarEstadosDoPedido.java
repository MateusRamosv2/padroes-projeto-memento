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

    @Test
    void deveRetornarEstadoInicialDoPedido() {
        PedidoSupermercado pedido = new PedidoSupermercado();
        pedido.setEstado(EstadoPedidoRascunho.getInstance());
        pedido.setEstado(EstadoPedidoSeparacao.getInstance());

        // Operador errou, quer voltar para o primeiro estado (índice 0)
        pedido.restauraEstado(0);

        assertEquals(EstadoPedidoRascunho.getInstance(), pedido.getEstado());
    }

    @Test
    void deveRetornarEstadoAnteriorApósCancelamento() {
        PedidoSupermercado pedido = new PedidoSupermercado();
        pedido.setEstado(EstadoPedidoRascunho.getInstance()); // Índice 0
        pedido.setEstado(EstadoPedidoSeparacao.getInstance()); // Índice 1
        pedido.setEstado(EstadoPedidoFaturado.getInstance()); // Índice 2
        pedido.setEstado(EstadoPedidoCancelado.getInstance()); // Índice 3

        // Cliente desistiu de cancelar, vamos voltar para "Faturado"
        pedido.restauraEstado(2);

        assertEquals(EstadoPedidoFaturado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveRetornarExcecaoParaIndiceInvalido() {
        try {
            PedidoSupermercado pedido = new PedidoSupermercado();
            // Tenta restaurar um histórico de um pedido que ainda não teve estados salvos
            pedido.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice de restauração inválido", e.getMessage());
        }
    }

}