package teste.casouso;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/* Responsável por configurar os serviços do spring durante a execucao, carrengando as classes necessaria
  ao teste do adaptador(classe que simula o froontend) de transferencia */
@Configuration
@ComponentScan({
        // procura e carrega os objetos de sistema em
        "conta.sistema",
        // procyra  carrega os adptadores falsos em
        "conta.adaptador"})
public class Build1 {
    // Build 1: Adaptador Testes -> Sistema <- Adptadores Mocks
}