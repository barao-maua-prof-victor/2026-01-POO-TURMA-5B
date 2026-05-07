import entidades.estacionamento.Ticket;
import entidades.pagamentos.cartao.PagamentoCartaoCredito;
import entidades.pagamentos.pix.PagamentoPix;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Ticket meuTicket = new Ticket(
                "ABC-1234",
                2,
                30,
                15.0
        );
        System.out.println(meuTicket.getDataHoraEntrada());
        System.out.println(meuTicket.getDataHoraEntradaFormatada());

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
