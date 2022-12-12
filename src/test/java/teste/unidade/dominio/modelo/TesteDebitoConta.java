package teste.unidade.dominio.modelo;


import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.modelo.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigDecimal;


// classe basica de testes do dominio
@DisplayName("Regra de Debito de conta")
public class TesteDebitoConta {
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
    @DisplayName("Valor debito nulo como obrigatorio")
    public void teste1(){
        try{
            contaValida.debitar(null);
            fail("valor débito obrigatorio");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Valor débito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Valor debito negativo como obrigatorio")
    public void teste2(){
        try{
            contaValida.debitar(new BigDecimal(-10));
            fail("valor débito obrigatorio");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Valor débito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Valor debito acima do saldo")
    public void teste3(){
        try{
            contaValida.debitar(new BigDecimal(-10));
            fail("valor débito obrigatorio");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Valor débito é obrigatório.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Valor debito acima do saldo")
    public void teste4(){
        try{
            contaValida.debitar(cem.add(BigDecimal.ONE));
            fail("valor débito acima do saldo");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Saldo insuficiente.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Valor debito igual ao saldo")
    public void teste5(){
        try{
            contaValida.debitar(cem);
            assertEquals(contaValida.getSaldo(), BigDecimal.ZERO, "Saldo deve zerar");
        }catch (NegocioException e){
               fail("Deve debitar com sucesso - " + e.getMessage());
        }
    }


    @Test
    @DisplayName("Valor debito menor que saldo")
    public void teste6(){
        try{
            contaValida.debitar(BigDecimal.TEN);
            var saldoFinal = cem.subtract(BigDecimal.TEN);
            assertEquals(contaValida.getSaldo(), saldoFinal, "Saldo deve bater");

        }catch (NegocioException e){
            fail("Deve debitar com sucesso - " + e.getMessage());
        }
    }

}
