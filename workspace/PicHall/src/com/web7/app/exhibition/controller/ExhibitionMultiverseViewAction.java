package com.web7.app.exhibition.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.music.vo.MusicVO;
import com.web7.app.music_exhibition.dao.MusicExhibitionDAO;
import com.web7.app.music_exhibition.vo.MusicExhibitionVO;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;
import com.web7.app.photo_exhibition.dao.PhotoExhibitionDAO;
import com.web7.app.photo_exhibition.vo.PhotoExhibitionVO;



public class ExhibitionMultiverseViewAction implements Action{
//exhibition_detail_page.jsp와 연결
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		ActionForward forward=new ActionForward();
		
		int exhibition_seq = Integer.parseInt(req.getParameter("exhibition_seq"));
		
		ExhibitionDAO e_dao=new ExhibitionDAO();
		MemberDAO m_dao=new MemberDAO();
		ExhibitionVO e_vo= e_dao.getDetail(exhibition_seq);
		
		//전시회에 사용된 사진을 불러오기위한 dao및 vo
		PhotoExhibitionDAO pe_dao = new PhotoExhibitionDAO();
		PhotoExhibitionVO pe_vo=new PhotoExhibitionVO();
		PhotoDAO p_dao=new PhotoDAO();
		PhotoVO p_vo=new PhotoVO();

		//전시회에 사용된 음악을 불러오기 위한 dao및 vo
		MusicExhibitionDAO me_dao = new MusicExhibitionDAO();
		MusicExhibitionVO me_vo=new MusicExhibitionVO();
		MusicDAO mu_dao=new MusicDAO();
		MusicVO mu_vo=new MusicVO();
		
		int member_seq=e_dao.getMemberSeq(exhibition_seq);
		String artist_text= m_dao.getTextbySeq(member_seq);
		String member_nickname= m_dao.getNicknamebySeq(member_seq);
		

		List<PhotoExhibitionVO> ExhibitionPhotoBeanList=pe_dao.getPhotobySeq(exhibition_seq);
		
		List<PhotoVO> photoBeanList=new ArrayList<>();
		//photoBeanList에 사진객체들 배열
		for(int i=0;i<ExhibitionPhotoBeanList.size(); i++){
			pe_vo= ExhibitionPhotoBeanList.get(i);
			
			int photo_seq=pe_vo.getPhoto_seq();
			
			p_vo=p_dao.getPhoto(photo_seq);

			photoBeanList.add(p_vo);
		}
		
		
		List<MusicExhibitionVO> ExhibitionMusicBeanList=me_dao.getMusicbySeq(exhibition_seq);
		
		List<MusicVO> musicBeanList=new ArrayList<>();
		//musicBeanList에 사진객체들 배열
		for(int i=0;i<ExhibitionMusicBeanList.size(); i++){
			me_vo= ExhibitionMusicBeanList.get(i);
			
			int music_seq=me_vo.getMusic_seq();
			
			mu_vo=mu_dao.getMusic(music_seq);
			
			musicBeanList.add(mu_vo);
		}
		
		req.setAttribute("photoBeanList", photoBeanList);
		req.setAttribute("musicBeanList", musicBeanList);
		
		
		if(e_vo != null) {
			req.setAttribute("member_seq", member_seq);
			req.setAttribute("exhibition_seq", exhibition_seq);
			req.setAttribute("member_nickname", member_nickname);
			req.setAttribute("artist_text", artist_text);

			forward.setRedirect(false);
			forward.setPath("/multiverse.jsp");
			
		}
		return forward;
	}
	}


