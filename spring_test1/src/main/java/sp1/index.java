package sp1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//index url 메인
public class index implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = "홍길동";
		/* Servlet 구조
		ModelAndView mv = new ModelAndView("index.jsp"); //여기서 웹경로를 잡는거랑 setViewName에서는 의미가 다름
		request.setAttribute("name", name);
		*/

		ModelAndView mv = new ModelAndView();
		//addObject("별명",데이터값) : 표현식 $ { } 형태 출력 및 getAttribute도 사용가능
		System.out.println(name);
		mv.addObject("name",name);	//setAttribute
		
		//view 파일을 로드
		//viewpage에 .jsp 사용안하는 이유는 dispatcher-servlet.xml에 이미 suffix로 셋팅하였음
		mv.setViewName("/WEB-INF/viewpage/index");   //view 파일을 로드 //웹 경로를 잡아줘야 안정적임(같은 디렉토리면 상관없음)
		/* WEB-INF : 경로 로드를 하지 못함 , jsp로 직접 접근하는것을 막을 수 있음 view page는 이 경로에 만듬 */
		
		return mv;
	}

}
