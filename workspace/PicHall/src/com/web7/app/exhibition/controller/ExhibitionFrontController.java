package com.web7.app.exhibition.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.ActionForward;
import com.web7.app.exhibition.controller.ExhibitionViewAction;

public class ExhibitionFrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		
		switch(command) {
		//마이페이지 -> 전시회만들기 페이지로 가기
		case "/exhibition/ExhibitionUpload.ex" :
			try {
				forward = new ExhibitionUploadAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		//제목, 설명, 카테고리, 날짜 확인
		case "/exhibition/ExhibitionSettingOk.ex" :
			try {
				forward = new ExhibitionSettingOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		//메인사진 고르는 페이지 뷰
		case "/exhibition/ExhibitionPhotoMain.ex" :
			try {
				forward = new ExhibitionPhotoMainViewAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;			
		//메인사진 고르고 ok
		case "/exhibition/ExhibitionPhotoMainOk.ex" :
			try { 
				forward = new ExhibitionPhotoMainOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;			
		case "/exhibition/ExhibitionPhoto.ex" :
			try { //ExhibitionPhotocAction 주의....오타..
				forward = new ExhibitionPhotocAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;			
		case "/exhibition/ExhibitionPhotoOk.ex" :
			try {
				forward = new ExhibitionPhotoOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		break;			
		//음악 선택 페이지가기(마지막 단계)
		case "/exhibition/ExhibitionMusic.ex" :
			try {
				forward = new ExhibitionMusicAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		break;
		//음악 확인(마지막 단계)
		case "/exhibition/ExhibitionFinishOk.ex" :
			try {
				forward = new ExhibitionFinishOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		break;
		//마이페이지->전시회 수정 페이지
		case "/exhibition/ExhibitionModify.ex" :
			try {
				forward = new ExhibitionModifyAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		break;
		//제목, 설명, 카테고리, 날짜 확인
		case "/exhibition/ExhibitionModifyOk.ex" :
			try {
				forward = new ExhibitionModifyOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		break;
		
		case "/exhibition/ExhibitionPhotoMainModifyView.ex" :
			try {
				forward = new ExhibitionPhotoMainModifyViewAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;			
		//메인사진 고르고 ok
		case "/exhibition/ExhibitionPhotoMainModifyOk.ex" :
			try { 
				forward = new ExhibitionPhotoMainModifyOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;			
		
		//사진, 사진제목, 사진설명 확인
		
		case "/exhibition/ExhibitionPhotoModify.ex" :
			try {
				forward = new ExhibitionPhotoModifyAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		break;		
		
		case "/exhibition/ExhibitionPhotoModifyOk.ex" :
			try {
				forward = new ExhibitionPhotoModifyOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		break;		
		//음악 확인(마지막 단계)
		case "/exhibition/ExhibitionMusicModify.ex" :
			try {
				forward = new ExhibitionMusicModifyAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		break;
		case "/exhibition/ExhibitionModifyFinishOk.ex" :
			try {
				forward = new ExhibitionModifyFinishOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		break;
		//recommend_exhibition.jsp
		case "/exhibition/RecommendExhibition.ex" :
			try {
				forward = new Recommend_exhibitionListAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		//all_exhibition.jsp
		case "/exhibition/ExhibitionList.ex" :
			try {
				forward = new All_exhibitionListAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		//detail.jsp
		case "/exhibition/ExhibitionView.ex" :
			try {
				forward = new ExhibitionViewAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			//multiverse.jsp
		case "/exhibition/ExhibitionMultiverseView.ex" :
			try {
				forward = new ExhibitionMultiverseViewAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		//userpage.jsp
		case "/exhibition/UserView.ex":
			try {
				forward = new UserPageAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		//subscribe
		case "/exhibition/SubscribeOk.ex":
			try {
				forward = new SubscribeOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		//unsubscribe
		case "/exhibition/UnSubscribeOk.ex":
			try {
				forward = new UnSubscribeOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/exhibition/SendReport.ex":
			try {
				forward = new SendReportAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/exhibition/ExhibitionMainList.ex":
			try {
				forward = new ExhibitionMainListAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/exhibition/ExhibitionDelete.ex":
			try {
				forward = new ExhibitionDeleteAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}
		
		//일괄처리
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
