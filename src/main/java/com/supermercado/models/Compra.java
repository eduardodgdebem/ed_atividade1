package com.supermercado.models;

import java.time.LocalDate;

public class Compra {
  private LocalDate dataCompra;
  private String nomeProduto;
  private double precoCompra;
  private double precoVenda;
  private int quantidadeComprada;
  private int quantidadeEstoque;

  public Compra(LocalDate dataCompra, String nomeProduto, double precoCompra,
      double precoVenda, int quantidadeComprada) {
    this.dataCompra = dataCompra;
    this.nomeProduto = nomeProduto;
    this.precoCompra = precoCompra;
    this.precoVenda = precoVenda;
    this.quantidadeComprada = quantidadeComprada;
    this.quantidadeEstoque = quantidadeComprada;
  }

  // Getters and Setters
  public LocalDate getCompraData() {
    return dataCompra;
  }

  public String getNomeProduto() {
    return nomeProduto;
  }

  public double getPrecoCompra() {
    return precoCompra;
  }

  public double getPrecoVenda() {
    return precoVenda;
  }

  public void setPrecoVenda(double precoVenda) {
    this.precoVenda = precoVenda;
  }

  public int getQuantidadeComprada() {
    return quantidadeComprada;
  }

  public int getQuantidadeEstoque() {
    return quantidadeEstoque;
  }

  public void setQuantidadeEstoque(int quantidadeEstoque) {
    this.quantidadeEstoque = quantidadeEstoque;
  }

  @Override
  public String toString() {
    return String.format("Compra[Data: %s, Produto: %s, Preco da Comrpa: %.2f, " +
        "Preco da Venda: %.2f, Quantidade: %d, Estoque: %d]",
        dataCompra, nomeProduto, precoCompra, precoVenda,
        quantidadeComprada, quantidadeEstoque);
  }
}
