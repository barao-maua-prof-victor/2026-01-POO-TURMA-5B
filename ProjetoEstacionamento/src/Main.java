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

        LocalDateTime dataTeste = LocalDateTime.parse("2026-05-13T22:30:00");

        Double valorPagamento = meuTicket.calcularValorTotalParaPagamento(dataTeste);

        PagamentoPix pagamentoPix = new PagamentoPix(
                valorPagamento,
                dataTeste,
                "JFO;IQHFQ3IRHFOQI3"
        );
        pagamentoPix.processarPagamento();

        meuTicket.registrarPagamento(pagamentoPix);

        System.out.println(meuTicket.temPermissaoParaSaida());

        System.out.println(meuTicket);
        meuTicket.registrarSaida();
        System.out.println(meuTicket);

//        System.out.println(pagamentoPix);
//        PagamentoCartaoCredito pagamentoCartaoCredito = new PagamentoCartaoCredito(
//                15.0,
//                123,
//                123
//        );
//        System.out.println(pagamentoCartaoCredito);
    }
}
