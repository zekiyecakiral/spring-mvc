package com.mkyong.form.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.mkyong.form.model.Arac;


@Repository
public class AracDaoImpl implements AracDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Arac findById(Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM arac WHERE id=:id";

		Arac result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new AracMapper());
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
		}

		/*
		 * User result = namedParameterJdbcTemplate.queryForObject( sql, params,
		 * new BeanPropertyRowMapper<User>());
		 */

		return result;

	}

	@Override
	public List<Arac> findAll() {

		String sql = "SELECT * FROM arac";
		List<Arac> result = namedParameterJdbcTemplate.query(sql, new AracMapper());
		

		return result;

	}

	@Override
	public void save(Arac arac) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		String sql = "INSERT INTO ARAC(SANTRAL, ARACPLAKASI, ADSOYAD, TARIH, HAREKETSAATI, BASLANGICKM, SONKM ,ARACDURUMU) "
				+ "VALUES ( :santral, :aracPlakasi, :adSoyad, :tarih, :hareketSaati, :baslangicKm, :sonKm, :aracDurumu)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(arac), keyHolder);
		arac.setId(keyHolder.getKey().intValue());
		
	}

	@Override
	public void update(Arac arac) {

		String sql = "UPDATE ARAC SET SANTRAL=:santral, ARACPLAKASI=:aracPlakasi, ADSOYAD=:adSoyad, " + "TARIH=:tarih, HAREKETSAATI=:hareketSaati, BASLANGICKM=:baslangicKm, "
				+ "SONKM=:sonKm, ARACDURUMU=:aracDurumu WHERE id=:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(arac));

	}

	@Override
	public void delete(Integer id) {

		String sql = "DELETE FROM ARAC WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

	}

	private SqlParameterSource getSqlParameterByModel(Arac arac) {

		// Unable to handle List<String> or Array
		// BeanPropertySqlParameterSource

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", arac.getId());
		paramSource.addValue("santral", arac.getSantral());
		paramSource.addValue("aracPlakasi", arac.getAracPlakasi());
		paramSource.addValue("adSoyad", arac.getAdSoyad());
		paramSource.addValue("tarih", arac.getTarih());
		paramSource.addValue("hareketSaati", arac.getHareketSaati());
		paramSource.addValue("baslangicKm", arac.getBaslangicKm());
		paramSource.addValue("sonKm", arac.getSonKm());
		paramSource.addValue("aracDurumu", arac.getAracDurumu());
		return paramSource;
	}

	private static final class AracMapper implements RowMapper<Arac> {

		public Arac mapRow(ResultSet rs, int rowNum) throws SQLException {
			Arac arac = new Arac();
			arac.setId(rs.getInt("id"));
			arac.setSantral(rs.getString("santral"));
			arac.setAracPlakasi(rs.getString("aracPlakasi"));
			arac.setAdSoyad(rs.getString("adSoyad"));
			arac.setTarih(rs.getString("tarih"));
			arac.setHareketSaati(rs.getString("hareketSaati"));
			arac.setBaslangicKm(rs.getLong("baslangicKm"));
			arac.setSonKm(rs.getLong("sonKm"));
			arac.setAracDurumu(rs.getString("aracDurumu"));
			
			return arac;
		}
	}

}