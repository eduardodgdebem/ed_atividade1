package com.supermercado.sistema;

import java.util.Scanner;
import java.time.LocalDate;
import com.supermercado.models.Compra;

public class SupermercadoApp {
    private static final SupermercadoSistema sistema = new SupermercadoSistema();
    private static final Scanner scanner = new Scanner(System.in);

    public static void iniciar() {
        while (true) {
            System.out.println("\n=== Sistema de Gerenciamento de Supermercado ===");
            System.out.println("1. Registrar Compra");
            System.out.println("2. Vender Produto");
            System.out.println("3. Verificar Detalhes do Produto");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    registrarCompra();
                    break;
                case 2:
                    venderProduto();
                    break;
                case 3:
                    verificarDetalhesProduto();
                    break;
                case 4:
                    System.out.println("Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void registrarCompra() {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        
        System.out.print("Digite o preço de compra: ");
        double precoCompra = scanner.nextDouble();
        
        System.out.print("Digite o preço de venda: ");
        double precoVenda = scanner.nextDouble();
        
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        
        Compra compra = new Compra(LocalDate.now(), nomeProduto, precoCompra, precoVenda, quantidade);
        sistema.registrarCompra(compra);
        System.out.println("Compra registrada com sucesso!");
    }

    private static void venderProduto() {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        
        System.out.print("Digite a quantidade para vender: ");
        int quantidade = scanner.nextInt();
        
        if (sistema.venderProduto(nomeProduto, quantidade)) {
            Double preco = sistema.getPrecoVendaAtual(nomeProduto);
            System.out.printf("Venda concluída! Total: R$%.2f%n", preco * quantidade);
        } else {
            System.out.println("Venda falhou! Verifique se o produto existe e tem estoque suficiente.");
        }
    }

    private static void verificarDetalhesProduto() {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        
        Compra ultimaCompra = sistema.getUltimaCompra(nomeProduto);
        if (ultimaCompra != null) {
            System.out.println("\nDetalhes do Produto:");
            System.out.println("Última Compra: " + ultimaCompra);
            System.out.println("Estoque Atual: " + sistema.getEsqoqueAtual(nomeProduto));
        } else {
            System.out.println("Produto não encontrado!");
        }
    }  
}
