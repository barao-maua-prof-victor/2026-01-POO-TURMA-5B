package entidades.estacionamento;

import entidades.pagamentos.Pagamento;
import excecoes.OrdemCronologicaInvalidaExcecao;
import utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.Optional;
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

    public Ticket(
            UUID id,
            String placaVeiculo,
            Integer intervaloDeCobranca,
            Integer margemTempoParaSaidaEmMinutos,
            Double valorUnitarioIntervaloDeCobranca,
            LocalDateTime dataHoraEntrada,
            LocalDateTime dataHoraSaida,
            LocalDateTime dataHoraPermitidaSaida,
            LocalDateTime dataHoraPagamento,
            Integer tempoPermanencia,
            Integer totalIntervalosDeCobranca,
            Double valorTotal,
            StatusTicket status) {
        this.id = id;
        this.placaVeiculo = placaVeiculo;
        this.intervaloDeCobranca = intervaloDeCobranca;
        this.margemTempoParaSaidaEmMinutos = margemTempoParaSaidaEmMinutos;
        this.valorUnitarioIntervaloDeCobranca = valorUnitarioIntervaloDeCobranca;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.dataHoraPermitidaSaida = dataHoraPermitidaSaida;
        this.dataHoraPagamento = dataHoraPagamento;
        this.tempoDePermanencia = tempoPermanencia;
        this.totalDeIntervalosDeCobranca = totalIntervalosDeCobranca;
        this.valorTotal = valorTotal;
        this.status = status;
        this.pagamento = null;
    }

    // Getter

    public Integer getIntervaloDeCobranca() {
        return intervaloDeCobranca;
    }

    public Double getValorUnitarioIntervaloDeCobranca() {
        return valorUnitarioIntervaloDeCobranca;
    }

    public Integer getTempoDePermanencia() {
        return tempoDePermanencia;
    }

    public Integer getTotalDeIntervalosDeCobranca() {
        return totalDeIntervalosDeCobranca;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public UUID getId() {
        return id;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public StatusTicket getStatus() {
        return status;
    }

    // Data e Hora Entrada
    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }
    public String getDataHoraEntradaFormatada(){
        return DateTimeUtils.formatarDataHoraPadrao(this.getDataHoraEntrada());
    }

    // Data Hora Saída
    public Optional<LocalDateTime> getDataHoraSaida() {
        return Optional.ofNullable(this.dataHoraSaida);
    }

    public String getDataHoraSaidaFormatada(){
        return this.getDataHoraSaida()
                .map(DateTimeUtils::formatarDataHoraPadrao)
                .orElse("VAZIO");
    }

    // Data Hora Pagamento
    public Optional<LocalDateTime> getDataHoraPagamento() {
        return Optional.ofNullable(this.dataHoraPagamento);
    }
    public String getDataHoraPagamentoFormatada(){
        return this.getDataHoraPagamento()
                .map(DateTimeUtils::formatarDataHoraPadrao)
                .orElse("VAZIO");
    }

    // Data Hora Permitida Saída
    public Optional<LocalDateTime> getDataHoraPermitidaSaida() {
        return Optional.ofNullable(this.dataHoraPermitidaSaida);
    }
    public String getDataHoraPermitidaSaidaFormatada(){
        return this.getDataHoraPermitidaSaida()
                .map(DateTimeUtils::formatarDataHoraPadrao)
                .orElse("VAZIO");
    }

    public Integer getMargemTempoParaSaidaEmMinutos() {
        return margemTempoParaSaidaEmMinutos;
    }

    // Regras de Negócio
    private int calcularTempoDePermanencia(LocalDateTime agora){
        return (int) DateTimeUtils.calcularMinutosEntreData(this.getDataHoraEntrada(), agora);
    }

    private int calcularIntervaloDeCobranca(int tempoDePermanenciaMinutos){
        double tempoDePermanenciaHoras = tempoDePermanenciaMinutos / 60.0;
        return (int) Math.ceil(
                tempoDePermanenciaHoras / this.intervaloDeCobranca
        );
    }

    private Double calcularValotTotal(int totalDeIntevalos){
        return totalDeIntevalos * this.valorUnitarioIntervaloDeCobranca;
    }

    public Double calcularValorTotalParaPagamento(LocalDateTime dataHoraConsulta){

        if (dataHoraConsulta.isBefore(this.getDataHoraEntrada())){
            throw new OrdemCronologicaInvalidaExcecao(
                    "Data Hora Entrada",
                    this.getDataHoraEntradaFormatada(),
                    "Data Hora Consulta",
                    DateTimeUtils.formatarDataHoraPadrao(dataHoraConsulta)
            );
        }

        System.out.println("Data Hora Entrada: " + this.getDataHoraEntradaFormatada());
        System.out.println("Data Hora Cálculo: " + DateTimeUtils.formatarDataHoraPadrao(
                dataHoraConsulta)
        );
        int tempoDePermanenciaMinutosTotal = this.calcularTempoDePermanencia(dataHoraConsulta);
        System.out.println("Tempo Permanência: " + tempoDePermanenciaMinutosTotal);
        int totalIntervalosDeCobranca = this.calcularIntervaloDeCobranca(tempoDePermanenciaMinutosTotal);
        System.out.println("Total Intervalos: " + totalIntervalosDeCobranca);
        double valorTotal = this.calcularValotTotal(totalIntervalosDeCobranca);
        System.out.println("Valor Total: R$ " + valorTotal);
        return valorTotal;
    }

    private void calcularDataHoraPermitidaSaida(){
        this.getDataHoraPagamento().ifPresent(maca ->
                this.dataHoraPermitidaSaida = DateTimeUtils.adicionarTempoEmMinutos(
                        maca,
                        this.getMargemTempoParaSaidaEmMinutos()
                )
        );
    }

    public void registrarPagamento(Pagamento pagamento){
        this.dataHoraPagamento = pagamento.getDataHoraPagamento();
        this.pagamento = pagamento;
        this.calcularDataHoraPermitidaSaida();
        this.tempoDePermanencia = this.calcularTempoDePermanencia(pagamento.getDataHoraPagamento());
        this.totalDeIntervalosDeCobranca = this.calcularIntervaloDeCobranca(this.tempoDePermanencia);
        this.valorTotal = this.calcularValotTotal(this.totalDeIntervalosDeCobranca);
        this.status = StatusTicket.PAGAMENTO_EFETUADO;
    }

    public boolean temPermissaoParaSaida(){
        return this.getDataHoraPermitidaSaida()
                .map(dataHoraPermitidaSaida ->
                        LocalDateTime.now().isBefore(dataHoraPermitidaSaida)
                        && this.status == StatusTicket.PAGAMENTO_EFETUADO
                ).orElse(false);
    }

    public void registrarSaida(){
        this.dataHoraSaida = LocalDateTime.now();
        this.status = StatusTicket.FINALIZADO;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                ", intervaloDeCobranca=" + intervaloDeCobranca +
                ", margemTempoParaSaidaEmMinutos=" + margemTempoParaSaidaEmMinutos +
                ", valorUnitarioIntervaloDeCobranca=" + valorUnitarioIntervaloDeCobranca +
                ", dataHoraEntrada=" + this.getDataHoraEntradaFormatada() +
                ", dataHoraSaida=" + this.getDataHoraSaidaFormatada() +
                ", dataHoraPermitidaSaida=" + this.getDataHoraPermitidaSaidaFormatada() +
                ", dataHoraPagamento=" + this.getDataHoraPagamentoFormatada() +
                ", tempoDePermanencia=" + tempoDePermanencia +
                ", totalDeIntervalosDeCobranca=" + totalDeIntervalosDeCobranca +
                ", valorTotal=" + valorTotal +
                ", status=" + status +
                ", pagamento=" + pagamento +
                '}';
    }

    public static Ticket reconstituir(
            UUID id,
            String placaVeiculo,
            Integer intervaloDeCobranca,
            Integer margemTempoParaSaidaEmMinutos,
            Double valorUnitarioIntervaloDeCobranca,
            LocalDateTime dataHoraEntrada,
            LocalDateTime dataHoraSaida,
            LocalDateTime dataHoraPermitidaSaida,
            LocalDateTime dataHoraPagamento,
            Integer tempoPermanencia,
            Integer totalIntervalosDeCobranca,
            Double valorTotal,
            StatusTicket status) {
        return new Ticket(
                id,
                placaVeiculo,
                intervaloDeCobranca,
                margemTempoParaSaidaEmMinutos,
                valorUnitarioIntervaloDeCobranca,
                dataHoraEntrada,
                dataHoraSaida,
                dataHoraPermitidaSaida,
                dataHoraPagamento,
                tempoPermanencia,
                totalIntervalosDeCobranca,
                valorTotal,
                status
        );
    }
}
