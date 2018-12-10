
public class LimiteUsuarioExcedidoException extends Exception {

	private String mensagem;
	
	public LimiteUsuarioExcedidoException(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}
