package layout.safetravel.com.safetravel.Utility;

/**
 * Created by root on 11/21/17.
 */

public class FormSetter {
    public int getMonthIndex(String date){
        return Integer.valueOf(date.substring(5, 7));
    }
    public int getYear(String date){
        return Integer.valueOf(date.substring(0, 4));
    }
    public int getDate(String date){
        return Integer.valueOf(date.substring(8, 10));
    }

    public String getMonthText(String date){
        switch (Integer.valueOf(date.substring(5, 7))){
            case 1:
                return "Januari";
            case 2:
                return "Februari";
            case 3:
                return "Maret";
            case 4:
                return "April";
            case 5:
                return "Mei";
            case 6:
                return "Juni";
            case 7:
                return "Juli";
            case 8:
                return "Agustus";
            case 9:
                return "September";
            case 10:
                return "Oktober";
            case 11:
                return "November";
            case 12:
                return "Desember";
            default:
                return "";
        }
    }
    public String getMonthText(int date){
        switch (date){
            case 1:
                return "Januari";
            case 2:
                return "Februari";
            case 3:
                return "Maret";
            case 4:
                return "April";
            case 5:
                return "Mei";
            case 6:
                return "Juni";
            case 7:
                return "Juli";
            case 8:
                return "Agustus";
            case 9:
                return "September";
            case 10:
                return "Oktober";
            case 11:
                return "November";
            case 12:
                return "Desember";
            default:
                return "";
        }
    }
}
