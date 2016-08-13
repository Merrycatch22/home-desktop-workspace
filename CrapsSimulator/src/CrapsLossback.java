
public class CrapsLossback {
	public static void main(String[] args) {
		double money=0;
		double plays=10000000;
		int dice;  // initial roll
		double lossback=0.00;
		boolean pass=true;
		if (pass){
			for (int i=0;i<plays;i++){
				dice = (int)(6.0*Math.random() + 1.0) +
						(int)(6.0*Math.random() + 1.0);

				if (dice == 2 || dice == 3 || dice == 12) {
					
					money+=-1+lossback;
				}
				else if (dice == 7 || dice == 11) {
					
					money+=1;
				}
				else { 
					int point = dice; // point: 4, 5, 6, 8, 9, or 10
					
					while (true) {  // keep rolling
						dice = (int)(6.0*Math.random() + 1.0) +
								(int)(6.0*Math.random() + 1.0);
						
						if (dice == point) {
							
							money+=1;
							break;  // break out of loop, a win
						}
						if (dice == 7) {
							
							money+=-1+lossback;
							break;  // break out of loop, a loss
						}
						
					}
				}
			}
		}
		else
		{
			for (int i=0;i<plays;i++){
				dice = (int)(6.0*Math.random() + 1.0) +
						(int)(6.0*Math.random() + 1.0);

				if (dice == 2 || dice == 3) {
					money+=1;
				}
				else if (dice == 12){
					money+=0;
				}
				else if (dice == 7 || dice == 11) {
					
					money+=-1+lossback;
				}
				else { 
					int point = dice; // point: 4, 5, 6, 8, 9, or 10
					//System.out.println("Point: " + point);
					while (true) {  // keep rolling
						dice = (int)(6.0*Math.random() + 1.0) +
								(int)(6.0*Math.random() + 1.0);
						//System.out.println("\nNew roll: " + dice);
						if (dice == point) {
							
							money+=-1+lossback;
							break;  // break out of loop, a win
						}
						if (dice == 7) {
							
							money+=1;
							break;  // break out of loop, a loss
						}
						
					}
				}
			}
		}
		System.out.println("EV/game:"+money/plays);
	}
}
