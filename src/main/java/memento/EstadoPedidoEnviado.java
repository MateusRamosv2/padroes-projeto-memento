package memento;

public class EstadoPedidoEnviado implements EstadoPedidoSupermercado {
    private EstadoPedidoEnviado() {};
    private static EstadoPedidoEnviado instance = new EstadoPedidoEnviado();
    public static EstadoPedidoEnviado getInstance() { return instance; }

    public String getNomeEstado() { return "Enviado para Entrega"; }
}