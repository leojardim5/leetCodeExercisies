
class No {

    int valor;
    No proximo;

    No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class ListaLigada {

    private No cabeca;

    private class No {

        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public ListaLigada(int valor) {

        No novoNo = new No(valor);
        cabeca = novoNo;

    }

    public ListaLigada() {

    }

    public void inserirNoInicio(int valor) {
        No novo = new No(valor);
        novo.proximo = cabeca;
        cabeca = novo;
    }

    public void lerLista() {
        No aux = cabeca;
        while (aux != null) {
            System.out.print(aux.valor + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }

    public int tamanhoLista() {
        int contador = 0;
        No aux = cabeca;
        while (aux != null) {
            contador++;
            aux = aux.proximo;
        }
        return contador;
    }
}
