import static java.lang.Math.pow;

public class Conta {

    private int numero;

    private Cliente dono;

    private double saldo;

    private double limite;

    private Operacao[] operacoes;

    private int proximaOperacao;

    private static int totalContas = 0;
    private int opLimiter = 10;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.operacoes = new Operacao[10];
        this.proximaOperacao = 0;

        Conta.totalContas++;
    }



    public boolean sacar(double valor) {
        if (!(valor >= 0 && valor <= this.limite)) {
            return false;
        }
        if(Oplimit()) {
            //aumentar o vetor de operacao???? tem como isso? acho que clonar o vetor com mais espaço pra ele mas nao tneho tempo
            //this.operacoes = new Operacao[this.opLimiter]; tentei ;-;
        }

        this.saldo -= valor;

        this.operacoes[proximaOperacao] = new Operacao('s', valor);
        this.proximaOperacao++;
        return true;

    }

    //isso é uma funcao que checa se o vetor operacao chegou no limite e fora dela vamos aumentar ele
    private boolean Oplimit()
    {
        if(this.proximaOperacao >= this.opLimiter)
        {
            this.opLimiter = this.opLimiter * 2;
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        this.operacoes[proximaOperacao] = new Operacao('d', valor);
        this.proximaOperacao++;
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public void imprimir() {
        System.out.println("===== Conta " + this.numero + " =====");
        System.out.println("Dono: " + this.dono.nome);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);
        System.out.println("====================");
    }

    public void imprimirExtrato() {
        System.out.println("======= Extrato Conta " + this.numero + " ======");
        for(Operacao atual : this.operacoes) {
            if (atual != null) {
                atual.imprimir();
            }
        }
        System.out.println("====================");
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public void setLimite(double limite) {
        if (limite < 0)
            limite = 0;

        this.limite = limite;
    }
}
