package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.dao.SaudeClienteDAO;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.SaudeCliente;

public class SaudeClienteController {

	private SaudeClienteDAO saudeClienteDAO;

	public SaudeClienteController() {
		Connection connection = new ConnectionFactory().conectar();
		this.saudeClienteDAO = new SaudeClienteDAO(connection);
	}
	
	public void insert(SaudeCliente saude) throws SQLException {
		this.saudeClienteDAO.insert(saude);
		System.out.println("Dados de saude inseridos.");
	}
	
	public void select() throws SQLException {
		List<SaudeCliente> saudes = this.saudeClienteDAO.select();
		
		for(SaudeCliente saude:saudes) {
			System.out.println("Codigo: " + saude.getCdSaudeClinte() + "\t| Nome: " + saude.getNmAsseguradoSaude() + "\t| Descrição da doença: " + saude.getDsDoencaCliente() + "\t| Vicio: " + saude.getSgVicioCliente() + "\t| Codigo cliente: " + saude.getCdCliente());
		}
		
	}
	
	public void update(SaudeCliente saude, int cd) throws SQLException {
		this.saudeClienteDAO.update(saude, cd);
		System.out.println("Update realizado.");
	}
	
	public void delete(int cd) {
		this.saudeClienteDAO.excluir(cd);
		System.out.println("Coluna deletada.");
	}
	
}
