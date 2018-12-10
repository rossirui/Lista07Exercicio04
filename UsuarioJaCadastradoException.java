
public class UsuarioJaCadastradoException extends Exception {

	private String mensagem;
	
	public UsuarioJaCadastradoException(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}
