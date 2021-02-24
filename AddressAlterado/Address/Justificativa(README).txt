GUILHERME BATISTA FERNANDES COELHO
HENRIQUE AUGUSTO FREIRE DE OLIVEIRA

INF3

Eu separei o arquivo original em 2 outros arquivos, tendo:   Person.java, que se manteve inalterado; PersonHandler.java, que cria, manipula e deleta instâncias de Person; AcessaBD.java, que faz todas as ações relacionadas a se comunicar com um banco de dados; AddressApp.java, que agora contém apenas uma instância de PersonHandler que ativa o método "menu"; e por último, o arquivo que contém o Statement para criar a tabela no banco de dados.

ULTIMA ATUALIZAÇÃO:
Não conseguimos fazer com que o netbeans reconhecesse os arquivos de teste. Sempre que tentávamos rodar o arquivo individualmente ou usar a funcionalidade "Testar Código" do netbeans, que roda todos os testes ao mesmo tempo, ele dizia que 0 testes foram executados e que faltava um "junit.jar" no classpath do Ant. Tentamos inúmeras soluções, como importar diversas versões do jar do JUnit, mexer nos classpaths indicados por arquivos .xml, adicionar bibliotecas sem a mediação do netbeans, e nada funcionou. Achamos que o código de teste funciona, por mais que não tenhamos conseguido testá-lo. Precisamos de ajuda para consertar esse erro.