import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(true){
			String s=in.nextLine();
			if(s.toString().equals("")){
				break;
			}
			boolean inBrack=false;
			ArrayList<String> cards=new ArrayList<>();
			
			
			for(int i=0;i<s.length();i++){
				if(!inBrack&&s.charAt(i)=='['){
					inBrack=true;				
				}
				else if(inBrack){
					if(s.charAt(i)==']'){
						inBrack=false;
					}
					else if(s.charAt(i)!=' '){
						cards.add(s.substring(i, i+2));
						i++;
					}
				}
			}
			for(int j=0;j<cards.size();j++){
				String card = cards.get(j);
				s=s.replace(card,"["+card+"](/"+card+")");
			}
			s=s.replace("haidere34","HERO");
			System.out.println("\n"+s);
		}

	}

}
