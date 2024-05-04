package lk.ijse.gdse70.Util;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.paint.Paint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Amil Srinath
 */
public class Regex {
    public static boolean isTextFiledValid(TextField textField, String text){
        String field = "";

        switch (textField){
            case ID :
                field = "^([A-Z][0-9]{3})$";
                break;
            case NIC:
                field = "^([0-9]{9}[x|X|v|V]|[0-9]{12})$";
                break;
        }

        Pattern pattern = Pattern.compile(field);

        if (text != null){
            if (text.trim().isEmpty()){
                return false;
            }
        }else {
            return false;
        }

        Matcher matcher = pattern.matcher(text);

        if (matcher.matches()){
            return true;
        }
        return false;
    }

    public static boolean setTextColor(TextField location, JFXTextField field){
        if (Regex.isTextFiledValid(location,field.getText())){
            field.setFocusColor(Paint.valueOf("Green"));
            field.setUnFocusColor(Paint.valueOf("Green"));
            return true;
        }else {
            field.setFocusColor(Paint.valueOf("Red"));
            field.setUnFocusColor(Paint.valueOf("Red"));
            return false;
        }
    }
}
