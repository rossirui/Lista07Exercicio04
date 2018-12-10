
public interface RepositorioUsuarios {

	public void inserir(Usuario usuario) throws UsuarioJaCadastradoException, LimiteUsuarioExcedidoException;
	public void alterar(Usuario usuario);
	public Usuario buscar(String nome);
	public int getIndice();

}
