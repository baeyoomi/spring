package sp1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller    //인터페이스를 해당 클래스 안에 있는 모든 메소드에 적용하아는 뜻
public class webpage {
	ModelAndView mv = null;
	
	/*
		@RequestMapping : 가상 파일명 GET,POST 모두 사용 (service)
		@GetMapping : GET전송
		@PostMapping : POST 전송
		@PutMapping : Database - insert 전용 (Ajax에서 사용)
		@DeleteMapping : Database = delete 전용 (Ajax에서 사용)
		@PatchMapping : Database = update 전용 (Ajax에서 사용)
	*/	
	
	//로그인
	/* ModelAndView(구식 - Controller Interface) vs Model(신식 - String형태로 변환 addAttribute)
	   Model을 쓴다는건 어노테이션을 사용하여 적용하는 사항 + 데이터를 담기 위한
	   View에서 Model에 담겨진 데이터 자동으로 출력 $형태
	  
	   ModelAndView : return 시 jsp(xml에서 설정함)는 같은 이름으로 처리
	   setViewName을 사용하지 않을 경우 webpage.xml에 prefix에 해당 view경로를
	   적어 주셔야 보안상 jsp 강제 입력이 되지 않습니다.
	   
	   setViewName을 사용시 webpage.xml에 prefix에는 /로 처리하고 해당 ("view경로를 필수로 입력하셔야 합니다.")
	*/
	@RequestMapping("/login.do") //양쪽다 받을수 있어서 위험할 수 있으니 RequestMapping보다는 get또는 post로 명시하는걸 추천
	public ModelAndView loginok(HttpServletRequest req, HttpServletResponse res) throws Exception  {
		String mid = req.getParameter("mid");
		String mpass = req.getParameter("mpass");
		this.mv = new ModelAndView();
		mv.addObject("userid",mid);
		mv.addObject("userpw",mpass);
		//mv.setViewName("/WEB-INF/viewpage/login"); //다른 위치에 파일있을때 쓰는것, xml에 /WEB-INF/viewpage/ 셋팅해서 이거 설정 안하고 쓸수도 있음
		return mv;
	}
	
	//상품검색 (문자 자료형으로 return 사용하여 해당 페이지로 view 출력)
	@GetMapping("/search.do")
	public String search(HttpServletRequest req, HttpServletResponse res, Model m) {
		String sh = req.getParameter("product");
		m.addAttribute("word",sh);
		return "/WEB-INF/viewpage/product";
	}
	
	//아이디 및 패스워드 찾기
	@PostMapping("/idsearch.do")
	/* void 메소드는 Response를 사용시 해당 view를 찾지 못하는 상황이 발생함
	   또한, ModelAndView를 사용할 수 없다. 고로 경로 지정 불가(xml에 지정해서 사용하는 방법이 있을 수 있음) */
	public void joinok(Model m, HttpServletRequest req) {
		String names = req.getParameter("person");
		m.addAttribute("user",names);
		System.out.println(m.getAttribute("user"));
	}
}
