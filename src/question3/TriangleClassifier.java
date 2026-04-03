package question3;

public class TriangleClassifier {
	
	public static int TypeTriangle(int a , int b , int c) {
		
		if( a < 0 ||  b < 0 || c < 0 )
			return 0;
		
		int type = 0 ;
		
		if(a== b)
			type = type+1;
		if(a==c)
			type = type +2;
		if(b==c)
			type = type+3;
		
		if(type== 0) {
			if(a+b <= c || a + c <= b || b+c <= a)
				return 0;
			return 1;
		}
		
		if(type >3)
			return 3;
		if(type ==1 && a + b > c)
			return 2;
		
		if(type == 2 && a + c > b)
			return 2;
		if (type == 3  && b+c > a)
			return 2 ;
		
		return 0;
	}
}