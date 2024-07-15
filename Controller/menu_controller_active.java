package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author User
 */
public class menu_controller_active {

    public static void activa_menu(HttpServletRequest request, String menu_active) {
        List<String> menus = new ArrayList<>(Arrays.asList("menu_reniec", "menu_sunarp_titu", "menu_sunarp_parti","menu_index"));
        for (int i = 0; i < menus.size(); i++) {
            String currentClasses = (String) request.getAttribute(menus.get(i));
            if (currentClasses == null) {
                currentClasses = "";
            }
            currentClasses = currentClasses.replace("active", "");
            request.setAttribute(menus.get(i), currentClasses);

        }
        String currentClasses = (String) request.getAttribute(menu_active);
        if (currentClasses == null) {
            currentClasses = "";
        }

        currentClasses += " active";

        request.setAttribute(menu_active, currentClasses);
    }
    
    public static void habilita_menu(HttpServletRequest request, String menu_active) {
        List<String> menus = new ArrayList<>(Arrays.asList("menu_reniec","menu_reniec_dni", "menu_sunarp_titu", "menu_sunarp_parti","menu_index"));
        for (int i = 0; i < menus.size(); i++) {
            String currentClasses = (String) request.getAttribute(menus.get(i));
            if (currentClasses == null) {
                currentClasses = "";
            }
            currentClasses = currentClasses.replace("active", "");
            request.setAttribute(menus.get(i), currentClasses);

        }
        String currentClasses = (String) request.getAttribute(menu_active);
        if (currentClasses == null) {
            currentClasses = "";
        }

        currentClasses += " active";

        request.setAttribute(menu_active, currentClasses);
    }
}
