/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.projetolibrary;

import java.util.*;

/**
 *
 * @author goncalo farias
 */
class Buffer<Object> {

    protected LinkedList<Object> buffer = new LinkedList<>();

    // Método que adiciona elemento ao buffer
    public void addElemento(Object elemento) {
        // Método a implementar nas classes FIFO e LIFO
    }

    // Método que remove elemento do buffer
    public Object removeElemento() {
        // Método a implementar nas classes FIFO e LIFO
        return null;
    }

    // Método que mostra elements do buffer
    public void mostrarElementos() {
        System.out.println("Buffer atualizado: ");
        for (int i = 0; i < buffer.size(); i++) {
            System.out.println("Posicao " + i + ": " + buffer.get(i));
        }
    }

    // Método que reseta o buffer
    public void limpaBuffer() {
        buffer.clear();
        System.out.println("Buffer limpo!");
    }

    // Método que vê o tamanho do buffer
    public int tamanho() {
        return buffer.size();
    }

    public void substituirElemento(int posicao, Object novoElemento) {

        if (posicao >= 0 && posicao < buffer.size()) {
            buffer.set(posicao, novoElemento);
            System.out.println("Elemento substituido na posicao " + posicao + ": " + novoElemento);
        } else {
            System.out.println("Posicao invalida!");
        }
    }
}

class BuffFIFO<Object> extends Buffer<Object> {

    // Método que adiciona elementos ao buffer
    @Override
    public void addElemento(Object elemento) {
        buffer.addLast(elemento);
    }

    // Método que remove elemento do buffer
    @Override
    public Object removeElemento() {
        if (!buffer.isEmpty()) {
            return buffer.removeFirst();
        } else {
            return (Object) "Nao existem mais elementos a remover!";
        }
    }

}

class BuffLIFO<Object> extends Buffer<Object> {

    // Método que adiciona elementos ao buffer
    @Override
    public void addElemento(Object elemento) {
        buffer.addFirst(elemento);
    }

    // Método que remove elemento do buffer
    @Override
    public Object removeElemento() {
        if (!buffer.isEmpty()) {
            return buffer.removeFirst();
        } else {
            return (Object) "Nao existem mais elementos a remover!";
        }
    }
}

class Menus {

    // Método que contém o menu da aplicação
    public int menuPrincipal(Scanner sc) {
        // Menu principal da Aplicação
        System.out.println("\n***** Menu *****");
        System.out.println("1. Adicionar elemento");
        System.out.println("2. Remover elemento");
        System.out.println("3. Mostrar elementos");
        System.out.println("4. Substituir posicao");
        System.out.println("5. Limpa Buffer");
        System.out.println("6. Verificar tamanho");
        System.out.println("7. Sair");
        System.out.println("Opcao: ");

        return sc.nextInt();
    }

    // Método que trabalha as opções do menu
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
                            //Substitui elemento
                            System.out.println("Posicao do elemento a substituir: ");
                            int posicaoSubstituir = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Novo elemento: ");
                            Object novoElementoBuff = sc.nextLine();
                            buffFifo.substituirElemento(posicaoSubstituir, novoElementoBuff);
                            break;

                        case 5:
                            //Limpa Buffer
                            buffFifo.limpaBuffer();
                            break;

                        case 6:
                            //Verifica tamanho
                            System.out.println("Tamanho do buffer: " + buffFifo.tamanho());
                            break;

                        case 7:
                            break;

                        default:
                            System.out.println("Opcao invalida!Tente novamente!");
                    }
                } while (opcaoMenu != 7);
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
                            //Substitui elemento
                            System.out.println("Posicao do elemento a substituir: ");
                            int posicaoSubstituir = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Novo elemento: ");
                            Object novoElementoBuff = sc.nextLine();
                            buffLifo.substituirElemento(posicaoSubstituir, novoElementoBuff);
                            break;

                        case 5:
                            //Limpa Buffer
                            buffLifo.limpaBuffer();
                            break;

                        case 6:
                            //Verifica tamanho
                            System.out.println("Tamanho do buffer: " + buffLifo.tamanho());
                            break;

                        case 7:
                            break;

                        default:
                            System.out.println("Opcao invalida!Tente novamente!");
                    }
                } while (opcaoMenu2 != 7);
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
