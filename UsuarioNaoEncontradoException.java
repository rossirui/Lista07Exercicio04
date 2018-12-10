
public class UsuarioNaoEncontradoException extends Exception {
	
	private String mensagem = "Usuário não encontrado: ";
	
	public UsuarioNaoEncontradoException(String nome) {
		this.mensagem += nome;
	}

	public String getMensagem() {
		return mensagem;
	}

}
