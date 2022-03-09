import java.util.*;
class Main {
  public static void main(String[] args) {
		//2차원 배열 BINGO
	
		final int SIZE = 5;
		int x = 0, y = 0, num = 0;
	
		int[][] bingo = new int[SIZE][SIZE];
		//int[][] bingoCheck = new int[SIZE][SIZE];
		int oCount = 0, lineCount = 0;
		Scanner scanner = new Scanner(System.in);
	
		//배열의 모든 요소를 1부터 SIZE*SIZE 까지의 숫자로 초기화
		int i,j;
		for(i=0;i<SIZE;i++)
			for(j=0;j<SIZE;j++)
				bingo[i][j] = i*SIZE + j + 1;
	
		//배열에 저장된 값을 뒤섞음
		for(i=0;i<SIZE;i++){
			for(j=0;j<SIZE;j++){
				x = (int)(Math.random()*SIZE);
				y = (int)(Math.random()*SIZE);
	
				//bingo[i][j]와 임의로 선택된 값(bingo[x][y])을 바꾼다.
				int change = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = change;
			} // j-for
		}// i-for
		do{
			for(i=0;i<SIZE;i++){
				for(j=0;j<SIZE;j++)
					System.out.printf("%3d",bingo[i][j]);
				System.out.println();		
			}
			System.out.println();

			System.out.printf("1~%d의 숫자를 입력하세요.(종료:0)>", SIZE*SIZE);
			String tmp = scanner.nextLine();
			num = Integer.parseInt(tmp);

			//중첩for문에 이름을 부여해서, 해당for문에만 break 걸릴 수 있게 해줌.
			outer:
			for(i=0;i<SIZE;i++){
				for(j=0;j<SIZE;j++){
					if(bingo[i][j]==num){
						bingo[i][j] = 0;
						break outer;
					}
				}
			}
			//bingo 출력문 보완 필요 
			// playGame:
			// for(i=0;i<SIZE;i++){
			// 	for(j=0;j<SIZE;j++){
			// 		if(bingo[i][j]==0) oCount++;	
			// 	}
			// 	if(oCount==SIZE){
			// 		++lineCount;
			// 		break playGame;
			// 	}
			// 	oCount = 0;
			// 	for(j=0;j<SIZE;j++){
			// 		if(bingo[j][i]==0) oCount++;	
			// 	}
			// 	if(oCount==SIZE){
			// 		++lineCount;
			// 		break playGame;
			// 	}
			// 	oCount = 0;
			// }//bingo출력 for문
			// if(lineCount!=0){
			// 	System.out.printf("%d BINGO!",lineCount);
			// 	System.out.println();
			// }
		}while(num!=0);
			
  } //main 
} //Main