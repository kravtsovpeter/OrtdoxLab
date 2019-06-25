package com.ortdox.dev;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ortdox.dev.domain.Meeting;
import com.ortdox.dev.repos.MeetingRepo;

/**
 * Класс-контроллер встреч
 * @author pkravtsov
 */
@Controller
public class GreetingController {
	
	/** DAO репозиторий встреч */
	@Autowired
	private MeetingRepo meetingRepo;

	/**
	 * Вызов основной страницы localhost
	 * @param model Модель параметров
	 * @return Отображаемая страница
	 */
    @GetMapping
    public String main(Map<String, Object> model) {
    	Iterable<Meeting> meetings = meetingRepo.findAll();
    	model.put("meetings", formatMeetings(meetings));
    	return "main";
    }
    
    /**
     * Вызов сервиса добавления встречи
     * @param place Место встречи
     * @param owner Автор встречи
     * @param date Дата встречи
     * @param model Модель параметров
     * @return Отображаемая страница
     */
    @PostMapping
    public String add(@RequestParam String place, @RequestParam String owner, 
    		@RequestParam("date") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm") Date date, Map<String, Object> model) {
    	Meeting meeting = new Meeting(place, owner, date);
    	meetingRepo.save(meeting);
    	Iterable<Meeting> meetings = meetingRepo.findAll();
    	model.put("meetings", formatMeetings(meetings));
    	return "main";
    }
    
    /**
     * Вызов сервиса фильтра встречи
     * @param filter Параметр фильтра(место встречи)
     * @param model Модель параметров
     * @return Отображаемая страница
     */
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model ) {
    	Iterable<Meeting> meetings;
    	if (filter != null && !filter.isEmpty())
    	{
    		meetings = meetingRepo.findByPlace(filter);
    	} else {
    		meetings = meetingRepo.findAll();
    	}
    	model.put("meetings", formatMeetings(meetings));
    	return "main";
    }
    
    /**
     * Обработка ошибки
     * @param req Запрос
     * @param ex Объект ошибки
     * @return Отображаемое представление с ошибкой
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
      ModelAndView mav = new ModelAndView();
      mav.addObject("exception", ex);
      mav.addObject("url", req.getRequestURL());
      mav.setViewName("error");
      return mav;
    }
    
    /**
     * Форматировать список встреч(формат даты)
     * @param meetings Список встреч
     * @return отфармотированный список встреч
     */
    private Iterable<Meeting> formatMeetings(Iterable<Meeting> meetings) {
    	for(Meeting meeting : meetings)
    	{
    		meeting.setFormatedDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").
    				format(meeting.getDate()));
    	}
    	return meetings;
    }

}
