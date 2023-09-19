# Atividade01Padroes
## Você foi contratado para desenvolver um sistema de gerenciamento de veículos para uma concessionária de automóveis. A concessionária vende carros e motocicletas, e eles desejam um sistema que permita registrar informações sobre cada veículo em estoque.

## Para atender a essa demanda, você deve criar uma hierarquia de classes que utilize herança para representar os diferentes tipos de veículos (Carro e Motocicleta) e, em seguida, implementar injeção de dependência para permitir que diferentes classes sejam responsáveis por #armazenar e recuperar informações sobre esses veículos.

## Aqui estão os requisitos específicos do sistema:

1. Crie uma classe base chamada "Veiculo" que tenha os seguintes atributos:
- Marca
- Modelo
- Ano de fabricação
- Preço
- Crie duas subclasses: "Carro" e "Motocicleta", que herdem da classe base "Veiculo". Adicione atributos específicos para cada tipo de veículo, como "Número de Portas" para carros e "Cilindradas" para motocicletas.

2. Crie uma interface chamada "Armazenamento" com métodos para adicionar um veículo ao estoque e recuperar informações sobre os veículos em estoque.

3.Implemente duas classes que implementam a interface "Armazenamento":

- "BancoDeDadosArmazenamento" que armazena os veículos em um banco de dados.
- "ArquivoArmazenamento" que armazena os veículos em um arquivo.
4. Utilize injeção de dependência para permitir que o sistema use qualquer uma das classes de armazenamento (BancoDeDadosArmazenamento ou ArquivoArmazenamento) de forma flexível.

5. Crie uma classe chamada "Concessionaria" que utilize a injeção de dependência para definir qual classe de armazenamento será usada para gerenciar os veículos em estoque.

6. Implemente métodos na classe "Concessionaria" para adicionar novos veículos ao estoque, recuperar informações sobre os veículos em estoque e listar todos os veículos disponíveis.

7. Crie um programa principal que demonstre como o sistema funciona. Crie instâncias de veículos, adicione-os ao estoque da concessionária e recupere informações sobre os veículos.

8. Importante: O seu sistema deve gravar em banco e em arquivo conforme descrito acima.
