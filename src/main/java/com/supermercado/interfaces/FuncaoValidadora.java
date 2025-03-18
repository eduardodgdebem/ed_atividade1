package com.supermercado.interfaces;

@FunctionalInterface
public interface FuncaoValidadora<T> {
  boolean validar(T item);
}
