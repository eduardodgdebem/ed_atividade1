package com.supermercado.models;

import com.supermercado.interfaces.FuncaoValidadora;

public class Pilha<T> {
  private No<T> topo;
  private Integer tamanho = 0;

  public void empilha(T valor) {
    No<T> novoNo = new No<>(valor);
    this.tamanho++;

    if (this.tamanho == 0) {
      this.topo = novoNo;
      return;
    }

    novoNo.filho = topo;
    topo = novoNo;
  }

  public T desempilha() {
    No<T> tempNo = topo;
    this.tamanho--;

    if (tamanho == 0) {
      topo = null;
      return tempNo.valor;
    } else if (tamanho < 0) {
      return null;
    }

    this.topo = tempNo.filho;
    return tempNo.valor;
  }

  public void print() {
    No<T> tempNo = topo;

    while (tempNo != null) {
      System.out.print(tempNo.valor + " ");
      tempNo = tempNo.filho;
    }
    System.out.println();
  }

  public T buscar(FuncaoValidadora<T> validacao) {
    No<T> atual = topo;
    while (atual != null) {
      if (validacao.validar(atual.valor)) {
        return atual.valor;
      }
      atual = atual.filho;
    }
    return null;
  }
}
