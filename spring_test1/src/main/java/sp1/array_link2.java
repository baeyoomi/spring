package sp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

//List : ArrayList, LinkedList, Vector, Stack

public class array_link2 {

	public static void main(String[] args) {
		String a[] = {"A","B","C"};
		List<String> z = Arrays.asList(a); //이상태면 추가 더 이상 안됌
		//z.add("D"); 안됌
		//System.out.println("List<자료형> : " + z);
		
		List<String> zz = new ArrayList<String>(Arrays.asList(a)); //추가 됌
		zz.add("D");
		zz.add(4,"J");  // 추가
		zz.set(4,"H");  // 기존 데이터를 변경(위치(인덱스 번호),바꿀내용)
		//System.out.println("ArrayList : " + zz);
		
	//Vector : 쓰레드를 활용함 배열에 대한 안정성이 확보됨 LinkedList 보다 빠름, ArrayList 보다 느림
		List<String> zzz = new Vector<String>(Arrays.asList(a));
		zzz.add("10");
		zzz.set(0, "AAA");
		//System.out.println("Vector : " + zzz);
		
		//List 에 자료형이 없는 경우 (Object)
		List k = new ArrayList<>(Arrays.asList(a));
		k.add(110);
		k.add("홍길동");
		//System.out.println("List : " + k);
		
	//List 에 자료형을 Object로 명시할 경우 (Object = ?)
		/*
		 List<?> k = new ArrayList<>(Arrays.asList(a)); 
		 k.add(1,null);  ?로 명시하면 사용하는 방법이 달라짐
		 */
		
		//ArrayList al = new ArrayList(Arrays.asList(a));
		//ArrayList<?> al = new ArrayList(Arrays.asList(a)); // ? : Object의 기호
		//System.out.println(al);
		
		new datalist().abc(); 
	}

}

class datalist{
	public void abc() {
		String member[][] = {
				{"홍길동","SKT","45"},
				{"이순신","LGT","55"},
				{"강감찬","KT","25"}
		};
		//System.out.println(Arrays.toString(member[0]));
		
	//String[], Integer[] : List 모든 배열을 2차 배열형태로 구성함
		ArrayList<String[]> al = new ArrayList<String[]>(Arrays.asList(member));
		int w = 0;
		while(w < al.size()) {
			//System.out.println(al.get(w)[0]);
			w++;
		}
		
	//빈배열 만들고 값넣기 (2차 배열임) - []가 밖에 있는것과 아닌것은 차이가 있음
		ArrayList<Integer>[] ai = new ArrayList[100];
		int ww = 0;
		while(ww < 10) {
			ai[ww] = new ArrayList<Integer>();
			ww++;
		}
		ai[0].add(10);
		ai[1].add(20);
		ai[2].add(30);
		ai[3].add(40);
		//System.out.println(ai[0].get(0));
		//System.out.println(Arrays.toString(ai));
		
	//2차원 배열 ArrayList (Arrays.deepToString)
		//2차원 빈 배열 값 생성
		ArrayList<ArrayList<String>> k = new ArrayList<ArrayList<String>>();
			//System.out.println(Arrays.deepToString(k.toArray()));
			//k.get(0).add("A"); 이렇게 넣을 수도 있음
		//2차원 배열에 그룹으로 값을 삽입하기 위한 1차원 빈배열
		ArrayList<String> kk = new ArrayList<String>();
		kk.add("홍길동");
		kk.add("25");
		kk.add("hong@nate.com");
		
		k.add(kk); //2차원 배열에 해당 값을 삽입
		
		//새로운 1차원 배열을 생성 후 데이터 입력
		ArrayList<String> kk2 = new ArrayList<String>();
		kk2.add("이순신");
		kk2.add("36");
		kk2.add("lee@nate.com");		
		
		k.add(kk2);  //새로운 데이터를 2차원 배열로 값을 삽입
		//출력
		System.out.println(k);
		//System.out.println(k.get(0).get(2));  //2차원 배열 중 그룹,데이터 index 숫자
		//k.remove(0);
		//System.out.println(k);
		k.get(1).remove(2);  //2차원 배열 중 해당 그룹에서 데이터를 삭제하는 방식 ,배열 속에 내용 지우기
		k.get(1).add("lee@gamil.com");
		System.out.println(k);
	}
}