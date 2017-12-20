package it.loginet.corso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import it.loginet.corso.config.Config;
import it.loginet.corso.domain.TestoNumero;

public class Programma {
	
	@Autowired
	private JdbcTemplate jt;

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		ctx.getBean(Programma.class).avvia();
		
		ctx.close();
	}

	private void avvia() {
		String sql = "insert into test (testo, numero) values (?, ?)";
		jt.update(sql, "paperino", 200.24F);
		
		List<Map<String, Object>> tab = jt.queryForList("select * from test");
		for(Map m : tab) {
			for(Object s : m.keySet())
				System.out.println(s + " => " + m.get(s));
		}
		
		List<TestoNumero> tns = jt.query("select * from test", new BeanPropertyRowMapper(TestoNumero.class));
		for(TestoNumero tn : tns)
			System.out.println(tn);
		
		tns = jt.query("select * from test", new RowMapper<TestoNumero>() {

			public TestoNumero mapRow(ResultSet rs, int rowNum) throws SQLException {
				TestoNumero tn = new TestoNumero();
				tn.setId(rs.getInt("id"));
				tn.setTesto(rs.getString("testo"));
				tn.setNumero(rs.getFloat("numero"));
				return tn;
			}
			
		});
		for(TestoNumero tn : tns)
			System.out.println(tn);
		
	}
}
