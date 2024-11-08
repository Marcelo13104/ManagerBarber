package utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class PopupUtils {

    public static void setPopupMessage(HttpServletRequest request, String title, String message, String type) {
        HttpSession session = request.getSession();
        session.setAttribute("popupTitle", title);
        session.setAttribute("popupMessage", message);
        session.setAttribute("popupType", type);
    }

    public static void clearPopupMessage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("popupTitle");
        session.removeAttribute("popupMessage");
        session.removeAttribute("popupType");
    }
}