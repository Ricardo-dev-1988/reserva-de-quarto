package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.ExcecoesDeDominio;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int numQuarto = sc.nextInt();
			System.out.print("Data de entrada (dia/mês/ano): ");
			Date dataEntrada = sdf.parse(sc.next());
			System.out.print("Data de saída (dia/mês/ano): ");
			Date dataSaida = sdf.parse(sc.next());
			
			Reserva res = new Reserva(numQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: " + res);
			
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.print("Data de entrada (dia/mês/ano): ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Data de saída (dia/mês/ano): ");
			dataSaida = sdf.parse(sc.next());
		
			res.atualizarData(dataEntrada, dataSaida);
			System.out.println("Reserva: " + res);
		}
		catch (ParseException e) {
			System.out.println("FORMATO DE DATA INVÁLIDO!");
		}
		catch(ExcecoesDeDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("ERRO INESPERADO!");
		}
		sc.close();
	}

}
