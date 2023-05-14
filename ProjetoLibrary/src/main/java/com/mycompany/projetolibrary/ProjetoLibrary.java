/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.projetolibrary;

import java.util.*;

/**
 *
 * @author goncalo farias
 */
class BuffFIFO<Object> {

    private LinkedList<Object> buffer = new LinkedList<>();

    public void addElemento(Object elemento) {
        buffer.addLast(elemento);
    }

    public Object removeElemento() {
        if (!buffer.isEmpty()) {
            return buffer.removeFirst();
        } else {
            return (Object) "Nao existem mais elementos a remover!";
        }
    }

    public void mostrarElementos() {
        System.out.println("Buffer atualizado: ");
        for (int i = 0; i < buffer.size(); i++) {
            System.out.println("Posicao " + i + ": " + buffer.get(i));
        }
    }

    public String vazio() {
        if (buffer.isEmpty()) {
            return "Buffer FIFO esta vazio!";
        } else {
            return "Buffer FIFO nao esta vazio!";
        }
    }

    public int tamanho() {
        return buffer.size();
    }
}

class BuffLIFO<Object> {

    private LinkedList<Object> buffer = new LinkedList<>();

    public void addElemento(Object elemento) {
        buffer.addFirst(elemento);
    }

    public Object removeElemento() {
        if (!buffer.isEmpty()) {
            return buffer.removeFirst();
        } else {
            return (Object) "Nao existem mais elementos a remover!";
        }
    }

    public void mostrarElementos() {
        System.out.println("Buffer atualizado: ");
        for (int i = 0; i < buffer.size(); i++) {
            System.out.println("Posicao " + i + ": " + buffer.get(i));
        }
    }

    public String vazio() {
        if (buffer.isEmpty()) {
            return "Buffer FIFO esta vazio!";
        } else {
            return "Buffer FIFO nao esta vazio!";
        }
    }

    public int tamanho() {
        return buffer.size();
    }
}

class Menus {

    public int menuPrincipal(Scanner sc) {
        // Menu principal da Aplicação
        System.out.println("\n***** Menu *****");
        System.out.println("1. Adicionar elemento");
        System.out.println("2. Remover elemento");
        System.out.println("3. Mostrar elementos");
        System.out.println("4. Verificar se está vazio");
        System.out.println("5. Verificar tamanho");
        System.out.println("6. Sair");
        System.out.println("Opcao: ");

        return sc.nextInt();
    }

    public void mostraAplicacao() {
        // Scan para a escolha da opção
        Scanner sc = new Scanner(System.in);

        // Menu inicial
        System.out.println("Buffer a usar: ");
        System.out.println("1. Utilizar buffer FIFO");
        System.out.println("2. Utilizar buffer LIFO");
        System.out.println("3. Sair");
        System.out.println("Opcao: ");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                // Criação de um buffer FIFO
                BuffFIFO<Object> buffFifo = new BuffFIFO<>();
                int opcaoMenu;
                do {
                    opcaoMenu = menuPrincipal(sc);
                    sc.nextLine();

                    switch (opcaoMenu) {
                        case 1:
                            //Adiciona elemento
                            System.out.print("Digite o elemento que deseja inserir: ");
                            Object elemento;
                            elemento = sc.nextLine();

                            //Coloca os elementos no buffer
                            buffFifo.addElemento(elemento);
                            break;

                        case 2:
                            //Remove elemento
                            Object elementoFifo = buffFifo.removeElemento();
                            System.out.println("Elemento removido: " + elementoFifo);
                            break;

                        case 3:
                            //Mostrar elementos do buffer
                            buffFifo.mostrarElementos();
                            break;

                        case 4:
                            //Verifica se está vazio
                            System.out.println(buffFifo.vazio());
                            break;

                        case 5:
                            //Verifica tamanho
                            System.out.println("Tamanho do buffer: " + buffFifo.tamanho());
                            break;

                        case 6:
                            break;

                        default:
                            System.out.println("Opcao invalida!Tente novamente!");
                    }
                } while (opcaoMenu != 6);
                break;
            case 2:
                // Criação de um buffer LIFO
                BuffLIFO<Object> buffLifo = new BuffLIFO<>();
                int opcaoMenu2;
                do {
                    opcaoMenu2 = menuPrincipal(sc);
                    sc.nextLine();

                    switch (opcaoMenu2) {
                        case 1:
                            //Adiciona elemento
                            System.out.print("Digite o elemento que deseja inserir: ");
                            Object elemento;
                            elemento = sc.nextLine();

                            //Coloca os elementos no buffer
                            buffLifo.addElemento(elemento);
                            break;

                        case 2:
                            //Remove elemento
                            Object elementoFifo = buffLifo.removeElemento();
                            System.out.println("Elemento removido: " + elementoFifo);
                            break;

                        case 3:
                            //Mostra elementos do buffer
                            buffLifo.mostrarElementos();
                            break;

                        case 4:
                            //Verifica se está vazio
                            System.out.println(buffLifo.vazio());
                            break;

                        case 5:
                            //Verifica tamanho
                            System.out.println("Tamanho do buffer: " + buffLifo.tamanho());
                            break;

                        case 6:
                            break;

                        default:
                            System.out.println("Opcao invalida!Tente novamente!");
                    }
                } while (opcaoMenu2 != 6);
                break;
            case 3:
                break;
            default:
                System.out.println("Opcao invalida! Escolha uma opcao valida!");
                break;
        }
    }
}

public class ProjetoLibrary {

    public static void main(String[] args) {

        // Chamada do método que mostra a aplicação funcional
        Menus menus = new Menus();
        menus.mostraAplicacao();
    }
}
