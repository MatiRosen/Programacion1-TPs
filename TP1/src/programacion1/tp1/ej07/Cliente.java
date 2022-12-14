package programacion1.tp1.ej07;

import java.util.ArrayList;

public class Cliente {

    private String nombre, apellido, dirección, email, teléfono;
    private ArrayList<Pedido> historialPedidos;

    public Cliente(String nombre, String apellido, String dirección, String email, String teléfono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dirección = dirección;
        this.email = email;
        this.teléfono = teléfono;
        this.historialPedidos = new ArrayList<>();
    }

    public boolean addPedido(Pedido pedido){
        boolean sePudo = false;
        if (pedido.getEstadoPedido() != EstadoPedido.PENDIENTE || this.getPedidoPendiente() == null){
            this.historialPedidos.add(pedido);
            sePudo = true;
        }

        return sePudo;
    }

    public void confirmarPedido(){
        Pedido pedidoPendiente = this.getPedidoPendiente();

        if (pedidoPendiente != null){
            for (ProductoPedido productoPedido : pedidoPendiente.getProductosPedidos()){
                productoPedido.getProducto().quitarDelStock(productoPedido.getCantidadPedida());
            }
            pedidoPendiente.setEstadoPedido(EstadoPedido.CONFIRMADO);
        }
    }

    public Pedido getPedidoPendiente(){
        Pedido pedido = null;
        int contador = 0;

        while (contador < historialPedidos.size() && pedido == null){
            Pedido pedidoAux = this.historialPedidos.get(contador);
            if (pedidoAux.getEstadoPedido() == EstadoPedido.PENDIENTE){
                pedido = pedidoAux;
            } else{
                contador++;
            }
        }

        return pedido;
    }
}
