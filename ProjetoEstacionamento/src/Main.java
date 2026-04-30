import entidades.pagamentos.cartao.PagamentoCartaoCredito;
import entidades.pagamentos.pix.PagamentoPix;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        PagamentoPix pagamentoPix = new PagamentoPix(
                10.0,
                "JFO;IQHFQ3IRHFOQI3"
        );
        System.out.println(pagamentoPix);
        PagamentoCartaoCredito pagamentoCartaoCredito = new PagamentoCartaoCredito(
                15.0,
                123,
                123
        );
        System.out.println(pagamentoCartaoCredito);
    }
}
