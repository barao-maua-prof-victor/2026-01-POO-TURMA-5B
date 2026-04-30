package entidades.pagamentos.pix;

import entidades.pagamentos.Pagamento;

public class PagamentoPix extends Pagamento {
    private String codigoPix;

    public PagamentoPix(Double valorPagamento, String codigoPix) {
        super(valorPagamento);
        this.codigoPix = codigoPix;
    }

    @Override
    protected void executar() {
        System.out.println("[PAGAMENTO " + this.getTipoPagamento() + "]" +
                " Processando pagamento pix de código " + this.getCodigoPix());
        System.out.println("[PAGAMENTO " + this.getTipoPagamento() + "]" +
                " Valor: R$ " + this.getValorPagamento());
    }

    @Override
    protected String getTipoPagamento() {
        return "PIX";
    }

    private String getCodigoPix() {
        return codigoPix;
    }
}
