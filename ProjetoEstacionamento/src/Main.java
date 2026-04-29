import entidades.pagamentos.pix.PagamentoPix;

public class Main {
    public static void main(String[] args) {
        PagamentoPix pagamentoPix = new PagamentoPix(
                "HF21",
                10.0,
                "AGUARDANDO",
                "JFO;IQHFQ3IRHFOQI3"
        );
    }
}
