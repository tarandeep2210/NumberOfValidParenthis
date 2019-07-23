package myProject;

public class NumberOfValidParenthis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DP SOLUTION
		NumberOfValidParenthis obj = new NumberOfValidParenthis();
		int n=6;
		int result; 
		// starting time 
        long start = System.currentTimeMillis(); 
        if((n&1)!=0)
			result=0;
        else
        	result = obj.catalanDP(n/2);
        // ending time 
        long end = System.currentTimeMillis();
        
		System.out.println("Total possible parenthesis strings are " +result + " Time in ms "+(end-start));

	}
	
	int catalanDP(int n){
		int catalan[] = new int[n+2];
		
		
		// Initialize first two values in table  
        catalan[0] = 1; 
        catalan[1] = 1;
        
     // Fill entries in catalan[] using recursive formula  
        for (int i = 2; i <= n; i++) { 
            catalan[i] = 0; 
            for (int j = 0; j < i; j++) { 
                catalan[i] += catalan[j] * catalan[i - j - 1]; 
            } 
        } 
        
		return catalan[n];
	}

}
//Time complexity of above implementation is O(n2)


//https://www.geeksforgeeks.org/program-nth-catalan-number
//recursive solutionn below with exponential complexity


class CatalnNumber { 

	// A recursive function to find nth catalan number 

	int catalan(int n) { 
		int res = 0; 
		
		// Base case 
		if (n <= 1) { 
			return 1; 
		} 
		for (int i = 0; i < n; i++) { 
			res += catalan(i) * catalan(n - i - 1); 
		} 
		return res; 
	} 

	public static void main(String[] args) { 
		CatalnNumber cn = new CatalnNumber(); 
		for (int i = 0; i < 10; i++) { 
			System.out.print(cn.catalan(i) + " "); 
		} 
	} 
} 

// O(N) SOlution using Binomaial Coefficient

// Java program for nth Catalan Number 

class GFG { 

// Returns value of Binomial Coefficient C(n, k) 
	static long binomialCoeff(int n, int k) { 
		long res = 1; 

		// Since C(n, k) = C(n, n-k) 
		if (k > n - k) { 
			k = n - k; 
		} 

		// Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1] 
		for (int i = 0; i < k; ++i) { 
			res *= (n - i); 
			res /= (i + 1); 
		} 

		return res; 
	} 

// A Binomial coefficient based function to find nth catalan 
// number in O(n) time 
	static long catalan(int n) { 
		// Calculate value of 2nCn 
		long c = binomialCoeff(2 * n, n); 

		// return 2nCn/(n+1) 
		return c / (n + 1); 
	} 

// Driver program to test above function 
	public static void main(String[] args) { 
		for (int i = 0; i < 10; i++) { 
			System.out.print(catalan(i) + " "); 
		} 

	} 
} 


