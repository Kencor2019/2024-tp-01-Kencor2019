public class Cliente {

    public String nome;

    private String cpf;

    private String endereco;

    private int idade;

    private char sexo;

    public Cliente(String nome, String cpf, String endereco, int age, char sexo)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = age;
        this.sexo = sexo;
    }

    //Getter de nome
    public String getNome() {
        return nome;
    }

    //Setter de Nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Getter de Cpf
    public String getCpf() {
        return cpf;
    }

    //Getter de Endereco
    public String getEndereco() {
        return endereco;
    }

    //Setter de Endereco
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //Getter de idade
    public int getIdade() {
        return idade;
    }

    //Setter de idade
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //Getter de sexo
    public char getSexo() {
        return sexo;
    }

    //Setter de sexo
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public static boolean checarCpf(String cpfs) {
        String cpf = cpfs;
        boolean cpfValido = true;

        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11)
            cpfValido = false;

        // Verifica se todos os dígitos são iguais
        boolean allDigitsEqual = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual)
            cpfValido = false;

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digit1 = 11 - (sum % 11);
        if (digit1 > 9)
            digit1 = 0;

        // Verifica o primeiro dígito verificador
        if ((cpf.charAt(9) - '0') != digit1)
            cpfValido = false;

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9)
            digit2 = 0;

        // Verifica o segundo dígito verificador
        if ((cpf.charAt(10) - '0') != digit2)
            cpfValido = false;

        if (cpfValido)
            System.out.println("CPF Válido");
        else
            System.out.println("CPF Inválido");

        return cpfValido;
    }

    //Essa função cria clientes no programa :D
    public static Cliente criarCliente(String nome, String cpf, String Endereco, int idade, char sexo)
    {
        if (!checarCpf(cpf)) {
            return null;
        }

        Cliente Cliente = new Cliente(nome, cpf, Endereco, idade, sexo);

        return Cliente;
    }
}
