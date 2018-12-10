
public class Permissao {

		private String id;		
		private String nome;
		private String observacao;
		
		public Permissao() {
		}
		
		public Permissao(String id, String nome, String observacao) {
			this.id = id;
			this.nome = nome;
			this.observacao = observacao;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getObservacao() {
			return observacao;
		}

		public void setObservacao(String observacao) {
			this.observacao = observacao;
		}

		@Override
		public String toString() {
			return "- Permissao: " + nome + " (" + observacao + ")";
		}
		
		
}
