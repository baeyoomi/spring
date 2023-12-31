package sp1;

import java.util.ArrayList;
import java.util.LinkedList;

//2차원 배열에 대한 응용편
/*
	A조 김경민,배유미,김승균
	B조 이철의,장진호,홍사라
	C조 박병준,전정호,이경선
	D조 최현제,서강인,염무원
	
	[결과]
	[[A조,김경민,배유미,김승균],[B조,이철의,장진호,홍사라]....]
*/
public class array_link3 {

	public static void main(String[] args) {
	//코드 및 결과 출력
		//Data 담은 2차배열 만듬
		String group[][] = {
				{"김경민","배유미","김승균"},
				{"이철의","장진호","홍사라"},
				{"박병준","전정호","이경선"},
				{"최현제","서강인","염무원"}
		}; 
		
		//빈 List 배열 (2차배열) 생성
		ArrayList<ArrayList<String>> team = new ArrayList<ArrayList<String>>();

		//빈배열에 나눠질 그룹별로 빈 List 배열 생성
		ArrayList<String> cr1 = new ArrayList<String>();
		ArrayList<String> cr2 = new ArrayList<String>();
		ArrayList<String> cr3 = new ArrayList<String>();
		ArrayList<String> cr4 = new ArrayList<String>();
		
		//반복문으로 들어갈 순서 돌리고, 조건문으로 해당 조건에만 그룹별 데이터 삽입
		int i,j=0;
		for(i=0; i<group.length; i++) {
			for(j=0; j<group[0].length;j++) {
				if(i == 0) {
					cr1.add(group[i][j]);
				}
				else if(i == 1) {
					cr2.add(group[i][j]);
				}
				else if(i == 2) {
					cr3.add(group[i][j]);
				}
				else{
					cr4.add(group[i][j]);
				}
			}
		}
		
		//그룹별로 입력 될 수 있게 List 2차 배열에 add시킴
		team.add(cr1);
		team.add(cr2);
		team.add(cr3);
		team.add(cr4);
		team.get(0).add(0,"A조");
		team.get(1).add(0,"B조");
		team.get(2).add(0,"C조");
		team.get(3).add(0,"D조");
		System.out.println(team);

	}

}
