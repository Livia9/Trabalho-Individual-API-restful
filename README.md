# Trabalho Individual — API RESTful de Funcionários com Spring Boot

API RESTful desenvolvida em Java com Spring Boot para gerenciamento de funcionários e seus endereços. Implementa um CRUD completo com validações, tratamento de exceções e relacionamento entre entidades.

**Trabalho Individual - Desenvolvimento de API RESTful Residência em TIC Serratec 2025.1 **  
*Pontuação: 30/30 pontos*

## 🛠️ Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- Bean Validation
- H2 Database
- Maven

## 📁 Estrutura do Projeto

### Entidades
- **Funcionario**: `id`, `nome`
- **Endereco**: `rua`, `cidade`, `estado`, `cep`
- **Relacionamento**: Funcionário possui endereço

### Componentes Principais
- **FuncionarioRepository**: Interface JpaRepository
- **FuncionarioController**: Controlador REST com CRUD
- **ControllerExceptionHandler**: Tratamento de exceções
- **ErroResposta**: Padronização de respostas de erro

## 🌐 Endpoints da API

### Base URL
```
http://localhost:8080
```

### Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/funcionarios` | Lista todos os funcionários |
| GET | `/funcionarios/{id}` | Retorna um funcionário específico |
| POST | `/funcionarios` | Insere um novo funcionário |
| PUT | `/funcionarios/{id}` | Atualiza um funcionário existente |
| DELETE | `/funcionarios/{id}` | Remove um funcionário por ID |

## ✅ Validações Implementadas

### Funcionario
- **nome**: Campo obrigatório (`@NotBlank`)

### Endereco
- **rua**: Campo obrigatório (`@NotBlank`)
- **cidade**: Campo obrigatório (`@NotBlank`)
- **estado**: Campo obrigatório (`@NotBlank`)
- **cep**: Campo obrigatório (`@NotBlank`)

## 📊 Estrutura de Dados

### Exemplo de Request/Response - Funcionário
```json
{
  "id": 1,
  "nome": "João Silva",
  "endereco": {
    "rua": "Rua das Flores, 123",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01234-567"
  }
}
```

### Exemplo de Resposta de Erro
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Nome é obrigatório",
  "path": "/funcionarios"
}
```

## 🚀 Como Executar

### Pré-requisitos
- Java 11 ou superior
- Maven 3.6+

### Passos para execução
1. **Clone o repositório:**
   ```bash
   git clone [URL_DO_REPOSITORIO]
   cd [NOME_DO_PROJETO]
   ```

2. **Compile o projeto:**
   ```bash
   mvn clean compile
   ```

3. **Execute os testes:**
   ```bash
   mvn test
   ```

4. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

## 🧪 Testando a API

### Usando Postman
1. Configure os endpoints manualmente
2. Teste cada endpoint seguindo a documentação
3. Verifique as validações enviando dados inválidos

### Exemplos de Teste

#### Listar todos os funcionários
```http
GET http://localhost:8080/funcionarios
```

#### Buscar funcionário por ID
```http
GET http://localhost:8080/funcionarios/1
```

#### Criar novo funcionário
```http
POST http://localhost:8080/funcionarios
Content-Type: application/json

{
  "nome": "Maria Santos",
  "endereco": {
    "rua": "Avenida Paulista, 456",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01310-100"
  }
}
```

#### Atualizar funcionário
```http
PUT http://localhost:8080/funcionarios/1
Content-Type: application/json

{
  "nome": "João Silva Santos",
  "endereco": {
    "rua": "Rua das Palmeiras, 789",
    "cidade": "Rio de Janeiro",
    "estado": "RJ",
    "cep": "20000-000"
  }
}
```

#### Deletar funcionário
```http
DELETE http://localhost:8080/funcionarios/1
```

## ⚠️ Tratamento de Exceções

A aplicação possui tratamento centralizado de exceções que retorna respostas padronizadas para:
- **404** - Recursos não encontrados
- **400** - Dados inválidos
- **400** - Erros de validação
- **500** - Erros internos do servidor

## 📌 Considerações Importantes

- O ID do funcionário **não pode ser atualizado** via PUT
- Todos os campos obrigatórios devem ser preenchidos
- As URIs foram construídas seguindo as convenções REST

## Algumas Funcionalidades Implementadas

- ✅ Entidades Funcionario e Endereco
- ✅ Relacionamento entre entidades
- ✅ FuncionarioRepository estendendo JpaRepository
- ✅ FuncionarioController com CRUD completo
- ✅ Validações de campos obrigatórios
- ✅ Tratamento de exceções centralizado
- ✅ Classe ErroResposta para padronização
- ✅ Todos os endpoints conforme especificação
