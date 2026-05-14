package entidades.pagamentos.cartao;

import entidades.pagamentos.Pagamento;

import java.time.LocalDateTime;

public class PagamentoCartaoCredito extends Pagamento {
    private int numeroCartao;
    private int cvv;

    public PagamentoCartaoCredito(Double valorPagamento, LocalDateTime dataHoraPagamento, int numeroCartao, int cvv) {
        super(valorPagamento, dataHoraPagamento);
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
    }

    @Override
    protected void executar() {
        System.out.println("[PAGAMENTO " + this.getTipoPagamento() + "]" +
                " Processando pagamento cartão de crédito " + this.getNumeroCartao()
        );
        System.out.println("[PAGAMENTO " + this.getTipoPagamento() + "]" +
                " Valor: R$ " + this.getValorPagamento()
        );
    }

    @Override
    protected String getTipoPagamento() {
        return "CREDITO";
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
