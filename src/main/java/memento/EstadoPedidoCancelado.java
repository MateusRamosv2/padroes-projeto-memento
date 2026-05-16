package memento;

public class EstadoPedidoCancelado implements EstadoPedidoSupermercado {
    private EstadoPedidoCancelado() {};
    private static EstadoPedidoCancelado instance = new EstadoPedidoCancelado();
    public static EstadoPedidoCancelado getInstance() { return instance; }

    public String getNomeEstado() { return "Cancelado"; }
}