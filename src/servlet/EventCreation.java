package servlet;

//index.jspの画面

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CreateAndAnnihilateEventPage;
import model.Event;

/**
 * Servlet implementation class EventCreation
 */
@WebServlet("/EventCreation")
public class EventCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventCreation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//リクエストパラメータの取得(新規イベント作成）
		request.setCharacterEncoding("UTF-8");
		String eventName = request.getParameter("eventName"); // イベント名
		String organizarName = request.getParameter("organizarName"); // 幹事の名前
		String eventVenueA = request.getParameter("eventVenue"); // 場所
		String autherName = request.getParameter("autherName"); // イベント製作者の名前
		String autherPass = request.getParameter("autherPass"); //イベント製作者の編集用パスワード
		String autherRemarkA = request.getParameter("autherRemark"); // イベント製作者の備考欄
		String eventOpenFlagS = request.getParameter("eventOpenFlag"); // イベントの公開フラグ.1:公開,0:非公開
		String numberOfEvent = request.getParameter("numberOfEvent");//イベント会数
		String pricePerPersonA = request.getParameter("pricePerPerson"); // イベント一人当たりの料金

		String deadlineDayYearS = request.getParameter("deadlineYear"); // 締切日　年
		String deadlineDayMonthS = request.getParameter("deadlineDayMonth"); //締切日　
		String deadlineDateS = request.getParameter("deadlineDay"); //締切日　日


		String[] yearS = request.getParameterValues("year"); // 年 日程候補日
		String[] monthS = request.getParameterValues("month"); // 月　日程候補日
		String[] dateS = request.getParameterValues("day"); // 日　日程候補日
		String[] hourS = request.getParameterValues("hour"); // 時間



		//イベントの場所
		ArrayList<String> eventVenue = new ArrayList<String>();
		eventVenue.add(eventVenueA);


		//イベント製作者の備考欄
		ArrayList<String> autherRemark = new ArrayList<String>();
		autherRemark.add(autherRemarkA);


		//イベント一人当たりの料金
		ArrayList<String> pricePerPerson = new ArrayList<String>();
		pricePerPerson.add(pricePerPersonA);


		//投稿日時
		Calendar  registDay = Calendar.getInstance();


		//締切日
		Calendar deadlineDay = Calendar.getInstance();


		//確定日時
		Calendar determinedDay =  Calendar.getInstance();


		//イベント確定のフラグ　１：確定　０：未確定
		int determinedFlag = 0;


		//イベント公開・非公開
		int eventOpenFlag = Integer.parseInt(eventOpenFlagS);


		//URL
		String eventUrl = "NO DATA";


		//イベントページファイルの名前
		String eventPageFileName = "NO DATA";


		//候補日
		ArrayList<Calendar> candidate = new ArrayList<Calendar>();


		//Eventインスタンスの生成
		Event event = new Event(eventName, organizarName, eventVenue,
			registDay, autherName, autherPass, deadlineDay,
			autherRemark, determinedDay, determinedFlag, eventOpenFlag,
			numberOfEvent, eventUrl, eventPageFileName, pricePerPerson,
			candidate);

		//候補日
		for (int i = 1; i < yearS.length; i++){

			String a = yearS[i];
			String b = monthS[i];
			String c = dateS[i];
			String d = hourS[i];

			//候補日Stringからintへ
			int year = Integer.parseInt(a);
			int month= Integer.parseInt(b);
			int date = Integer.parseInt(c);
			int hour = Integer.parseInt(d);

			month -= 1;

			//Calendarクラスにまとめる
			Calendar candidateA = Calendar.getInstance();
			Event.setYear(candidateA, year);
			Event.setMonth(candidateA, month);
			Event.setDate(candidateA, date);
			Event.setHour(candidateA, hour);

			//ArrayListにいれる
			event.addCandidate(candidateA);
		}


		//締め切り日時Stringからintへ
		int deadlineDayYear = Integer.parseInt(deadlineDayYearS);
		int deadlineDayMonth= Integer.parseInt(deadlineDayMonthS);
		int deadlineDate = Integer.parseInt(deadlineDateS);
		deadlineDayMonth -= 1;


		//締切日をセット
		event.setDeadlineYear(deadlineDayYear);
		event.setDeadlineMonth(deadlineDayMonth);
		event.setDeadlineDate(deadlineDate);


		//URL
		CreateAndAnnihilateEventPage.createEventPageUrl(event);


		//セッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("event",event);



/*		//DAOの利用
		try{
			EventDAO eventDao = new EventDAO;
			ArrayList<EventDto> table = dao.findAll();

			request.setAttribute("table", table);
			request.getRequestDispatcher("アドレス").forward(request, response);
		} catch(Expention e){
			throw new ServletException(e);
		}
*/


		//フォワード(イベント作成決定後のページ）
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/eventconfirmed.jsp");
		dispatcher.forward(request, response);


	}


}
