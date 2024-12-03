package jogodaforca;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JogoDaForca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String tema = "Frutas";
        String palavraSecreta = "morango";
        int maxTentativas = 6;

        
        Set<Character> letrasUsadas = new HashSet<>();
        Set<Character> letrasReveladas = new HashSet<>();
        int tentativasRestantes = maxTentativas;

       
        System.out.println("Jogo da Forca");
        System.out.println("O Tema é: " + tema);
        System.out.println("A palavra possui " + palavraSecreta.length() + " letras.");
        System.out.println("Você tem " + maxTentativas + " tentativas para adivinhar a palavra.\n");

        
        while (tentativasRestantes > 0) {
            
            System.out.print("Palavra: ");
            for (char letra : palavraSecreta.toCharArray()) {
                if (letrasReveladas.contains(letra)) {
                    System.out.print(letra + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();

           
            System.out.println("Letras usadas: " + letrasUsadas);
            System.out.println("Tentativas restantes: " + tentativasRestantes);

            
            System.out.print("Digite uma letra: ");
            String entrada = scanner.nextLine().toLowerCase();
            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("Por favor, insira apenas uma letra válida.\n");
                continue;
            }

            char letra = entrada.charAt(0);

            
            if (letrasUsadas.contains(letra)) {
                System.out.println("Você já usou essa letra. Tente outra.\n");
                continue;
            }

            
            letrasUsadas.add(letra);

            
            if (palavraSecreta.contains(String.valueOf(letra))) {
                System.out.println("Boa! A letra " + letra + " está na palavra.\n");
                letrasReveladas.add(letra);
            } else {
                System.out.println("Ops! A letra " + letra + " não está na palavra.\n");
                tentativasRestantes--;
            }

            
            boolean venceu = true;
            for (char letraPalavra : palavraSecreta.toCharArray()) {
                if (!letrasReveladas.contains(letraPalavra)) {
                    venceu = false;
                    break;
                }
            }

            if (venceu) {
                System.out.println("Parabéns! Você adivinhou a palavra: " + palavraSecreta);
                break;
            }
        }

        
        if (tentativasRestantes == 0) {
            System.out.println("Você perdeu! A palavra era: " + palavraSecreta);
        }

        scanner.close();
    }
}

