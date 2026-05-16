package memento;

public class EstadoPedidoFaturado implements EstadoPedidoSupermercado {
    private EstadoPedidoFaturado() {};
    private static EstadoPedidoFaturado instance = new EstadoPedidoFaturado();
    public static EstadoPedidoFaturado getInstance() { return instance; }

    public String getNomeEstado() { return "Faturado"; }
}