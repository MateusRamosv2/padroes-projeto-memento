package memento;

public class EstadoPedidoRascunho implements EstadoPedidoSupermercado {
    private EstadoPedidoRascunho() {};
    private static EstadoPedidoRascunho instance = new EstadoPedidoRascunho();
    public static EstadoPedidoRascunho getInstance() { return instance; }

    public String getNomeEstado() { return "Rascunho"; }
}
