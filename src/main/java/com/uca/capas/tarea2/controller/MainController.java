package com.uca.capas.tarea2.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/alumno")
	public @ResponseBody String Alumno() {
		return "Nombre: Cristian "  +
				"Apellido: Mundo " + 
				"Carnet: 00086917 " + 
				"Carrera: Ing. Informatica " +
				"Nivel: 4to anio " ;
	}
	
	@RequestMapping("/parameter")
	public @ResponseBody String Parameter(HttpServletRequest request) {
		Integer dia = Integer.parseInt(request.getParameter("dia"));
		Integer mes = Integer.parseInt(request.getParameter("mes"));
		Integer anio = Integer.parseInt(request.getParameter("anio"));
		Calendar cal = Calendar.getInstance();
		//le sumo 1 porque enero tinee como constante = 0
		cal.set(anio, mes+1, dia);
		
		int queDia = cal.get(Calendar.DAY_OF_WEEK);
		String diaFecha;
		String fecha = Integer.toString(cal.get(Calendar.DATE)) +"/"+
						Integer.toString(cal.get(Calendar.MONTH)-1)+"/"+
						Integer.toString(cal.get(Calendar.YEAR));
		
		switch (queDia-5) {
		 case 2: diaFecha = "Lunes";
		 break;
		 case 3: diaFecha = "Martes";
		 break;
		 case 4: diaFecha = "Miercoles";
		 break;
		 case 5: diaFecha = "Jueves";
		 break;
		 case 6: diaFecha = "Viernes";
		 break;
		 case 7: diaFecha = "Sabado";
		 break;
		 default: diaFecha = "Domingo";
		 break;
		 }
		 
		return "Dia de la semana de la fecha: " + fecha + " es: " + diaFecha;
	}
		

	
}
