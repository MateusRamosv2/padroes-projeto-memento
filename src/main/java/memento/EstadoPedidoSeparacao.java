package memento;

public class EstadoPedidoSeparacao implements EstadoPedidoSupermercado {
    private EstadoPedidoSeparacao() {};
    private static EstadoPedidoSeparacao instance = new EstadoPedidoSeparacao();
    public static EstadoPedidoSeparacao getInstance() { return instance; }

    public String getNomeEstado() { return "Em Separação"; }
}
