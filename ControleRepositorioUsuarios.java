
public class ControleRepositorioUsuarios {

	private RepositorioUsuarios usuarios;
	
	public ControleRepositorioUsuarios(int tamanho) {
		usuarios = new RepositorioUsuariosArray(tamanho);
	}
	
	public void inserir(Usuario usuario) throws UsuarioJaCadastradoException, LimiteUsuarioExcedidoException {
		if(this.getIndice() == 0) {
			if(usuario.getPerfil().getDescricao().equals("Administrador")) {
				usuarios.inserir(usuario);
			} else {
				UsuarioJaCadastradoException e = new UsuarioJaCadastradoException("O primeiro usuário tem que ser do perfil Administrador!");
			}
		} else {
			if(usuario.getPerfil().getDescricao().equals("Administrador")) {
				UsuarioJaCadastradoException e = new UsuarioJaCadastradoException("Perfil do Administrador já existe!");
			} else {
				usuarios.inserir(usuario);
			}			
		}
	}

	public void alterar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	public Usuario buscar(String nome) throws UsuarioNaoEncontradoException {
		Usuario usuarioLocal = new Usuario();
		
		if(nome.length() > 0) {
			usuarioLocal = usuarios.buscar(nome);
			if(usuarioLocal == null) {
				UsuarioNaoEncontradoException e = new UsuarioNaoEncontradoException(nome);
				throw e;
			}
			return usuarioLocal;
		}
		return null;
	}

	public int getIndice() {
		return usuarios.getIndice();
	}

	@Override
	public String toString() {
		return usuarios.toString();
	}

	
}
