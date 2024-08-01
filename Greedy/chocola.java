// //divide the chocolate into single squares with min cost
// import java.util.*;
// class chocola
// {
//     public static int minCost(ArrayList<Integer> al1 , ArrayList<Integer> al2)
//     {

//         Collections.sort(al1,Collections.reverseOrder());
//         Collections.sort(al2,Collections.reverseOrder());
        
//         int cost = 0;
//         int rowCut = 1;
//         int colCut = 1;
        
//         int i = 0;
//         int j = 0;

//         while(i < al1.size() && j < al2.size())
//         {
//             if(al1.get(i) < al2.get(j))
//             {
//                 cost += rowCut*al2.get(j);
//                 j++;
//                 colCut++;
//             }

//             else if(al1.get(i) > al2.get(j))
//             {
//                 cost += colCut*al1.get(i);
//                 i++;
//                 rowCut++;
//             }
//             else
//             {
//                 if(rowCut <= colCut)
//                 {
//                     cost += rowCut*al2.get(j);
//                     j++;
//                     colCut++;
//                 }
//                 else
//                 {
//                     cost += colCut*al1.get(i);
//                     i++;
//                     rowCut++;
//                 }
//             }
//         }

//         while(i < al1.size())
//         {
//             cost += colCut*al1.get(i);
//             i++;
//             rowCut++;
//         }
//         while(j < al2.size())
//         {
//             cost += rowCut*al2.get(j);
//             j++;
//             colCut++;
//         }

//         return cost;
//     }

//     public static void main(String args[])
//     {
//         Scanner sc = new Scanner(System.in);
//         int testCases = sc.nextInt();
        
//         while(testCases > 0)
//         {
//             String inp = sc.nextLine();
//             int m = sc.nextInt();
//             int n = sc.nextInt();
            
//             ArrayList<Integer> al1 = new ArrayList<>();
//             ArrayList<Integer> al2 = new ArrayList<>();

//             for(int i = 0 ; i < m-1 ; i++)
//             {
//                 al1.add(sc.nextInt());
//             }
//             for(int i = 0 ; i < n-1 ; i++)
//             {
//                 al2.add(sc.nextInt());
//             }

//             System.out.println("minimum cost is "+minCost(al1,al2));
//             testCases--;
//         }
//     }
// }

import java.util.*;

class Chocola {
    public static int minCost(ArrayList<Integer> al1, ArrayList<Integer> al2) {
        Collections.sort(al1, Collections.reverseOrder());
        Collections.sort(al2, Collections.reverseOrder());

        int cost = 0;
        int rowCut = 1;
        int colCut = 1;

        int i = 0;
        int j = 0;

        while (i < al1.size() && j < al2.size()) {
            if (al1.get(i) < al2.get(j)) {
                cost += rowCut * al2.get(j);
                j++;
                colCut++;
            } else {
                cost += colCut * al1.get(i);
                i++;
                rowCut++;
            }
        }

        while (i < al1.size()) {
            cost += colCut * al1.get(i);
            i++;
            rowCut++;
        }
        while (j < al2.size()) {
            cost += rowCut * al2.get(j);
            j++;
            colCut++;
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine().trim());
        sc.nextLine();

        while (testCases > 0) {
            String[] dimensions = sc.nextLine().trim().split(" ");
            int m = Integer.parseInt(dimensions[0]);
            int n = Integer.parseInt(dimensions[1]);

            ArrayList<Integer> al1 = new ArrayList<>();
            ArrayList<Integer> al2 = new ArrayList<>();

            for (int i = 0; i < m - 1; i++) {
                al1.add(Integer.parseInt(sc.nextLine().trim()));
            }
            for (int i = 0; i < n - 1; i++) {
                al2.add(Integer.parseInt(sc.nextLine().trim()));
            }

            System.out.println(minCost(al1, al2));
            testCases--;

            if (testCases > 0) {
                sc.nextLine(); // consume the blank line between test cases
            }
        }

        sc.close();
    }
}
