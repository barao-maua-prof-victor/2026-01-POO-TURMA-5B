package entidades.pagamentos;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Pagamento {
    private final UUID idPagamento;
    private final Double valorPagamento;
    private StatusPagamento status;
    private final LocalDateTime dataHoraPagamento;

    public Pagamento(Double valorPagamento, LocalDateTime dataHoraPagamento) {
        this.idPagamento = UUID.randomUUID();
        this.valorPagamento = valorPagamento;
        this.status = StatusPagamento.AGUARDANDO_PAGAMENTO;
        this.dataHoraPagamento = dataHoraPagamento;
    }

    // Public
    public void processarPagamento(){
        this.registrarLogInicioProcessamento();
        this.validarValor();
        this.executar();
        this.registrarLogFimProcessamento();
        this.setStatus(StatusPagamento.PAGO);
    }

    // Protected
    protected abstract void executar();
    protected abstract String getTipoPagamento();
    protected void validarValor(){
        if (this.getValorPagamento() < 0){
            System.out.println("Valor inválido!!!!");
        }
    }
    protected Double getValorPagamento(){
        return this.valorPagamento;
    }

    // Default
    void registrarLogInicioProcessamento(){
        System.out.println("[LOG] [INFO] Iniciado processamento do pagamento com id " +
                this.getIdPagamento()
        );
    }
    void registrarLogFimProcessamento(){
        System.out.println("[LOG] [INFO] Finalizado processamento do pagamento com id " +
                this.getIdPagamento()
        );
    }

    // Private
    private UUID getIdPagamento(){
        return this.idPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "idPagamento=" + idPagamento +
                ", valorPagamento=" + valorPagamento +
                ", status='" + status + '\'' +
                '}';
    }
}
