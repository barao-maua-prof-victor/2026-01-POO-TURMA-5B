package entidades.pagamentos;

public abstract class Pagamento {
    private String idPagamento;
    private Double valorPagamento;
    private String status;

    public Pagamento(String idPagamento, Double valorPagamento, String status) {
        this.idPagamento = idPagamento;
        this.valorPagamento = valorPagamento;
        this.status = status;
    }

    // Public
    public void processarPagamento(){}

    // Protected
    protected abstract void executar();
    protected abstract String getTipoPagamento();
    protected void validarValor(){}
    protected Double getValorPagamento(){
        return this.valorPagamento;
    }

    // Default
    void registrarLogInicioProcessamento(){}
    void registrarLogFimProcessamento(){}

    // Private
    private String getIdPagamento(){
        return this.idPagamento;
    }
}
