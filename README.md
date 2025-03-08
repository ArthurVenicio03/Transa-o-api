# 📌 API de Transações

<p align="center">
  Este projeto é uma API REST desenvolvida em Java com Spring Boot para gerenciar transações e calcular estatísticas das transações realizadas nos últimos 60 segundos.
</p>

<p align="center">
  <a href="#-pré-requisitos">Pré-requisitos</a> •
  <a href="#-como-configurar-o-projeto">Configuração</a> •
  <a href="#-como-rodar-em-um-container-opcional">Docker</a> •
  <a href="#-documentação-da-api">API</a> •
  <a href="#-autor">Autor</a>
</p>

---
##Video Demonstração

https://github.com/user-attachments/assets/25d25190-dd32-4ad0-bbca-1ca4911362b4
--------

## 🛠️ Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- **Java**: JDK 21 ou superior.
- **Maven**: Versão 3.8.1 ou superior.
- **Git**: Para clonar o repositório.
- **Docker** (opcional): Para rodar a aplicação em um container.

---

## 🚀 Como Configurar o Projeto

### 1️⃣ Clone o Repositório

```bash
git clone https://github.com/Arthurvenicio03/api-transacoes.git
cd api-transacoes
```

### 2️⃣ Compile o Projeto

```bash
mvn clean install
```

### 3️⃣ Execute o Projeto

```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## 🐳 Como Rodar em um Container (Opcional)

### 4️⃣.1 Crie a Imagem Docker

Certifique-se de que o Docker está instalado e execute:

```bash
docker build -t api-transacoes .
```

### 4️⃣.2 Execute o Container

```bash
docker run -p 8080:8080 api-transacoes
```

A API estará disponível em `http://localhost:8080`.

---

## 📚 Documentação da API

### 🔹 Receber Transações

- **Método**: `POST`
- **Endpoint**: `/transacao`
- **Parâmetros**:
  - `valor` (BigDecimal): Obrigatório. O valor da transação.
  - `dataHora` (OffsetDateTime): Obrigatório. O horário que a transação ocorreu.

📌 **Exemplo de Requisição**:

```json
{
  "valor": 100.50,
  "dataHora": "2023-10-01T12:34:56Z"
}
```
![post](https://github.com/user-attachments/assets/53b26397-d233-48db-9598-9ea252218b86)


### 🔹 Limpar Transações

- **Método**: `DELETE`
- **Endpoint**: `/transacao`

Este endpoint remove todas as transações armazenadas.

![delet](https://github.com/user-attachments/assets/f410bbcb-8f2f-4d59-acd2-14e32ac452cb)



### 🔹 Calcular Estatísticas

- **Método**: `GET`
- **Endpoint**: `/estatistica`
- **Parâmetros**:
  - `intervaloSegundos` (integer): Não obrigatório. O intervalo de tempo em segundos para calcular as estatísticas. O padrão é 60 segundos.

📌 **Exemplo de Resposta**:

```json
{
  "soma": 1500.75,
  "media": 375.19,
  "maximo": 1000.00,
  "minimo": 100.50,
  "quantidade": 4
}
```
![estastirsi](https://github.com/user-attachments/assets/cf5691a8-e4e2-47cc-8108-8300c2ae0d69)


---

## 👨‍💻 Autor

Feito com ❤️ por **Arthur Venicio** 👋

[![GitHub](https://img.shields.io/badge/GitHub-Arthurvenicio03-181717?style=for-the-badge&logo=github)](https://github.com/Arthurvenicio03)

---

<p align="center">
  ⭐️ Se este projeto te ajudou, deixe uma estrela no repositório! ⭐️
</p>
