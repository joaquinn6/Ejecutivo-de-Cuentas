package FactoryMethod;

import java.util.List;

import com.cuentasejecutivo.model.Direccion;
import com.cuentasejecutivo.model.Documento;
import com.cuentasejecutivo.model.Natural;
import com.cuentasejecutivo.model.Referencia;
import com.cuentasejecutivo.model.Socio;
import com.cuentasejecutivo.model.Telefono;
import com.cuentasejecutivo.model.Trabajo;

public class FactoriaDeSocios {

    public SocioF getSocio(boolean natOJur, Natural natural, List<Direccion> direcciones, List<Documento> documentos,
			List<Referencia> referencias, Socio socio, List<Telefono> telefonos, Trabajo trabajo) {
        if (natOJur) {
            return (new NaturalF(natural,direcciones, documentos,referencias,socio,telefonos,trabajo));
        } else {
            return (new JuridicoF(direcciones, documentos,referencias,socio,telefonos,trabajo));
        }
    }
}
