
public class UsuarioNaoEncontradoException extends Exception {
	
	private String mensagem = "Usu�rio n�o encontrado: ";
	
	public UsuarioNaoEncontradoException(String nome) {
		this.mensagem += nome;
	}

	public String getMensagem() {
		return mensagem;
	}

}
