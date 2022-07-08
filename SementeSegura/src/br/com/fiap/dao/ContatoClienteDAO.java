package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.model.ContatoCliente;

public class ContatoClienteDAO {
	
	private Connection conexao;

	public ContatoClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void insert(ContatoCliente contato) throws SQLException {
		String sql = "insert into t_contato_cliente (ds_email_cliente, nr_cel_cliente, nr_tel_cliente, nm_rua_cliente, nr_moradia_cliente, nr_cep_cliente, ds_complemento_cliente, nm_bairro_cliente, nm_cidade_cliente, nm_estado_cliente, cd_cliente) values (?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement stmt = conexao.prepareStatement(sql);

						stmt.setString(1, contato.getDsEmilCliente());
						stmt.setInt(2, contato.getNrCelCliente());
						stmt.setString(3, contato.getNrTelCliente());
						stmt.setString(4, contato.getNmRuaCliente());
						stmt.setInt(5, contato.getNrMoradiaCliente());
						stmt.setString(6, contato.getNrCepCliente());
						stmt.setString(7, contato.getDsComplementoClinte());
						stmt.setString(8, contato.getNmBairroCliente());
						stmt.setString(9, contato.getNmCidadeCliente());
						stmt.setString(10, contato.getNmEstadoCliente());
						stmt.setInt(11, contato.getCdCliente());

						stmt.execute();
						stmt.close();
	}
	
	public List<ContatoCliente> select() throws SQLException {
		List<ContatoCliente> contatos = new ArrayList<ContatoCliente>();
		String sql = "select * from t_contato_cliente";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			ContatoCliente contato = new ContatoCliente(null, 0, null, null, 0, null, null, null, null, null, 0);
			contato.setCdContatoCliente(rs.getInt("cd_contato_cliente"));
			contato.setNmRuaCliente(rs.getString("nm_rua_cliente"));
			contato.setNrMoradiaCliente(rs.getInt("nr_moradia_cliente"));
			contato.setNrCepCliente(rs.getString("nr_cep_cliente"));
			contato.setDsComplementoClinte(rs.getString("ds_complemento_cliente"));
			contato.setNmBairroCliente(rs.getString("nm_bairro_cliente"));
			contato.setNmCidadeCliente(rs.getString("nm_cidade_cliente"));
			contato.setNmEstadoCliente(rs.getString("nm_estado_cliente"));
			contato.setDsEmilCliente(rs.getString("ds_email_cliente"));
			contato.setNrCelCliente(rs.getInt("nr_cel_cliente"));
			contato.setNrTelCliente(rs.getString("nr_tel_cliente"));
			contato.setCdCliente(rs.getInt("cd_cliente"));

			contatos.add(contato);
		}

		rs.close();
		stmt.close();
		return contatos;
	}
	
	public void selectByCd(int cd) throws SQLException {

		ContatoCliente contato = null;
		String sql = "Select * from t_contato_cliente where cd_cliente=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, cd);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			contato = new ContatoCliente(null, 0, null, null, 0, null, null, null, null, null, 0);
			contato.setCdContatoCliente(rs.getInt("cd_contato_cliente"));
			contato.setNmRuaCliente(rs.getString("nm_rua_cliente"));
			contato.setNrMoradiaCliente(rs.getInt("nr_moradia_cliente"));
			contato.setNrCepCliente(rs.getString("nr_cep_cliente"));
			contato.setDsComplementoClinte(rs.getString("ds_complemento_cliente"));
			contato.setNmBairroCliente(rs.getString("nm_bairro_cliente"));
			contato.setNmCidadeCliente(rs.getString("nm_cidade_cliente"));
			contato.setNmEstadoCliente(rs.getString("nm_estado_cliente"));
			contato.setDsEmilCliente(rs.getString("ds_email_cliente"));
			contato.setNrCelCliente(rs.getInt("nr_cel_cliente"));
			contato.setNrTelCliente(rs.getString("nr_tel_cliente"));
			contato.setCdCliente(rs.getInt("cd_cliente"));

			System.out.println("Cidade: " + rs.getString("nm_cidade_cliente") + "\t| CEP: " + rs.getString("nr_cep_cliente") + "\t| Email: " + rs.getString("ds_email_cliente") + "\t| Celular: " + rs.getInt("nr_cel_cliente") + "\t| Telefone: " + rs.getString("nr_tel_cliente")); 

		} else {
			System.out.println("O codigo do cliente digitado nao existe.");
		}

		rs.close();
		stmt.close();

	}
	
	public void update(ContatoCliente contato, int cd) throws SQLException {
		String sql = "update t_contato_cliente set ds_email_cliente=?, nr_cel_cliente=?, nr_tel_cliente=?, nm_rua_cliente=?, nr_moradia_cliente=?, nr_cep_cliente=?, ds_complemento_cliente=?, nm_bairro_cliente=?, nm_cidade_cliente=?, nm_estado_cliente=?, cd_cliente=? where cd_contato_cliente=?";

		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, contato.getDsEmilCliente());
		stmt.setInt(2, contato.getNrCelCliente());
		stmt.setString(3, contato.getNrTelCliente());
		stmt.setString(4, contato.getNmRuaCliente());
		stmt.setInt(5, contato.getNrMoradiaCliente());
		stmt.setString(6, contato.getNrCepCliente());
		stmt.setString(7, contato.getDsComplementoClinte());
		stmt.setString(8, contato.getNmBairroCliente());
		stmt.setString(9, contato.getNmCidadeCliente());
		stmt.setString(10, contato.getNmEstadoCliente());
		stmt.setInt(11, contato.getCdCliente());
		stmt.setInt(12, cd);

		stmt.execute();

		stmt.close();
	}
	
	public void excluir(int cd) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM t_contato_cliente WHERE cd_contato_cliente = ?");
			stmt.setInt(1, cd);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
