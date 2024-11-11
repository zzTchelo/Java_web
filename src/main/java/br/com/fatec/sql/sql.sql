DROP TABLE IF EXISTS PRODUTO;
DROP TABLE IF EXISTS CATEGORIA;

CREATE TABLE CATEGORIA (
  idCategoria INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL
);

CREATE TABLE PRODUTO (
  idProduto INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  descricao VARCHAR(200) NOT NULL,
  idCategoria INT NOT NULL,
  CONSTRAINT FK_CATEGORIA FOREIGN KEY (idCategoria) REFERENCES CATEGORIA (idCategoria) ON DELETE CASCADE
);

-- Inserindo dados na tabela CATEGORIA
INSERT INTO CATEGORIA (nome) VALUES ('Eletrônicos'), ('Games'), ('Eletrodomésticos'), ('Alimentos'), ('Brinquedos');