package br.com.fiap.data;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Data {

	public Date dataAlt(int dia, int mes, int ano) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.YEAR, ano);
		Date date = new Date(cal.getTimeInMillis());

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		sdf.format(date);

		return date;
	} 
	
	public Date dataHoje() {
		
		Calendar cal = Calendar.getInstance();
		Date data = new Date(cal.getTimeInMillis());
		
		return data;
	}
	
}
