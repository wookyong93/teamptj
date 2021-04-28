package com.spring.foodchain.roomlist.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.foodchain.roomlist.service.RoomListService;
import com.spring.foodchain.roomlist.vo.RoomListVO;

@Controller("roomlistController")
public class RoomListControllerImpl implements RoomListController{
   @Autowired
   private RoomListService roomlistSrv;
   @Autowired
   private RoomListVO roomlistVO;
   private Map<Integer, HashSet> joinMember = new HashMap<Integer, HashSet>();
   private Map<Integer, HashSet> readyMember = new HashMap<Integer, HashSet>();


   // readyButton 을 누르면 여기로 와서
   @RequestMapping(value="/room/readyButton.do", method= RequestMethod.POST)
   public void readyButton(HttpServletRequest request, HttpServletResponse response) {
      String nickName = request.getParameter("nickName");
      int roomNum = Integer.parseInt(request.getParameter("roomNum"));
      
      // readyMember에 저장되어 있는 roomNum 에 값을 호출 해서
      HashSet<String> readyId = readyMember.get(roomNum);
      
      // 그안에 들어 있는 hashset에 readyId 가 있는 지 확인 하고 
      if(readyId == null) {
    	  // 비어 있으면 새로 만들어서 
         readyId = new HashSet<String>();
      }
      // 없으면 그냥 저장 
      readyId.add(nickName);
      // 다시 그 값을 hashmap 에 저장 
      readyMember.put(roomNum, readyId);
      
      // 세션을 확인하고 
      HttpSession session = request.getSession(false);
      
      // 거기에 readyButton 누른 사람의 수를 넘겨 주는 거
      session.setAttribute("readyCount", readyId.size());
  
   }
	@Override
	@RequestMapping(value="/room/roomlistmain.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView roomlist(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = getViewName(request);
		List roomList = roomlistSrv.roomsList();
		
		HttpSession session = request.getSession(false);
		
		String roomNum = request.getParameter("roomNum");
	    Integer room = null;
	    if(roomNum != null) {
	         room = Integer.parseInt(request.getParameter("roomNum"));
	      }
	    
	    String  userId = (String) session.getAttribute("nickName");
	    
	    HashSet joinId = joinMember.get(room);
	    
	    if(joinId != null) {
	         joinId.remove(userId);
	         System.out.println("delRoom : " + userId);
	         System.out.println(joinId);
	         if(joinId.size() == 0) {
	            System.out.println("test");
	            int result = roomlistSrv.delRoom(room);
	         }
	      }

		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("roomList",roomList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/room/addroom.do" ,method = RequestMethod.POST)
	public ModelAndView addRoom(@ModelAttribute("room") RoomListVO room,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("addroom");
		int result = 0;
		result = roomlistSrv.addRoom(room);
		System.out.println(room.getChief_id()+room.getRoomNum()+room.getTitle());
		ModelAndView mav = new ModelAndView("redirect:/room/roomlistmain.do");
		return mav;
	}
	
	@RequestMapping(value = "/room/createroom.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value = "/room/gamewaitpage.do", method =  RequestMethod.GET)
	private ModelAndView form1(@RequestParam(value= "result", required=false) String result,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		
		HttpSession sessoin = request.getSession(false);

		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		
		Integer roomNum = Integer.parseInt(request.getParameter("roomNum"));
		
		String nickName = (String) sessoin.getAttribute("nickName");
		
		HashSet<String> joinId = joinMember.get(roomNum);
	      
	    if(joinId == null) {
	         joinId = new HashSet<String>();
	    }
	      
	    joinId.add(nickName);
	      
	    joinMember.put(roomNum, joinId);
	      
	    sessoin.setAttribute("joinId", joinId);
	    sessoin.setAttribute("joinCount", joinId.size());
	    mav.setViewName(viewName);
	    return mav;
	   }
	
	@RequestMapping(value="/room/popup.do" ,method = RequestMethod.GET)
	private ModelAndView form2(@RequestParam(value= "result", required=false) String result,
		       HttpServletRequest request, 
		       HttpServletResponse response) throws Exception {
String viewName = (String)request.getAttribute("viewName");
ModelAndView mav = new ModelAndView();
mav.addObject("result",result);
mav.setViewName(viewName);
return mav;
}
	
	private String getViewName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}

	}
