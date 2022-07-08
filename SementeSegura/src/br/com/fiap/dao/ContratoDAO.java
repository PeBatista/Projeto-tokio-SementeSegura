package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.model.Contrato;

public class ContratoDAO {

	private Connection conexao;

	public ContratoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void insert(Contrato contrato) throws SQLException {

		String sql = "insert into t_contrato (ds_ass_cliente, ds_ass_corretor, dt_inicio_contrato, dt_fim_contrato, cd_cliente, cd_corretor, cd_seguro_vida) values (?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		

		stmt.setString(1, contrato.getDsAssCliente());
		stmt.setString(2, contrato.getDsAssCorretor());
		stmt.setDate(3, contrato.getDtInicioContrato());
		stmt.setDate(4, contrato.getDtFimContrato());
		stmt.setInt(5, contrato.getCdCliente());
		stmt.setInt(6, contrato.getCdCorretor());
		stmt.setInt(7, contrato.getCdSeguroVida());

		stmt.execute();

		stmt.close();

	}

	public List<Contrato> select() throws SQLException {

		List<Contrato> contratos = new ArrayList<Contrato>();
		String sql = "Select * from t_contrato";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Contrato contrato = new Contrato(rs.getString("ds_ass_cliente"),
					rs.getString("ds_ass_corretor"), rs.getDate("dt_inicio_contrato"), rs.getDate("dt_fim_contrato"),
					rs.getInt("cd_cliente"), rs.getInt("cd_corretor"), rs.getInt("cd_seguro_vida"));

			contrato.setCdContrato(rs.getInt("cd_contrato"));
			
			contratos.add(contrato);

		}

