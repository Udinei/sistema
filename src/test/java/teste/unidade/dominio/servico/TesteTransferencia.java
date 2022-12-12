package teste.unidade.dominio.servico;


import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import conta.sistema.dominio.servico.Transferencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

@DisplayName("Regra de Transferência")
public class TesteTransferencia {

    BigDecimal cem = new BigDecimal(100);
    BigDecimal vinte = new BigDecimal(20);

    Transferencia trans;
    Conta contaDebito;
    Conta contaCredito;

    @BeforeEach
    void preparar(){
        contaDebito = new Conta(1, cem, "Fernando");
        contaCredito = new Conta(2, cem, "Rebeca");
        trans = new Transferencia();
    }

    @Test
    @DisplayName("Valor nulo como obrigatório")
    void teste1(){
        try{
            trans.processar(null, contaDebito,contaCredito);
            fail("Valor transferência obrigatorio");

        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Valor da transferência é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("conta debito obrigatório")
    void teste2(){
        try{
            trans.processar(vinte, null,contaCredito);
            fail("conta debito obrigatorio");

        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Conta débito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }


    @Test
    @DisplayName("conta credito obrigatório")
    void teste3(){
        try{
            trans.processar(vinte, contaDebito,null);
            fail("conta credito obrigatorio");

        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Conta crédito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("tranferir 20 reais")
    void teste4(){
        try{
            trans.processar(vinte, contaDebito,contaCredito);
            assertEquals(contaDebito.getSaldo(), cem.subtract(vinte),"Saldo da conta débito deve bater");
            assertEquals(contaCredito.getSaldo(), cem.add(vinte),"Saldo da conta débito deve bater");

        }catch (NegocioException e){
              fail("Deve transferir com sucesso");
        }
    }

}

