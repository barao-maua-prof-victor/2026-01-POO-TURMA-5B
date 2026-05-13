import entidades.estacionamento.Ticket;
import entidades.pagamentos.cartao.PagamentoCartaoCredito;
import entidades.pagamentos.pix.PagamentoPix;

import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Ticket meuTicket = new Ticket(
                "ABC-1234",
                1,
                30,
                10.0
        );

        LocalDateTime dataTeste = LocalDateTime.parse("2026-05-13T00:30:00");
        meuTicket.calcularValorTotalParaPagamento(dataTeste);

//        PagamentoPix pagamentoPix = new PagamentoPix(
//                10.0,
//                "JFO;IQHFQ3IRHFOQI3"
//        );
//        System.out.println(pagamentoPix);
//        PagamentoCartaoCredito pagamentoCartaoCredito = new PagamentoCartaoCredito(
//                15.0,
//                123,
//                123
//        );
//        System.out.println(pagamentoCartaoCredito);
    }
}
