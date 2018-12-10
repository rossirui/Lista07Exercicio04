
public class Usuario {

	private Perfil perfil;
	private String nome;
	
	public Usuario() {
	}

	public Usuario(Perfil perfil, String nome) {
		this.perfil = perfil;
		this.nome = nome;
	}



	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario: " + nome + "\n" + this.perfil.toString();
	}
	
}
