O Projeto foi feito seguindo atentamente os requisitos solicitados pelo professor e atendendo aos critérios de uso dos conceitos
apreendidos em sala como Modularização, Persistência de dados, utilização de herança, interface, collection e date, 
além de serialização e uso do Singleton na classe BancoDAO.java. Todos os métodos foram implementados e
o código está devidamente organizado e comentado.

Como executar:
Certifique-se de que o Java 8 ou superior está instalado.
Abra o projeto em uma IDE como IntelliJ IDEA, Eclipse ou VSCode e execute a classe principal Main.java.
Caso prefira usar o terminal, compile os arquivos com o comando javac e execute a classe principal com java.
Ao iniciar, o programa carregará os dados previamente salvos (se existirem) no arquivo binário funcionarios.bin 
e exibirá um menu interativo no console.


Funcionalidades do sistema:

Cadastrar Funcionários:
Permite inserir informações como nome, CPF, endereço, matrícula, departamento, formação e dados específicos:
Professores: Nível, formação acadêmica e disciplinas ministradas.
Técnicos ADM: Nível, formação acadêmica, insalubridade e função gratificada.
Os funcionários cadastrados são armazenados no sistema e salvos no arquivo binário.

Listar Funcionários:
Lista todos os professores cadastrados, exibindo nome e disciplinas ministradas.
Lista todos os técnicos administrativos, exibindo nome e função.

Buscar por Matrícula:
Localiza e exibe as informações completas de um funcionário (professor ou técnico) com base na matrícula fornecida.

Excluir Funcionários:
Remove um professor ou técnico ADM do sistema com base na matrícula.

Calcular Salários:
Os salários são calculados de acordo com critérios:
Professores: Salário base de R$4.000,00, com adicional por nível (5% a cada nível) e formação (25% para especialização, 
50% para mestrado e 75% para doutorado).
Técnicos ADM: Salário base de R$2.500,00, com adicional por nível (3% a cada nível), formação (mesmos percentuais dos professores),
insalubridade e função gratificada (cada uma adiciona 50% do salário base).

Persistência de Dados:
Os dados de todos os funcionários são salvos automaticamente no arquivo binário funcionarios.bin ao encerrar o programa. 
Ao reiniciá-lo, as informações são carregadas novamente.