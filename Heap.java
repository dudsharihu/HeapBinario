
public class Heap {
	
	private int[] vetor;
	private int tamanho, comprimento;
	
	public Heap (int[] vetor) {
		this.vetor = vetor;
	}
	
	public Heap (int tamanho, int comprimento) {
		this.comprimento = comprimento;
		this.tamanho = tamanho;
		vetor = new int[comprimento];		
	}
	
	private int getPai(int i) {
		return (i-1)/2;
	}
	
	private int getEsquerdo(int i) {
		return 2*i+1;
	}
	
	private int getDireito(int i) {
		return 2*i+2;
	}
		
	private void trocar(int i, int j) {
		int aux;
		aux = i;
		vetor[i] = vetor[j];
		vetor[j] = vetor[aux];
	}
	
	public void maxHeapify(int i) {
		int l, r, maior;
		
		l = getEsquerdo(i);
		r = getDireito(i);
		
		if( (l <= tamanho) && (vetor[l] > vetor[r])) {
			maior = l;
		} else {
			maior = i;
		}
		
		if ( (r <= tamanho) && (vetor[r] > vetor[maior])) {
			maior = r;
		}
		
		if (maior != i) {
			trocar(i, maior);
			maxHeapify(maior);
		}
	}

	public void buildMaxHeap() {
		tamanho = comprimento;
		for(int i = (comprimento/2); i >= 0; i--) {
			maxHeapify(i);
		}
	}
	
	public void buildMaxHeap(int[] vetor) {
		this.vetor = vetor;
		for(int i = (comprimento/2); i >= 0; i--) {
			maxHeapify(i);
		}
	}
	
	public void heapSort() {
		buildMaxHeap();
		for (int i = comprimento; i > 0; i--) {
			trocar(1, i);
			tamanho -= 1;
			maxHeapify(1);
		}
	}
}
