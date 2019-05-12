package Queens;

public class Queens {

	   /***************************************************************************
	    Kiểm tra nếu đặt quân hậu ở vị trí q[n] ko ảnh hưởng đến các quân khác ở các vị trí q[0] tới q[n-1]
	    Trả lại true nếu phù hợp điều kiện các quân ko gặp nhau
	    ***************************************************************************/
	    public static boolean isConsistent(int[] q, int n) {
	        for (int i = 0; i < n; i++) {
	            if (q[i] == q[n])             return false;   //  kiểm tra cùng hàng
	            if ((q[i] - q[n]) == (n - i)) return false;   //  kiểm tra đường chéo
	            if ((q[n] - q[i]) == (n - i)) return false;   //  kiểm tra đường chéo 
	        }
	        return true;
	    }

	   /***************************************************************************
	    * In ra bàn cờ
	    ***************************************************************************/
	    public static void printQueens(int[] q) {
	        int n = q.length;
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (q[i] == j) System.out.print("Q ");
	                else           System.out.print("* ");
	            }
	            System.out.println();
	        }  
	        System.out.println();
	    }
	
	    public static void enumerate(int n) {
	        int[] a = new int[n];
	        enumerate(a, 0);
	    }

	    // Hàm đệ quy
	    public static void enumerate(int[] q, int k) {
	        int n = q.length;
	        // Nếu đã đặt hết 8 thì kết thúc thuật toán và in ra bàn cờ
	        if (k == n) {
	        	printQueens(q);
	        	System.exit(0);
	        }
	        else {
	        	// Đệ quy để in ra các quân hậu còn lại
	            for (int i = 0; i < n; i++) {
	                q[k] = i;
	                if (isConsistent(q, k)) enumerate(q, k+1); // Nếu hậu ở vị trí q[k] phù hợp, tiếp tục đặt ở vị trí q[k+1]
	            }
	        }
	    }  


	    public static void main(String[] args) {
	        int n = 8;
	        enumerate(n);
	    }

	}
