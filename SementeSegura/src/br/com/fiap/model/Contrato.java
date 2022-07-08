package br.com.fiap.model;

import java.sql.Date;

public class Contrato {
	
	private int cdContrato;
	private String dsAssCliente;
	private String dsAssCorretor;
	private Date dtInicioContrato;
	private Date dtFimContrato;
	private int cdCliente;
	private int cdCorretor;
	private int cdSeguroVida;
	
	public Contrato(String dsAssCliente, String dsAssCorretor, Date dtInicioContrato,
			Date dtFimContrato, int cdCliente, int cdCorretor, int cdSeguroVida) {
		this.dsAssCliente = dsAssCliente;
		this.dsAssCorretor = dsAssCorretor;
		this.dtInicioContrato = dtInicioContrato;
		this.dtFimContrato = dtFimContrato;
		this.cdCliente = cdCliente;
		this.cdCorretor = cdCorretor;
		this.cdSeguroVida = cdSeguroVida;
	}
	
	public int getCdContrato() {
		return cdContrato;
	}
	public void setCdContrato(int cdContrato) {
		this.cdContrato = cdContrato;
	}
	public String getDsAssCliente() {
		return dsAssCliente;
	}
	public void setDsAssCliente(String dsAssCliente) {
		this.dsAssCliente = dsAssCliente;
	}
	public String getDsAssCorretor() {
		return dsAssCorretor;
	}
	public void setDsAssCorretor(String dsAssCorretor) {
		this.dsAssCorretor = dsAssCorretor;
	}
	public Date getDtInicioContrato() {
		return dtInicioContrato;
	}
	public void setDtInicioContrato(Date dtInicioContrato) {
		this.dtInicioContrato = dtInicioContrato;
	}
	public Date getDtFimContrato() {
		return dtFimContrato;
	}
	public void setDtFimContrato(Date dtFimContrato) {
		this.dtFimContrato = dtFimContrato;
	}
	public int getCdCliente() {
		return cdCliente;
	}
	public void setCdCliente(int cdCliente) {
		this.cdCliente = cdCliente;
	}
	public int getCdCorretor() {
		return cdCorretor;
	}
	public void setCdCorretor(int cdCorretor) {
		this.cdCorretor = cdCorretor;
	}
	public int getCdSeguroVida() {
		return cdSeguroVida;
	}
	public void setCdSeguroVida(int cdSeguroVida) {
		this.cdSeguroVida = cdSeguroVida;
	}
	
	

}
