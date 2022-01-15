package entidades;

public class PessoaFisica extends PessoaComum{
	private Double gastoSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}
	
	@Override
	public double imposto() {
		double imposto = 0;
		if (super.getRendaAnual() < 20000.0) {
			imposto = super.getRendaAnual() * 0.15;
		} else {
			imposto = super.getRendaAnual() * 0.25;
		}
		
		if (gastoSaude != 0) {
			imposto -= gastoSaude * 0.5;
		}
		return imposto;
	}
}
