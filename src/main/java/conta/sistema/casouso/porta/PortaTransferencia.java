package conta.sistema.casouso.porta;
import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import java.math.BigDecimal;


// Responsável por definir a porta de entrada (driver) de operações para caso de uso de
//transferência.
public interface PortaTransferencia {

    Conta getConta(Integer numero);

    void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valor);
}
