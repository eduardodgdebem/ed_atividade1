package com.supermercado.models;

public class No<T> {
  public T valor;
  public No<T> filho;

  public No(T valor) {
    this.valor = valor;
  } 
}
