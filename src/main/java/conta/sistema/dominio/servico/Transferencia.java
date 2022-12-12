package conta.sistema.dominio.servico;

import conta.sistema.dominio.modelo.Conta;

import javax.inject.Named;
import java.math.BigDecimal;
import static java.util.Objects.isNull;
import static conta.sistema.dominio.modelo.Erro.obrigatorio;


/**
 * Essa classe não sera instanciada, sera injetada  CDI
 * */
@Named
public class Transferencia {

    public void processar(BigDecimal valor, Conta debito, Conta credito){
        if(isNull(valor)){
            obrigatorio("Valor da transferência");
        }

        if(isNull(debito)){
            obrigatorio("Conta débito");
        }

        if(isNull(credito)){
            obrigatorio("Conta crédito");
        }

        // retira de uma conta de credita em outra
        debito.debitar(valor);
        credito.creditar(valor);

    }

}
