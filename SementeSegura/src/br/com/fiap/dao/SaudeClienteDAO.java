package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.model.SaudeCliente;

public class SaudeClienteDAO {

	private Connection conexao;

	public SaudeClienteDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void insert(SaudeCliente saude) throws SQLException {
		String sql = "insert into t_saude (nm_assegurado_saude, ds_esp_rad_cliente, ds_doenca_cliente, sg_vicio_cliente, cd_cliente) values (?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, saude.getNmAsseguradoSaude());
		stmt.setString(2, saude.getDsEspRadCliente());
		stmt.setString(3, saude.getDsDoencaCliente());
		stmt.setString(4, String.valueOf(saude.getSgVicioCliente()));
		stmt.setInt(5, saude.getCdCliente());

		stmt.execute();
		stmt.close();
	}
	
	public List<SaudeCliente> select() throws SQLException {
		List<SaudeCliente> saudes = new ArrayList<SaudeCliente>();
		String sql = "Select * from t_saude";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			
			SaudeCliente saude = new SaudeCliente(rs.getString("nm_assegurado_saude"), rs.getString("ds_esp_rad_cliente"), rs.getString("ds_doenca_cliente"), rs.getString("sg_vicio_cliente").charAt(0), rs.getInt("cd_cliente"));
			saude.setCdSaudeClinte(rs.getInt("cd_saude_cliente"));
			saudes.add(saude);

		}

		rs.close();
		stmt.close();
		return saudes;
	}
	
	public void update(SaudeCliente saude, int cd) throws SQLException {
		String sql = "update t_saude set nm_assegurado_saude=?, ds_esp_rad_cliente=?, ds_doenca_cliente=?, sg_vicio_cliente=?, cd_cliente=? where cd_saude_cliente=?";

		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, saude.getNmAsseguradoSaude());
		stmt.setString(2, saude.getDsEspRadCliente());
		stmt.setString(3, saude.getDsDoencaCliente());
		stmt.setString(4, String.valueOf(saude.getSgVicioCliente()));
		stmt.setInt(5, saude.getCdCliente());
		stmt.setInt(6, cd);

		stmt.execute();

		stmt.close();
	}
	
	public void excluir(int cd) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM t_saude WHERE cd_saude_cliente = ?");
			stmt.setInt(1, cd);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
