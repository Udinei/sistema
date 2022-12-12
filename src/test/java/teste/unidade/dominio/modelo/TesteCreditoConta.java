package teste.unidade.dominio.modelo;


import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


// classe basica de testes do dominio
@DisplayName("Regra de crédito de conta")
public class TesteCreditoConta {
    // variaveis globais
    BigDecimal cem = new BigDecimal(100);
    Conta contaValida;

    @BeforeEach // executa a cada teste de unidade
    public void preparar(){
        contaValida = new Conta(1, cem, "Rebeca");
    }


    // testes de unidade
    // teste negativos
    @Test
    @DisplayName("Valor credito nulo como obrigatorio")
    public void teste1(){
        try{
            contaValida.creditar(null);
            fail("valor credito obrigatorio");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Valor crédito é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("Valor credito negativo como obrigatorio")
    public void teste2(){
        try{
            contaValida.creditar(new BigDecimal(-10));
            fail("valor credito obrigatorio");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Valor crédito é obrigatório.");
            System.out.println(e.getMessage());
        }

    }


    @Test
    @DisplayName("Valor credito zero como obrigatorio")
    public void teste3(){
        try{
            contaValida.creditar(new BigDecimal(0));
            fail("valor credito obrigatorio");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Valor crédito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }


    // teste positivo
    @Test
    @DisplayName("Valor credito acima de zero")
    public void teste4(){
        try{
            contaValida.creditar(BigDecimal.ONE);
            var saldoFinal = cem.add(BigDecimal.ONE);
            assertEquals(contaValida.getSaldo(), saldoFinal, "Saldo deve bater");

        }catch (NegocioException e){
            fail("Deve creditar com sucesso -" + e.getMessage());

        }
    }

}
