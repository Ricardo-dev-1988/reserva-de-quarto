package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.ExcecoesDeDominio;

public class Reserva {

	private Integer numQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(Integer numQuarto, Date dataEntrada, Date dataSaida) {
		if(!dataSaida.after(dataEntrada)) {
			throw new ExcecoesDeDominio("A DATA DE SAÍDA DEVE SER POSTERIOR À DATA DE ENTRADA!");
		}
		this.numQuarto = numQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getDataEntra() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public long duracao() {
		long diferenca = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);	
	}
	
	public void atualizarData(Date dataEntrada, Date dataSaida) {
		Date agora = new Date();
		if(dataEntrada.before(agora) || dataSaida.before(agora)) {
			throw new ExcecoesDeDominio("AS DATAS DE RESERVA PARA ATUALIZAÇÃO DEVEM SER DATAS FUTURAS!");
		}
		if(!dataSaida.after(dataEntrada)) {
			throw new ExcecoesDeDominio("A DATA DE SAÍDA DEVE SER POSTERIOR À DATA DE ENTRADA!");
		}
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Quarto: " + numQuarto);
		sb.append(", data de entrada: " + sdf.format(dataEntrada));
		sb.append(", data de saída: " + sdf.format(dataSaida));
		sb.append(", " + duracao() + " noites");
		return sb.toString();
	}
}
