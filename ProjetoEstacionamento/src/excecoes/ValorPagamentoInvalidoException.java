package excecoes;

public class ValorPagamentoInvalidoException extends RuntimeException {
    private final Double valorInvalido;

    public ValorPagamentoInvalidoException(Double valorInvalido) {
        super("[ERRO] Valor de pagamento inválido: R$ " + valorInvalido);
        this.valorInvalido = valorInvalido;
    }

    public Double getValorInvalido() {
        return valorInvalido;
    }
}
