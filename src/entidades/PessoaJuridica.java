package entidades;

public class PessoaJuridica extends PessoaComum{
	private Integer numeroFunc;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFunc) {
		super(nome, rendaAnual);
		this.numeroFunc = numeroFunc;
	}

	public Integer getNumeroFunc() {
		return numeroFunc;
	}

	public void setNumeroFunc(Integer numeroFunc) {
		this.numeroFunc = numeroFunc;
	}
	
	@Override
	public double imposto() {
		double imposto = 0;
		if (numeroFunc >=10) {
			imposto = super.getRendaAnual() * 0.14;
		} else {
			imposto = super.getRendaAnual() * 0.16;
		}
		
		return imposto;
	}
}
