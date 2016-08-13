
public class CrapsNoSim {
	public static void main(String[] args) {
		boolean pass=true;
		double lossback=0.01;
		double passEV;
		double dontEV;
		
			passEV=(-7.0/495.0+839.0/495.0*lossback)/3;
			//3 is avg chips bet
			//251/495+3(6/36*2/3+8/36*3/5+10/36*6/11)=839/495
			//ev=-7/495.0+251.0/495*lossback;
		
	
			
			dontEV=(-3.0/220.0+646.0/495.0*lossback)/3;
			//3 is avg chips bet
			
		System.out.println("passEV per chip "+passEV);
		System.out.println("dontEV per chip "+dontEV);
	}
}
