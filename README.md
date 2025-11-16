# 🌿 MindWork – Plataforma Inteligente de Upskilling Emocional para o Futuro do Trabalho

## 🌐 API MindWork
MindWork é uma plataforma que utiliza **IA Emocional, análise de dados e trilhas de desenvolvimento humano** para promover o bem-estar no trabalho, fortalecer vínculos entre equipes e incentivar uma cultura organizacional mais saudável, ética e sustentável.

A solução está alinhada às transformações do **Futuro do Trabalho (2030+)** e às **ODS da ONU**, especialmente:

| ODS | Descrição                              |
|-----|----------------------------------------|
| 🟢 ODS 3 | Saúde e Bem-estar                |
| 🟣 ODS 4 | Educação de Qualidade            |
| 🟡 ODS 8 | Trabalho decente e crescimento econômico |
| 🟠 ODS 10 | Redução das desigualdades       |

---

## 🎯 Objetivo Geral

Criar uma plataforma inteligente e humanizada que:

- Acompanhe o **bem-estar emocional** de forma contínua e respeitosa.  
- Incentive **autocuidado e hábitos saudáveis**.  
- Fortaleça **vínculos e relações humanas** entre equipes.  
- Gere **insights éticos e anonimizados** para apoiar lideranças humanizadas.

---

## 🧠 Solução Proposta – MindWork

MindWork é uma plataforma integrada (Web + App + Plugins para Teams/Slack/Google Workspace) que utiliza:

- **IA Emocional e análise de sentimentos**;  
- **Gamificação positiva** para incentivar autocuidado;  
- **Trilhas de aprendizagem focadas em habilidades humanas** essenciais para o futuro do trabalho (inteligência emocional, colaboração, empatia, regulação de estresse etc.).

---

## 🧩 Arquitetura da Solução

A API segue uma arquitetura em camadas:

```text
Controller  → recebe e responde à API HTTP (REST)
Service     → regras de negócio, validações, orquestração
Repository  → acesso e persistência no banco (Spring Data JPA)
Model/DTO   → representação do domínio e troca de dados (entidades / DTOs)
```

Pacotes principais:

controller – Endpoints da API (REST Controllers)
service e service.impl – Regras de negócio
repository – Acesso ao banco via Spring Data JPA
model – Entidades do domínio (User, LearningPath)
dto – Objetos de transferência de dados (UserDTO, LearningPathDTO)
exception – Tratamento centralizado de erros
config – Seeds de dados iniciais (DataSeeder)

Tecnologia	Versão (exemplo)
Java → 17+
Spring Boot → 3.x.x
Spring Web → Starter
Spring Data → JPA	Starter
Validation (Bean Validation) → Starter
Banco de Dados → H2 (em memória)
Build	→ Maven

## 🚀 Como Executar o Projeto
## 📌 Pré-requisitos
Java 17 ou superior instalado
Maven instalado ou uso do wrapper (mvnw / mvnw.cmd)

## Executar via Maven
Na raiz do projeto, executar:

mvn clean install
mvn spring-boot:run

ou, usando o wrapper:
./mvnw spring-boot:run

A API iniciará em:
http://localhost:8080

## 🗄 Configuração do Banco de Dados (H2)

A aplicação utiliza o banco H2 em memória, já configurado no arquivo:

📌 src/main/resources/application.properties

