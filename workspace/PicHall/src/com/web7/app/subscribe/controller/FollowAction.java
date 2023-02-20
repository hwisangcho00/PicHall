package com.web7.app.subscribe.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.board.vo.BoardVO;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.subscribe.dao.SubscribeDAO;
import com.web7.app.subscribe.vo.SubscribeVO;

public class FollowAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	  req.setCharacterEncoding("UTF-8");
	  resp.setCharacterEncoding("UTF-8");
		
      SubscribeDAO s_dao = new SubscribeDAO();
      MemberDAO m_dao = new MemberDAO();
      HttpSession session = req.getSession();
      //기준 아이디(로그인된 계정 또는 다른 유저 계정)
      int member_seq = Integer.parseInt(req.getParameter("member_seq"));
      
      //팔로워 : follower, 팔로잉 : following
      String check = req.getParameter("check");
      
      PrintWriter out = resp.getWriter();
      
      //뷰에서 Ajax 통신 후 success:function(result){var follows = JSON.parse(result);}
      
      List<SubscribeVO> followList = s_dao.getFollowerList(member_seq);
      JSONObject follower_json = new JSONObject();
      JSONObject following_json = new JSONObject();
      int idx = 0;
      
      List<String> idList = new ArrayList<>();

   //getFollowed_id, getFollowing_id를 하면 seq값이 담긴다.
      if(check.equals("follower")) {
         for(SubscribeVO follower : followList) {
            follower_json.put("" + idx++, m_dao.getId(follower.getFollowed_id()));
         }
         
         //{"0":"김철수","1":"홍길동","2":"이순신"} 꼴로 나옴
         out.println(follower_json.toJSONString());
   //getFollowed_id, getFollowing_id를 하면 seq값이 담긴다.
      }else if(check.equals("following")) {
         for(SubscribeVO following : followList) {
            following_json.put("" + idx++, m_dao.getId(following.getFollowing_id()));
         }
         
         //{"0":"김철수","1":"홍길동","2":"이순신"} 꼴로 나옴
         out.println(following_json.toJSONString());
      }
      req.setAttribute("idList", idList);
      out.close();
      return null;
   }

}