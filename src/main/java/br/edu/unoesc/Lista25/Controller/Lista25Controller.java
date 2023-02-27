package br.edu.unoesc.Lista25.Controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.Lista25.Controller.Calculadora.Calculadora;
import br.edu.unoesc.Lista25.Controller.Calculadora.ConversorNumerico;
import br.edu.unoesc.Lista25.Error.Exceptions.ErroDeDivisaoPorZeroException;
import br.edu.unoesc.Lista25.Error.Exceptions.ErroDeRaizQuadradaException;

@RestController
@RequestMapping("/api/calculadora")
public class Lista25Controller {
	Calculadora Calculadora = new Calculadora();
	ConversorNumerico conversor;
	private Logger logger = Logger.getLogger(Lista25Controller.class.getName());

	// Versão com Query Params
	@GetMapping("/somar")
	public Double somarQuery(@RequestParam(value = "numero1", defaultValue = "0") Double numero1,
			@RequestParam(value = "numero2", defaultValue = "0") Double numero2) {
		logger.info("Calculando... " + numero1 + " + " + numero2);
		return Calculadora.somar(numero1, numero2);
	}

	@GetMapping("/subtrair")
	public Double subtrairQuery(@RequestParam(value = "numero1", defaultValue = "0") Double numero1,
			@RequestParam(value = "numero2", defaultValue = "0") Double numero2) {
		logger.info("Calculando... " + numero1 + " - " + numero2);
		return Calculadora.subtrair(numero1, numero2);
	}

	@GetMapping("/multplicar")
	public Double multplicarQuery(@RequestParam(value = "numero1", defaultValue = "0") Double numero1,
			@RequestParam(value = "numero2", defaultValue = "0") Double numero2) {
		logger.info("Calculando... " + numero1 + " * " + numero2);
		return Calculadora.multiplicar(numero1, numero2);
	}

	//
	// metodo Usando Error Exception Padrão
	@SuppressWarnings("finally")
	@GetMapping("/dividir")
	public Double dividirQuery(@RequestParam(value = "numero1", defaultValue = "0") Double numero1,
			@RequestParam(value = "numero2", defaultValue = "0") Double numero2) {
		double res = 0;
		try {
			res = Calculadora.dividir(numero1, numero2);
		} catch (Exception error) {

			logger.info("Impossível dividir por zero");
		} finally {

			return res;
		}
	}

	@GetMapping("/media")
	public Double mediaQuery(@RequestParam(value = "numero1", defaultValue = "0") Double numero1,
			@RequestParam(value = "numero2", defaultValue = "0") Double numero2) {
		logger.info("Calculando Média ");
		return Calculadora.media(numero1, numero2);
	}

	@GetMapping("/potencia")
	public Double potenciaQuery(@RequestParam(value = "numero1", defaultValue = "0") Double numero1,
			@RequestParam(value = "numero2", defaultValue = "0") Double numero2) {
		logger.info("Calculando Potencia");
		return Calculadora.potencia(numero1, numero2);
	}

	// metodo Usando Error Exception Padrão
	@SuppressWarnings("finally")
	@GetMapping("/raiz")
	public Double raizQuery(@RequestParam(value = "numero1", defaultValue = "0") Double numero1) {
		try {

			return Calculadora.raizQuadrada(numero1);

		} catch (Exception erro) {
			logger.info("Numero negativos não possuem raiz quadrada");
		} finally {
			return numero1;

		}
	}

	// versão Path Params

	@RequestMapping(value = "/somar-path/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double somarPath(@PathVariable("numero1") String numero1, @PathVariable(value = "numero2") String numero2) {
		logger.info("Calculando... " + numero1 + " + " + numero2);
		return Calculadora.somarPath(numero1, numero2);
	}

	@RequestMapping(value = "/subtrair-path/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double subtrairPath(@PathVariable("numero1") String numero1,
			@PathVariable(value = "numero2") String numero2) {
		logger.info("Calculando... " + numero1 + " - " + numero2);
		return Calculadora.subtrairPath(numero1, numero2);
	}

	@RequestMapping(value = "/multiplicar-path/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double multiplciarPath(@PathVariable("numero1") String numero1,
			@PathVariable(value = "numero2") String numero2) {
		logger.info("Calculando... " + numero1 + " * " + numero2);
		return Calculadora.multiplicarPath(numero1, numero2);
	}

	// metodo Usando Error Exception Personalizado
	@SuppressWarnings("finally")
	@RequestMapping(value = "/dividir-path/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double dividirPath(@PathVariable("numero1") String numero1,
			@PathVariable(value = "numero2") String numero2) {
		double res = 0;
		try {
			res = Calculadora.dividirPath(numero1, numero2);
		} catch (ErroDeDivisaoPorZeroException erro) {
			System.out.println(erro.getMessage());
			logger.info(erro.getMessage());
		} finally {
			return res;
		}
	}

	@RequestMapping(value = "/media-path/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double mediaPath(@PathVariable("numero1") String numero1, @PathVariable(value = "numero2") String numero2) {
		logger.info("Calculando Média");
		return Calculadora.mediaPath(numero1, numero2);
	}

	@RequestMapping(value = "/potencia-path/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double potenciaPath(@PathVariable("numero1") String numero1,
			@PathVariable(value = "numero2") String numero2) {
		logger.info("Calculando Potencia");
		return Calculadora.potenciaPath(numero1, numero2);
	}

	// metodo Usando Error Exception Personalizado
	@SuppressWarnings("finally")
	@RequestMapping(value = "/raiz-path/{numero1}", method = RequestMethod.GET)
	public Double raizPath(@PathVariable("numero1") String numero1) {
		double res = 0;
		try {
			res = Calculadora.raizPath(numero1);
		} catch (ErroDeRaizQuadradaException erro) {
			System.out.println(erro.getMessage());
			logger.info(erro.getMessage());

		} finally {
			return res;
		}
	}
}