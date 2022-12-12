
module conta.sistema {
 // framework que o projeto depende
 requires javax.inject; // CDI
 requires spring.tx; // controle de transacao (JCA ResourceAdpter/ConnectionFactory )

 // expondo porta de entrada (driver)
 exports conta.sistema.casouso.porta;
 exports conta.sistema.casouso.imp;

 // expondo sistema negocio
 exports conta.sistema.dominio.modelo;
 exports conta.sistema.dominio.servico;

 // expondo adptadores de saidas (driven)
 exports conta.sistema.porta;
 exports conta.adaptador;

 exports teste.unidade.dominio.modelo;


 // abre reflexão spring
 opens conta.sistema.casouso.porta;
 opens conta.sistema.casouso.imp;
 opens conta.sistema.dominio.servico;
 opens conta.sistema.dominio.modelo;
 opens conta.adaptador;


}