package br.edu.unoesc.Lista25.Controller.Calculadora;

import br.edu.unoesc.Lista25.Error.Exceptions.ErroDeDivisaoPorZeroException;
import br.edu.unoesc.Lista25.Error.Exceptions.ErroDeRaizQuadradaException;

public class Calculadora {

	public Double somar(double x, double y) {
		return x + y;

	}

	public double somarPath(String numero1, String numero2) {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
			return 0d;
		}

		return ConversorNumerico.converterParaDouble(numero1) + ConversorNumerico.converterParaDouble(numero2);
	}

	public Double subtrair(double x, double y) {
		return x - y;

	}

	public double subtrairPath(String numero1, String numero2) {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
			return 0d;
		}

		return ConversorNumerico.converterParaDouble(numero1) - ConversorNumerico.converterParaDouble(numero2);
	}

	public Double dividir(double x, double y) throws IllegalArgumentException {
		if (x == 0 || x == 0.0 || y == 0 || y == 0.0) {
			IllegalArgumentException error = new IllegalArgumentException("Erro de divisão por zero");
			throw error;

		}
		return x / y;

	}

	public double dividirPath(String numero1, String numero2) throws ErroDeDivisaoPorZeroException {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
			return 0d;
		}
		Double n1 = ConversorNumerico.converterParaDouble(numero1);
		Double n2 = ConversorNumerico.converterParaDouble(numero2);

		if (n1 == 0 || n1 == 0.0 || n2 == 0 || n2 == 0.0) {
			throw new ErroDeDivisaoPorZeroException("Impossivel dividir por zero");
		}
		return n1 / n2;
	}

	public Double multiplicar(double x, double y) {
		return x * y;

	}

	public double multiplicarPath(String numero1, String numero2) {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
			return 0d;
		}

		return ConversorNumerico.converterParaDouble(numero1) * ConversorNumerico.converterParaDouble(numero2);
	}

	public Double media(double x, double y) {
		return (x + y) / 2;

	}

	public double mediaPath(String numero1, String numero2) {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
			return 0d;
		}

		return (ConversorNumerico.converterParaDouble(numero1) + ConversorNumerico.converterParaDouble(numero2)) / 2;
	}

	public Double potencia(double x, double y) {
		return Math.pow(x, y);

	}

	public double potenciaPath(String numero1, String numero2) {
		if (!ConversorNumerico.ehNumerico(numero1) || !ConversorNumerico.ehNumerico(numero2)) {
			return 0d;
		}

		return Math.pow(ConversorNumerico.converterParaDouble(numero1), ConversorNumerico.converterParaDouble(numero2));
	}

	public Double raizQuadrada(double x) throws IllegalArgumentException {

		System.out.println(x);
		if (x < 0) {
			IllegalArgumentException erro = new IllegalArgumentException(
					"Não é possivel raiz quadrada de numeros negativos");
			throw erro;
		} else {
			return Math.sqrt(x);
		}
	}

	public double raizPath(String numero1) throws ErroDeRaizQuadradaException {
		if (!ConversorNumerico.ehNumerico(numero1)) {
			return 0d;
		}
		Double n1 = ConversorNumerico.converterParaDouble(numero1);
		if (n1 == 0 || n1 == 0.0) {
			throw new ErroDeRaizQuadradaException("Erro de raiz quadrada por 0");
		}
		return Math.sqrt(n1);
	}

}
