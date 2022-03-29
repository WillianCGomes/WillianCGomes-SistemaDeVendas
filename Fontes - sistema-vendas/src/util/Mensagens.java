package util;

/**
 * Classe para armazenar as mensagens utilizadas no sistema
 *
 * @author Willian Carlos Gomes
 * @since 16/03/2021
 * @version 1.0
 */
public class Mensagens {

    /*
     * Textos de Labels
     */
    public static String cnpj = "CNPJ:";
    public static String cpf = "CPF:";
    public static String rg = "RG:";
    public static String ie = "I.E:";
    public static String razaoSocial = "Razão Social:";
    public static String nome = "Nome:";
    public static String dataNasc = "Data de nascimento:";
    public static String dataFundacao = "Data de fundação:";

    /*
     * Máscaras
     */
    public static String cnpjMascara = "##.###.###/####-##";
    public static String cpfMascara = "###.###.###-##";
    public static String rgMascara = "##.###.###-#";
    public static String ieMascara = "###.###.###.###";

    /*
    * Mensagens de sucesso
    */
    public static String clienteSalvo = "Cliente salvo com sucesso!";
    public static String funcionarioSalvo = "Funcionário salvo com sucesso!";
    public static String fornecedorSalvo = "Fornecedor salvo com sucesso!";
    public static String produtoSalvo = "Produto salvo com sucesso!";
    public static String produtoExcluido = "Produto excluído com sucesso!";
    public static String clienteExcluido = "Cliente excluído com sucesso!";
    public static String fornecedorExcluido = "Fornecedor excluído com sucesso!";
    public static String funcionarioExcluido = "Funcionário excluído com sucesso!";
    public static String enderecoSalvo = "Endereço salvo com sucesso!";
    public static String contatoSalvo = "Contato salvo com sucesso!";
    
    /*
     * Mensagens de erro
     */
    public static String erroConsultaEstados = "Erro ao gerar consulta de estados";
    public static String erroConsultaCidades = "Erro ao gerar consulta de cidades";
    public static String PessoaJuridicaErro = "Erro ao salvar Pessoa Jurídica";
    public static String PessoaFisicaErro = "Erro ao salvar Pessoa Física";
    public static String fornecedorErro = "Erro ao salvar o fornecedor";
    public static String funcionarioErro = "Erro ao salvar o funcionário";
    public static String clienteErro = "Erro ao salvar o cliente";
    public static String produtoErro = "Erro ao salvar o produto";
    public static String contatoExcluirErro = "Erro ao excluir contato";
    public static String enderecoExcluirErro = "Erro ao excluir endereço";
    public static String pjExcluirErro = "Erro ao excluir Pessoa Jurídica";
    public static String pfExcluirErro = "Erro ao excluir Pessoa Física";
    public static String enderecoErro = "Erro ao salvar endereço";
    public static String contatoErro =  "Erro ao salvar contato";
    public static String consultaClienteErro =  "Erro ao consultar cliente";
    public static String consultaFornecedorErro =  "Erro ao consultar fornecedor";
    public static String consultaFuncionarioErro =  "Erro ao consultar funcionário";
    public static String consultaProdutoErro =  "Erro ao consultar produto";

    /*
     *Validações
     */
    // Campos Vazios
    public static String tipoPessoaVazio = "Informe o tipo de pessoa, campo obrigatório!";
    public static String cnpjVazio = "Informe o CNPJ, campo obrigatório!";
    public static String cpfVazio = "Informe o CPF, campo obrigatório!";
    public static String inscricaoEstadualVazio = "Informe uma Inscrição Estadual, campo obrigatório!";
    public static String rgVazio = "Informe um Registro Geral, campo obrigatório!";
    public static String razaoSocialVazio = "Informe uma Razão Social, campo obrigatório!";
    public static String nomeVazio = "Informe um nome, campo obrigatório!";
    public static String dataFundacaoVazio = "Informe uma data de fundação, campo obrigatório!";
    public static String dataNascimentoVazio = "Informe uma data de nascimento, campo obrigatório!";
    public static String enderecoVazio = "Informe o endereço, campo obrigatório!";
    public static String numeroVazio = "Informe o número do logradouro, campo obrigatório!";
    public static String bairroVazio = "Informe o bairro, campo obrigatório!";
    public static String cidadeVazio = "Informe a cidade, campo obrigatório!";
    public static String estadoVazio = "Informe o estado, campo obrigatório!";
    public static String cepVazio = "Informe o CEP, campo obrigatório!";
    public static String celularVazio = "Informe um número de celular, campo obrigatório!";
    public static String contatoVazio = "Informe o nome do contato, campo obrigatório!";
    public static String emailVazio = "Informe um endereço de email, campo obrigatório!";
    public static String loginVazio = "Informe um login, campo obrigatório!";
    public static String senhaVazia = "Informe uma senha, campo obrigatório!";
    public static String confirmaSenhaVazia = "Por favor repita a senha, campo obrigatório!";
    public static String descricaoVazia = "Informe uma descrição para o produto, campo obrigatório!";
    public static String fornecedorVazio = "Informe um fornecedor para o produto, campo obrigatório!";
    public static String valorCustoVazio = "Informe um valor de custo para o produto, campo obrigatório!";
    public static String valorVendaVazio = "Informe um valor de venda para o produto, campo obrigatório!";

    //Campos Inválidos  
    public static String cnpjInvalido = "Informe um CNPJ válido, campo obrigatório!";
    public static String nomeInvalido = "Informe um nome válido, campo obrigatório!";
    public static String cpfInvalido = "Informe um CPF válido, campo obrigatório!";
    public static String inscricaoEstadualInvalido = "Informe uma Inscrição Estadual válida, campo obrigatório!";
    public static String rgInvalido = "Informe um Registro Geral Válido, campo obrigatório!";
    public static String dataFundacaoInvalida = "Informe uma data de funcação válida, campo obrigatório!";
    public static String dataNascimentoInvalida = "Informe uma data de nascimento válida, campo obrigatório!";
    public static String numeroEnderecoInvalido = "Informe um número válido para o logradouro, campo obrigatório!";
    public static String contatoInvalido = "Informe um nome para contato válido, campo obrigatório!";
    public static String valorCustoInvalido = "Informe um valor de custo válido para o produto, campo obrigatório!";
    public static String valorVendaInvalido = "Informe um valor de venda válido para o produto, campo obrigatório!";
    public static String confirmaSenhaInvalida = "As senhas informadas não coincidem, favor repetir corretamente!";

    /*
     * Avisos
     */
    public static String credenciaisInvalidas = "Credenciais inválidas!";
    public static String selecioneFornecedor = "Selecione um fornecedor!";
    public static String selecioneFuncionario = "Selecione um funcionário!";
    public static String selecioneCliente = "Selecione um cliente!";
    public static String selecioneProduto = "Selecione um produto!";
    public static String excluirFuncionario = "Deseja mesmo excluir o funcionário selecionado?";
    public static String excluirProduto = "Deseja mesmo excluir o produto selecionado?";
    public static String excluirFornecedor = "Deseja mesmo excluir o fornecedor selecionado?";
    public static String excluirCliente = "Deseja mesmo excluir o cliente selecionado?";
    public static String sairSistema = "Deseja realmente encerrar o sistema?";
    public static String logout = "Deseja realmente desconectar do sistema?";

}
