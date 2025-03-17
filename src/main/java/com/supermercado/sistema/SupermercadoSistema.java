package com.supermercado.sistema;

import com.supermercado.models.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SupermercadoSistema {
  private Pilha<Compra> historicoCompra;
  private Map<String, Integer> estoqueAtual;

  public SupermercadoSistema() {
    this.historicoCompra = new Pilha<>();
    this.estoqueAtual = new HashMap<>();
  }

  public void registrarCompra(Compra compra) {
    this.historicoCompra.empilha(compra);
    this.estoqueAtual.merge(compra.getNomeProduto(), compra.getQuantidadeComprada(), Integer::sum);
  }

  public Boolean venderProduto(String nomeProduto, Integer quantidade) {
        Compra ultimaCompra = this.historicoCompra.buscar(produto -> produto.getNomeProduto().equals(nomeProduto));
        if (ultimaCompra == null) {
            return false;
        }

        int quantidadeAtual = estoqueAtual.getOrDefault(nomeProduto, 0);
        if (quantidadeAtual < quantidade) {
            return false;
        }

        estoqueAtual.put(nomeProduto, quantidadeAtual - quantidade);
        return true;
  }

    public Double getPrecoVendaAtual(String nomeProduto) {
      Compra ultimaCompra = this.historicoCompra.buscar(produto -> produto.getNomeProduto().equals(nomeProduto));
      return ultimaCompra != null ? ultimaCompra.getPrecoVenda() : null;
    }

    public Integer getEsqoqueAtual(String nomeProduto) {
        return estoqueAtual.getOrDefault(nomeProduto, 0);
    }

    public Compra getUltimaCompra(String nomeProduto) {
        return this.historicoCompra.buscar(produto -> produto.getNomeProduto().equals(nomeProduto));
    }
}