		rs.close();
		stmt.close();
		return contratos;

	}

	public Contrato selectByCd(int cd) throws SQLException {

		Contrato contrato = null;
		String sql = "Select * from t_contrato where cd_contrato=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		stmt.setInt(1, cd);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			contrato = new Contrato(rs.getString("ds_ass_cliente"),
					rs.getString("ds_ass_corretor"), rs.getDate("dt_inicio_contrato"), rs.getDate("dt_fim_contrato"),
					rs.getInt("cd_cliente"), rs.getInt("cd_corretor"), rs.getInt("cd_seguro_vida"));

			System.out.println(rs.getInt("cd_contrato") + "\t" + rs.getString("ds_ass_cliente") + "\t"
					+ rs.getString("ds_ass_corretor") + "\t" + sdf.format(rs.getDate("dt_inicio_contrato")) + "\t"
					+ rs.getDate("dt_fim_contrato"));

		} else {
			System.out.println("Esse numero de contrato nao existe.");
		}

		rs.close();
		stmt.close();
		return contrato;

	}

	public Contrato selectByAssCliente(String assCliente) throws SQLException {

		Contrato contrato = null;
		String sql = "Select * from t_contrato where ds_ass_cliente=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		stmt.setString(1, assCliente);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			contrato = new Contrato(rs.getString("ds_ass_cliente"),
					rs.getString("ds_ass_corretor"), rs.getDate("dt_inicio_contrato"), rs.getDate("dt_fim_contrato"),
					rs.getInt("cd_cliente"), rs.getInt("cd_corretor"), rs.getInt("cd_seguro_vida"));

			System.out.println(rs.getInt("cd_contrato") + "\t" + rs.getString("ds_ass_cliente") + "\t"
					+ rs.getString("ds_ass_corretor") + "\t" + sdf.format(rs.getDate("dt_inicio_contrato")) + "\t"
					+ rs.getDate("dt_fim_contrato"));

		}

		rs.close();
		stmt.close();
		return contrato;

	}

	public Contrato selectByAssCorretor(String assCorretor) throws SQLException {

		Contrato contrato = null;
		String sql = "Select * from t_contrato where ds_ass_corretor=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		stmt.setString(1, assCorretor);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			contrato = new Contrato(rs.getString("ds_ass_cliente"),
					rs.getString("ds_ass_corretor"), rs.getDate("dt_inicio_contrato"), rs.getDate("dt_fim_contrato"),
					rs.getInt("cd_cliente"), rs.getInt("cd_corretor"), rs.getInt("cd_seguro_vida"));

			System.out.println(rs.getInt("cd_contrato") + "\t" + rs.getString("ds_ass_cliente") + "\t"
					+ rs.getString("ds_ass_corretor") + "\t" + sdf.format(rs.getDate("dt_inicio_contrato")) + "\t"
					+ rs.getDate("dt_fim_contrato"));

		}

		rs.close();
		stmt.close();
		return contrato;

	}

	public List<Contrato> listarPorCorretorNome(String nmCorretor) {
		List<Contrato> contratos = new ArrayList<Contrato>();
		try {
			String sql = "SELECT ds_ass_cliente, ds_ass_corretor, dt_inicio_contrato, cd_corretor, cd_contrato FROM t_contrato WHERE ds_ass_corretor = ?";

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nmCorretor);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contrato contrato = new Contrato(rs.getString("ds_ass_cliente"), rs.getString("ds_ass_corretor"), null, null, 0, 0, 0);
				
				contratos.add(contrato);
			}
			stmt.close();
			rs.close();
			return contratos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contrato> listarPorCorretorCd(int cdCorretor) {
		List<Contrato> contratos = new ArrayList<Contrato>();
		try {
			String sql = "SELECT ds_ass_cliente, ds_ass_corretor, dt_inicio_contrato, cd_corretor, cd_contrato FROM t_contrato WHERE cd_corretor = ?";

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdCorretor);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contrato contrato = new Contrato(null, null, null, null, 0, 0, 0);
				contrato.setDsAssCliente(rs.getString("ds_ass_cliente"));
				contrato.setDsAssCorretor(rs.getString("ds_ass_corretor"));
				contrato.setDtInicioContrato(rs.getDate("dt_inicio_contrato"));
				contrato.setCdCorretor(rs.getInt("cd_corretor"));
				contrato.setCdContrato(rs.getInt("cd_contrato"));
				contratos.add(contrato);
			}
			stmt.close();
			rs.close();
			return contratos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contrato> listarContratoAssegurados() {
		List<Contrato> contratos = new ArrayList<Contrato>();
		try {
			String sql = "SELECT * FROM t_contrato";

			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contrato contrato = new Contrato(null, null, null, null, 0, 0, 0);
				contrato.setDsAssCliente(rs.getString("ds_ass_cliente"));
				contrato.setDsAssCorretor(rs.getString("ds_ass_corretor"));
				contrato.setDtInicioContrato(rs.getDate("dt_inicio_contrato"));
				contrato.setCdCorretor(rs.getInt("cd_corretor"));
				contrato.setCdContrato(rs.getInt("cd_contrato"));
				contratos.add(contrato);
			}
			stmt.close();
			rs.close();
			return contratos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Contrato contrato, int cd) throws SQLException {

		String sql = "update t_contrato set ds_ass_cliente=?, ds_ass_corretor=?, dt_inicio_contrato=?, dt_fim_contrato=?, cd_cliente=?, cd_corretor=?, cd_seguro_vida=? where cd_contrato=?";

		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, contrato.getDsAssCliente());
		stmt.setString(2, contrato.getDsAssCorretor());
		stmt.setDate(3, contrato.getDtInicioContrato());
		stmt.setDate(4, contrato.getDtFimContrato());
		stmt.setInt(5, contrato.getCdCliente());
		stmt.setInt(6, contrato.getCdCorretor());
		stmt.setInt(7, contrato.getCdSeguroVida());
		stmt.setInt(8, cd);

		stmt.execute();

		stmt.close();

	}
	
	public void excluir(int cd) {
		try {
			PreparedStatement stmt = conexao.prepareStatement("DELETE FROM t_contrato WHERE cd_contrato = ?");
			stmt.setInt(1, cd);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
