package br.com.fiap.model;

import java.util.ArrayList;
import java.util.List;

public class SeguroVida {
	
	private int cdSeguroVida;
	private double vlSeguroVida;
	private String nmSeguroVida, dsCobertura;
	private List<Contrato> contratos = new ArrayList<Contrato>();
	
	public SeguroVida() {
	}
	
	public List<Contrato> getContrato() {
		return contratos;
	}

	public void AdicionarContrato(Contrato contrato) {
		contratos.add(contrato);
	}

	

	public int getCdSeguroVida() {
		return cdSeguroVida;
	}

	public void setCdSeguroVida(int cdSeguroVida) {
		this.cdSeguroVida = cdSeguroVida;
	}

	public double getVlSeguroVida() {
		return vlSeguroVida;
	}

	public void setVlSeguroVida(double vlSeguroVida) {
		this.vlSeguroVida = vlSeguroVida;
	}

	public String getNmSeguroVida() {
		return nmSeguroVida;
	}

	public void setNmSeguroVida(String nmSeguroVida) {
		this.nmSeguroVida = nmSeguroVida;
	}

	public String getDsCobertura() {
		return dsCobertura;
	}

	public void setDsCobertura(String dsCobertura) {
		this.dsCobertura = dsCobertura;
	}
	
	

}
