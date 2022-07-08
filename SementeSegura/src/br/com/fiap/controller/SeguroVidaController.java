package br.com.fiap.controller;
	
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.dao.SeguroVidaDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.SeguroVida;
	
public class SeguroVidaController {
	
	private SeguroVidaDAO seguroVidaDAO;
	
	public SeguroVidaController() {
		Connection connection = new ConnectionFactory().conectar();
		this.seguroVidaDAO = new SeguroVidaDAO(connection);
	}
	
	public void select() throws SQLException {
		List<SeguroVida> seguros = this.seguroVidaDAO.select();
		
		for(SeguroVida seguro:seguros) {

				System.out.println("Codigo: " + seguro.getCdSeguroVida() + "\t| Seguro: " + seguro.getNmSeguroVida() + "\t| Valor: " + seguro.getVlSeguroVida() + "\t| Cobertura: " + seguro.getDsCobertura());
		
		}
		
	}

	/*
	public List<SeguroVida> selectSeguroAssCliente() throws SQLException {
		List<SeguroVida> seguros = this.seguroVidaDAO.selectSeguroAssCliente();
		return seguros;
	}
	*/
	
}
