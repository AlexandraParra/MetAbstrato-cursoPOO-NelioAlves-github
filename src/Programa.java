import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.PessoaComum;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List <PessoaComum> list = new ArrayList<>();
		System.out.print("Digite o número de contribuintes: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Dados do pagador #" + i + ":");
			System.out.print("Pessoa física ou jurídica (f/j): ");
			char p = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			
			if (p == 'f') {
				System.out.print("Gastos com saúde: ");
				double gastoSaude = sc.nextDouble();
				PessoaComum pessoa = new PessoaFisica(nome, rendaAnual, gastoSaude);
				list.add(pessoa);
			} else {
				System.out.print("Número de funcinários: ");
				int numeroFunc = sc.nextInt();
				PessoaComum pessoa = new PessoaJuridica(nome, rendaAnual, numeroFunc);
				list.add(pessoa);
			}
		}
		
		System.out.println();
		System.out.println("Impostos a pagar:");
		for (PessoaComum pessoa : list) {
			System.out.println(pessoa);
		}
		
		double soma = 0;
		for (PessoaComum pessoa : list) {
			soma += pessoa.imposto();
		}
		System.out.printf("Total impostos: $%.2f",soma);
		sc.close();

	}

}
