
import java.lang.Math;
import java.util.*;
import java.util.Arrays;


//!!---AM LUAT AL TREILEA PARAMETRU CA FIIND UN STRING NU MAI MULTE CARACTERE SEPARATE--!!!/////////////
//!!---APOI L-AM TRANSFORMAT IN VECTOR DE CARACTERE---!!!///////////

public class Main<ana> {
    public static void main(String args[]) {
        long startTime = System.nanoTime();
        System.out.println("hello world");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println("n=" + n);
        n = n * 3;
        System.out.println("n=" + n);
        int var = Integer.parseInt("10101", 2);
        System.out.println(Integer.parseInt("10101", 2));
        n = n + var;

        String hex = "FF";
        int dec = Integer.parseInt(hex, 16);
        System.out.println("decIs=" + dec);
        n = n + dec;
        System.out.println("n=" + n);
        n = n * 6;
        System.out.println("n=" + n);
        int sum = 0;
        while (n > 10) {
            while (n > 0) {
                sum = sum + n % 10;
                n = n / 10;
            }

            if (sum > 10) {
                n = sum;
                sum = 0;
            }

        }
        System.out.println("sumaCifrelor=" + sum);

        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);


        ////////////---Optional---///////////
        System.out.println();
        System.out.println("----------------optional-------------");
        System.out.println();
        System.out.println("------1------");
        /////1////
        if (args.length < 3) {
            System.out.println(
                    "Usage: number, number, one or more characters");
            System.exit(-1);
        }
        int a0 = Integer.parseInt(args[0]);//n
        int a1 = Integer.parseInt(args[1]);//k
        String alph = args[2]; // AM LUAT AL TREILEA PARAMETRU CA FIIND UN STRING NU MAI MULTE CARACTERE SEPARATE
        for (String s : args) {
            System.out.println(s);
        }

        char[] alphabet = new char[alph.length()];
        for (int i = 0; i < alph.length(); i++) {
            alphabet[i] = alph.charAt(i);  // AM CREAT VECTORUL DE CHAR-URI FORMAT DIN FIECARE CARACTER AL STRINGULUI
        }
        //AFISAREA VECTORULUI
        for (char c : alphabet) {
            System.out.println(c);
        }
        ////2+3/////
        System.out.println();
        System.out.println("-----2+3-----");
        String words[] = new String[a0];
        Main app = new Main();
        for (int i3 = 0; i3 < a0; i3++) {
            String word = app.createRandomWord(a1, alphabet); //AM CREAT VECTORUL DE STRINGURI FORMAT DIN CUVINTE CU LITERE DIN VECTORUL DE CARACTERE
            words[i3] = word;
            System.out.println(word);// AFISAM VECTORUL DE STRINGURI
        }
        ////4/////
        System.out.println("-----4-----");
        int [][] matrix1 = new int[a0][a0];
        //CONSTRUIM MATRICEA
        for (int i4 = 0; i4 < a0; i4++) {
            for (int j = i4 + 1; j < a0; j++) {
                if (checkw(words[i4], words[j])) {//VERIFICAM DACA 2 STRINGURI AU CARACTERE COMUNE
                    matrix1[i4][j] = 1;
                    matrix1[j][i4] = 1;
                } else {
                    matrix1[i4][j] = 0;
                    matrix1[j][i4] = 0;
                }
            }
        }
        for (int i6 = 0; i6 < a0; i6++) {
            matrix1[i6][i6] = 1;

        }

        for (int i5 = 0; i5 < a0; i5++) {
            for (int j1 = 0; j1 < a0; j1++) {
                System.out.print(matrix1[i5][j1] + " ");// AFISAM MATRICEA
            }
            System.out.println();
        }

        ////////5////////
        System.out.println("-----5-----");
        int sumn;
        //AM CREAT VECTORUL DE VECINI CARE PENTRU FIECARE CUVANT IN PARTE RETINE CATI VECINI ARE
        int neighb[] = new int[a0];
        for (int z = 0; z < a0; z++) {
            sumn = 0;
            for (int x = 0; x < a0; x++) {

                sumn = sumn + matrix1[z][x];
            }

            neighb[z] = sumn;


        }
        for (int i = 0; i < a0; i++) {
            System.out.println(neighb[i]);//AFISEZ VECTORUL DE VECINI
        }

        //CALCULEZ MIN SI MAX DIN VECTOR SI AFISEZ CUVANTUL DIN VECTORUL DE STRINGURI CARE ARE INDICELE EGAL CU CEL CORESPUNZATOR VALORII MAXIME/MINIME DIN VECTORUL DE VECINI
        int maxi = neighb[0];
        int mini = neighb[0];

        for (int i = 1; i < a0; i++) {
            if (neighb[i] > maxi) {
                maxi = neighb[i];
            }
            if (neighb[i] < mini) {
                mini = neighb[i];
            }

        }
        System.out.println(maxi + " " + mini);//AFISEZ MAX SI MIN

        for (int i = 0; i < a0; i++) {
            if (neighb[i] == maxi) {
                System.out.println("max:" + words[i]);//AFISEZ CUVINTELE CU NR. MAX DE VECINI
            }
        }
        for (int i = 0; i < a0; i++) {
            if (neighb[i] == mini) {
                System.out.println("min:" + words[i]);//AFISEZ CUVINTELE CU NR MINIM DE VECINI
            }
        }
        System.out.println();
        /////////6/////////
        System.out.println("-----6-----");
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);


        ///////////////////Bonus

        System.out.println();
        System.out.println("---------------------BONUS-------------");
        boolean verif=app.isConnected(matrix1,a0);
        System.out.println(verif);
        System.out.println();
        System.out.println("---------------------BONUS-------------");
        Graph g = new Graph(a0); // a0 vertices numbered from 0 to a0-1
        for(int i=0;i<a0;i++){
            for(int j=0;j<a0;j++){
                if(matrix1[i][j]==1&&i<j){
                    g.addEdge(i, j);
                }
            }
        }

        System.out.println("Following are connected components");
        g.connectedComponents(words);





    }


    private String createRandomWord(int len, char[] alphabet) {
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        for (int i2 = 0; i2 < len; i2++) {
            int k2 = rand.nextInt(alphabet.length);
            word.append(alphabet[k2]);
        }
        return word.toString();
    }

    static boolean checkw(String s1, String s2) {
        boolean v[] = new boolean[26];
        Arrays.fill(v, false);
        for (int i = 0; i < s1.length(); i++)
            v[s1.charAt(i) - 'a'] = true;
        for (int i = 0; i < s2.length(); i++)
            if (v[s2.charAt(i) - 'a'])
                return true;

        return false;
    }

    ///////////////////////////////Bonus
    void traverse(int u, boolean visited[],int graph[][], int a0) {
        visited[u] = true; //mark v as visited
        for(int v = 0; v<a0; v++) {
            if(graph[u][v]==1) {
                if(!visited[v])
                    traverse(v, visited,graph,a0);
            }
        }
    }


    boolean isConnected(int graph[][],int a0) {
        boolean[] vis = new boolean[a0];
        //for all vertex u as start point, check whether all nodes are visible or not
        for(int u=0; u < a0; u++) {
            for(int i = 0; i<a0; i++)
                vis[i] = false; //initialize as no node is visited
            traverse(u, vis, graph,a0);
            for(int i = 0; i<a0; i++) {
                if(!vis[i]) //if there is a node, not visited by traversal, graph is not connected
                    return false;
            }
        }
        return true;
    }

}


