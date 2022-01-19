import com.salesianostriana.dam.ejerciciotesting.model.Cliente;
import com.salesianostriana.dam.ejerciciotesting.model.LineaDeVenta;
import com.salesianostriana.dam.ejerciciotesting.model.Producto;
import com.salesianostriana.dam.ejerciciotesting.model.Venta;
import com.salesianostriana.dam.ejerciciotesting.repos.ProductoRepositorio;
import com.salesianostriana.dam.ejerciciotesting.repos.VentaRepositorio;
import com.salesianostriana.dam.ejerciciotesting.services.VentaServicio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.listeners.VerificationStartedNotifier;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest2 {

    @Mock
    VentaRepositorio ventaRepositorio;

    @Mock
    ProductoRepositorio productoRepositorio;

    @InjectMocks
    VentaServicio ventaServicio;

    @Test
    public void whenNuevaVenta_success(){
        Producto p = Producto.builder()
                .codigoProducto("1")
                .nombre("Producto")
                .precio(12.34)
                .build();

        Cliente c = Cliente.builder()
                .nombre("Rompetechos")
                .email("rompretechos@gmail.com")
                .dni("123324324T")
                .build();
        lenient().when(productoRepositorio.findOne("1")).thenReturn(p);


        Map<String,Integer> carrito= Map.of("1",2);

        Venta v = new Venta();
        v.setId(2L);
        v.setCliente(c);
        v.setLineasDeVenta(List.of(new LineaDeVenta(p,2,12.34)));

        lenient().when(ventaRepositorio.save(v)).thenReturn(v);
    }
}