```text
Configuração aplicada:
# Configuração do Banco H2 em Memória
spring.datasource.url=jdbc:h2:mem:upskill_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuração JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

🔍 Acessar o Console H2
URL do console H2:
http://localhost:8080/h2-console

| Campo     | Valor                     |
|-----------|---------------------------|
| JDBC URL  | `jdbc:h2:mem:upskill_db`  |
| User      | `sa`                      |
| Password  | *(vazio)*                 |

---

## 🌱 Seeds (Dados Iniciais)

Ao iniciar a aplicação, o banco é automaticamente populado pelo componente `DataSeeder`, que cria:

### 📚 Trilhas de Aprendizagem Iniciais
| Título | Competências Futuro |
|--------|----------------------|
| Inteligência Emocional e Psicologia Positiva no Trabalho | Inteligência Emocional, Comunicação Empática, Segurança Psicológica |
| Mindfulness, Autocuidado e Gestão Saudável do Estresse | Mindfulness, Regulação Emocional, Hábitos Saudáveis |
| Cultura de Confiança, Times Humanizados e Colaboração Ética | Colaboração, Mediação de Conflitos, Diversidade & Inclusão |

### 👥 Usuários Iniciais
| Nome | E-mail | Profissão Atual |
|------|--------|----------------|
| Carolina Mendes | carolina@mindwork.com | Analista de People & Culture |
| Diego Araújo | diego@mindwork.com | Tech Lead e Facilitador de Equipes |
| Fernanda Rocha | fernanda@mindwork.com | Psicóloga Organizacional |

Esses dados podem ser consultados diretamente pelos endpoints GET listados abaixo.

---

## 🌐 Endpoints da API (CRUDs REST)

A API implementa **dois CRUDs completos**, conforme exigido pela especificação:

- `User` (profissionais/alunos da plataforma)
- `LearningPath` (trilhas de desenvolvimento humano e emocional)

---

## 🌐 Exemplos de requisições (Endpoints + JSON)
## 👥 Usuários – /api/users

1. Listar todos os usuários
GET http://localhost:8080/api/users

2. Buscar usuário por ID
GET http://localhost:8080/api/users/1

3. Criar usuário
POST http://localhost:8080/api/users
Content-Type: application/json

Body:
{
  "nome": "Ana Tech",
  "email": "ana@future.com",
  "profissaoAtual": "Analista de Pessoas"
}

4. Atualizar usuário
PUT http://localhost:8080/api/users/1
Content-Type: application/json

Body:
{
  "nome": "Ana Tech Atualizada",
  "email": "ana.atualizada@future.com",
  "profissaoAtual": "Líder de People & Culture"
}

5. Remover usuário
DELETE http://localhost:8080/api/users/1

6. Inscrever usuário em trilha
POST http://localhost:8080/api/users/1/enroll/1

## 📚 Trilhas – /api/paths
| Método | Endpoint          | Descrição              |
| ------ | ----------------- | ---------------------- |
| GET    | `/api/paths`      | Lista todas as trilhas |
| GET    | `/api/paths/{id}` | Busca trilha por ID    |
| POST   | `/api/paths`      | Cria uma nova trilha   |
| PUT    | `/api/paths/{id}` | Atualiza uma trilha    |
| DELETE | `/api/paths/{id}` | Remove uma trilha      |

## ⚠ Validação de Dados (Bean Validation)
A API utiliza validações com Jakarta Bean Validation.
Exemplos de validações aplicadas:
| Campo             | Regras de Validação                  |
| ----------------- | ------------------------------------ |
| `nome`            | `@NotBlank`, `@Size(max = 100)`      |
| `email`           | `@Email`, `@NotBlank`, único na base |
| `titulo` (trilha) | `@NotBlank`, `@Size(max = 150)`      |

## 🔵 Testar com curl (terminal)

Criar usuário:
```text
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "email": "joao@future.com",
    "profissaoAtual": "Desenvolvedor"
  }'
```

Listar usuários:
```text
curl http://localhost:8080/api/users

Criar trilha:
curl -X POST http://localhost:8080/api/paths \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Mindfulness e Autocuidado",
    "descricao": "Trilha prática para gestão de estresse e atenção plena.",
    "competenciasFuturo": "Mindfulness, Autoconsciência, Autocuidado"
  }'
```

Listar trilhas:
```text
curl http://localhost:8080/api/paths
```

Com isso, qualquer pessoa consegue:
-Instalar dependências
-Configurar o banco
-Rodar a aplicação
-Testar os endpoints rapidamente
-Validar o comportamento dos CRUDs
