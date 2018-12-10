import java.util.Arrays;

public class RepositorioUsuariosArray implements RepositorioUsuarios {

	private Usuario[] usuarios;
	private int indice;
	
	public RepositorioUsuariosArray(int tamanho) {
		this.usuarios = new Usuario[tamanho];
		indice = 0;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}


	public void inserir(Usuario usuario) throws UsuarioJaCadastradoException, LimiteUsuarioExcedidoException {
		if(this.indice < usuarios.length) {
			if(buscar(usuario.getNome()) == null) {
				usuarios[indice] = usuario;
				indice++;
			} else {
				UsuarioJaCadastradoException e = new UsuarioJaCadastradoException("Usuário já cadastrado!");
				throw e;
			}					
		} else {
			LimiteUsuarioExcedidoException e = new LimiteUsuarioExcedidoException("Limite de usuários excedido!");
			throw e;
		}				
	}
	
	public void alterar(Usuario usuario) {
		int indiceBusca;
		
		indiceBusca = buscarIndice(usuario);
		if(indiceBusca >= 0) {
			usuarios[indice] = usuario;
		} else {
		}
	}
	
	private int buscarIndice(Usuario usuario) {
		for(int i = 0; i < indice; i++) {
			if(usuarios[i].getNome() == usuario.getNome()) {
				return i;
			}
		}
		return -1;
	}
	
	public Usuario buscar(String nome) {
		for(int i = 0; i < indice; i++) {
			if(usuarios[i].getNome().equals(nome)) {
				return usuarios[i];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String str = "";
		
		for(int i = 0; i < indice; i++) {
			str += usuarios[i].toString() + "\n";
		}
		return str;
	}

}
