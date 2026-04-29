package entidades.pagamentos.pix;

import entidades.pagamentos.Pagamento;

public class PagamentoPix extends Pagamento {
    private String codigoPix;

    public PagamentoPix(String idPagamento, Double valorPagamento, String status, String codigoPix) {
        super(idPagamento, valorPagamento, status);
        this.codigoPix = codigoPix;
    }

    @Override
    protected void executar() {
    }

    @Override
    protected String getTipoPagamento() {
        return "";
    }

    private String getCodigoPix() {
        return codigoPix;
    }
}
