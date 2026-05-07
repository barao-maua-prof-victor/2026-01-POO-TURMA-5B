package entidades.estacionamento;

import entidades.pagamentos.Pagamento;
import utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final UUID id;
    private final String placaVeiculo;
    private final Integer intervaloDeCobranca;
    private final Integer margemTempoParaSaidaEmMinutos;
    private final Double valorUnitarioIntervaloDeCobranca;
    private final LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private LocalDateTime dataHoraPermitidaSaida;
    private LocalDateTime dataHoraPagamento;
    private Integer tempoDePermanencia;
    private Integer totalDeIntervalosDeCobranca;
    private Double valorTotal;
    private StatusTicket status;
    private Pagamento pagamento;

    public Ticket(
            String placaVeiculo,
            Integer intervaloDeCobranca,
            Integer margemTempoParaSaidaEmMinutos,
            Double valorUnitarioIntervaloDeCobranca) {
        this.id = UUID.randomUUID();
        this.placaVeiculo = placaVeiculo;
        this.intervaloDeCobranca = intervaloDeCobranca;
        this.margemTempoParaSaidaEmMinutos = margemTempoParaSaidaEmMinutos;
        this.valorUnitarioIntervaloDeCobranca = valorUnitarioIntervaloDeCobranca;
        this.dataHoraEntrada = LocalDateTime.now();
        this.dataHoraSaida = null;
        this.dataHoraPermitidaSaida = null;
        this.dataHoraPagamento = null;
        this.tempoDePermanencia = null;
        this.totalDeIntervalosDeCobranca = null;
        this.valorTotal = null;
        this.status = StatusTicket.EM_ANDAMENTO;
        this.pagamento = null;
    }

    // Getter
    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public String getDataHoraEntradaFormatada(){
        return DateTimeUtils.formatarDataHoraPadrao(this.getDataHoraEntrada());
    }


}
