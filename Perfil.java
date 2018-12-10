import java.util.Arrays;

public class Perfil {

	private String descricao;		//nome
	private Permissao[] permissoes;

	private static final int TAMANHO = 2;
	
	public Perfil() {
		this.permissoes = new Permissao[TAMANHO];
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Permissao[] getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Permissao[] permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public String toString() {
		String str = "     -> Perfil: " + descricao + "\n";
		
		for(int i = 0; i < TAMANHO; i++ ) {
			str += "\t" + permissoes[i].toString() + "\n";
		}
		
		return str;
	}

}
