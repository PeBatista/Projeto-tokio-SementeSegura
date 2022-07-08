package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Contrato;
import br.com.fiap.model.SeguroVida;

public class SeguroVidaDAO {

	private Connection conexao;

	public SeguroVidaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public List<SeguroVida> selectSeguroAssCliente() throws SQLException {
		
		try {
			SeguroVida seguroVida = null;
			List<SeguroVida> seguros = new ArrayList<SeguroVida>();

			String sql = "SELECT s.nm_seguro_vida, c.ds_ass_cliente FROM t_seguro_vida s INNER JOIN t_contrato c ON s.cd_seguro_vida = c.cd_seguro_vida order by s.cd_seguro_vida";

			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()) {
					if (seguroVida == null || !seguroVida.getNmSeguroVida().equals(rs.getString(1))) {
						SeguroVida seguro = new SeguroVida();
						seguroVida.setNmSeguroVida((rs.getString(1)));
						seguros.add(seguro);
						seguroVida = seguro;
					}
					Contrato contrato = new Contrato(rs.getString("ds_ass_cliente"),
							rs.getString("ds_ass_corretor"), rs.getDate("dt_inicio_contrato"), rs.getDate("dt_fim_contrato"),
							rs.getInt("cd_cliente"), rs.getInt("cd_corretor"), rs.getInt("cd_seguro_vida"));
					
					
					seguroVida.AdicionarContrato(contrato);
				}
				rs.close();
				stmt.close();
				return seguros;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public List<SeguroVida> select() throws SQLException {

		List<SeguroVida> seguros = new ArrayList<SeguroVida>();
		String sql = "Select * from t_seguro_vida";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			SeguroVida seguroVida = new SeguroVida();
			seguroVida.setCdSeguroVida((rs.getInt("CD_SEGURO_VIDA")));
			seguroVida.setVlSeguroVida((rs.getDouble("VL_SEGURO_VIDA")));
			seguroVida.setNmSeguroVida((rs.getString("NM_SEGURO_VIDA")));
			seguroVida.setDsCobertura((rs.getString("DS_COBERTURA")));
			
			seguros.add(seguroVida);

		}

		rs.close();
		stmt.close();
		return seguros;

	}
	
}
